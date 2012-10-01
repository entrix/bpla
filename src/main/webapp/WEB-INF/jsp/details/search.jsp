<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<h2>Find Owners:</h2>

<form:form method="get">
  <table>
    <tr>
      <th>
        Point Id: <form:errors path="*" cssClass="errors"/>
        <br/> 
        <input type="text" name="id" size="5" maxlength="80" />
      </th>
    </tr>
    <tr>
      <td><p class="submit"><input type="submit" value="Find Details"/></p></td>
    </tr>
  </table>
</form:form>

<br/>
<a href='<spring:url value="/details/new" htmlEscape="true"/>'>Add Owner</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>