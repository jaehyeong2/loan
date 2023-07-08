package jjfactory.loan.service

import jjfactory.loan.domain.Application
import jjfactory.loan.domain.Counsel
import jjfactory.loan.infrastructure.ApplicationRepository
import jjfactory.loan.presentation.dto.ApplicationDto
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@ExtendWith(MockitoExtension::class)
class ApplicationServiceImplTest {

    @InjectMocks
    lateinit var applicationService: ApplicationServiceImpl

    @Mock
    lateinit var applicationRepository: ApplicationRepository

    @Test
    fun `생성`() {
        //given
        val application = Application(
            name = "이재형",
            phone = "010-1234-1234",
            email = "wogud111@test.com",
            fee = BigDecimal(0.4),
            hopeAmount = BigDecimal(5000000),
            interestRate = BigDecimal(5),
            maturity = LocalDateTime.now()
        )

        val request = ApplicationDto.Request(
            name = "이재형",
            phone = "010-1234-1234",
            email = "wogud111@test.com",
            fee = BigDecimal(0.4),
            hopeAmount = BigDecimal(5000000),
            interestRate = BigDecimal(5),
            maturity = LocalDateTime.now()
        )

        //stub
        `when`(applicationRepository.save(ArgumentMatchers.any(Application::class.java))).thenReturn(application)

        //when
        val response = applicationService.create(request)

        //then
        assertThat(response.name).isSameAs(application.name)
        assertThat(response.fee).isSameAs(application.fee)
    }

    @Test
    fun `정상조회`() {
        //given
        val id = 1L

        val application = Application(
            name = "이재형",
            phone = "010-1234-1234",
            email = "wogud111@test.com",
            fee = BigDecimal(0.4),
            hopeAmount = BigDecimal(5000000),
            interestRate = BigDecimal(5),
            maturity = LocalDateTime.now()
        )

        //stub
        `when`(applicationRepository.findById(id)).thenReturn(Optional.ofNullable(application))

        //when
        val result = applicationService.get(id)
        //then
        assertThat(result.name).isEqualTo("이재형")
        assertThat(result.fee).isEqualTo(BigDecimal(0.4))
    }

    @Test
    fun `삭제`() {
        //given
        val id = 1L

        val application = Application(
            name = "이재형",
            phone = "010-1234-1234",
            email = "wogud111@test.com",
            fee = BigDecimal(0.4),
            hopeAmount = BigDecimal(5000000),
            interestRate = BigDecimal(5),
            maturity = LocalDateTime.now()
        )

        //stub
        `when`(applicationRepository.findById(id)).thenReturn(Optional.ofNullable(application))

        //when
        applicationService.delete(id)
        //then
        assertThat(application.isDeleted).isSameAs(true)
    }
}