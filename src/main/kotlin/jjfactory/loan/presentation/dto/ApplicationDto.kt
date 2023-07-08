package jjfactory.loan.presentation.dto

import java.math.BigDecimal
import java.time.LocalDateTime

class ApplicationDto {
    data class Request(
        val appliedAt: LocalDateTime = LocalDateTime.now(),
        val maturity: LocalDateTime,
        var name: String,
        var phone: String,
        var email: String,
        var interestRate: BigDecimal,
        var hopeAmount: BigDecimal,
        var fee: BigDecimal,
    )

    data class Response(
        val appliedAt: LocalDateTime = LocalDateTime.now(),
        val maturity: LocalDateTime,
        var name: String,
        var phone: String,
        var email: String,
        var interestRate: BigDecimal,
        var hopeAmount: BigDecimal,
        var fee: BigDecimal,
    )
}