package com.exprnc.domain.usecase

import com.exprnc.domain.repository.EmailRepository
import javax.inject.Inject

class EmailDetailsUseCase @Inject constructor(
    private val emailRepository: EmailRepository
) {
    suspend operator fun invoke() = emailRepository.getEmailDetails()
}