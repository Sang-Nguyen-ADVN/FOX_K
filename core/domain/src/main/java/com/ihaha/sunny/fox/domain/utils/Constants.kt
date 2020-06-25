package com.ihaha.sunny.fox.domain.utils

object Constants{


    object PAGE{

        object LINK {
            const val AVATAR = "https://images.viblo.asia/avatar/"
            const val THUMB = "https://images.viblo.asia/thumbnail/"
        }

        object VALUES{
            const val DEFAULT_FIRST_PAGE = 1
            const val DEFAULT_NUM_VISIBLE_THRESHOLD = 3
            const val THRESHOLD_CLICK_TIME = 1000
            const val DEFAULT_SCOPE = "normal"
            const val DEFAULT_SORT = "follower"
            const val DEFAULT_TYPE = "none"
            const val DEFAUlT_LIMIT = 15
            const val DEFAULT_OFF_SET = 0
        }

        object KEYS{
            const val LIMIT = "limit"
            const val OFFSET = "offset"
            const val SORT = "sort"
            const val SCOPE = "scope"
            const val TYPE = "type"
        }
    }
}