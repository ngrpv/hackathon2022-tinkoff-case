package com.example.Hackathon2022Spring.controllers

import com.example.Hackathon2022Spring.models.Form
import com.example.Hackathon2022Spring.models.Question
import com.example.Hackathon2022Spring.repositories.FormRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.inject.Inject
import javax.persistence.Id

@RestController
@RequestMapping("form")
class FormController() {
    @GetMapping("/{form_id}")
    @ResponseBody
    fun getForm(@PathVariable form_id: Long): Form? {
        return Form(
            1,
            listOf(
                Question("Question1", listOf("A", "B", "C")),
                Question("Question2", listOf("2", "3", "C")),
                Question("Question3", listOf("A", "B", "C")),
                Question("Question4", listOf("5", "45", "C")),
                Question("Question5", listOf("12", "B", "C")),
                Question("Question6", listOf("A", "B", "C")),
                Question("Question7", listOf("A", "B", "C")),
                Question("Question8", listOf("A", "B", "C")),
                Question("Question9", listOf("A", "B", "C")),
            ),
        )
//        return formRepository.findById(form_id).orElseGet(null)
    }

//    @PostMapping
//    fun saveForm(@RequestBody form: Form) {
//        formRepository.save(form)
//    }
}