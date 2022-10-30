package com.example.Hackathon2022Spring.controllers

import com.example.Hackathon2022Spring.models.RegisterInfo
import com.example.Hackathon2022Spring.models.enums.LoginResponseType
import com.example.Hackathon2022Spring.models.enums.LogoutResponseType
import com.example.Hackathon2022Spring.models.enums.RegisterResponseType
import com.example.Hackathon2022Spring.repositories.RegisterInfoRepository
import com.example.Hackathon2022Spring.repositories.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*
import javax.inject.Inject

@Controller
class RegistrationController @Inject constructor(
    val registerInfoRepository: RegisterInfoRepository,
    val userRepository: UserRepository
) {

    @GetMapping("/register")
    @ResponseBody
    fun register(@RequestBody registerInfo: RegisterInfo): String {
        val user = registerInfoRepository.getByEmail(registerInfo.email);
        val registerResponseType = registerResponseType(user, registerInfo)
        return if (registerResponseType == RegisterResponseType.Successful) {
            registerInfo.email
        } else {
            ""
        }
    }

    @GetMapping("/login")
    @ResponseBody
    fun login(@RequestBody registerInfo: RegisterInfo): String {
        val user = registerInfoRepository.getByEmail(registerInfo.email)
        val loginResponseType = loginResponseType(user)

        return if (loginResponseType == LoginResponseType.Successful) {
            registerInfo.email
        } else {
            ""
        }
    }

    @GetMapping("/logout")
    @ResponseBody
    fun logout(@RequestBody registerInfo: RegisterInfo): LogoutResponseType {
        val user = registerInfoRepository.getByEmail(registerInfo.email)
        val userFromUsers = userRepository.findUserByEmail(user.email)
        userFromUsers.isActive = true;
        return LogoutResponseType.Successful
    }

    private fun registerResponseType(
        user: RegisterInfo,
        registerInfo: RegisterInfo
    ): RegisterResponseType {
        if (user.equals(null)) {
            registerInfoRepository.save(registerInfo)
            return RegisterResponseType.Successful;
        } else {
            return RegisterResponseType.EmailExists;
        }
    }

    private fun loginResponseType(user: RegisterInfo): LoginResponseType {
        return if (user.equals(null)) {
            LoginResponseType.UnknownEmail
        } else {
            val userFromUsers = userRepository.findUserByEmail(user.email)
            userFromUsers.isActive = true;
            LoginResponseType.Successful
        }
    }
}