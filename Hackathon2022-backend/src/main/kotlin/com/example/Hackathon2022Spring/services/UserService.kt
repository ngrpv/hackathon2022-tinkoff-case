package com.example.Hackathon2022Spring.services

import com.example.Hackathon2022Spring.models.User

interface UserService {
    fun getAllUsers(): List<User>
    fun getUserByUserName(userName: String): User
    fun saveUser(user: User): User
}