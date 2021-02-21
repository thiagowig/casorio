package br.com.ithiago.casorio.application.system.exception

import br.com.ithiago.casorio.api.exceptions.dto.ErrorMessageValidationDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApplicationControllerAdvice {

    @Autowired
    private lateinit var messageSource: MessageSource

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handle(exception: MethodArgumentNotValidException): List<ErrorMessageValidationDTO> {
        val dto = mutableListOf<ErrorMessageValidationDTO>()

        val fieldErrors: List<FieldError> = exception.bindingResult.fieldErrors

        fieldErrors.forEach { e: FieldError ->
            val message = messageSource.getMessage(e, LocaleContextHolder.getLocale())
            val error = ErrorMessageValidationDTO(e.field, message)
            dto.add(error)
        }

        return dto
    }
}