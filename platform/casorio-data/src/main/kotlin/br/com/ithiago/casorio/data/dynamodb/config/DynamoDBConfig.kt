package br.com.ithiago.casorio.data.dynamodb.config

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.document.DynamoDB
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableDynamoDBRepositories(basePackages = ["br.com.ithiago.casorio.data.dynamodb.repository"])
class DynamoDBConfig {

    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB {
        return AmazonDynamoDBClientBuilder.defaultClient()
    }


}