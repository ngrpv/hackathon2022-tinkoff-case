package com.example.Hackathon2022Spring.repositories

import com.example.Hackathon2022Spring.models.UserProfile
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserProfileRepository : CrudRepository<UserProfile, String> {
}