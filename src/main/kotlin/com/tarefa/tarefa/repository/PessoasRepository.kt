package com.tarefa.tarefa.repository

import com.tarefa.tarefa.controller.Pessoa
import com.tarefa.tarefa.entity.pessoas.Pessoas
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PessoasRepository : JpaRepository<Pessoas, Long> {

        @Query("SELECT p FROM Pessoa p WHERE p.id = (:id) ORDER BY p.id asc")
        fun findPessoaById(@Param("id") id: Long): List<Pessoa>

    @Query("SELECT p FROM Pessoa p WHERE p.name = :name "+
                                    "and p.endereco = :endereco")
    fun findPessoa(@Param("name") name: String,
                   @Param("endereco") endereco : String): List<Pessoa>
}