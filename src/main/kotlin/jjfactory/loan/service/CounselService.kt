package jjfactory.loan.service

import jjfactory.loan.presentation.dto.CounselDto

interface CounselService {
    fun create(request: CounselDto.Request): CounselDto.Response
}