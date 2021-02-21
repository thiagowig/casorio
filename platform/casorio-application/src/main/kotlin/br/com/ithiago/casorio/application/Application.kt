package br.com.ithiago.casorio.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["br.com.ithiago.casorio"])
@EnableCaching
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
