package br.com.ithiago.casorio.api.entities.security

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import org.springframework.security.core.userdetails.UserDetails

@DynamoDBTable(tableName="user")
data class UserEntity(

    @DynamoDBHashKey
    var email: String = "",
    var pass: String = "",
    var name: String = "",
    var profiles: List<Profiles> = emptyList()

): UserDetails {

    override fun getAuthorities(): List<Profiles> {
        return this.profiles
    }

    override fun getPassword(): String {
        return this.pass
    }

    override fun getUsername(): String {
        return this.email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}