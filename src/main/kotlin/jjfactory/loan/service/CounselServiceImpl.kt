package jjfactory.loan.service

import jjfactory.loan.config.ModelMapper
import jjfactory.loan.domain.Counsel
import jjfactory.loan.exception.BaseException
import jjfactory.loan.infrastructure.CounselRepository
import jjfactory.loan.presentation.dto.CounselDto
import org.springframework.data.repository.findByIdOrNull
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

    override fun get(id: Long): CounselDto.Response {
        val counsel = counselRepository.findByIdOrNull(id) ?: throw BaseException("not found")
        return modelMapper.mapper<Counsel, CounselDto.Response>(counsel)
    }

    override fun delete(id: Long) {
        val counsel = counselRepository.findByIdOrNull(id) ?: throw BaseException("not found")
        counsel.delete()
    }
}