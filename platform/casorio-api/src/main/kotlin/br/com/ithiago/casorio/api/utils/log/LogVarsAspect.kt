package br.com.ithiago.casorio.api.utils.log

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class LogVarsAspect {

    val log = LoggerFactory.getLogger(this.javaClass)

    @Around("@annotation(LogVars)")
    fun logVars(jointPoint: ProceedingJoinPoint): Any? {
        val text = StringBuilder()

        try {
            val methodName = jointPoint.toShortString().replace("execution(", "").dropLast(1)
            text.appendLine("[LogVars] Method: $methodName")

            jointPoint.args?.forEach { arg ->
                text.append("[LogVars] Arg: ${generateValue(arg)}")
            }

            val result = jointPoint.proceed()
            text.appendLine(generateValue(result))

            return result

        } catch (ex: Exception) {
            text.appendLine("[LogVars] Result: Exception: ${ex.message}")
            throw ex

        } finally {
            log.info(text.toString())
        }
    }

    fun generateValue(value: Any): String {
        val text = StringBuilder()

        if (value is List<*>) {
            value.forEach {
                text.appendLine("[LogVars] Result: ${it?.toString()}")
            }
        } else {
            text.appendLine("[LogVars] Result: ${value.toString()}")
        }

        return text.toString()
    }

}