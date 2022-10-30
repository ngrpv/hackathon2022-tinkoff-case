package com.example.Hackathon2022Spring.repositories

import com.example.Hackathon2022Spring.models.FormAnswer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Repository
@Service
interface FormAnswerRepository : CrudRepository<FormAnswer, Long>{
    fun findFormAnswersByUsername(username: String): List<FormAnswer>
}