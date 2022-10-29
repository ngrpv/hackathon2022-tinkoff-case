package com.example.Hackathon2022Spring.repositories

import com.example.Hackathon2022Spring.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
@Repository
interface UserRepository : CrudRepository<User, String> {
    fun findUserByEmail(email: String): User
}