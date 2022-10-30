package com.example.Hackathon2022Spring.controllers

import com.example.Hackathon2022Spring.models.RegisterInfo
import com.example.Hackathon2022Spring.models.User
import com.example.Hackathon2022Spring.models.UserProfile
import com.example.Hackathon2022Spring.models.enums.LoginResponseType
import com.example.Hackathon2022Spring.models.enums.LogoutResponseType
import com.example.Hackathon2022Spring.models.enums.RegisterResponseType
import com.example.Hackathon2022Spring.repositories.RegisterInfoRepository
import com.example.Hackathon2022Spring.repositories.UserProfileRepository
import com.example.Hackathon2022Spring.repositories.UserRepository
import org.springframework.context.annotation.Profile
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*
import javax.inject.Inject
import kotlin.jvm.optionals.getOrNull

@Controller
class RegistrationController @Inject constructor(
    val registerInfoRepository: RegisterInfoRepository,
    val userRepository: UserRepository,
    val userProfileRepository: UserProfileRepository
) {

    @PostMapping("/register")
    @ResponseBody
    fun register(@RequestBody registerInfo: RegisterInfo): ResponseEntity<String?> {
        val user = registerInfoRepository.findByIdOrNull(registerInfo.email);
        val registerResponseType = registerResponseType(user, registerInfo)
        if (registerResponseType == RegisterResponseType.Successful) {
            return ResponseEntity(registerInfo.email, HttpStatus.CREATED)
        }
        return ResponseEntity(HttpStatus.CONFLICT)
    }

    @PostMapping("/login")
    @ResponseBody
    fun login(@RequestBody registerInfo: RegisterInfo): ResponseEntity<String> {
        val user = registerInfoRepository.findByIdOrNull(registerInfo.email)
        val loginResponseType = loginResponseType(user)

        return if (loginResponseType == LoginResponseType.Successful) {
            ResponseEntity(registerInfo.email, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.LOCKED)
        }
    }

    @PostMapping("/logout")
    @ResponseBody
    fun logout(@RequestBody registerInfo: RegisterInfo): LogoutResponseType {
        val user = userRepository.findByIdOrNull(registerInfo.email)

        if(user == null)
            return LogoutResponseType.Successful
        user.isActive = false;
        userRepository.save(user);
        return LogoutResponseType.Successful
    }

    private fun registerResponseType(
        user: RegisterInfo?,
        registerInfo: RegisterInfo
    ): RegisterResponseType {

        return if (user == null) {
            registerInfoRepository.save(registerInfo)
            RegisterResponseType.Successful;
        } else {
            RegisterResponseType.EmailExists;
        }
    }

    private fun loginResponseType(user: RegisterInfo?): LoginResponseType {
        return if (user == null) {
            LoginResponseType.UnknownEmail
        } else {
            val userFromUsers = registerInfoRepository.findById(user.email)
            if(userFromUsers.isEmpty)
                LoginResponseType.UnknownEmail
            var user_e = userRepository.findByIdOrNull(user.email)
            if(user_e == null)
                user_e = User(user.email, user.email, true)
            var profile = userProfileRepository.findById(user.email)
            if(profile.isEmpty)
            {
                userProfileRepository.save(UserProfile(user.email,user.email, 20 ))
            }
            user_e.isActive = true;
            userRepository.save(user_e)
            LoginResponseType.Successful
        }
    }
}