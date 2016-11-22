<%@ page import="java.sql.Date" %>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>

<div class="container">
    <h1>All User Stories</h1>
    <c:out value="${session.employee.role}"></c:out>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>DeveloperID</th>
        </tr>
        </thead>

        <c:forEach var="us" items="${AssignDevUSList}">
            <tr>
                <td>${us.uid}</td>
                <td>${us.name}</td>
                <td>${us.description}</td>
                <td>${us.eid}</td>
                <td>
                    <spring:url value="/AssignDevList/${us.uid}" var="updateUrl"/>
                    <button class="btn btn-info" onclick="location.href='${updateUrl}'">Assign</button>
                </td>
            </tr>
        </c:forEach>


    </table>
</div>

