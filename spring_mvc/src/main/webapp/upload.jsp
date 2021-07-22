<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Upload</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/show20" method="post" enctype="multipart/form-data">
        名称: <input type="text" name="username"/><br/>
        文件: <input type="file" name="myFile"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>