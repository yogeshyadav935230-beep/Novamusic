package com.nova.music.data.mapper

import com.nova.music.data.remote.dto.*
import com.nova.music.domain.model.Song

fun PlayerResponseDto.toSong(): Song {
    val streamUrl = streamingData?.adaptiveFormats
        ?.filter { it.mimeType?.contains("audio") == true }
        ?.maxByOrNull { it.bitrate ?: 0 }
        ?.url ?: ""

    return Song(
        videoId = videoId ?: "",
        title = videoDetails?.title ?: "Unknown Title",
        artist = videoDetails?.author ?: "Unknown Artist",
        thumbnail = "https://i.ytimg.com/vi/${videoId}/hqdefault.jpg",
        streamUrl = streamUrl
    )
}

fun PlaylistPanelVideoRendererDto.toSong(): Song {
    val titleText = title?.runs?.firstOrNull()?.text ?: "Unknown"
    val artistText = "YouTube Music" // Placeholder
    
    return Song(
        videoId = videoId ?: "",
        title = titleText,
        artist = artistText,
        thumbnail = thumbnail?.thumbnails?.lastOrNull()?.url ?: ""
    )
}

fun LyricsResponseDto.toPlainLyrics(): String? {
    return contents?.sectionListRenderer?.contents
        ?.firstOrNull { it.descriptionShelfRenderer != null }
        ?.descriptionShelfRenderer?.description?.runs
        ?.joinToString("") { it.text ?: "" }
}
