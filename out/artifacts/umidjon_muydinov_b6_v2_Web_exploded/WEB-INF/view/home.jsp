<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BOOKS</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <br>
    <c:if test="${user.customer==true}">
        <a class="btn btn-success" href="<c:url value="/books/get-save/${user.id}"/>">+Add Book</a>
        <hr>
    </c:if>

    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Title</th>
            <c:if test="${user.customer==true}">
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </c:if>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="books" items="${bookList}">
            <tr>
                <td>
                    <a
                            style="text-decoration: none"> ${books.name}</a>
                </td>
                <td><a
                        style="text-decoration: none"> ${books.title}</a>
                </td>

                <c:if test="${user.customer==true}">
                    <td><a class="btn btn-primary"
                           href="<c:url value="/books/get-edit/${books.id}"/>"><i
                            class="fas fa-edit"></i></a></td>
                    <td><a class="btn btn-danger" href="<c:url value="/books/delete/${books.id}"/>"> <i
                            class="fas fa-trash"></i> </a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>
</body>
</html>
