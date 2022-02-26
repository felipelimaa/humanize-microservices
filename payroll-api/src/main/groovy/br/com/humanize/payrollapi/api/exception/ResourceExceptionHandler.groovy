package br.com.humanize.payrollapi.api.exception

import br.com.humanize.payrollapi.service.exception.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

import javax.servlet.http.HttpServletRequest
import java.time.LocalDateTime

@ControllerAdvice
class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<StandardError> entityNotFound(
            EntityNotFoundException e,
            HttpServletRequest request
    ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new StandardError(
                timestamp: LocalDateTime.now(),
                error: e.getReason(),
                status: HttpStatus.NOT_FOUND.value(),
                path: request.getRequestURI()
            )
        )
    }


}
