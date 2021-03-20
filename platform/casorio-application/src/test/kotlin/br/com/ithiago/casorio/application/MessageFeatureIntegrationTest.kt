package br.com.ithiago.casorio.application

import br.com.ithiago.casorio.api.entities.MessageEntity
import br.com.ithiago.casorio.application.config.DynamoLocalstackConfig
import br.com.ithiago.casorio.application.config.TestcontainersConfig
import io.restassured.RestAssured
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.context.annotation.Import
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@ExtendWith(TestcontainersConfig::class)
@Import(DynamoLocalstackConfig::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class MessageFeatureIntegrationTest {

    @LocalServerPort
    private lateinit var serverPort: Integer

    @Test
    @Order(1)
    fun `should get empty list`() {
        RestAssured.port = serverPort.toInt()

        RestAssured
            .given()
                .log().all()
            .`when`()
                .get("/message")
            .then()
                .body("isEmpty()", `is`(true))
            .and()
                .statusCode(HttpStatus.OK.value())
    }

    @Test
    @Order(2)
    fun `should save new item`() {
        RestAssured.port = serverPort.toInt()
        val message = MessageEntity(name="Thiago")

        RestAssured
            .given()
                .body(message)
                .contentType("application/json")
                .log().body()
            .`when`()
                .post("/message")
            .then()
                .log().body()
                .assertThat()
                    .body("id", `is`(not(emptyString())))
                    .body("name", `is`("Thiago"))
                .and()
                    .statusCode(HttpStatus.OK.value())
    }
}