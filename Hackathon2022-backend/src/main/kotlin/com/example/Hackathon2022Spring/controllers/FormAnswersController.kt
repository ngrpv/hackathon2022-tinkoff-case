package com.example.Hackathon2022Spring.controllers

import com.example.Hackathon2022Spring.models.FormAnswer
import com.example.Hackathon2022Spring.repositories.FormAnswerRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.inject.Inject

@Controller
@RestController
@RequestMapping("form-answers")
class FormAnswersController @Inject constructor( val repository: FormAnswerRepository) {
    @PostMapping("/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    fun save(@RequestBody answers: FormAnswer): Int{
        repository.save(answers)
        return 1;
    }
    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): Long{
        return id;
    }
}