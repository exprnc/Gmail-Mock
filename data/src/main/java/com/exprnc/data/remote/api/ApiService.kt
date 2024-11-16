package com.exprnc.data.remote.api

import com.exprnc.data.dto.emaildetails.EmailDetailsDto
import com.exprnc.data.dto.emaillist.EmailListItemDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/emaillist")
    suspend fun getEmailList() : Response<ArrayList<EmailListItemDto>>

    @GET("api/v1/emaildetails")
    suspend fun getEmailDetail() : Response<ArrayList<EmailDetailsDto>>
}