package br.com.ithiago.casorio.data.dynamodb

import br.com.ithiago.casorio.api.entities.UserEntity
import br.com.ithiago.casorio.api.interfaces.UserRepository
import org.springframework.stereotype.Component

@Component
class UserRepositoryImpl: UserRepository {

    override fun save(user: UserEntity): UserEntity {
        println("ENTROU")
        return user
    }
}