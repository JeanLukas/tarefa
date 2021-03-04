package com.tarefa.tarefa.service

import com.tarefa.tarefa.entity.pessoas.Pessoa
import com.tarefa.tarefa.repository.PessoaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException


@Component
class PessoaService {

    @Autowired
    lateinit var repository: PessoaRepository

    fun checkPeople(name: String): List<Pessoa> {
        val checkPerson = repository.findPessoa(name)

        if (checkPerson.isNullOrEmpty()) {
            return (checkPerson)
        } else {
            throw IllegalArgumentException("inexistent person!")
        }
    }


    fun findByName(name: String): List<Pessoa> {
        return repository.findPessoa(name)
    }

    fun findById(id: Long): Pessoa {
        return repository.findById(id).get()
    }

    fun save(pessoa: Pessoa): Pessoa {
        return repository.save(pessoa)
    }

    fun delete(id: Long) {
        return repository.deleteById(id)
    }
}