<%--
  Created by IntelliJ IDEA.
  User: mehdi
  Date: 11/15/16
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<div class="container">

<c:if test="${bdc != null }">

    <c:if test="${bdc.onTime}">
        <div class="alert alert-success">
            OK : This sprint is  on Time !!!
            The dead line for this sprint is day number : ${bdc.deadLine}
        </div>
    </c:if>

    <c:if test="${! bdc.onTime}">
        <div class="alert alert-danger">
            Attention : This sprint is not on Time !!!
            The dead line for this sprint is Day number : ${bdc.deadLine}
        </div>
    </c:if>




<!-- Styles -->
    <style>
        #chartdiv {
            width: 100%;
            height: 500px;
        }
    </style>

    <!-- Resources -->
    <script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
    <script src="https://www.amcharts.com/lib/3/serial.js"></script>
    <script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
    <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
    <script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

    <!-- Chart code -->
    <script>
        var chart = AmCharts.makeChart( "chartdiv", {
            "type": "serial",
            "addClassNames": true,
            "theme": "light",
            "autoMargins": false,
            "marginLeft": 30,
            "marginRight": 8,
            "marginTop": 10,
            "marginBottom": 26,
            "balloon": {
                "adjustBorderColor": false,
                "horizontalPadding": 10,
                "verticalPadding": 8,
                "color": "#ffffff"
            } ,           "dataProvider":

                    [
                        <c:forEach items="${bdc.bars}" var="entry">
                        {

                            <c:if test="${(bdc.firstKey == entry.key) }">
                            "expenses": ${entry.value},
                            </c:if>
                            "day": ${entry.key},
                            "income": ${entry.value}
                        },
                        </c:forEach>



                        <c:if test="${bdc.lastKey != -1 &&  bdc.projected != -1 }">
                        <c:if test="${bdc.lastKey != bdc.projected }">

                        <c:forEach begin="${bdc.lastKey + 1}" end="${bdc.projected - 1}" varStatus="loop">
                        {
                            "day": ${loop.index},
                            "income": 0
                        },
                        </c:forEach>

                        {
                            "day": ${bdc.projected},
                            "expenses": 0
                        },


                        </c:if>
                        </c:if>


                    ]









            /*[ {

                "income": 50
            }, {
                "day": 2,
                "income": 45
            }, {
                "day": 3,
                "income": 40
            }, {
                "day": 4,
                "income": 30,
                "expenses2": 30

            }, {
                "day": 5,
                "income": 25,
                "expenses": 28.2,
                "expenses2": 50

            }, {
                "day": 6,
                "income": 20,
                "expenses": 20,
                "dashLengthColumn": 5,
                "alpha": 0.2,
                "additional": "(projection)"
            } ]*/,
            "valueAxes": [ {
                "axisAlpha": 0,
                "position": "left"
            } ],
            "startDuration": 1,
            "graphs": [ {
                "alphaField": "alpha",
                "balloonText": "<span style='font-size:12px;'>[[title]] in [[category]]:<br><span style='font-size:20px;'>[[value]]</span> [[additional]]</span>",
                "fillAlphas": 1,
                "title": "Income",
                "type": "column",
                "valueField": "income",
                "dashLengthField": "dashLengthColumn"
            }, {
                "id": "graph2",
                "balloonText": "<span style='font-size:12px;'>[[title]] in [[category]]:<br><span style='font-size:20px;'>[[value]]</span> [[additional]]</span>",
                "bullet": "round",
                "lineThickness": 3,
                "bulletSize": 7,
                "bulletBorderAlpha": 1,
                "bulletColor": "#FFFFFF",
                "useLineColorForBulletBorder": true,
                "bulletBorderThickness": 3,
                "fillAlphas": 0,
                "lineAlpha": 1,
                "title": "Expenses",
                "valueField": "expenses",
                "dashLengthField": "dashLengthLine"
            }
                , {
                    "id": "graph3",
                    "balloonText": "<span style='font-size:12px;'>[[title]] in [[category]]:<br><span style='font-size:20px;'>[[value]]</span> [[additional]]</span>",
                    "bullet": "round",
                    "lineThickness": 3,
                    "bulletSize": 7,
                    "bulletBorderAlpha": 1,
                    "bulletColor": "#bbbbbb",
                    "useLineColorForBulletBorder": true,
                    "bulletBorderThickness": 3,
                    "fillAlphas": 0,
                    "lineAlpha": 1,
                    "title": "Expenses2",
                    "valueField": "expenses2",
                    "dashLengthField": "dashLengthLine"
                }],
            "categoryField": "day",
            "categoryAxis": {
                "gridPosition": "start",
                "axisAlpha": 0,
                "tickLength": 0
            },
            "export": {
                "enabled": true
            }
        } );
    </script>

    <!-- HTML -->
    <div id="chartdiv"></div>
</c:if>
</div>
