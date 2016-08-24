<%@ page import="ru.javaresume.webapp.model.ContactType" %>
<%@ page import="ru.javaresume.webapp.util.HtmlUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Список всех резюме</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>
<section>
    <table>
        <tr>
            <td>
                <table border="1" cellpadding="8" cellspacing="0">
                    <tr>
                        <td colspan="5" style="text-align: right">
                            <a href="resume?action=create"><img src="img/add.png"> Добавить Резюме</a>
                        </td>
                    </tr>
                    <tr>
                        <th>Имя</th>
                        <th>Email</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <c:forEach items="${resumeList}" var="resume">
                        <jsp:useBean id="resume" type="ru.javaresume.webapp.model.Resume"/>
                        <tr>
                            <td><a href="resume?uuid=${resume.uuid}&action=view"><%=resume.getFullName()%>
                            </a></td>
                            <td><%=HtmlUtil.getContact(resume, ContactType.MAIL)%>
                            </td>
                            <td><a href="resume?uuid=${resume.uuid}&action=delete"><img src="img/delete.png"></a>
                            </td>
                            <td><a href="resume?uuid=${resume.uuid}&action=edit"><img src="img/pencil.png"></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
</section>
<jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>
</body>
</html>
