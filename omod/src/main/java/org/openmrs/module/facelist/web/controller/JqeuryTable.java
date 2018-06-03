package org.openmrs.module.facelist.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JqeuryTable {

	@RequestMapping(value = "module/facelist/Jquerytable.form", method = RequestMethod.GET)
	public String showForm(ModelMap model , HttpServletRequest request) {
		
		Collection<Patient> patients = Context.getPatientService().getAllPatients();
		model.addAttribute("thePatientList",  patients );
		
		 final String endpoint = "moduleServlet/facelist/FaceServlet";
			final String URL = request.getContextPath() + "/" + endpoint;
			
			
			model.addAttribute("requestURL", URL);
		
		return "module/facelist/JqueryTable";
	}
	
	
	
}
