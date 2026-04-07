package com.nova.music.data.remote

import com.nova.music.data.remote.dto.ClientDto
import com.nova.music.data.remote.dto.ContextDto

object ApiHelper {
    fun createBaseBody(): MutableMap<String, Any> {
        return mutableMapOf(
            "context" to ContextDto(
                client = ClientDto()
            )
        )
    }

    fun createVideoBody(videoId: String): Map<String, Any> {
        return createBaseBody().apply {
            put("videoId", videoId)
        }
    }

    fun createBrowseBody(browseId: String): Map<String, Any> {
        return createBaseBody().apply {
            put("browseId", browseId)
        }
    }
}
