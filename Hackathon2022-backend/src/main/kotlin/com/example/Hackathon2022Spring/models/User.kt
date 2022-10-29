package com.example.Hackathon2022Spring.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "users")
class User(val userName: String, val email: String, val password: String) {
    constructor() : this("","","") {

    }

    @Id
    @GeneratedValue
    val id : Long=0;
}
