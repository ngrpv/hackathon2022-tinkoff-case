package com.example.Hackathon2022Spring.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "users")
class User(@Id val email: String, val userName: String, var isActive:Boolean) {
    constructor() : this("","",false) {

    }
}
