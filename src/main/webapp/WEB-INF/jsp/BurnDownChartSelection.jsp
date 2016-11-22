<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <c:if test="${not empty message}">
                        <div Class="message error">${message}</div>
                    </c:if>
                    <spring:url value="/employee" var="ActionUrl"/>
                    <form:form id="myForm" method="post" action="${ActionUrl}"
                               class="bs-example form-horizontal" commandName="sprint">
                        <fieldset>

                            <legend>Burn Down Chart Form</legend>
                            <div class="form-group">
                                <label for="sid" class="col-lg-3 control-label">Sprint</label>
                                <div class="col-lg-9">
                                    <form:select path="sid" id="sid" cssClass="form-control">
                                        <form:option value="0" label="--- Select ---"/>
                                        <form:options items="${sprints}" itemLabel="name" itemValue="sid"/>
                                    </form:select>
                                    <form:errors path="role" cssClass="error"/>
                                </div>
                            </div>

                            <div class="col-lg-9 col-lg-offset-3">
                                <spring:url value="/admin" var="adminUrl"/>

                                <button type="reset" class="btn btn-default" onclick="location.href='${adminUrl}'"
                                        formnovalidate>Cancel
                                </button>
                                <button class="btn btn-primary" data-toggle="modal"
                                        data-target="#themodal">View Chart
                                </button>
                            </div>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

