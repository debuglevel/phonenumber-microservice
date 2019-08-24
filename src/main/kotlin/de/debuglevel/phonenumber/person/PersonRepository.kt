package de.debuglevel.phonenumber.person

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface PersonRepository : CrudRepository<Person, Long> {
    fun find(name: String): Person
}