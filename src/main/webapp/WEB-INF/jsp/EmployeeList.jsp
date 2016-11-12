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
                <td>${emp.id}</td>
                <td>${emp.firstName}</td>
                <td>${emp.lastName}</td>
                <td>${user.email}</td>
                <td>${emp.role}</td>

                <td>
                    <spring:url value="/users/${user.id}" var="userUrl"/>
                    <spring:url value="/users/${user.id}/delete" var="deleteUrl"/>
                    <spring:url value="/users/${user.id}/update" var="updateUrl"/>

                    <button class="btn btn-info"
                            onclick="location.href='${userUrl}'">Query
                    </button>
                    <button class="btn btn-primary"
                            onclick="location.href='${updateUrl}'">Update
                    </button>
                    <button class="btn btn-danger"
                            onclick="this.disabled=true;post('${deleteUrl}')">Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
