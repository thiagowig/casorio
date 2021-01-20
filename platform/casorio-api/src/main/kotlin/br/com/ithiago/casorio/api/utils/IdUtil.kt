package br.com.ithiago.casorio.api.utils

import java.util.*

class IdUtil {

    companion object {
        fun generateId() = UUID.randomUUID().toString()
    }
}