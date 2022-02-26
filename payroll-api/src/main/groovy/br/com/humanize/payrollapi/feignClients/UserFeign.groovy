package br.com.humanize.payrollapi.feignClients

import br.com.humanize.payrollapi.domain.Users
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "user-api", url = "http://localhost:8000")
interface UserFeign {

    @GetMapping(value = "/api/users/{id}")
    ResponseEntity<Users> findById(@PathVariable(name = "id") Long id)

    @GetMapping("/api/users")
    ResponseEntity<List<Users>> findAll()

}