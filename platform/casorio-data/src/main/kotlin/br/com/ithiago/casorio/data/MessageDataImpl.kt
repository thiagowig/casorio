package br.com.ithiago.casorio.data

import br.com.ithiago.casorio.api.entities.MessageEntity
import br.com.ithiago.casorio.api.interfaces.MessageData
import br.com.ithiago.casorio.api.utils.IdUtil
import br.com.ithiago.casorio.data.dynamodb.repository.MessageRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class MessageDataImpl(val messageRepository: MessageRepository): MessageData {

    override fun get(id: String): MessageEntity {
        val message = messageRepository.findById(id)

        if (message.isPresent) {
            return message.get()

        } else
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "No message found with id $id")
    }

    override fun getAll(): List<MessageEntity> {
        return messageRepository.findAll() as List<MessageEntity>
    }

    override fun save(message: MessageEntity): MessageEntity {
        print("")
        if (message.id.isEmpty()) {
            message.id = IdUtil.generateId()
        }

        return messageRepository.save(message)
    }
}