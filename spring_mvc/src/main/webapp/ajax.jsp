<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>

<script>
    var list = new Array();
    list.push({name:"zhangsan",age:14});
    list.push({name:"lisi",age:19});

   $.ajax({
           type:"POST",
           url:"${pageContext.request.contextPath}/user/show13",
           data:JSON.stringify(list),
           contentType:"application/json;charset=utf-8"
       });
</script>
<body>
</body>
</html>