package com.example.Hackathon2022Spring.models

import com.vladmihalcea.hibernate.type.json.JsonStringType
import org.hibernate.annotations.TypeDef
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "formAnswers")
@TypeDef(name = "json", typeClass = JsonStringType::class)

data class FormAnswer(
    @Id
    var id: Long = 0,
    var username: String = "",
    var formId: String = "",
    @ElementCollection
    var answers: List<String> = listOf()
)