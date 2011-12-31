<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/templates/header.jsp" %>
<h1>Liste des interventions</h1>
<c:choose>
<c:when test="${empty interventions}">
<p>Vous n'avez aucune intervention...</p>
</c:when>
<c:otherwise>
<table>
<thead>
<tr>
	<th>Sujet</th>
	<th>Campus</th>
	<th>Du</th>
	<th>Au</th>
	<th>Status</th>
	<th>Note globale</th>
	<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach items="${interventions}" var="intervention">
<tr>
	<td><c:out value="${intervention.name}" /></td>
	<td><c:out value="${intervention.campus.name}" /></td>
	<td><c:out value="${intervention.dateStart}" /></td>
	<td><c:out value="${intervention.dateEnd}" /></td>
	<td><c:out value="${intervention.getGlobalNote()}" /></td>
	<td></td>	
</tr>
</c:forEach>
</tbody>
</table>
</c:otherwise>
</c:choose>
<p><a href="<c:out value="${baseUrl}" />/speaker/intervention/edit/">Ajouter une intervention</a></p>
<%@ include file="/templates/footer.jsp" %>