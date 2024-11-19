package com.exprnc.presentation.emaillist.mvi

import com.exprnc.core.error.Failure
import com.exprnc.coreui.mvi.MVIContract
import com.exprnc.domain.model.emaillist.EmailListItemModel

interface EmailListContract :
    MVIContract<EmailListContract.EmailListState, EmailListContract.EmailListEffect, EmailListContract.EmailListEvent> {


    sealed class EmailListEvent {
        data object LoadEmailList : EmailListEvent()

        data class EmailClicked(val model: EmailListItemModel) : EmailListEvent()
    }

    sealed class EmailListState {
        data object Loading : EmailListState()

        data class Success(
            val emailList: List<EmailListItemModel>
        ) : EmailListState()

        data class Error(
            val error: Failure
        ) : EmailListState()
    }

    sealed class EmailListEffect {
        data class NavigateToEmailDetails(val model: EmailListItemModel) : EmailListEffect()
    }
}