<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<spring:url value="/employee" var="ActionUrl" />

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

                <td>${emp.eid}</td>
                <td>${emp.firstName}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.role}</td>
                <td>
                    <spring:url value="/admin/${emp.eid}" var="updateUrl"/>
                    <spring:url value="/employee/${emp.eid}/delete" var="deleteUrl"/>
                    <button class="btn btn-info" onclick="location.href='${updateUrl}'">Update</button>
                    <c:choose>
                        <c:when test="${emp.email == 'admin@gmail.com'}">
                            <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-primary" onclick="location.href='${deleteUrl}'">Delete</button>
                        </c:otherwise>
                    </c:choose>


                </td>
            </tr>
        </c:forEach>


    </table>
</div>

