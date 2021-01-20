package br.com.ithiago.casorio.api.interfaces

import br.com.ithiago.casorio.api.entities.MessageEntity

interface MessageData {

    fun get(id: String): MessageEntity

    fun save(message: MessageEntity): MessageEntity

}