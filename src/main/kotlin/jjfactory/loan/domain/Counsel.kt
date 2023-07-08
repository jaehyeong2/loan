package jjfactory.loan.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.Where
import java.time.LocalDateTime

@Where(clause = "isDeleted = false")
@Entity
class Counsel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val appliedAt: LocalDateTime = LocalDateTime.now(),
    var name: String,
    var phone: String,
    var email: String,
    var memo: String,
) : BaseEntity()