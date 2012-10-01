<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<c:set var="method" value="post"/>

<h2>Detail:</h2>
<form:form modelAttribute="detail" method="${method}">
  <table>
    <%--<tr>--%>
      <%--<th>--%>
          <%--detTypeId: <form:errors path="detTypeId" cssClass="errors"/>--%>
        <%--<br/>--%>
        <%--<form:input path="detTypeId" size="30" maxlength="80"/>--%>
      <%--</th>--%>
    <%--</tr>--%>
    <tr>
      <th>
          State: <form:errors path="State" cssClass="errors"/>
        <br/>
        <form:input path="State" size="30" maxlength="80"/>
      </th>
    </tr>
    <tr>
      <th>
          Raids: <form:errors path="Raids" cssClass="errors"/>
        <br/>
        <form:input path="Raids" size="30" maxlength="80"/>
      </th>
    </tr>
    <tr>
      <th>
          Name: <form:errors path="Name" cssClass="errors"/>
        <br/>
        <form:input path="Name" size="30" maxlength="80"/>
      </th>
    </tr>
    <tr>
      <th>
          Size: <form:errors path="Size" cssClass="errors"/>
        <br/>
        <form:input path="Size" size="30" maxlength="80"/>
      </th>
    </tr>
    <tr>
      <th>
          Weight: <form:errors path="Weight" cssClass="errors"/>
        <br/>
        <form:input path="Weight" size="30" maxlength="80"/>
      </th>
    </tr>
    <tr>
      <td>
            <p class="submit"><input type="submit" value="Update Detail"/></p>
      </td>
    </tr>
  </table>
</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
