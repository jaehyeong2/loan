package jjfactory.loan.service

import jjfactory.loan.presentation.dto.ApplicationDto
import jjfactory.loan.presentation.dto.CounselDto

interface ApplicationService {
    fun create(request: ApplicationDto.Request): ApplicationDto.Response
    fun get(id: Long): ApplicationDto.Response
    fun delete(id: Long)
}