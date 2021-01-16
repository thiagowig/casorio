package br.com.ithiago.casorio.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["br.com.ithiago.casorio"])
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
