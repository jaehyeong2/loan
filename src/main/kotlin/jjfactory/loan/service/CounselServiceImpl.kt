package jjfactory.loan.service

import jjfactory.loan.config.ModelMapper
import jjfactory.loan.domain.Counsel
import jjfactory.loan.infrastructure.CounselRepository
import jjfactory.loan.presentation.dto.CounselDto
import org.springframework.stereotype.Service

@Service
class CounselServiceImpl(
    private val counselRepository: CounselRepository
) : CounselService {
    private val modelMapper: ModelMapper = ModelMapper()

    override fun create(request: CounselDto.Request): CounselDto.Response {
        val counsel = modelMapper.mapper<CounselDto.Request, Counsel>(request)
        val created = counselRepository.save(counsel)

        return modelMapper.mapper<Counsel, CounselDto.Response>(created)
    }
}