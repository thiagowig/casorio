package br.com.ithiago.casorio.api.interfaces

import br.com.ithiago.casorio.api.entities.MessageEntity

interface MessageRepository {

    fun get(id: String): MessageEntity

}