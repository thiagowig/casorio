package br.com.ithiago.casorio.application.config

import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.amazonaws.services.dynamodbv2.model.*
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class DynamoLocalstackConfig {

    companion object {
        lateinit var amazonDynamoDB: AmazonDynamoDB
        lateinit var dynamoDB: DynamoDB
        private const val TABLE_NAME = "massage"
    }

    init {
        initDynamoDB()
    }

    private fun initDynamoDB() {
        val localstack = TestcontainersConfig.localstack
        val dynamoAddress = "http://${localstack.containerIpAddress}:" +
                "${localstack.getMappedPort(TestcontainersConfig.DYNAMO_PORT)}"

        val endpointConfiguration =
            AwsClientBuilder.EndpointConfiguration(dynamoAddress, Regions.DEFAULT_REGION.getName())
        amazonDynamoDB =
            AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(endpointConfiguration)
                .build() as AmazonDynamoDB

        dynamoDB = DynamoDB(amazonDynamoDB)

        initDynamoTables()
    }

    private fun initDynamoTables() {
        val attributes = arrayListOf(
            AttributeDefinition("id", ScalarAttributeType.S),
            AttributeDefinition("name", ScalarAttributeType.S),
        )

        val keySchemas = arrayListOf(
            KeySchemaElement("id", KeyType.HASH),
            KeySchemaElement("name", KeyType.RANGE)
        )

        val request = CreateTableRequest().withTableName(TABLE_NAME)
            .withAttributeDefinitions(attributes)
            .withKeySchema(keySchemas)
            .withProvisionedThroughput(ProvisionedThroughput(10L, 10L))
        val table = dynamoDB.createTable(request)
        table.waitForActive()
    }

    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB {
        return amazonDynamoDB
    }
}