package org.openmrs.module.facelist.Service;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.facelist.Multipart;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MultipartService extends OpenmrsService {

	@Transactional(readOnly = false)
	public List<Multipart> getAllMultiparts();

	@Transactional(readOnly = false)
	Multipart getMultipart(Integer multipartId);

	Multipart SaveMultipart(Multipart file);

}
