package com.ihaha.sunny.fox.remote.models.auth.response

enum class ResponseStatus (val value: String) {
    NOT_INITIALIZED("NOT_INITIALIZED"),
    IN_PROGRESS("IN_PROGRESS"),
    SUCCESS("SUCCESS"),
    NO_RESULT("NO_RESULT"),
    ERROR("ERROR"),
}