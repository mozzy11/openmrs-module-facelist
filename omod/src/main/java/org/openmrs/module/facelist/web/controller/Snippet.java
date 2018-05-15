package org.openmrs.module.facelist.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.messagesource.MessageSourceService;
import org.openmrs.module.facelist.Department;
import org.openmrs.module.facelist.Service.DepartmentService;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller

public class Snippet {
	
	
	
	@RequestMapping(value = "/module/facelist/addDepartmentLink.form")
	public String submitDepartment(WebRequest request, HttpSession httpSession, ModelMap model,
	        @RequestParam(required = false, value = "action") String action,
	        @ModelAttribute("department") Department department, BindingResult errors) {
		
		//protected final Log log = LogFactory.getLog(getClass());
		DepartmentService departmentService = Context.getService(DepartmentService.class);
		MessageSourceService mss = Context.getMessageSourceService();
		
		if (!Context.isAuthenticated()) {
			errors.reject("department.auth.required");
			httpSession.setAttribute(WebConstants.OPENMRS_ERROR_ATTR, "first login");
		} else if (mss.getMessage("department.purgeDepartment").equals(action)) {
			try {
				departmentService.purgeDepartment(department);
				httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "department.delete.success");
				return "/module/facelist/departmentForm";
			}
			catch (Exception ex) {
				httpSession.setAttribute(WebConstants.OPENMRS_ERROR_ATTR, "department.delete.failure");
				
				//Log.error("Failed to delete department", ex);
				return "/module/facelist/departmentForm?departmentId=" + request.getParameter("departmentId");
			}
			
		} else {
			departmentService.saveDepartment(department);
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "department.saved");
		}
		return "/module/facelist/departmentForm";
	}
	
	
	
/*	@ModelAttribute("derpartList")
	protected Collection<Department> formBackingObject(HttpServletRequest request) throws Exception {
		// get all patients that have an identifier "101" (from the demo sample data)
		// see http://resources.openmrs.org/doc/index.html?org/openmrs/api/PatientService.html for
		// a list of all PatientService methods
		//DepartmentService departmentService = new DepartmentService();
		
		Collection<Department> derparts = departmentService.getAllDepartments();
		
		// this object will be made available to the jsp page under the variable name
		// that is defined in the @ModuleAttribute tag
		return derparts;
	}*/
	
}
