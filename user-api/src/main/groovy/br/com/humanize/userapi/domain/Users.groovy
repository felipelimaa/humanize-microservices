package br.com.humanize.userapi.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

import static javax.persistence.GenerationType.IDENTITY

@Entity(name = "tb_user")
@EqualsAndHashCode
@ToString(includePackage = false, includeNames = true)
class Users {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id

    String name

    String email

    String password

    Double hourlyPrice

}
