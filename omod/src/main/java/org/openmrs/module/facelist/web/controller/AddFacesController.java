package org.openmrs.module.facelist.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.facelist.Multipart;
import org.openmrs.module.facelist.Service.MultipartService;
import org.openmrs.util.OpenmrsUtil;
import org.openmrs.web.WebConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddFacesController {
	
	private static final Logger log = LoggerFactory.getLogger(AddFacesController.class);
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "/module/facelist/addFaces.form", method = RequestMethod.GET)
	public ModelAndView fileUploadPage(ModelMap map) {
		Multipart file = new Multipart();
		Collection<Patient> patients = Context.getPatientService().getAllPatients();
		map.addAttribute("patients", patients);
		ModelAndView modelAndView = new ModelAndView("/module/facelist/AddFaces", "command", file);
		return modelAndView;
	}
	
	@RequestMapping(value = "/module/facelist/addFaces.form", method = RequestMethod.POST)
	public String fileUpload(Multipart file, BindingResult result, ModelMap model, HttpServletRequest request,
	        HttpSession sesion) throws IOException {
		if (result.hasErrors()) {
			return "/module/facelist/addFaces.form";
		} else {		
			MultipartService muiltipartService = Context.getService(MultipartService.class);
			MultipartFile multipartFile = file.getFile();
			int patientId = file.getPatient_ID();
			muiltipartService.SaveMultipart(file);
			File imgDir = new File(OpenmrsUtil.getApplicationDataDirectory(), "Face_images");
			if (!imgDir.exists()) {
				FileUtils.forceMkdir(imgDir);
			}
			String fileName = multipartFile.getOriginalFilename();
			FileCopyUtils.copy(file.getFile().getBytes(), new File(imgDir + "/" + patientId + ".jpg"));
			sesion.setAttribute(WebConstants.OPENMRS_MSG_ATTR, fileName + " " + "SUCCESFULLY UPLOADED");
			log.info("FILE SAVED SUCCESFULYY");
			final String endpoint = "moduleServlet/facelist/FaceServlet";
			final String URL = request.getContextPath() + "/" + endpoint;		
			Collection<Patient> patients = Context.getPatientService().getAllPatients();
			model.addAttribute("fileName", fileName);
			model.addAttribute("realpath", imgDir);
			model.addAttribute("thePatientList", patients);
			model.addAttribute("path", imgDir);
			model.addAttribute("requestURL", URL);
			return "module/facelist/JqueryTable";
		}
	}
	
}
