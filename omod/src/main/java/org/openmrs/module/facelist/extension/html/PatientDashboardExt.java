/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0 + Health disclaimer. If a copy of the MPL was not distributed with
 * this file, You can obtain one at http://license.openmrs.org
 */
package org.openmrs.module.facelist.extension.html;

import org.openmrs.module.web.extension.PatientDashboardTabExt;

public class PatientDashboardExt extends PatientDashboardTabExt {
	
	@Override
	public String getPortletUrl() {
		return "PatientDashbord";
	}
	
	@Override
	public String getRequiredPrivilege() {
		return "Patient Dashboard - Manage Patient Image";
	}
	
	@Override
	public String getTabId() {
		return "patientface";
	}
	
	@Override
	public String getTabName() {
		return "FACE LIST";
	}
	
}
