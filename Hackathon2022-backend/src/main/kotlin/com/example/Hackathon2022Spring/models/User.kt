package com.example.Hackathon2022Spring.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "users")
class User() {
    @Id
    @GeneratedValue
    val id : Long=0;

    constructor(userName: String, email: String, password: String) : this() {

    }
}
