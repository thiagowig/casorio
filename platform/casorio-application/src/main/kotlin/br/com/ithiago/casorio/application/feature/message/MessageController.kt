package br.com.ithiago.casorio.application.feature.message

import br.com.ithiago.casorio.api.interfaces.MessageData
import br.com.ithiago.casorio.api.utils.log.LogVars
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class MessageController(val messageData: MessageData) {

    @GetMapping("/message/{id}")
    @LogVars
    fun get(@PathVariable id: String): MessageDTO {
        val entity = messageData.get(id)

        return MessageConverter.convertToDTO(entity)
    }

    @GetMapping("/message")
    @LogVars
    fun getAll(): List<MessageDTO> {
        val entities = messageData.getAll()

        return MessageConverter.convertToDTOBulk(entities)
    }

    @PostMapping("/message")
    @LogVars
    fun post(@RequestBody @Valid dto: MessageDTO): MessageDTO {
        var entity = MessageConverter.convertToEntity(dto)
        entity = messageData.save(entity)

        return MessageConverter.convertToDTO(entity)
    }

    @DeleteMapping("/message/{id}")
    @LogVars
    fun delete(@PathVariable id: String) {
        messageData.delete(id)
    }
}