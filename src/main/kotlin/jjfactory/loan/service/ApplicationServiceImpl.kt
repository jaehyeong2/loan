package jjfactory.loan.service

import jjfactory.loan.config.ModelMapper
import jjfactory.loan.domain.Application
import jjfactory.loan.domain.Counsel
import jjfactory.loan.exception.BaseException
import jjfactory.loan.infrastructure.ApplicationRepository
import jjfactory.loan.presentation.dto.ApplicationDto
import jjfactory.loan.presentation.dto.CounselDto
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ApplicationServiceImpl(
    private val applicationRepository: ApplicationRepository
) : ApplicationService {
    private val modelMapper: ModelMapper = ModelMapper()
    override fun create(request: ApplicationDto.Request): ApplicationDto.Response {
        val application = modelMapper.mapper<ApplicationDto.Request, Application>(request)
        val created = applicationRepository.save(application)

        return modelMapper.mapper<Application, ApplicationDto.Response>(created)
    }

    override fun get(id: Long): ApplicationDto.Response {
        val application = applicationRepository.findByIdOrNull(id) ?: throw BaseException("not found")

        return modelMapper.mapper<Application, ApplicationDto.Response>(application)
    }

    override fun delete(id: Long) {
        val application = applicationRepository.findByIdOrNull(id) ?: throw BaseException("not found")

        application.delete()
    }
}