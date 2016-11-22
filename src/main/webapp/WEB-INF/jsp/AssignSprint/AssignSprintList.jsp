<%@ page import="java.sql.Date" %>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>

<div class="container">
    <h1>Assign Sprints</h1>
    <c:out value="${session.employee.role}"></c:out>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Scrum Master</th>
        </tr>
        </thead>

        <c:forEach var="sp" items="${sprints}">
            <tr>
                <td>${sp.name}</td>
                <td>${sp.description}</td>
                <td>${sp.startDate}</td>
                <td>${sp.endDate}</td>
                <td>${sp.assignedTo}</td>
                <td>
                    <spring:url value="/AssignSprint/${sp.sid}" var="updateUrl"/>
                    <button class="btn btn-info" onclick="location.href='${updateUrl}'">Assign Sprint</button>
                </td>
            </tr>
        </c:forEach>


    </table>
</div>

