package com.exprnc.domain.repository

import com.exprnc.core.error.Failure
import com.exprnc.core.functional.Either
import com.exprnc.domain.model.emaildetails.EmailDetailsModel
import com.exprnc.domain.model.emaillist.EmailListItemModel

interface EmailRepository {
    suspend fun getEmailList() : Either<Failure, List<EmailListItemModel>>
    suspend fun getEmailDetails() : Either<Failure, EmailDetailsModel>
}