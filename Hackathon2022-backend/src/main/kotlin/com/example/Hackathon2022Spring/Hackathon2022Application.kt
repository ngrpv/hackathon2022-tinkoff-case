package com.example.Hackathon2022Spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
class Hackathon2022Application

fun main(args: Array<String>) {
	runApplication<Hackathon2022Application>(*args)
}
