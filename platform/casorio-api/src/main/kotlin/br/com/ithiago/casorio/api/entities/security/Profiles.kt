package br.com.ithiago.casorio.api.entities.security

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument
import org.springframework.security.core.GrantedAuthority

@DynamoDBDocument
data class Profiles(

    var id: String = "",
    var name: String = ""

): GrantedAuthority {

    override fun getAuthority(): String {
        return this.name
    }

}
