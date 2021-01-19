package br.com.ithiago.casorio.data.dynamodb.repository

import br.com.ithiago.casorio.api.entities.MessageEntity
import br.com.ithiago.casorio.api.interfaces.MessageRepository
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import org.springframework.stereotype.Component

@Component
class MessageRepositoryImpl(val dynamoDBMapper: DynamoDBMapper): MessageRepository {

    override fun get(id: String): MessageEntity {
        return dynamoDBMapper.load(MessageEntity::class.java, id)
    }
}