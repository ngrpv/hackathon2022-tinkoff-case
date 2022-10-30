package com.example.Hackathon2022Spring.controllers

import com.example.Hackathon2022Spring.mappingLogic.MapService
import com.example.Hackathon2022Spring.models.UserProfile
import com.example.Hackathon2022Spring.repositories.UserProfileRepository
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.context.annotation.Bean
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.inject.Inject

@Controller
@RequestMapping("profile")
class UserProfileController @Inject constructor(
    val userProfileRepository: UserProfileRepository,
    val mapService: MapService
) {
    @GetMapping("/{id}")
    @ResponseBody
    fun get(@PathVariable id: String): UserProfile? {
        return userProfileRepository.findByIdOrNull(id)
    }

    @PostMapping("/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    fun save(@RequestBody userProfile: UserProfile) {
        userProfileRepository.save(userProfile)
    }

    @GetMapping("/matches/{username}")
    @ResponseBody
    fun getMatches(@PathVariable username: String): List<UserProfile> {
        val profile = userProfileRepository.findById(username);
        if (profile.isEmpty)
            return emptyList()
        return mapService.getProfilesFor(profile.get());

    }
}