package br.com.ithiago.casorio.data.dynamodb.config

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.document.DynamoDB
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DynamoDBConfig {

    @Bean
    fun dynamoClient(): AmazonDynamoDB {
        return AmazonDynamoDBClientBuilder.defaultClient()
    }

    @Bean
    fun dynamoDB(): DynamoDB {
        var client = dynamoClient()
        return DynamoDB(client)
    }

    @Bean
    fun dynamoDBMapper(): DynamoDBMapper {
        var client = dynamoClient()
        return DynamoDBMapper(client)
    }


}