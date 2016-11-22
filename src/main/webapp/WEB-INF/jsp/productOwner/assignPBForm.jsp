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
                    <form:form id="myForm" method="post" action = "/assignPB"
                               class="bs-example form-horizontal" commandName="productBackLog">
                        <fieldset>

                            <legend>Product BackLog Assign Form</legend>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Name</label>
                                <label class="col-lg-3 control-label"><c:out value="${productBackLog.name}"></c:out></label>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-3 control-label">Description</label>
                                <label class="col-lg-3 control-label"><c:out value="${productBackLog.description}"></c:out></label>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-3 control-label">Status</label>
                                <label class="col-lg-3 control-label"><c:out value="${productBackLog.status}"></c:out></label>
                            </div>



                            <div class="form-group">
                                <label class="col-lg-3 control-label">Assign To</label>

                                <form:select id="selectedRecord" name="selectedRecord" path = "assignedTo">

                                    <c:forEach var="employee" items="${employeeList}">

                                        <form:option value="${employee.firstName} ${employee.lastName}">${employee.firstName} ${employee.lastName}</form:option>

                                    </c:forEach>

                                </form:select>

                            </div>

                            <form:hidden path="name"/>
                            <form:hidden path="status"/>

                            <div class="col-lg-9 col-lg-offset-3">

                                <spring:url value="/assignPBL" var="pblURL"/>
                                <button type="reset" class="btn btn-default" onclick="location.href='${pblURL}'" formnovalidate>Cancel</button>

                                <button class="btn btn-primary" type="submit">Assign

                                </button>


                            </div>

                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>





