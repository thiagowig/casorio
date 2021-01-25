package br.com.ithiago.casorio.application.feature.message

import br.com.ithiago.casorio.api.entities.MessageEntity
import br.com.ithiago.casorio.api.interfaces.MessageData
import br.com.ithiago.casorio.api.utils.log.LogVars
import org.springframework.web.bind.annotation.*

@RestController
class MessageController(val messageData: MessageData) {

    @GetMapping("/message/{id}")
    @LogVars
    fun get(@PathVariable id: String): MessageEntity {
        return messageData.get(id)
    }

    @GetMapping("/message")
    @LogVars
    fun getAll(): List<MessageEntity> {
        return messageData.getAll()
    }

    @PostMapping("/message")
    @LogVars
    fun post(@RequestBody message: MessageEntity): MessageEntity {
        return messageData.save(message)
    }
}