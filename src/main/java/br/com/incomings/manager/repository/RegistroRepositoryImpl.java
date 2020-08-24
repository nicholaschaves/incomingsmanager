package br.com.incomings.manager.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.incomings.manager.model.Registro;

public class RegistroRepositoryImpl implements RegistroRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Registro> findByFilter(Registro registro) {

		StringBuilder sb = null;
		sb = new StringBuilder();

		sb.append("FROM Registro o");

		if (registro.getNomeRequisitor() != null) {
			sb.append(" WHERE nomeRequisitor LIKE '%");
			sb.append(registro.getNomeRequisitor());
			sb.append("%'");
		}

		if (registro.getNomeRequisitor() != null) {
			sb.append(" WHERE cpfRequisitor = ");
			sb.append(registro.getCpfRequisitor());
		}

		return entityManager.createQuery(sb.toString(), Registro.class).getResultList();

	}

}
