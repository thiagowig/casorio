package br.com.ithiago.casorio.application.feature.message

import br.com.ithiago.casorio.api.entities.MessageEntity
import br.com.ithiago.casorio.api.interfaces.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {

    @Autowired
    private lateinit var messageRepository: MessageRepository

    @GetMapping("/")
    fun get(): MessageEntity {
        return messageRepository.get("e0493221-9822-4855-9889-eff5b181ca90")
    }
}