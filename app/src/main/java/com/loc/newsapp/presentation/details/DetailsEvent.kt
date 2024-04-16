package com.loc.newsapp.presentation.details

import com.loc.newsapp.domain.model.Article
import java.net.URL

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()
}