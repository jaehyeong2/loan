package jjfactory.loan.presentation.dto

import java.time.LocalDateTime

class CounselDto {
    data class Request(
        val appliedAt: LocalDateTime = LocalDateTime.now(),
        var name: String,
        var phone: String,
        var email: String,
        var memo: String,
    )

    data class Response(
        val appliedAt: LocalDateTime,
        var name: String,
        var phone: String,
        var email: String,
        var memo: String,
    )
}