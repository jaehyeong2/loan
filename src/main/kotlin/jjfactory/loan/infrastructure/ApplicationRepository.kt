package jjfactory.loan.infrastructure

import jjfactory.loan.domain.Application
import org.springframework.data.jpa.repository.JpaRepository

interface ApplicationRepository : JpaRepository<Application, Long>