package br.com.ithiago.casorio.application.feature.login

import br.com.ithiago.casorio.api.entities.UserEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController {

    @GetMapping("/")
    fun getLogin(): String {
        return UserEntity(123).name
    }
}