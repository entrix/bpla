<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<c:set var="method" value="post"/>

<h2>Views:</h2>

<form:form action="http://localhost:8080/meteo/views.form2" method="${method}">
<input type="hidden" name="metId" value="100500"/>
  <table>
    <tr>
        <table>
          <thead>
            <th>Id</th>
            <th>Name</th>
            <th>Type</th>
          </thead>
          <c:forEach var="rsmc" items="${rsmcs}">
            <tr>
            <!--
              <td>
                    <input style="margin-top: 6px;" type="checkbox" name="${rsmc.id}" value="">
              </td>
            -->
              <td>${rsmc.id}</td>
              <td>${rsmc.name}</td>
              <td>${rsmc.type}</td>
              <td>
                <spring:url value="rsmcs/{rsmcId}" var="descriptionUrl">
                  <spring:param name="rsmcId" value="${rsmc.id}"/>
                </spring:url>
                <a href="${fn:escapeXml(descriptionUrl)}">more</a>
              </td>
            </tr>
          </c:forEach>
        </table>
        <!-- <p class="submit"><input type="submit" value="Update View"/></p> -->
    </tr>
  </table>
</form:form>


<%@ include file="/WEB-INF/jsp/footer.jsp" %>