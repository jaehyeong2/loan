package jjfactory.loan.infrastructure

import jjfactory.loan.domain.Counsel
import org.springframework.data.jpa.repository.JpaRepository

interface CounselRepository : JpaRepository<Counsel, Long>