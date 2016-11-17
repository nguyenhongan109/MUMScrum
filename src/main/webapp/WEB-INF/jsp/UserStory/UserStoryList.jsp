<%@ page import="java.sql.Date" %>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>

<div class="container">
    <c:if test="${not empty message}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${message}</strong>
        </div>
    </c:if>
    <h1>All User Stories</h1>
    <c:out value="${session.employee.role}"></c:out>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Estimated Effort</th>
            <th>Actual Effort</th>
            <th>Completed Date</th>
            <th>Assigned Date</th>
            <th>Status</th>
        </tr>
        </thead>

        <c:forEach var="us" items="${userstories}">
            <tr>
                <td>${us.uid}</td>
                <td>${us.name}</td>
                <td>${us.description}</td>
                <td>${us.estimatedEffort}</td>
                <td>${us.actualEffort}</td>
                <td>${us.ComDate()}</td>
                <td>${us.assignedDate}</td>
                <td>${us.status}</td>
                <td>
                    <spring:url value="/userstoryupdate/${us.uid}" var="updateUrl"/>
                    <spring:url value="/userstorydelete/${us.uid}" var="deleteUrl"/>
                    <button class="btn btn-info" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-primary" onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
            </tr>
        </c:forEach>


    </table>
</div>

