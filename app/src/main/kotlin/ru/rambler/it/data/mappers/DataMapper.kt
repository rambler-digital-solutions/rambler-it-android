package ru.rambler.it.data.mappers


interface DataMapper<BE, DTO, DBO> {
    fun mapDto(dto: DTO): BE
    fun mapToDbo(entity: BE): DBO
    fun mapFromDbo(dbo: DBO): BE
}