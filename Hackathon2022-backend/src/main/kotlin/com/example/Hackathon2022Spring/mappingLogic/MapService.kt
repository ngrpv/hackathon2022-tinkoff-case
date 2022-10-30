package com.example.Hackathon2022Spring.mappingLogic

import com.example.Hackathon2022Spring.models.FormAnswer
import com.example.Hackathon2022Spring.models.UserProfile
import com.example.Hackathon2022Spring.repositories.FormAnswerRepository
import com.example.Hackathon2022Spring.repositories.UserProfileRepository
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import javax.inject.Inject

@Service
class MapService @Inject constructor(
    private val comparator: UserProfileComparator,
    private val userProfileRepository: UserProfileRepository
) {
    fun getProfilesFor(userProfile: UserProfile): List<UserProfile> {
        return userProfileRepository.findAll().sortedBy { x ->  comparator.getMatchScore(x, userProfile)}.take(20);
    }
}
@Service
class UserProfileComparator @Inject constructor(
    private val formAnswerRepository: FormAnswerRepository
) {

    fun getMatchScore(first: UserProfile, second: UserProfile): Int {
        val firstProfileForms = formAnswerRepository.findFormAnswersByUsername(first.username)
        val secondProfileForms = formAnswerRepository.findFormAnswersByUsername(second.username)
        var totalScore = 0;
        var commonFormsCount = 0
        for (firstForm in firstProfileForms) {
            val secondForm = secondProfileForms.find { x -> x.formId == firstForm.formId }
            if (secondForm != null) {
                totalScore += getMatchScore(firstForm, secondForm)
                commonFormsCount += 1
            }
        }
        return totalScore / commonFormsCount
    }

    fun getMatchScore(first: FormAnswer, second: FormAnswer): Int {
        if (first.formId !== second.formId) return 0
        var score = 0;
        for (i in 1..first.answers.size) {
            if (first.answers[i] == second.answers[i]) score += 1

        }
        return score

    }

}