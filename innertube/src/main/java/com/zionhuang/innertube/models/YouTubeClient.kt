package com.zionhuang.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class YouTubeClient(
    val clientName: String,
    val clientVersion: String,
    val clientId: String,
    val userAgent: String,
    val osVersion: String? = null,
    val referer: String? = null,
) {
    fun toContext(locale: YouTubeLocale, visitorData: String?) = Context(
        client = Context.Client(
            clientName = clientName,
            clientVersion = clientVersion,
            osVersion = osVersion,
            gl = locale.gl,
            hl = locale.hl,
            visitorData = visitorData
        )
    )

    companion object {
        private const val REFERER_YOUTUBE_MUSIC = "https://music.youtube.com/"

        private const val USER_AGENT_WEB = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:128.0) Gecko/20100101 Firefox/128.0"
        private const val USER_AGENT_ANDROID = "com.google.android.youtube/20.10.38 (Linux; U; Android 11) gzip"
        private const val USER_AGENT_IOS = "com.google.ios.youtube/20.10.4 (iPhone16,2; U; CPU iOS 18_3_2 like Mac OS X;)"

        val ANDROID_MUSIC = YouTubeClient(
            clientName = "ANDROID_MUSIC",
            clientVersion = "7.27.52",
            clientId = "21",
            userAgent = USER_AGENT_ANDROID
        )

        val ANDROID = YouTubeClient(
            clientName = "ANDROID",
            clientVersion = "20.10.38",
            clientId = "3",
            userAgent = USER_AGENT_ANDROID,
        )

        val WEB = YouTubeClient(
            clientName = "WEB",
            clientVersion = "2.20250312.04.00",
            clientId = "1",
            userAgent = USER_AGENT_WEB
        )

        val WEB_REMIX = YouTubeClient(
            clientName = "WEB_REMIX",
            clientVersion = "1.20250310.01.00",
            clientId = "67",
            userAgent = USER_AGENT_WEB,
            referer = REFERER_YOUTUBE_MUSIC
        )

        val TVHTML5 = YouTubeClient(
            clientName = "TVHTML5_SIMPLY_EMBEDDED_PLAYER",
            clientVersion = "2.0",
            clientId = "85",
            userAgent = "Mozilla/5.0 (PlayStation 4 5.55) AppleWebKit/601.2 (KHTML, like Gecko)"
        )

        val IOS = YouTubeClient(
            clientName = "IOS",
            clientVersion = "20.10.4",
            clientId = "5",
            userAgent = USER_AGENT_IOS,
            osVersion = "18.3.2.22D82",
        )

        val ANDROID_VR = YouTubeClient(
            clientName = "ANDROID_VR",
            clientVersion = "1.61.48",
            clientId = "28",
            userAgent = "com.google.android.apps.youtube.vr.oculus/1.61.48 (Linux; U; Android 12; en_US; Oculus Quest 3; Build/SQ3A.220605.009.A1; Cronet/132.0.6808.3)",
        )
    }
}
