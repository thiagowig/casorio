package br.com.ithiago.casorio.data.dynamodb.repository

import br.com.ithiago.casorio.api.entities.security.UserEntity
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import java.util.*

@EnableScan
interface UserRepository: CrudRepository<UserEntity, String> {

    fun findByEmail(email: String): Optional<UserEntity>
}