package jjfactory.loan.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.Where
import java.math.BigDecimal
import java.time.LocalDateTime

@Where(clause = "isDeleted = false")
@Entity
class Application(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val appliedAt: LocalDateTime = LocalDateTime.now(),
    val maturity: LocalDateTime,
    var name: String,
    var phone: String,
    var email: String,
    var interestRate: BigDecimal,
    var hopeAmount: BigDecimal,
    var fee: BigDecimal,
) : BaseEntity()