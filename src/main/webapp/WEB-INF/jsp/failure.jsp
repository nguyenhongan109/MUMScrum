<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!--
<legend>Student Enrollment Login Success</legend>
 -->
<div class="panel panel-danger">
    <div class="panel-heading">
        <h3 class="panel-title">MUMScrum System Login failure</h3>
    </div>
    <div class="panel-body">
        <div class="alert alert-dismissable alert-danger">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <strong>Oh snap!</strong> Something is wrong. Change a few things up
            and try submitting again.
        </div>
    </div>
</div>
<div></div>
<div></div>

<a class="btn btn-primary" href="<spring:url value="login.html"/>">Try
    again?</a>
</body>
</html>