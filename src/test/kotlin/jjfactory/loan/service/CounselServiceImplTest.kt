package jjfactory.loan.service

import jjfactory.loan.domain.Counsel
import jjfactory.loan.exception.BaseException
import jjfactory.loan.infrastructure.CounselRepository
import jjfactory.loan.presentation.dto.CounselDto
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class CounselServiceImplTest {
    @InjectMocks
    lateinit var counselService: CounselServiceImpl

    @Mock
    lateinit var counselRepository: CounselRepository

    @Test
    fun `생성`() {
        //given
        val counsel = Counsel(
            name = "이재형",
            phone = "010-1234-1234",
            email = "wogud111@test.com",
            memo = "대출 상담 드립니다."
        )

        val request = CounselDto.Request(
            name = "이재형",
            phone = "010-1234-1234",
            email = "wogud111@test.com",
            memo = "대출 상담 드립니다."
        )

        //stub
        `when`(counselRepository.save(ArgumentMatchers.any(Counsel::class.java))).thenReturn(counsel)

        //when
        val response = counselService.create(request)

        //then
        assertThat(response.name).isSameAs(counsel.name)
    }

    @Test
    fun `정상조회`() {
        //given
        val id = 1L

        val counsel = Counsel(
            name = "이재형",
            phone = "010-1234-1234",
            email = "wogud111@test.com",
            memo = "대출 상담 드립니다."
        )

        //stub
        `when`(counselRepository.findById(id)).thenReturn(Optional.ofNullable(counsel))

        //when
        val response = counselService.get(id)
        //then
        assertThat(response.name).isSameAs(counsel.name)
    }

    @Test
    fun `조회실패`() {
        //given
        val id = 1L

        //stub
        `when`(counselRepository.findById(id)).thenReturn(Optional.ofNullable(null))

        //expected
        assertThatThrownBy {
            counselService.get(id)
        }.isInstanceOf(BaseException::class.java)
    }
}