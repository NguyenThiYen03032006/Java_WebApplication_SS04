<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết bàn</title>
</head>
<body>
    <h1>Chi tiết bàn số ${t.id}</h1>
    <p><strong>ID:</strong> ${t.id}</p>
    <p><strong>Sức chứa:</strong> ${t.capacity} người</p>
    <p><strong>Trạng thái:</strong> ${t.status}</p>
    <br>
    <a href="${pageContext.request.contextPath}/list">Quay lại danh sách</a>
</body>
</html>
