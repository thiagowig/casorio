package br.com.ithiago.casorio.application.system.config.security

import br.com.ithiago.casorio.api.entities.security.UserEntity
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@Service
class TokenService {

    @Value("\${security.jwt.expiration}")
    private lateinit var jwtExpiration: String

    @Value("\${security.jwt.secret}")
    private lateinit var jwtSecret: String

    fun generateToken(auth: Authentication): String {
        val loggedUser = auth.principal as UserEntity
        val currentDate = Instant.now()
        val exprationDate = currentDate.plusSeconds(jwtExpiration.toLong())

        return Jwts.builder()
            .setIssuer("casorio-application")
            .setSubject(loggedUser.email)
            .setIssuedAt(convertToDate(currentDate))
            .setExpiration(convertToDate(exprationDate))
            .signWith(SignatureAlgorithm.HS256, jwtSecret)
            .compact()
    }

    fun convertToDate(instant: Instant): Date {
        return Date(instant.toEpochMilli())
    }
}