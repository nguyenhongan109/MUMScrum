<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<%@ page import="edu.mum.se.mumscrum.utilities.Role" %>
<script>
    $(document).ready(function () {
        $('.${mySelectedClass}').addClass('active');
    });
</script>
<div class="navbar navbar-default">

    <%--
    <div class="navbar-header">
        <a class="navbar-brand"><span style="font-weight: bold;">MUMScrum System</span>
            | <span style="font-size: medium"> ${Role.valueOf(sessionScope.employee.role).desc()} </span></a>
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                class="icon-bar"></span>
        </button>
    </div>--%>
    <div class="navbar-collapse collapse navbar-responsive-collapse">
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${sessionScope.employee.role == 'ADMIN'}">
                    <li><a href="/admin">Home</a></li>
                    <li><a>|</a></li>
                    <li><a href="/employee">New Employee</a></li>
                    <li><a>|</a></li>
                    <li><a href="/login">Logout</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="#">Home</a></li>
                    <li><a href="/signupPage">Signup</a></li>
                    <li><a href="/login/loginPage">Login</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Explore<b
                            class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Contact us</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Further Actions</a></li>
                        </ul>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>


</div>
