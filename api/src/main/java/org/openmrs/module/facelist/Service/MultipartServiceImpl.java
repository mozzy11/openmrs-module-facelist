package org.openmrs.module.facelist.Service;

import java.util.List;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.facelist.Multipart;
import org.openmrs.module.facelist.DAO.MultipartDAO;
import org.springframework.stereotype.Service;

@Service
public class MultipartServiceImpl extends BaseOpenmrsService implements MultipartService {

	private MultipartDAO dao;

	@Override
	public List<Multipart> getAllMultiparts() {

		return dao.getAllMultiparts();
	}

	public MultipartDAO getDao() {
		return dao;
	}

	@Override
	public Multipart getMultipart(Integer multipartId) {

		return dao.getMultipart(multipartId);
	}

	@Override
	public Multipart SaveMultipart(Multipart file) {

		return dao.SaveMultipart(file);
	}

	public void setDao(MultipartDAO dao) {
		this.dao = dao;
	}

}
