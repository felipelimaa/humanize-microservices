package br.com.humanize.userapi.service.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class EntityNotFoundException extends ResponseStatusException {
    EntityNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Entity not found")
    }
}
