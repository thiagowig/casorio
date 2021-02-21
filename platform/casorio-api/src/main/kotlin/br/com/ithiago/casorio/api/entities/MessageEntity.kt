package br.com.ithiago.casorio.api.entities

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import org.hibernate.validator.constraints.Length
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@DynamoDBTable(tableName="message")
data class MessageEntity (
    @get:NotEmpty
    @get:Size(min=2)

    @DynamoDBHashKey
    var id: String = "",

    @get:NotBlank
    var name: String = ""


)