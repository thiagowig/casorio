package br.com.ithiago.casorio.data

import br.com.ithiago.casorio.api.entities.MessageEntity
import br.com.ithiago.casorio.api.interfaces.MessageData
import br.com.ithiago.casorio.api.utils.IdUtil
import br.com.ithiago.casorio.api.utils.log.LogVars
import br.com.ithiago.casorio.data.dynamodb.repository.MessageRepository
import br.com.ithiago.casorio.data.queue.SQSService
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class MessageDataImpl(val messageRepository: MessageRepository,
                      val sqsService: SQSService): MessageData {

    @Value("\${casorio.queues.message.url}")
    lateinit var messageQueue: String

    @LogVars
    override fun get(id: String): MessageEntity {
        val message = messageRepository.findById(id)

        if (message.isPresent) {
            return message.get()

        } else
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "No message found with id $id")
    }

    @LogVars
    @Cacheable(value = ["listaDeTopicos"])
    override fun getAll(): List<MessageEntity> {
        return messageRepository.findAll() as List<MessageEntity>
    }

    @LogVars
    @CacheEvict(value = ["listaDeTopicos"], allEntries = true)
    override fun save(messageEntity: MessageEntity): MessageEntity {
        if (messageEntity.id.isEmpty()) {
            messageEntity.id = IdUtil.generateId()
        }

        return messageRepository.save(messageEntity)

//        val result = sqsService.sendMessage(SQSObject(messageQueue, messageEntity))
//
//        return messageEntity
    }
}