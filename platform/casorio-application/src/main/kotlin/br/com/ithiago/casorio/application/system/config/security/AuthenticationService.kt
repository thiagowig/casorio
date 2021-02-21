package br.com.ithiago.casorio.application.system.config.security

import br.com.ithiago.casorio.data.dynamodb.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AuthenticationService: UserDetailsService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository.findByEmail(email)

        if (user.isPresent) {
            return user.get()
        }

        throw UsernameNotFoundException("User and/or password are invalids")
    }
}