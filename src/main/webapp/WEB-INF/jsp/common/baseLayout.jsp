<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../assets/css/bootstrap-united.css" rel="stylesheet"/>
    <link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet"/>
    <link href="../bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <link href="../datepicker/css/datepicker.css" rel="stylesheet"/>
    <link href="../assets/css/bootstrap-united.css" rel="stylesheet"/>

    <style>
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
    </style>

</head>
<body>
<script src="../jquery-1.8.3.js">

</script>

<script src="../bootstrap/js/bootstrap.js">

</script>
<div>
    <tiles:insertAttribute name="menu"/>
</div>

<div>
    <tiles:insertAttribute name="head"/>
</div>

<div class="col-lg-6 col-lg-offset-3" >
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <tiles:insertAttribute name="body"/>
                </div>
            </div>
        </div>
   </div>
</div>
</body>
</html>
