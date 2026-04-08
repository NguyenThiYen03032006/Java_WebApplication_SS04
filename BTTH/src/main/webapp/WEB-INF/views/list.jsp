<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách bàn</title>
</head>
<body>
    <h1>Danh sách bàn</h1>

    <form action="${pageContext.request.contextPath}/list" method="get">
        Lọc sức chứa: <input name="cap" type="number"> <button type="submit">Tìm</button>
    </form>

    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Sức chứa (người)</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        <c:forEach var="t" items="${tables}">
            <tr>
                <td>${t.id}</td>
                <td>${t.capacity}</td>
                <td>${t.status}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/details/${t.id}">Chi tiết</a> |

                    <c:if test="${t.status == 'Trống'}">
                        <form action="${pageContext.request.contextPath}/update-status" method="post" style="display:inline">
                            <input type="hidden" name="id" value="${t.id}">
                            <input type="hidden" name="status" value="Đang sử dụng">
                            <button type="submit">Nhận bàn</button>
                        </form>
                    </c:if>
                    <c:if test="${t.status == 'Đang sử dụng'}">
                        <form action="${pageContext.request.contextPath}/update-status" method="post" style="display:inline">
                            <input type="hidden" name="id" value="${t.id}">
                            <input type="hidden" name="status" value="Trống">
                            <button type="submit">Trả bàn</button>
                        </form>
                    </c:if>
                    |
                    <form action="${pageContext.request.contextPath}/delete/${t.id}" method="post" style="display:inline">
                        <button type="submit" onclick="return confirm('Xóa bàn này?')">Xóa</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
