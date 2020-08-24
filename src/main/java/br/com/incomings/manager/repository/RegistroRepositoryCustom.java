package br.com.incomings.manager.repository;

import java.util.List;

import br.com.incomings.manager.model.Registro;

public interface RegistroRepositoryCustom {

	public List<Registro> findByFilter(Registro registro);

}
