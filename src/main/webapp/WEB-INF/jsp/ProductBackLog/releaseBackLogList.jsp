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
    <h1>All Release BackLogs</h1>
    <spring:url value="/releaseBackLog/${currentProductBackLog}" var="newURL"/>
    <button class="btn btn-link" onclick="location.href='${newURL}'">Create new</button>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Product Backlog</th>
            <th>Product Owner</th>
            <th>Name</th>
            <th>Description</th>
            <th>Release Date</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach var="releaseBL" items="${releaseBackLogList}">
            <tr>

                <td>${releaseBL.rid}</td>
                <td>${releaseBL.pid}</td>
                <td>${releaseBL.uid}</td>
                <td>${releaseBL.name}</td>
                <td>${releaseBL.description}</td>
                <td>${releaseBL.releaseDate}</td>
                <td>
                    <spring:url value="/releaseBackLog/${releaseBL.pid}/${releaseBL.rid}" var="updateUrl"/>
                    <button class="btn btn-link" onclick="location.href='${updateUrl}'">Update</button>
                    <spring:url value="/releaseBackLog/${releaseBL.pid}/${releaseBL.rid}/delete" var="deleteUrl"/>
                    <button class="btn btn-link" onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>