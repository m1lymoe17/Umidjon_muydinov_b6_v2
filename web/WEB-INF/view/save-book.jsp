<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Book form</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>

<body>
<div class="container">
    <form style="width: 500px; margin: 0 auto;" action="/books/save" method="post">
        <div class="form-group" style="margin-top:30px">
            <label>Title</label>
            <input type="text" class="form-control" name="title" placeholder="Enter book title">
        </div>

        <div class="form-group" style="margin-top:30px">
            <label>Name</label>
            <input type="text" class="form-control" name="name" placeholder="Enter book name">
        </div>

        <input type="hidden" name="userId" value="${userId}">

        <button type="submit" class="btn btn-success" value="save" style="margin-top:30px">Save</button>
    </form>
</div>
</body>
</html>