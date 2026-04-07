package com.nova.music.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PlayerResponseDto(
    @SerializedName("playabilityStatus") val playabilityStatus: PlayabilityStatusDto?,
    @SerializedName("streamingData")     val streamingData: StreamingDataDto?,
    @SerializedName("videoDetails")      val videoDetails: PlayerVideoDetailsDto?
)

data class PlayabilityStatusDto(
    @SerializedName("status")          val status: String?,
    @SerializedName("reason")          val reason: String?,
    @SerializedName("errorScreen")     val errorScreen: ErrorScreenDto?
)

data class ErrorScreenDto(
    @SerializedName("playerErrorMessageRenderer")
    val playerErrorMessageRenderer: PlayerErrorMessageRendererDto?
)

data class PlayerErrorMessageRendererDto(
    @SerializedName("reason") val reason: RunsContainerDto?
)

data class StreamingDataDto(
    @SerializedName("adaptiveFormats") val adaptiveFormats: List<AdaptiveFormatDto>?
)

data class AdaptiveFormatDto(
    @SerializedName("itag")              val itag: Int?,
    @SerializedName("url")               val url: String?,
    @SerializedName("signatureCipher")   val signatureCipher: String?,
    @SerializedName("cipher")            val cipher: String?,
    @SerializedName("mimeType")          val mimeType: String?,
    @SerializedName("bitrate")           val bitrate: Long?,
    @SerializedName("audioQuality")      val audioQuality: String?,
    @SerializedName("approxDurationMs")  val approxDurationMs: String?
)

data class PlayerVideoDetailsDto(
    @SerializedName("videoId")  val videoId: String?,
    @SerializedName("title")    val title: String?,
    @SerializedName("author")   val author: String?
)
