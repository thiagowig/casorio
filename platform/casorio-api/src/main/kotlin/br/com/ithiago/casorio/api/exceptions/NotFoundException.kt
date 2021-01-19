package br.com.ithiago.casorio.api.exceptions

import java.lang.RuntimeException

class NotFoundException(override val message: String): RuntimeException(message) {
}