package com.example.Hackathon2022Spring.controllers

import com.example.Hackathon2022Spring.models.User
import com.example.Hackathon2022Spring.repositories.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.inject.Inject;
import kotlin.random.Random
import kotlin.random.asKotlinRandom

@Controller
class UserController @Inject constructor(val userRepository: UserRepository) {

    @GetMapping("/user/{userName}")
    @ResponseBody
    fun getUser(@PathVariable userName: String): User {
        return userRepository.findUserByUserName(userName)
    }

    @GetMapping("add")
    @ResponseBody
    fun add():User{

        val random = Random(123);// Random(1).asKotlinRandom()
        val nextInt = random.nextInt(1000)
        val nextInt1 = random.nextInt(1000)
        val nextInt2 = random.nextInt(1000)
        return userRepository.save(User("biba$nextInt",
            "biba$nextInt1@mail.ru", false))
    }

    @PostMapping("/user/{user}")
    @ResponseBody
    fun saveUser(@RequestBody user: User): User {
        return userRepository.save(user)
    }
}