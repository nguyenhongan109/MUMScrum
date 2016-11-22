<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<div class="container">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${css} alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <h3><strong class="error">${message}</strong></h3>
                        </div>
                    </c:if>
                    <h4>User Stories List to Assign to the Sprint</h4>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                    <c:forEach var="usn" items="${userstory}">
                        <tr>
                            <td>${usn.name}</td>
                            <td>${usn.description}</td>
                            <td>
                                <spring:url value="/assignSprintUpdate/${usn.uid}" var="updateUrl"/>
                                <button class="btn btn-info" onclick="location.href='${updateUrl}'">ADD</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </table>
                    <h4>Assigned User Stories List</h4>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                    <c:forEach var="us" items="${userstorybysid}">
                        <tr>
                            <td>${us.name}</td>
                            <td>${us.description}</td>
                            <td>
                                <spring:url value="/assignSprintdelete/${us.uid}" var="deleteUrl"/>
                                <button class="btn btn-info" onclick="location.href='${deleteUrl}'">DELETE</button>
                            </td>
                        </tr>
                    </c:forEach>
      </table>
</div>

