package br.com.ithiago.casorio.data.dynamodb.repository

import br.com.ithiago.casorio.api.entities.MessageEntity
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository

@EnableScan
interface MessageRepository: CrudRepository<MessageEntity, String> {
}