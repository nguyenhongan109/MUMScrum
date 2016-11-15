<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<spring:url value="/productBackLogList" var="ActionUrl" />

<div class="container">
    <c:if test="${not empty message}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${message}</strong>
        </div>
    </c:if>
    <h1>All Product BackLogs</h1>
    <button class="btn btn-primary" onclick="location.href='/productBackLog'">Create new</button>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Status</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach var="pbl" items="${productBackLogList}">
            <tr>

                <td>${pbl.pid}</td>
                <td>${pbl.name}</td>
                <td>${pbl.description}</td>
                <td>${pbl.status}</td>
                <td>
                    <spring:url value="/productBackLog/${pbl.pid}" var="updateUrl"/>
                    <button class="btn btn-info" onclick="location.href='${updateUrl}'">Update</button>
                    <spring:url value="/productBackLog/${pbl.pid}/delete" var="deleteUrl"/>
                    <button class="btn btn-primary" onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

