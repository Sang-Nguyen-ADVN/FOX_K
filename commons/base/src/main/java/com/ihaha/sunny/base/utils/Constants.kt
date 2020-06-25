package com.ihaha.sunny.base.utils

class Constants {
    companion object{
        const val GALLERY_REQUEST_CODE = 201
        const val PERMISSION_REQUEST_READ_STORAGE: Int = 301

        fun isPaginationDone(errorResponse: String?): Boolean {
            // if error response = '{"detail":"Invalid page."}' then pagination is finished
            return errorResponse?.contains(INVALID_PAGE) ?: false
        }

        //
        const val GENERIC_AUTH_ERROR = "Error"
        const val INVALID_PAGE = "Invalid page."
        const val ERROR_CHECK_NETWORK_CONNECTION = "Check network connection."
        const val ERROR_UNKNOWN = "Unknown error"
        const val INVALID_CREDENTIALS = "Invalid credentials"
        const val SOMETHING_WRONG_WITH_IMAGE = "Something went wrong with the image."
        const val INVALID_STATE_EVENT = "Invalid state event"
        const val CANNOT_BE_UNDONE = "This can't be undone."
        const val NETWORK_ERROR = "Network error"
        const val NETWORK_ERROR_TIMEOUT = "Network timeout"
        const val CACHE_ERROR_TIMEOUT = "Cache timeout"
        const val UNKNOWN_ERROR = "Unknown error"
        const val ERROR_ALL_FIELDS_ARE_REQUIRED = "All fields are required"
        const val ERROR_PASSWORD_DOESNOT_MATCH = "Password and confirm password must be same"
        const val INVALID_PAGE_NUMBER = "invalid page number"
    }
}