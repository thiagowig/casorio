package br.com.ithiago.casorio.application.feature.login

import br.com.ithiago.casorio.api.entities.UserEntity
import br.com.ithiago.casorio.api.interfaces.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController {

    @Autowired
    private lateinit var userRepository: UserRepository

    @GetMapping("/")
    fun getLogin(): String {
        return userRepository.save(UserEntity(123, "Thiago", 35)).name
    }
}