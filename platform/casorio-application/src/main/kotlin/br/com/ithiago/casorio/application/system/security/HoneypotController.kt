package br.com.ithiago.casorio.application.system.security

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HoneypotController {

    @GetMapping("admin")
    fun honeypot() {

    }
}