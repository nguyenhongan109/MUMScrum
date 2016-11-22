<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<%@ page import="edu.mum.se.mumscrum.utilities.Status" %>

<div class="container">
    <h1>All Sprint</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Assign Date</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Status</th>
        </tr>
        </thead>

        <c:forEach var="s" items="${sprints}">
            <tr>

                <td>${s.sid}</td>
                <td>${s.name}</td>
                <td>${s.description}</td>
                <td>${s.assignedDate}</td>
                <td>${s.startDate}</td>
                <td>${s.endDate}</td>
                <td>${Status.valueOf(s.status).desc()}</td>
                <td>
                    <spring:url value="/sprintupdate/${s.sid}" var="updateUrl"/>
                    <spring:url value="/sprintdelete/${s.sid}" var="deleteUrl"/>
                    <button class="btn btn-info" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-primary" onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

