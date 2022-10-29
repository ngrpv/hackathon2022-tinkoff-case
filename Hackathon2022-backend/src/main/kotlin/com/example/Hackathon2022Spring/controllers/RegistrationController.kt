package com.example.Hackathon2022Spring.controllers

import com.example.Hackathon2022Spring.models.enums.LoginResponseType
import com.example.Hackathon2022Spring.models.RegisterInfo
import com.example.Hackathon2022Spring.models.enums.LogoutResponseType
import com.example.Hackathon2022Spring.models.enums.RegisterResponseType
import com.example.Hackathon2022Spring.repositories.RegisterInfoRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.inject.Inject

@Controller
class RegistrationController @Inject constructor(val registerInfoRepository: RegisterInfoRepository) {

    @GetMapping("/register")
    fun register(@RequestBody registerInfo: RegisterInfo): RegisterResponseType {
        val user = registerInfoRepository.getByEmail(registerInfo.email);
        return if (user.equals(null)){
            registerInfoRepository.save(registerInfo)
            RegisterResponseType.Successful;
        } else{
            RegisterResponseType.EmailExists;
        }
    }

    @GetMapping("/login")
    fun login(@RequestBody registerInfo : RegisterInfo) : LoginResponseType {
        val user = registerInfoRepository.getByEmail(registerInfo.email)
        return if (user.equals(null)){
            LoginResponseType.UnknownEmail
        } else {
            user.isActive=true;
            LoginResponseType.Successful
        }
    }

    @GetMapping("/logout")
    fun logout(@RequestBody registerInfo: RegisterInfo): LogoutResponseType{
        val user = registerInfoRepository.getByEmail(registerInfo.email)
        user.isActive=false
        return LogoutResponseType.Successful
    }

}