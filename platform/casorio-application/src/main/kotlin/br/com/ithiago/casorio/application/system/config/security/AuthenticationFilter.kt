package br.com.ithiago.casorio.application.system.config.security

import br.com.ithiago.casorio.data.dynamodb.repository.UserRepository
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFilter(
    private var tokenService: TokenService,
    private var userRepository: UserRepository
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = getToken(request)
        var valid = tokenService.isValidToken(token)

        if (valid) {
            authenticateUser(token)
        }

        filterChain.doFilter(request, response)
    }

    private fun getToken(request: HttpServletRequest): String? {
        val bearerPattern = "Bearer "
        val token = request.getHeader("Authorization")

        if (token.isNotBlank() && token.startsWith(bearerPattern)) {
            return token.substring(7, token.length)
        }

        return null
    }

    private fun authenticateUser(token: String?) {
        val email = tokenService.getUserEmail(token)
        val user = userRepository.findByEmail(email)

        val authentication = UsernamePasswordAuthenticationToken(user, null, user.get().authorities)
        SecurityContextHolder.getContext().authentication = authentication
    }

}