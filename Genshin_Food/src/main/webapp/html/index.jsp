<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/7/2023
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!--    Bootstrap 5-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <!--    My CSS-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css">
    <title>Main Page</title>
    <%--    Favicon--%>
    <link rel="shortcut icon" href="https://th.bing.com/th/id/OIP.f9P3mL2hwGb18tPEi0SA8wHaHa?pid=ImgDet&rs=1"
          type="image/x-icon">
</head>
<body>
<!--HEADER SECTION-->
<div class="container-fluid">
    <header>
        <nav class="navbar">
            <div class="container-fluid">
                <img src="https://th.bing.com/th/id/OIP.f9P3mL2hwGb18tPEi0SA8wHaHa?pid=ImgDet&rs=1"
                     style="width: 100px; height: 73px;" alt="genshin_icon">
                <div class="nav navbar-nav1">
                    <a href="#" class="btn btn3">HOME</a>
                    <a href="#" class="btn btn3">SHOP</a>
                    <a href="#" class="btn btn3">ABOUT</a>
                    <a href="#" class="btn btn3">CONTACT</a>
                </div>
                <div class="nav navbar-nav2">
                    <a href="foods?action=admin" class="btn btn2">Go to admin page</a>
                    <a href="#" class="btn btn2"><i class="fas fa-search"></i></a>
                    <a href="/foods?action=show" class="btn btn2"><i class="fas fa-shopping-cart"></i> <span
                            class="badge badge-danger" style="color: red"><c:out
                            value="${sessionScope['cart'].getQuantity()}"/></span></a>
                </div>
            </div>
        </nav>
    </header>
</div>
<!--CAROUSEL SECTION-->
<div class="container mt-4">
    <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://images.alphacoders.com/112/1123246.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://c4.wallpaperflare.com/wallpaper/312/1015/690/anime-girls-genshin-impact-chongyun-genshin-impact-xiangling-genshin-impact-xingqiu-genshin-impact-hd-wallpaper-preview.jpg"
                     class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://images2.alphacoders.com/120/1209038.jpg" class="d-block w-100" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>
<!--=============================-->
<h1 style="text-align: center" class="mt-4 mb-4">Special Foods</h1>
<!--PRODUCT CARD SECTION-->
<div class="container bg-transparent my-4 p-3" style="position: relative">
    <div class="row row-cols-1 row-cols-xs-2 row-cols-sm-2 row-cols-lg-4 g-3">
        <c:forEach items="${listFood}" var="food">
            <div class="col hp">
                <div class="card h-100 shadow-sm">
                    <a href="foods?action=detail&idFood=${food.getIdFood()}">
                        <img src="<c:out value="${food.getImgFood()}"/>" class="card-img-top"
                             alt="product.title"/>
                    </a>

                    <div class="label-top shadow-sm">
                        <a class="text-white" href="#"><c:out value="${food.getCountryFood()}"/> </a>
                    </div>
                    <div class="card-body">
                        <h4 class="card-text" style="text-align: center"><c:out value="${food.getNameFood()}"/></h4>
                        <div class="clearfix mb-3">
                            <span class="float-start badge rounded-pill bg-success"><c:out
                                    value="${food.getPriceFood()}"/> MORA </span>
                        </div>
                        <h5 class="card-title">
                            <a target="_blank" href="foods?action=detail&idFood=${food.getIdFood()}"><c:out
                                    value="${food.getDescriptionFood()}"/> </a>
                        </h5>

                        <div class="d-grid gap-2 my-4">

                            <a href="/AddToCartServlet?idFood=${food.getIdFood()}" class="btn btn-warning bold-btn">add
                                to cart</a>

                        </div>
                        <div class="clearfix mb-1">

                            <span class="float-start"><a href="#"><i class="fas fa-question-circle"></i></a></span>

                            <span class="float-end">
              <i class="far fa-heart" style="cursor: pointer"></i>

            </span>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<!--=============================-->
<!--FOOTER SECTION-->
<!-- Remove the container if you want to extend the Footer to full width. -->
<div class="container-fluid mt-5">
    <!-- Footer -->
    <footer class="text-center text-lg-start bg-light text-muted">
        <!-- Section: Social media -->
        <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
            <!-- Left -->
            <div class="me-5 d-none d-lg-block">
                <span>Get connected with us on social networks:</span>
            </div>
            <!-- Left -->

            <!-- Right -->
            <div>
                <a href="" class="me-4 text-reset">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a href="" class="me-4 text-reset">
                    <i class="fab fa-twitter"></i>
                </a>
                <a href="" class="me-4 text-reset">
                    <i class="fab fa-google"></i>
                </a>
                <a href="" class="me-4 text-reset">
                    <i class="fab fa-instagram"></i>
                </a>
                <a href="" class="me-4 text-reset">
                    <i class="fab fa-linkedin"></i>
                </a>
                <a href="" class="me-4 text-reset">
                    <i class="fab fa-github"></i>
                </a>
            </div>
            <!-- Right -->
        </section>
        <!-- Section: Social media -->

        <!-- Section: Links  -->
        <section class="">
            <div class="container text-center text-md-start mt-5">
                <!-- Grid row -->
                <div class="row mt-3">
                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                        <!-- Content -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            <i class="fas fa-gem me-3"></i>Company name
                        </h6>
                        <p>
                            Here you can use rows and columns to organize your footer content. Lorem ipsum
                            dolor sit amet, consectetur adipisicing elit.
                        </p>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            Products
                        </h6>
                        <p>
                            <a href="#!" class="text-reset">Angular</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">React</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Vue</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Laravel</a>
                        </p>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            Useful links
                        </h6>
                        <p>
                            <a href="#!" class="text-reset">Pricing</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Settings</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Orders</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Help</a>
                        </p>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                        <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
                        <p>
                            <i class="fas fa-envelope me-3"></i>
                            info@example.com
                        </p>
                        <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
                        <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
                    </div>
                    <!-- Grid column -->
                </div>
                <!-- Grid row -->
            </div>
        </section>
        <!-- Section: Links  -->

        <!-- Copyright -->
        <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
            © 2021 Copyright:
            <a class="text-reset fw-bold" href="https://mdbootstrap.com/">MDBootstrap.com</a>
        </div>
        <!-- Copyright -->
    </footer>
    <!-- Footer -->
</div>
<!-- End of .container -->
<!--============================-->
<!--SCRIPTS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>