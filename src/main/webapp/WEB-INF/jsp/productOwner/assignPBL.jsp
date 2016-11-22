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
    <h1>Assign Product BackLogs To Scrum Master</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Status</th>
            <th>Assign To</th>
        </tr>
        </thead>
        <c:forEach var="pbl" items="${assignPBL}">
            <tr>

                <td>${pbl.pid}</td>
                <td>${pbl.name}</td>
                <td>${pbl.description}</td>
                <td>${pbl.status}</td>
                <td>${pbl.assignedTo}</td>
                <td>
                    <spring:url value="/assignPB/${pbl.pid}" var="assignUrl"/>
                    <button class="btn btn-link" onclick="location.href='${assignUrl}'">Assign</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

