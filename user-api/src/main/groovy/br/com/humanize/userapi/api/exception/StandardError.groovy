package br.com.humanize.userapi.api.exception

import java.time.LocalDateTime

class StandardError {

    LocalDateTime timestamp
    String error
    Integer status
    String path

}
