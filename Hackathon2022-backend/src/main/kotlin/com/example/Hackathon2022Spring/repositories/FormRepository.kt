package com.example.Hackathon2022Spring.repositories

import com.example.Hackathon2022Spring.models.Form
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service


interface FormRepository : CrudRepository<Form, Long> {
}