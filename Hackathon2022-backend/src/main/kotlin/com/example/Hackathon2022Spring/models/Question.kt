package com.example.Hackathon2022Spring.models

import com.vladmihalcea.hibernate.type.json.JsonStringType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@TypeDef(name = "json", typeClass = JsonStringType::class)

data class Question(
    @Id
    var question: String = "",

    @Type(type = "json")
    @Column(columnDefinition = "json")
    var answers: List<String> = listOf()
) {
}