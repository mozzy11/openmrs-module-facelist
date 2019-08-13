package org.openmrs.module.facelist;

import java.io.Serializable;

import javax.persistence.Transient;

import org.openmrs.BaseOpenmrsObject;
import org.springframework.web.multipart.MultipartFile;

public class Multipart extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer MultipartId;
	
	@Transient
	private MultipartFile file;
	
	private int Patient_ID;
	
	public MultipartFile getFile() {
		return file;
	}
	
	@Override
	public Integer getId() {
		
		return getMultipartId();
	}
	
	public Integer getMultipartId() {
		return MultipartId;
	}
	
	public int getPatient_ID() {
		return Patient_ID;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	@Override
	public void setId(Integer id) {
		setMultipartId(id);
		
	}
	
	public void setMultipartId(Integer multipartId) {
		MultipartId = multipartId;
	}
	
	public void setPatient_ID(int patient_ID) {
		Patient_ID = patient_ID;
	}
	
}
