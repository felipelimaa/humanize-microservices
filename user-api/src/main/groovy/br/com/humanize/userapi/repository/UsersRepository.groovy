package br.com.humanize.userapi.repository

import br.com.humanize.userapi.domain.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository extends JpaRepository<Users, Long> {

}