package org.openmrs.module.facelist.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.facelist.Department;
import org.openmrs.module.facelist.Service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "module/facelist/return.form")
public class DepartList {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return "module/facelist/returnDepartList";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpSession httpSession, @ModelAttribute("anyRequestObject") Object anyRequestObject,
	        BindingResult errors) {
		
		if (errors.hasErrors()) {
			// return error view
		}
		
		return "module/facelist/returnDepartList";
	}
	
	
	@ModelAttribute("derpartList")
	protected Collection<Department> formBackingObject(HttpServletRequest request) throws Exception {
		// get all patients that have an identifier "101" (from the demo sample data)
		// see http://resources.openmrs.org/doc/index.html?org/openmrs/api/PatientService.html for
		// a list of all PatientService methods
		Collection<Department> depats =  Context.getService(DepartmentService.class).getAllDepartments();
		
		// this object will be made available to the jsp page under the variable name
		// that is defined in the @ModuleAttribute tag
		return depats;
	}
	
}
