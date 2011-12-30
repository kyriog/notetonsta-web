<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/templates/header.jsp" %>
<div class="row"><div class="span16"><h1><c:out value="${intervention.name}" /></h1></div></div>
<div class="row">
	<div class="span-one-third">Campus : <c:out value="${intervention.campus.name}" /></div>
	<div class="span-one-third">Du : <c:out value="${intervention.dateStart}" /></div>
	<div class="span-one-third">Au : <c:out value="${intervention.dateEnd}" /></div>
</div>
<p><c:out value="${intervention.description}" /></p>
<ul>
	<li>Nombre de note : <c:out value="${intervention.getNoteCount()}" /></li>
	<c:if test="${intervention.getNoteCount() > 0}">
	<li>Moyenne de l'intervenant : <c:out value="${intervention.getSpeakerNote()}" />/5</li>
	<li>Moyenne des slides : <c:out value="${intervention.getSlideNote()}" />/5</li>
	<li>Moyenne globale de l'intervention : <c:out value="${intervention.getGlobalNote()}" />/5</li>
	</c:if>
</ul>
<a href="<c:out value="${baseUrl}" />/intervention/evaluate/?id=<c:out value="${intervention.id}" />">Evaluer cette intervention</a>
<%@ include file="/templates/footer.jsp" %>