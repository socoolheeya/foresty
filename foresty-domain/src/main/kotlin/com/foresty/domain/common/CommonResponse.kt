package com.foresty.domain.common

data class CommonResponse<T>(
    val result: String?,
    val data: T?,
    val error: ErrorData?
) {
    data class ErrorData(
        val code: String?,
        val message: String?,
        val data: Map<String, Any?>?
    )
}
