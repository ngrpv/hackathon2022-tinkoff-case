package com.example.Hackathon2022Spring.controllers

import com.example.Hackathon2022Spring.models.Form
import com.example.Hackathon2022Spring.models.Question
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import javax.persistence.Id

@Controller
class FormController {
    @GetMapping("/form/{form_id}")
    @ResponseBody
    fun getForm(@PathVariable form_id: Long): Form {
        return Form(form_id, listOf(Question("пропрпропорп", listOf("B", "C"))));
    }
}