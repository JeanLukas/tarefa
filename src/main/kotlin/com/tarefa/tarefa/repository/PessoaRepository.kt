package com.tarefa.tarefa.repository

import com.tarefa.tarefa.entity.pessoas.Pessoa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PessoaRepository : JpaRepository<Pessoa, Long> {

    @Query("SELECT p FROM Pessoa p WHERE p.id = (:id) ORDER BY p.id asc")
    fun findPessoaById(@Param("id") id: Long): Pessoa

    @Query(
        "SELECT p FROM Pessoa p WHERE p.name LIKE %:name%"
    )
    fun findPessoa(
        @Param("name") name: String
    ): List<Pessoa>
}