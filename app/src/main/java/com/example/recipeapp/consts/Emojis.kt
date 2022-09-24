package com.example.recipeapp.consts

/**
 *
 */
class Emojis{

    companion object {
        private val countries: Map<String, String> = mapOf(
            "america" to "🇺🇸",
            "australia" to "🇦🇺",
            "austria" to "🇦🇹",
            "belgium" to "🇧🇪",
            "brazil" to "🇧🇷",
            "canada" to "🇨🇦",
            "china" to "🇨🇳",
            "croatia" to "🇭🇷",
            "czech" to "🇨🇿",
            "denmark" to "🇩🇰",
            "egypt" to "🇪🇬",
            "finland" to "🇫🇮",
            "france" to "🇫🇷",
            "germany" to "🇩🇪",
            "greece" to "🇬🇷",
            "hungary" to "🇭🇺",
            "india" to "🇮🇳",
            "indonesia" to "🇮🇩",
            "ireland" to "🇮🇪",
            "italy" to "🇮🇹",
            "japan" to "🇯🇵",
            "malaysia" to "🇲🇾",
            "mexico" to "🇲🇽",
            "netherlands" to "🇳🇱",
            "new zealand" to "🇳🇿",
            "norway" to "🇳🇴",
            "philippines" to "🇵🇭",
            "poland" to "🇵🇱",
            "portugal" to "🇵🇹",
            "romania" to "🇷🇴",
            "russia" to "🇷🇺",
            "singapore" to "🇸🇬",
            "south africa" to "🇿🇦",
            "south korea" to "🇰🇷",
            "spain" to "🇪🇸",
            "sweden" to "🇸🇪",
            "switzerland" to "🇨🇭",
            "thailand" to "🇹🇭",
            "turkey" to "🇹🇷",
            "uk" to "🇬🇧",
            "ukraine" to "🇺🇦",
            "vietnam" to "🇻🇳",
            "peru" to "🇵🇪",
            "other" to "🌎"
        )

        /**
         * Returns the flag emoji for the country or the world emoji if the country is not found
         */
        fun getEmoji(country: String): String {
            return countries[country] ?: countries["other"]!!
        }
    }
}