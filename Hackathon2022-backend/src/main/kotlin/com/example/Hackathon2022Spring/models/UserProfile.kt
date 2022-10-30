package com.example.Hackathon2022Spring.models

import javax.persistence.Entity
import javax.persistence.Id

@Entity(name="userProfile")
data class UserProfile(@Id var username: String = "", var name: String = "", var age: Int = 0) {

}