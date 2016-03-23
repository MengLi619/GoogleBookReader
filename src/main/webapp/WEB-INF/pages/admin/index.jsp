<%@ page language="java" contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>bookstore</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/import" method="post">
    <div>
        <label for="query">查询关键字：</label>
        <input type="text" id="query" name="query" style="width: 200px"/>
    </div>
    <div>
        <label for="startIndex">开始索引：</label>
        <input type="number" id="startIndex" name="startIndex" value="0"/>
    </div>
    <div>
        <label for="maxResults">最大记录书：</label>
        <input type="number" id="maxResults" name="maxResults" max="40" value="40"/>
    </div>
    <div>
        <input type="submit" value="导入"/>
    </div>
</form>
</body>
</html>