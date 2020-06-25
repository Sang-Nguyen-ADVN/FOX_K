package com.ihaha.sunny.fox.remote


/**
 * Created by Sunny on 9/30/2019.
 * Version 1.0
 */

object Constants {

    const val TAG = "FOX"

    object FRAGMENT {
        const val FRAGMENT_CATEGORIES_NEWEST = "newest"
        const val FRAGMENT_CATEGORIES_SERIES = "series"
        const val FRAGMENT_CATEGORIES_TRENDING = "trending"
        const val FRAGMENT_CATEGORIES_VIDEOS = "videos"
        const val FRAGMENT_CATEGORIES_EDITOR_CHOICE = "editors-choice"
    }

    object STRUCTURE {

        object NAME {
            const val NEWEST = "Newest"
            const val SERIES = "Series"
            const val TRENDING = "Trending"
            const val VIDEOS = "Videos"
            const val EDITOR_CHOICE = "Editor-Choice"
        }

        object DOMAIN {
            const val NEWEST = "newest"
            const val TRENDING = "trending"
            const val VIDEOS = "videos"
            const val EDITORS_CHOICE = "editors-choice"
            const val TAGS = "tags"
            const val SERIES = "series"
            const val ORGANIZATIONS = "organizations"
            const val SEARCH = "search"
        }
    }

    object ERROR{
        const val ERROR_NULL_RESOURCE = "Lỗi không tìm thấy dữ liệu"
        const val ERROR_NULL_DATA_FROM_SERVER = "Lỗi chưa có dữ liệu"
        const val ERROR_SERVER_DATA_NOT_CHANGE = "Dữ liệu không thay đổi"
        const val ERROR_MISSING_PARAMS_SEND_TO_SERVER = "Lỗi gửi tham số tới hệ thống"
        const val ERROR_REQUIRED_LOGIN = "Bạn vui lòng đăng nhập để sử dụng dịch vụ"
        const val ERROR_WRONG_TOKEN = "Quyền truy cập bị chặn"
        const val ERROR_REQUIRED_VIP_USER = "Bạn vui lòng nâng cấp VIP để sử dụng dịch vụ"
        const val ERROR_TIMEOUT_CONNECT_TO_SERVER = "Lỗi thời gian kết nối tới hệ thống"
        const val ERROR_ITEM_NOT_FOUND = "Dữ liệu không tồn tại"
        const val ERROR_NETWORK = "Bạn đang offline. Vui lòng kiểm tra tín hiệu mạng"
        const val ERROR_OTHER = "Lỗi kết nối tới hệ thống"
    }
}

