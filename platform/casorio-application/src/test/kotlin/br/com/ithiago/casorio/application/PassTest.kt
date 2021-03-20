package br.com.ithiago.casorio.application

import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class PassTest {

    @Test
    fun createPass() {
        print(BCryptPasswordEncoder().encode("123"))
        print("\n")
    }
}