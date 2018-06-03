<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>
   
  
                <!--   including custom scripts files  -->
        <%@ include file ="External_Scripts.jsp" %>
	
     <div class = "load"> </div>     
	 
   
 
   <!--  form to handle multipart upload -->
    <div class ="container">



       <div class="panel-group">
  			<div class="panel panel-primary">
    			<div class="panel-body"> <c:out value = "ADD IMAGE FORM" /></div>
  			</div>
  
 			 <div class="panel panel-default">
   			 <div class="panel-body">
    
   			 </div>

				<form method="POST" modelAttribute="fileUpload" enctype="multipart/form-data" id ="upload">



      			 <div>
    				<c:out value = "SELECT PATIENT NAME :" /><select    class="btn btn-success btn-large"  id="selected" name = "Patient_ID" tyoe ="number" >

					<c:forEach items="${patients}" var="item">
						<option value="${item.patientId}" ${item.patientId == selectedRole ? 'selected' : ''}> <c:out value ="${item.personName}"/></option>
					</c:forEach>
       			   </select>
       			   <errors path="Patient_ID" cssClass="help-block" element="em"/> 
       			</div>	 
       				<br>   	<br> 
      			<div>
					<input class="btn btn-warning btn-large"  type="file" name="file" />
			<errors path="file" cssClass="help-block" element="em"/> 
     			</div>
     			<br>   	<br> 
    				 <div>
     
			<input type="hidden" name="MultipartId" />

			</div>

			<input   class="btn btn-primary btn-large"   type="submit" value="upload" />


			</form>
    
    
    
    
    
    
    	</div>
 	 </div>
	</div>


                 <div class="container">	 

  <a  href = "Jquerytable.form"><button type="button" class="btn btn-info"><c:out value = "VIEW FACE LIST" /></button> </a>
	         	
                  </div>	




     










   
   
<%@ include file="/WEB-INF/template/footer.jsp"%> 