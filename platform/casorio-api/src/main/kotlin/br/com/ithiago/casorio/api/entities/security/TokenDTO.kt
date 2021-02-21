package br.com.ithiago.casorio.api.entities.security

data class TokenDTO(
    val token: String,
    val authenticationType: String
) {}