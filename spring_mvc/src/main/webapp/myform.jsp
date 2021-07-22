<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/show12" method="post">
        <!--表是第x个对象-->
        <input type="text" name="userList[0].name"/></br>
        <input type="text" name="userList[0].age"/></br>
        <hr/>
        <input type="text" name="userList[1].name"/></br>
        <input type="text" name="userList[1].age"/></br>
        <hr/>
        <input type="text" name="userList[2].name"/></br>
        <input type="text" name="userList[2].age"/></br>
        <hr/>
        <input type="submit" value="submit"/>
    </form>
</body>
</html>