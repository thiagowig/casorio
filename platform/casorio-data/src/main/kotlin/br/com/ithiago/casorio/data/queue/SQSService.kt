package br.com.ithiago.casorio.data.queue

import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.model.SendMessageRequest
import org.springframework.stereotype.Service

@Service
class SQSService (var amazonSQS: AmazonSQS) {

    fun sendMessage(sqsObject: SQSObject) {
        val request = SendMessageRequest()
            .withQueueUrl(sqsObject.url)
            .withMessageBody(sqsObject.messageBody.toString())

        val result =  amazonSQS.sendMessage(request)

        print(result)
    }
}