<%--
  Created by IntelliJ IDEA.
  User: phandungmykieu
  Date: 11/12/16
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Task name</th>
            <th>Description</th>
            <th>Estimate Effort</th>
            <th></th>
        </tr>
        </thead>

        <c:forEach var="task" items="${USList}">
            <tr>
                <td>${task.getUid()}</td>
                <td>${task.getName()}</td>
                <td>${task.getDescription()}</td>
                <td>${task.getEstimatedEffort()}</td>

                <td>
                    <spring:url value="/estimateEffort/${task.uid}" var="taskUrl"/>
                    <c:if test="${empty task.getEstimatedEffort() || task.getEstimatedEffort() == 0 }">
                        <button class="btn btn-info"
                                onclick="location.href='${taskUrl}'">Estimate
                        </button>
                    </c:if>
                </td>

                <td>
                    <spring:url value="/updateEffort/${task.uid}" var="taskUrl"/>
                    <c:if test="${not empty task.getEstimatedEffort() || task.getEstimatedEffort() != 0 }">
                        <button class="btn btn-info"
                                onclick="location.href='${taskUrl}'">Update
                        </button>
                    </c:if>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>


