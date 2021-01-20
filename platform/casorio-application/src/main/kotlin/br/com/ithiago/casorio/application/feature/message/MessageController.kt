package br.com.ithiago.casorio.application.feature.message

import br.com.ithiago.casorio.api.entities.MessageEntity
import br.com.ithiago.casorio.api.interfaces.MessageData
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*

@RestController
class MessageController(val messageData: MessageData) {

    @Value("\${casorio.apis.prefix}")
    private lateinit var parameter: String

    @GetMapping("/message/{id}")
    fun get(@PathVariable id: String): MessageEntity {
        return messageData.get(id)
    }

    @PostMapping("message")
    fun post(@RequestBody message: MessageEntity): MessageEntity {
        return messageData.save(message)
    }
}