<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/templates/header.jsp" %>
<h1>Interventions du campus de <c:out value="${campusName}" /></h1>
<c:choose>
<c:when test="${empty interventions}">
<p>Aucune intervention enregistrée sur ce campus.</p>
</c:when>
<c:otherwise>
<table>
	<thead>
	<tr>
		<th>Sujet</th>
		<th>Début</th>
		<th>Fin</th>
		<th>Status</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${interventions}" var="intervention">
	<tr>
		<td><a href="<c:out value="${baseUrl}" />/intervention/view/?id=<c:out value="${intervention.id}" />"><c:out value="${intervention.name}" /></a></td>
		<td><c:out value="${intervention.dateStart}" /></td>
		<td><c:out value="${intervention.dateEnd}" /></td>
		<td><c:out value="${intervention.status}" /></td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:otherwise>
</c:choose>
<%@ include file="/templates/footer.jsp" %>