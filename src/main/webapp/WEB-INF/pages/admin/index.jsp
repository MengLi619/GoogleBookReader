<%@ page language="java" contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>bookstore</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/import">
    <div>
        <label for="url">导入Url：</label>
        <input type="text" id="url" name="url" style="width: 200px"/>
    </div>
    <div>
        <input type="submit" value="导入"/>
    </div>
</form>
</body>
</html>