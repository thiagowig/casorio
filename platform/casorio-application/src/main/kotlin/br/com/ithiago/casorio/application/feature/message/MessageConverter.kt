package br.com.ithiago.casorio.application.feature.message

import br.com.ithiago.casorio.api.entities.MessageEntity

object MessageConverter {

    fun convertToDTO(entity: MessageEntity): MessageDTO {
        val dto = MessageDTO()

        dto.id = entity.id
        dto.name = entity.name
        dto.email = entity.email
        dto.content = entity.content

        return dto
    }

    fun convertToDTOBulk(entities: List<MessageEntity>): List<MessageDTO> {
        return entities.map { entity ->
            this.convertToDTO(entity)
        }
    }

    fun convertToEntity(dto: MessageDTO): MessageEntity {
        return MessageEntity(
            id = dto.id,
            name = dto.name,
            email = dto.email,
            content = dto.content
        )
    }

    fun convertToEntityBulk(dtos: List<MessageDTO>): List<MessageEntity> {
        return dtos.map { dto ->
            this.convertToEntity(dto)
        }
    }
}