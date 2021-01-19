package br.com.ithiago.casorio.api.entities

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable

@DynamoDBTable(tableName="message")
data class MessageEntity (

    @DynamoDBHashKey
    var id: String = "",

    var name: String = ""


)