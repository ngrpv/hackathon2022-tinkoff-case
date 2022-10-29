package com.example.Hackathon2022Spring.controllers

import com.example.Hackathon2022Spring.models.User
import com.example.Hackathon2022Spring.repositories.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.inject.Inject;

@Controller
class UserController @Inject constructor(val userRepository: UserRepository) {

    @GetMapping("/user/{userName}")
    @ResponseBody
    fun getUser(@PathVariable userName: String): User {
        return userRepository.findUserByUserName(userName)
    }

    @PostMapping("/user/{user}")
    @ResponseBody
    fun saveUser(@RequestBody user: User): User {
        return userRepository.save(user)
    }
}