package jjfactory.loan.service

import jjfactory.loan.domain.Counsel
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

@ExtendWith(MockitoExtension::class)
class CounselServiceImplTest {
    @InjectMocks
    lateinit var counselService: CounselServiceImpl
    @Mock
    lateinit var counselRepository: CounselRepository

    @Test
    fun create() {
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
        `when`(counselRepository.save(ArgumentMatchers.any(Counsel::class.java))).thenReturn(counsel);

        //when
        val response = counselService.create(request)

        //then
        assertThat(response.name).isSameAs(counsel.name)
    }
}