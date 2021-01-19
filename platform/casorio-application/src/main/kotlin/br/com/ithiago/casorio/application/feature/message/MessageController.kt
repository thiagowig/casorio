package br.com.ithiago.casorio.application.feature.message

import br.com.ithiago.casorio.api.entities.MessageEntity
import br.com.ithiago.casorio.api.interfaces.MessageData
import br.com.ithiago.casorio.data.dynamodb.repository.MessageRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController(val messageData: MessageData) {

    @Value("\${casorio.apis.prefix}")
    private lateinit var parameter: String

    @GetMapping("/message")
    fun get(): MessageEntity {
        return messageData.get("e0493221-9822-4855-9889-eff5b181ca90")
    }
}