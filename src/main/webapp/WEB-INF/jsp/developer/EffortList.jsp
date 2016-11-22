<%--
  Created by IntelliJ IDEA.
  User: phandungmykieu
  Date: 11/12/16
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<div class="container">
    <h1>Effort List</h1>
    This belongs to ${sessionScope.employee.firstName} ${sessionScope.employee.lastName}
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Task name</th>
            <th>Description</th>
            <th>Estimate Effort</th>
            <th>Actual Effort</th>
            <%--<th>Status</th>--%>
            <th></th>
            <th></th>
        </thead>

        <c:forEach var="task" items="${USList}">
            <tr>
                <td>${task.uid}</td>
                <td>${task.name}</td>
                <td>${task.description}</td>
                <td>${task.estimatedEffort}</td>
                <td>${task.actualEffort}</td>
                <%--<td>${task.status}</td>--%>
                <%--<td>--%>
                    <%--<c:if test="${task.status == 1}">--%>
                        <%--Processing--%>
                    <%--</c:if>--%>
                    <%--<c:if test="${task.status == 2}">--%>
                    <%--Complete--%>
                    <%--</c:if>--%>
                <%--<td>--%>
                <td>
                    <spring:url value="/estimateEffort/${task.uid}" var="taskUrl"/>
                    <c:if test="${empty task.estimatedEffort || task.estimatedEffort == 0 }">
                        <button class="btn btn-info"
                                onclick="location.href='${taskUrl}'">Estimate
                        </button>
                    </c:if>
                </td>

                <td>
                    <spring:url value="/updateEffort/${task.uid}" var="taskUrl"/>
                    <c:if test="${not empty task.estimatedEffort || task.estimatedEffort != 0 }">
                        <button class="btn btn-info"
                                onclick="location.href='${taskUrl}'">Update
                        </button>
                    </c:if>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>


