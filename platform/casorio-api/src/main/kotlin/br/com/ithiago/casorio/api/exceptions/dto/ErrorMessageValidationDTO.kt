package br.com.ithiago.casorio.api.exceptions.dto

data class ErrorMessageValidationDTO (
    val field: String,
    val errorMessage: String
) {}