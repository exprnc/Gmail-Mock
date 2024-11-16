package com.exprnc.data.repository

import com.exprnc.core.error.Failure
import com.exprnc.core.functional.Either
import com.exprnc.data.mapper.EmailDetailsMapper
import com.exprnc.data.mapper.EmailListMapper
import com.exprnc.data.remote.api.ApiService
import com.exprnc.data.remote.handler.safeApiCall
import com.exprnc.domain.model.emaildetails.EmailDetailsModel
import com.exprnc.domain.model.emaillist.EmailListItemModel
import com.exprnc.domain.repository.EmailRepository
import javax.inject.Inject

class EmailRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val emailListMapper: EmailListMapper,
    private val emailDetailsMapper: EmailDetailsMapper
) : EmailRepository {

    override suspend fun getEmailList(): Either<Failure, List<EmailListItemModel>> = safeApiCall(
        apiCall = { apiService.getEmailList() },
        mapper = { emailListMapper.map(it) }
    )

    override suspend fun getEmailDetails(): Either<Failure, EmailDetailsModel> = safeApiCall(
        apiCall = { apiService.getEmailDetail() },
        mapper = { emailDetailsMapper.map(it) }
    )
}