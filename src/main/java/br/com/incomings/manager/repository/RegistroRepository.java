package br.com.incomings.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.incomings.manager.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Long>, RegistroRepositoryCustom {

}
