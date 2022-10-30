package com.example.Hackathon2022Spring.models

import javax.persistence.*

@Entity(name = "forms")
data class Form(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @OneToMany
    val question: List<Question>
) {
    constructor() : this(0, mutableListOf()) {

    }
}