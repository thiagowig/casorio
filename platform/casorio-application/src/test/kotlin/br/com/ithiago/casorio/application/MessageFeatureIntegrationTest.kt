package br.com.ithiago.casorio.application

import br.com.ithiago.casorio.application.config.DynamoLocalstackConfig
import br.com.ithiago.casorio.application.config.TestcontainersConfig
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@ExtendWith(TestcontainersConfig::class)
@Import(DynamoLocalstackConfig::class)
@SpringBootTest()
class MessageFeatureIntegrationTest {


    @Test
    fun `should start container`() {
        println("FOI")
    }
}