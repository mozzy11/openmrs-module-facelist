<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<h2><spring:message code="DEPARTMENT LIST" /></h2>

 <br/>
<table>
  <tr>
   <th>DEPARTMENT Id</th>
   <th> DEPARTMENT Name</th>
 
     <th>DESCRIPTION</th>
  </tr>
  <c:forEach var="dpt" items="${derpartList}">
      <tr>
        <td>${dpt.departmentId}</td>
        <td>${dpt.name}</td>
       
        <td>${dpt. description}</td>
      </tr>		
  </c:forEach>
</table> 

<%@ include file="/WEB-INF/template/footer.jsp"%>