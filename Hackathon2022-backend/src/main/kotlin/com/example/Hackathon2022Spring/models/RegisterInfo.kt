package com.example.Hackathon2022Spring.models

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class RegisterInfo(@Id val email: String, val password: String) {
    constructor() : this("","") {

    }
};
