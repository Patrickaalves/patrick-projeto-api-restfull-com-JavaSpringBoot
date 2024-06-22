package br.com.patrick.aplicacaobackend.repository;

import br.com.patrick.aplicacaobackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}

