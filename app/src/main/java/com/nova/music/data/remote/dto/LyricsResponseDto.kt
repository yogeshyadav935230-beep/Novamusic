package com.nova.music.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LyricsResponseDto(
    @SerializedName("header")   val header: BrowseHeaderDto?,
    @SerializedName("contents") val contents: LyricsContentsDto?
)

data class LyricsContentsDto(
    @SerializedName("sectionListRenderer")
    val sectionListRenderer: LyricsSectionListRendererDto?
)

data class LyricsSectionListRendererDto(
    @SerializedName("contents")  val contents: List<LyricsShelfContainerDto>?,
    @SerializedName("continuations") val continuations: List<ContinuationDto>?
)

data class ContinuationDto(
    @SerializedName("nextContinuationData") val nextContinuationData: NextContinuationDataDto?
)

data class NextContinuationDataDto(
    @SerializedName("continuation") val continuation: String?,
    @SerializedName("clickTrackingParams") val clickTrackingParams: String?
)

data class LyricsShelfContainerDto(
    @SerializedName("musicDescriptionShelfRenderer")
    val descriptionShelfRenderer: MusicDescriptionShelfRendererDto?,
    @SerializedName("musicShelfRenderer")
    val shelfRenderer: MusicShelfRendererDto?,
    @SerializedName("elementRenderer")
    val elementRenderer: ElementRendererContainerDto?
)

data class MusicDescriptionShelfRendererDto(
    @SerializedName("header")      val header: RunsContainerDto?,
    @SerializedName("description") val description: RunsContainerDto?,
    @SerializedName("footer")      val footer: RunsContainerDto?,
    @SerializedName("subHeader")   val subHeader: RunsContainerDto?
)

data class ElementRendererContainerDto(
    @SerializedName("newElement") val newElement: NewElementDto?
)

data class NewElementDto(
    @SerializedName("type") val type: ElementTypeDto?
)

data class ElementTypeDto(
    @SerializedName("componentType") val componentType: ComponentTypeDto?
)

data class ComponentTypeDto(
    @SerializedName("model") val model: ComponentModelDto?
)

data class ComponentModelDto(
    @SerializedName("lyricsModel") val lyricsModel: LyricsModelDto?
)

data class LyricsModelDto(
    @SerializedName("lyricsData") val lyricsData: LyricsDataDto?
)

data class LyricsDataDto(
    @SerializedName("timedLyricsData") val timedLyricsData: TimedLyricsDataDto?,
    @SerializedName("lyricsData")      val plainLyricsData: PlainLyricsDataDto?
)

data class TimedLyricsDataDto(
    @SerializedName("timedLyricsData") val lines: List<TimedLyricLineDto>?
)

data class TimedLyricLineDto(
    @SerializedName("cueRange")           val cueRange: CueRangeDto?,
    @SerializedName("lyricLine")          val lyricLine: String?,
    @SerializedName("lyricsLineVariant")  val lyricsLineVariant: LyricsLineVariantDto?
)

data class CueRangeDto(
    @SerializedName("startTimeMilliseconds") val startTimeMilliseconds: String?,
    @SerializedName("endTimeMilliseconds")   val endTimeMilliseconds: String?
)

data class LyricsLineVariantDto(
    @SerializedName("text") val text: RunsContainerDto?
)

data class PlainLyricsDataDto(
    @SerializedName("lyrics") val lyrics: RunsContainerDto?
)
