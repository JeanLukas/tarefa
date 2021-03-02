package com.tarefa.tarefa.service

import com.tarefa.tarefa.controller.Pessoa
import com.tarefa.tarefa.entity.pessoas.Pessoas
import com.tarefa.tarefa.repository.PessoasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException
import java.util.Optional
import java.util.*


@Component
class PessoaService {

    @Autowired
    lateinit var repository: PessoasRepository

    fun checkPeople(endereco : String, name : String) : List<Pessoa> {
        val checkPerson = repository.findPessoa(name, endereco)

        if (checkPerson.isNullOrEmpty()){
            return (checkPerson)
        }else{
            throw IllegalArgumentException("inexistent person!")
        }
    }
    fun findUserById(id: Long) : Pessoas {
        return repository.findById(id).get()
    }


    fun findByName(name: String, endereco: String): List<Pessoa> {
        return repository.findPessoa(name, endereco )
    }
    fun findById(id: Long) : Pessoas {
        return repository.findById(id).get()
    }

    fun save( pessoas: Pessoas) : Pessoas {
        return repository.save(pessoas)
    }

    fun delete( id : Long ) {
        return repository.deleteById( id )
    }
}