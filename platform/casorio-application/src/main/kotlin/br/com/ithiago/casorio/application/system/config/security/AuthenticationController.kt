package br.com.ithiago.casorio.application.system.config.security

import br.com.ithiago.casorio.api.entities.security.TokenDTO
import br.com.ithiago.casorio.api.entities.security.UserEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthenticationController {

    @Autowired
    private lateinit var authManager: AuthenticationManager

    @Autowired
    private lateinit var tokenService: TokenService

    @PostMapping("/auth")
    fun authenticate(@RequestBody userEntity: UserEntity): ResponseEntity<Any> {
        val loginData = UsernamePasswordAuthenticationToken(userEntity.email, userEntity.pass)

        return try {
            val auth = authManager.authenticate(loginData)
            val token = tokenService.generateToken(auth)

            ResponseEntity.ok(TokenDTO(token, "Bearer"))

        } catch (exception: AuthenticationException) {
            ResponseEntity.badRequest().build()
        }
    }

}
