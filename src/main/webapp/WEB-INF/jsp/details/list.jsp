<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<c:set var="method" value="post"/>

    <h2>Detail Type Information</h2>

      <table width="400">
        <tr>
          <td>
            <table>
              <tr>
                <th width="200">Id</th>
                <td width="200"><b>${detType.id}</b></td>
              </tr>
              <tr>
                <th width="200">Name</th>
                <td width="200"><b>${detType.name}</b></td>
              </tr>
              <tr>
                <th width="200">latitudeLatitude</th>
                <td width="200">${detType.size}</td>
              </tr>
              <tr>
                <th width="200">Longitude</th>
                <td width="200">${detType.weight}</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>

<h2>Views</h2>

<form:form id="editForm" action="http://localhost:8080/meteo/views.delete/${detType.id}" method="${method}" modelAttribute="delDetails">
<!-- <input type="hidden" name="metId" value="100500" /> -->
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
          <c:forEach var="detail" items="${details}" varStatus="status">
            <tr>

              <td>
                    <form:checkbox path="deletes" value="${detail.id}"/>
              </td>
              <td>
                    <form:input path="ids" value="${detail.detTypeId}"/>
              </td>
              <td>
					<form:input path="types" value="${detail.state}"/>
              </td>
              <td>
                    <form:input path="courses" value="${detail.raids}"/>
              </td>
<!--
              <td>${view.id}</td>
              <td>${view.pointId}</td>
              <td>${view.course}</td>
              <td>${view.force}</td>
              <td>${view.pressure}</td>
              <td>${view.quantity}</td>
              <td>${view.frequency}</td>
-->
            </tr>
          </c:forEach>
        </table>
        <div>
			<p style="float: left;" class="submit"><input type="submit" name="submit" value="Delete"/></p>
			<p style="float: left; margin-left: 50px;" class="submit"><input type="submit" name="submit" value="Update"/></p>
		</div>
    </tr>
  </table>
  
</form:form>
  
<%@ include file="/WEB-INF/jsp/footer.jsp" %>