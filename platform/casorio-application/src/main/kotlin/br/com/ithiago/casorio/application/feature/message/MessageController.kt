package br.com.ithiago.casorio.application.feature.message

import br.com.ithiago.casorio.api.entities.MessageEntity
import br.com.ithiago.casorio.api.interfaces.MessageData
import br.com.ithiago.casorio.api.utils.log.LogVars
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

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
    fun post(@RequestBody @Valid message: MessageEntity): MessageEntity {
        return messageData.save(message)
    }

    @DeleteMapping("/message/{id}")
    @LogVars
    fun delete(@PathVariable id: String) {
        messageData.delete(id)
    }
}