package br.com.humanize.userapi.api.controller

import br.com.humanize.userapi.service.UsersService
import org.apache.catalina.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UsersController {

    @Autowired
    UsersService usersService

    @GetMapping("/{id}")
    ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(usersService.findById(id))
    }

    @GetMapping
    ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(usersService.findAll())
    }

}
