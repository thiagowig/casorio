package br.com.ithiago.casorio.data.queue

import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SQSConfig {

    @Bean
    fun amazonSQS(): AmazonSQS {
        return AmazonSQSClientBuilder.defaultClient();
    }
}