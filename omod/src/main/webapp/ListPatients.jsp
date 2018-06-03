<div class="container">

					
					 
  	  <table id = "patients"  class="table table-striped table-borderd">
 		 	<thead>
 				 <tr>
  				 	<th><openmrs:message code="PATIENT-ID"/></th>
   					<th><openmrs:message code="PATIENT NAME"/></th>
   					<th><openmrs:message code="PATIENT IDENTIFIER"/></th>
   					<th><openmrs:message code="PATIENT-FACE"/></th>
   					 <th></th>

  					</tr>
  
  			</thead>
  
    		<tbody>
 			 <c:forEach var="patient" items="${thePatientList}">
      			<tr>
       				 <td> <c:out value = "${patient.patientId}" /></td>
       				 <td><c:out value = "${patient.personName}" /></td>
        			 <td> <c:out  value = "${patient.patientIdentifier}"/> </td>
          
       				 <td> 
       
       					 <div>
        
      
        
       			  <object id = "xxx" height="130" width="130" data="${requestURL}?image=${patient.patientId}.jpg"  type="image/jpg">
          	  <img  border="1" height="130" width="130" src="${pageContext.request.contextPath}/moduleResources/facelist/faces/M.png"  />
        		</object>
       
          
             
        			  </div>
      			  </td>
         
        		   <td>
         
 
  						 <div class="container">
  
 			 <!-- Trigger the modal with a button -->
  			<a id ="ryt" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#${patient.patientId}"> <c:out value = "VIEW FULL FACE"/></a>

 				 <!-- Modal -->
 						 <div class="modal fade" id="${patient.patientId}" role="dialog">
    						<div class="modal-dialog">
    
     					 <!-- Modal content-->
     							 <div class="modal-content">
      							  <div class="modal-header">
         								 <button type="button" class="close" data-dismiss="modal">&times;</button>
        						  <h4 class="modal-title">  <c:out value = "${patient.personName}"/></h4>
      						  </div>
       						 <div class="modal-body">
      					  <image alt =" NO FACE-IMAGE. ! PLEASE ADD IMAGE " height ="500" width ="500" src ="${requestURL}?image=${patient.patientId}.jpg"  /> 
        
      
        
         
      					  </div>
      					  <div class="modal-footer">
        			  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       			 </div>
     			 </div>
      
    			</div>
  			</div>
  
			</div>
           
     
         
         </td>
             
           </tr>	
      			</c:forEach>
     
 
   		 </tbody>
		</table>
  
				
		



</div>