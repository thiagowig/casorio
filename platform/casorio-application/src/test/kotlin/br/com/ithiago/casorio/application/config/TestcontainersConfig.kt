package br.com.ithiago.casorio.application.config

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
class TestcontainersConfig: BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    companion object {

        const val DYNAMO_PORT = 4566
        private const val LOCALSTACK_VERSION = "0.12.5"

        @Container
        val localstack: GenericContainer<*> = GenericContainer<Nothing>("localstack/localstack:$LOCALSTACK_VERSION")
            .apply {
                this.addExposedPort(DYNAMO_PORT)
            }
    }

    override fun beforeAll(context: ExtensionContext?) {
        if (!localstack.isRunning) {
            localstack.start()
        }
    }

    override fun close() {
        if (localstack.isRunning) {
            localstack.stop()
        }
    }
}