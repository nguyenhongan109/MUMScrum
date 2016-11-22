<%--
  Created by IntelliJ IDEA.
  User: phandungmykieu
  Date: 11/14/16
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<div class="col-lg-7 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-7">
                    <form:form id="updateForm" method="POST"
                               class="bs-example form-horizontal" action="/updateEffort" commandName="timelogs">
                        <fieldset>
                            <legend>Update Estimate Effort</legend>
                            <c:out value="${sessionScope.userStory.description}"></c:out>
                            <div class="form-group">
                                <label for="update" class="col-lg-3 control-label">Today Effort</label>
                                <div class="col-lg-8">
                                    <form:input type="text" class="form-control" path="todayEffort"
                                                id="update" placeholder="Today effort"/>
                                    <form:errors path="todayEffort" cssClass="error"/>



                                        <%--<form:select path="${timelogs.status}">--%>
                                            <%--<form:option value="" label="--- Select ---"/>--%>
                                            <%--<form:options items="${statusList}"/>--%>
                                        <%--</form:select>--%>

                                    <button class="btn btn-primary">Update</button>


                                    <spring:url value="/effortList" var="cancelEstimate"/>

                                    <button type="reset" class="btn btn-default" onclick="location.href='${cancelEstimate}'"  formnovalidate>Cancel</button>

                                    <c:out value="<%= new java.util.Date() %>"></c:out>
                                    <form:hidden path="tid"/>
                                    <form:hidden path="uid"/>
                                    <form:hidden path="updatedDate"/>

                                </div>
                            </div>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>