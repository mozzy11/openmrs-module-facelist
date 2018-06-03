package org.openmrs.module.facelist.DAO;

import java.util.List;

import org.openmrs.module.facelist.Multipart;

public interface MultipartDAO {

	List<Multipart> getAllMultiparts();

	Multipart getMultipart(Integer multipartId);

	Multipart SaveMultipart(Multipart file);

}
