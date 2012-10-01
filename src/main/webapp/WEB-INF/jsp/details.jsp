<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<c:set var="method" value="post"/>

<h2>Details:</h2>

<form:form action="http://localhost:8080/bpla/details.form2" method="${method}">
<input type="hidden" name="bplaId" value="100500"/>
  <table>
    <tr>
        <table>
          <thead>
            <th width="200">/</th>
            <th width="200">Id</th>
            <th width="200">Detail Type Id</th>
            <th width="200">State</th>
            <th width="200">Raids</th>
            <th width="200">Name</th>
            <th width="200">Weight</th>
            <th width="200">Size</th>
          </thead>
          <c:forEach var="detail" items="${details}">
            <tr>
              <td width="200">
                    <input style="margin-top: 6px;" type="checkbox" name="${detail.id}" value="">
              </td>
              <td width="200">${detail.id}</td>
              <td width="200">${detail.detTypeId}</td>
              <td width="200">${detail.state}</td>
              <td width="200">${detail.raids}</td>
              <td width="200">${detail.name}</td>
              <td width="200">${detail.weight}</td>
              <td width="200">${detail.size}</td>
            </tr>
          </c:forEach>
        </table>
        <p class="submit"><input type="submit" value="Update Detail"/></p>
    </tr>
  </table>
</form:form>


<%@ include file="/WEB-INF/jsp/footer.jsp" %>
