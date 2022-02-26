package br.com.humanize.payrollapi.api.exception

import java.time.LocalDateTime

class StandardError {

    LocalDateTime timestamp
    String error
    Integer status
    String path

}
