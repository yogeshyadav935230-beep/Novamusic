package com.nova.music.domain.model

data class Song(
    val videoId: String,
    val title: String,
    val artist: String,
    val thumbnail: String,
    val duration: Long = 0,
    val streamUrl: String? = null,
    val lyrics: String? = null,
    val isExplicit: Boolean = false
)
