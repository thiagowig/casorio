package br.com.ithiago.casorio.api.entities.security

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import org.springframework.security.core.GrantedAuthority

data class Profiles(

    @DynamoDBHashKey
    var id: String,
    var name: String

): GrantedAuthority {

    override fun getAuthority(): String {
        return this.name
    }

}
