<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        h1 {
            color: black;
            text-align: center;
        }
        body{
            background:linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)), url('https://static1.smartbear.co/smartbearbrand/media/images/blog/what%E2%80%99s-the-best-programming-language-to-learn-first.png?ext=.png');
            background-size: cover;
            background-repeat: no-repeat;
            background-position: top;
            background-color: rgba(0,0,0,0.1);

        }
    </style>

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Home</title>
</head>
<body>
<header style="box-shadow: -20px -5px 20px">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-white">
        <div class="container-fluid">
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#navbarExample01"
                    aria-controls="navbarExample01"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarExample01">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item ">
                        <a class="nav-link active"  href="#" style="background-color: #eee">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/mentors">Mentors</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link  " href="/courses" >Courses</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/about">About</a>
                    </li>
                    <li class="nav-item">
                        <c:if test="${user==null}">
                            <button class="form-control" value="sign in"
                                    name="button"><a href="<c:url value="/login/"/>">Sign in</a></button>
                        </c:if>

                        <c:if test="${user!=null}">
                            <button class="form-control" value="sign out"
                                    name="button"><a href="<c:url value="/login/log_out"/>">Log out</a></button>
                        </c:if>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Navbar -->

</header>
<div class="container fluid">

    <style>
        * {

            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Roboto Thin";
        }
        .main {
            position: relative;
        }

        h1 {
            position: absolute;
            margin-top: 180px;
            width: 30%;
            margin-left: 70px;
            font-size: 40px;
            font-weight: 500;
        }

        p {
            position: absolute;
            margin-top: 350px;
            margin-left: 70px;
            font-size: 15px;
            width: 20%;
        }

        button {
            position: absolute;
            margin-top: 460px;
            margin-left: 190px;
            padding: 12px;
            border-radius: 50px;
            background: rgb(54, 166, 204);
            font-weight: bold;
            box-shadow:5px 5px 15px black;
            border: 1px solid;
        }


        .box1 {
            position: relative;
        }
        .box2 {
            position: absolute;
            top: 300px;
            right: 150px;
            margin-right: 100px;
            width: 100px;
            height: 100px;
        }
        .box2 > img {
            position: relative;
            width: 100%;
        }



    </style>

    <div class="main" >
        <h1 style="color: white; text-shadow: black 5px 8px 8px ">Choose and start learning what interests you
            Online course from leading universities and companies</h1>
        <button type="button" class="btn btn-primary btn-lg" style="font-family: sans-serif">Start Learning</button>

    </div>

</div>
</body>
</html>