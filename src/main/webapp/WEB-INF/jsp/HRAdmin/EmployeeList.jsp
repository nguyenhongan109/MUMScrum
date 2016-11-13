<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<form:form method="post" commandName="hb">
    <div class="container">
        <c:if test="${not empty message}">
            <div class="alert alert-${css} alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <strong>${message}</strong>
            </div>
        </c:if>
        <h1>All Employees</h1>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Role</th>
            </tr>
            </thead>
            <c:forEach var="emp" items="${employees}">
                <tr>
                    <form:hidden path="hiddenID" value="${emp.eid}"></form:hidden>
                    <td>${emp.eid}</td>
                    <td>${emp.firstName}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>${emp.role}</td>
                    <td>
                            <spring:url value="/employeeUpdate" var="updateUrl"/>
                        <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                </tr>
            </c:forEach>


        </table>
    </div>
</form:form>
