<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h2>Regional Station Meteo Centers Information</h2>

  <table>
    <tr>
      <th>Id</th>
      <td><b>${rsmc.id}</b></td>
    </tr>
    <tr>
      <th>Name</th>
      <td>${rsmc.name}</td>
    </tr>
    <tr>
      <th>Type</th>
      <td>${rsmc.type}</td>
    </tr>
  </table>

    <h2>Station Points Information</h2>

    <c:forEach var="point" items="${rsmc.points}">
      <table width="400">
        <tr>
          <td>
            <table>
              <tr>
                <th width="200">Id</th>
                <td width="200"><b>${point.id}</b></td>
              </tr>
              <tr>
                <th width="200">Name</th>
                <td width="200"><b>${point.name}</b></td>
              </tr>
              <tr>
                <th width="200">latitudeLatitude</th>
                <td width="200">${point.latitude}</td>
              </tr>
              <tr>
                <th width="200">Longitude</th>
                <td width="200">${point.longitude}</td>
              </tr>
              <tr>
                <th width="200">Sea Height</th>
                <td width="200"	>${point.seaHeight}</td>
              </tr>
              <tr>
                <td width="400">
                    <spring:url value="views/search/{pointId}" var="dataUrl">
                      <spring:param name="pointId" value="${point.id}"/>
                    </spring:url>
                    <a href="http://localhost:8080/meteo/views/list/${point.id}"><font color="blue"><b>view all data</b></font></a>
                </td>
              </tr>			  
            </table>
          </td>
        </tr>
      </table>
<!--
      <table class="table-buttons">
        <tr>
          <td>
            <spring:url value="{ownerId}/pets/{petId}/edit" var="petUrl">
              <spring:param name="ownerId" value="${owner.id}"/>
              <spring:param name="petId" value="${pet.id}"/>
            </spring:url>
            <a href="${fn:escapeXml(petUrl)}">Edit Pet</a>
          </td>
          <td></td>
          <td>
            <spring:url value="{ownerId}/pets/{petId}/visits/new" var="visitUrl">
              <spring:param name="ownerId" value="${owner.id}"/>
              <spring:param name="petId" value="${pet.id}"/>
            </spring:url>
            <a href="${fn:escapeXml(visitUrl)}">Add Visit</a>
          </td>
          <td></td>
          <td>
            <spring:url value="{ownerId}/pets/{petId}/visits.atom" var="feedUrl">
              <spring:param name="ownerId" value="${owner.id}"/>
              <spring:param name="petId" value="${pet.id}"/>
            </spring:url>
            <a href="${fn:escapeXml(feedUrl)}" rel="alternate" type="application/atom+xml">Atom Feed</a>
          </td>
        </tr>
      </table>
-->
   </c:forEach>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>