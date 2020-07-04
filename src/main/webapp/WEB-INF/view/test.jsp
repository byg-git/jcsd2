<%--
  Created by IntelliJ IDEA.
  User: byg
  Date: 2020/7/2
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#dg').datagrid({
                url:'${pageContext.request.contextPath}/test/list',
                columns:[[
                    {field:'id',title:'id',width:100},
                    {field:'name',title:'Name',width:100},
                    {field:'pass',title:'pass',width:100,align:'right'}
                ]]
            });
        })
    </script>
</head>
<body>
<h1>this is my Test</h1>
<table id="dg"></table>
</body>
</html>
