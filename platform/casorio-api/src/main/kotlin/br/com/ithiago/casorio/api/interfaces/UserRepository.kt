package br.com.ithiago.casorio.api.interfaces

import br.com.ithiago.casorio.api.entities.UserEntity

interface UserRepository {

    fun save(user: UserEntity): UserEntity

}