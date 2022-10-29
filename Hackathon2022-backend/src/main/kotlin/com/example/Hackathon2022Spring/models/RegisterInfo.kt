package com.example.Hackathon2022Spring.models

import javax.persistence.Id

data class RegisterInfo(@Id val email: String, val password: String);
