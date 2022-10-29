package com.example.Hackathon2022Spring.models

import javax.persistence.Entity

@Entity(name = "user")
data class User(val userName: String, val email: String, val password: String)
