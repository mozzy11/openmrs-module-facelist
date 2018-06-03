
<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>



           <!--   including custom scripts files  -->
        <%@ include file ="External_Scripts.jsp" %>
	
	<div class = "load"> </div> 
	 
<div class="container">	 

  <a  href = "addFaces.form">   <button type="button" class="btn btn-info ">  CLICK TO ADD FACE</button> </a>
	         	
</div>	 
	 
	<br> <br>
	
<%@ include file="ListPatients.jsp" %>  
	 






		<script type="text/javascript">
			$(document).ready(function() {

	
	
	 			$("#patients").css({"table-layout":"fixed","width":"1200px"});
	   
		 /*   converting the patients table to jquery datatable */
	     		 $("#patients").DataTable();
	 
	     
	      
	      
	      
		});

	</script> 






























<%@ include file="/WEB-INF/template/footer.jsp"%>