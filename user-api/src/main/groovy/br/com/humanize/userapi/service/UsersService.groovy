package br.com.humanize.userapi.service

import br.com.humanize.userapi.domain.Users
import br.com.humanize.userapi.repository.UsersRepository
import br.com.humanize.userapi.service.exception.EntityNotFoundException
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service

@Slf4j
@Service
class UsersService {

    @Autowired
    UsersRepository userRepository

    @Autowired
    Environment env

    Users findById(Long id) {
        log.info("USER_SERVICE ::: Get Request on " + env.getProperty("local.server.port") + " port.")
        return userRepository.findById(id).orElseThrow{new EntityNotFoundException()}
    }

    List<Users> findAll() {
        return userRepository.findAll()
    }

}
