package br.com.ithiago.casorio.data

import br.com.ithiago.casorio.api.entities.MessageEntity
import br.com.ithiago.casorio.api.exceptions.NotFoundException
import br.com.ithiago.casorio.api.interfaces.MessageData
import br.com.ithiago.casorio.data.dynamodb.repository.MessageRepository
import org.springframework.stereotype.Component

@Component
class MessageDataImpl(val messageRepository: MessageRepository): MessageData {

    override fun get(id: String): MessageEntity {
        val message = messageRepository.findById(id)

        if (message.isPresent) {
            return message.get()

        } else
            throw NotFoundException("No message found with id $id")
    }
}