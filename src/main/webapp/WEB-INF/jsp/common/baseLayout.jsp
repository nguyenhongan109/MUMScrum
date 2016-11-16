<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../assets/css/bootstrap-united.css" rel="stylesheet"/>
    <link href="../../../bootstrap/css/bootstrap-responsive.css" rel="stylesheet"/>
    <link href="../../../bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <link href="../../../datepicker/css/datepicker.css" rel="stylesheet"/>
    <link href="../../../assets/css/bootstrap-united.css" rel="stylesheet"/>

    <script src="../../../js/jquery-1.11.3.js"
            type="text/javascript"></script>
    <script src="../../../js/jquery.validate.min.js"
            type="text/javascript"></script>

    <style type="text/css">
        .error {
            color: #ff0000;
            font-size: 0.9em;
            font-weight: bold;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }

        div:empty {
            display: none;
        }
    </style>


</head>
<body>

<div>
    <%--
    <c:if test="${empty sessionScope.employee.role && loginPage!=true}">
        <c:redirect url="/login"></c:redirect>
    </c:if>
    --%>
</div>
<div>
    <tiles:insertAttribute name="menu"/>
</div>

<div>
    <tiles:insertAttribute name="head"/>
</div>

<div style="width: 99%;overflow-x: hidden">
    <tiles:insertAttribute name="body"/>
</div>

</body>
</html>
