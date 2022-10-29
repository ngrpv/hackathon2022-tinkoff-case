package com.example.Hackathon2022Spring.repositories

import com.example.Hackathon2022Spring.models.RegisterInfo
import com.example.Hackathon2022Spring.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service


@Service
@Repository
interface RegisterInfoRepository : CrudRepository<RegisterInfo, String> {
    fun getByEmail(email: String) : RegisterInfo
}