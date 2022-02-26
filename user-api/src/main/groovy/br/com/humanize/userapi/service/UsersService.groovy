package br.com.humanize.userapi.service

import br.com.humanize.userapi.domain.Users
import br.com.humanize.userapi.repository.UsersRepository
import br.com.humanize.userapi.service.exception.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsersService {

    @Autowired
    UsersRepository userRepository

    Users findById(Long id) {
        return userRepository.findById(id).orElseThrow{new EntityNotFoundException()}
    }

    List<Users> findAll() {
        return userRepository.findAll()
    }

}
