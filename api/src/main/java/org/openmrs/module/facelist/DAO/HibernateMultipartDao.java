package org.openmrs.module.facelist.DAO;

import java.util.List;

import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.facelist.Multipart;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateMultipartDao implements MultipartDAO {

	private DbSessionFactory sessionFactory;

	@Override
	public List<Multipart> getAllMultiparts() {
		return sessionFactory.getCurrentSession().createQuery("From Multipart").list();

	}

	@Override
	public Multipart getMultipart(Integer MultipartId) {
		return (Multipart) sessionFactory.getCurrentSession().get(Multipart.class, MultipartId);

	}

	@Override
	public Multipart SaveMultipart(Multipart file) {
		sessionFactory.getCurrentSession().save(file);
		return file;
	}

	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
