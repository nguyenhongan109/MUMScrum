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
                    <form:form id="estimateForm" method="post"
                               class="bs-example form-horizontal" commandName="userStory">
                        <fieldset>
                            <legend>Update Estimate Effort</legend>
                            <c:out value="${userStory.description}"></c:out>
                            <div class="form-group">
                                <label for="estimation" class="col-lg-3 control-label">Actual Effort</label>
                                <div class="col-lg-8">
                                    <form:input type="text" class="form-control" path="actualEffort"
                                                id="estimation" placeholder="Estimation"/>
                                    <form:errors path="estimatedEffort" cssClass="error"/>

                                    <button class="btn btn-primary">Estimate</button>
                                  //show current date here then when click Update -> update Timelogs and Userstory
                                    <form:hidden path="uid"/>
                                    <form:hidden path="name"/>
                                    <form:hidden path="description"/>
                                    <form:hidden path="estimatedEffort"/>
                                    <form:hidden path="completDate"/>

                                </div>
                            </div>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>