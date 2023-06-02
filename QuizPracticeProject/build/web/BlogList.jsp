<%-- 
    Document   : BlogList
    Created on : May 22, 2023, 8:19:09 AM
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<%@page import = "model.Blog" %>
<%@page import = "model.Blog_Category" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/BlogList.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>JSP Page</title>
    </head>
    
    <%
    if (session.getAttribute("user") != null) {
       // Nếu có user, bao gồm trang cusheader.jsp
    %>
    <%@ include file="components/CusHeader.jsp" %>
    <%
} else {
    // Nếu không có user, bao gồm trang header.jsp
    %>
    <%@ include file="components/Header.jsp" %>
    <%
}
    %>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

    <body>
<!--        Main layout
        <div class="container">
            Section: News of the day
            <section class="border-bottom pb-4 mb-5">
                <div class="row gx-5">
                    <div class="col-md-6 mb-4">
                        <div class="bg-image hover-overlay ripple shadow-2-strong rounded-5" data-mdb-ripple-color="light">
                            <img src="https://mdbcdn.b-cdn.net/img/new/slides/080.webp" class="img-fluid" />
                            <a href="#!">
                                <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                            </a>
                        </div>
                    </div>

                    <div class="col-md-6 mb-4">
                        <span class="badge bg-danger px-2 py-1 shadow-1-strong mb-3">News of the day</span>
                        <h4><strong>Facilis consequatur eligendi</strong></h4>
                        <p class="text-muted">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis consequatur
                            eligendi quisquam doloremque vero ex debitis veritatis placeat unde animi laborum
                            sapiente illo possimus, commodi dignissimos obcaecati illum maiores corporis.
                        </p>
                        <button type="button" class="btn btn-primary">Read more</button>
                    </div>
                </div>
            </section>
            Section: News of the day

            Section: Content
            <section>
                <div class="row gx-lg-5">
                    <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                         News block 
                        <div>
                             Featured image 
                            <div class="bg-image hover-overlay shadow-1-strong ripple rounded-5 mb-4"
                                 data-mdb-ripple-color="light">
                                <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/113.webp" class="img-fluid" />
                               Article title and description 
                            <a href="" class="text-dark">
                                <h5>This is title of the news</h5>

                                <p>
                                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit, iste aliquid. Sed
                                    id nihil magni, sint vero provident esse numquam perferendis ducimus dicta
                                    adipisci iusto nam temporibus modi animi laboriosam?
                                </p>
                            </a>

                            <hr />

                             News 
                            <a href="" class="text-dark">
                                <div class="row mb-4 border-bottom pb-2">
                                    <div class="col-3">
                                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/041.webp"
                                             class="img-fluid shadow-1-strong rounded" alt="Hollywood Sign on The Hill" />
                                    </div>

                                    <div class="col-9">
                                        <p class="mb-2"><strong>Lorem ipsum dolor sit amet</strong></p>
                                        <p>
                                            <u> 15.07.2020</u>
                                        </p>
                                    </div>
                                </div>
                            </a>

                             News 
                            <a href="" class="text-dark">
                                <div class="row mb-4 border-bottom pb-2">
                                    <div class="col-3">
                                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/042.webp"
                                             class="img-fluid shadow-1-strong rounded" alt="Palm Springs Road" />
                                    </div>

                                    <div class="col-9">
                                        <p class="mb-2"><strong>Lorem ipsum dolor sit amet</strong></p>
                                        <p>
                                            <u> 15.07.2020</u>
                                        </p>
                                    </div>
                                </div>
                            </a>

                             News 
                            <a href="" class="text-dark">
                                <div class="row mb-4 border-bottom pb-2">
                                    <div class="col-3">
                                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/043.webp"
                                             class="img-fluid shadow-1-strong rounded" alt="Los Angeles Skyscrapers" />
                                    </div>

                                    <div class="col-9">
                                        <p class="mb-2"><strong>Lorem ipsum dolor sit amet</strong></p>
                                        <p>
                                            <u> 15.07.2020</u>
                                        </p>
                                    </div>
                                </div>
                            </a>

                             News 
                            <a href="" class="text-dark">
                                <div class="row mb-4 border-bottom pb-2">
                                    <div class="col-3">
                                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/044.webp"
                                             class="img-fluid shadow-1-strong rounded" alt="Skyscrapers" />
                                    </div>

                                    <div class="col-9">
                                        <p class="mb-2"><strong>Lorem ipsum dolor sit amet</strong></p>
                                        <p>
                                            <u> 15.07.2020</u>
                                        </p>
                                    </div>
                                </div>
                            </a>
                        </div>
                         News block 
                    </div>

                    <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                         News block 
                        <div>
                             Featured image 
                            <div class="bg-image hover-overlay shadow-1-strong rounded-5 ripple mb-4"
                                 data-mdb-ripple-color="light">
                                <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/011.webp" class="img-fluid"
                                     alt="Brooklyn Bridge" />
                                <a href="#!">
                                    <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                                </a>
                            </div>

                             Article data 
                            <div class="row mb-3">
                                <div class="col-6">
                                    <a href="" class="text-danger">
                                        <i class="fas fa-chart-pie"></i>
                                        Business
                                    </a>
                                </div>

                                <div class="col-6 text-end">
                                    <u> 15.07.2020</u>
                                </div>
                            </div>

                             Article title and description 
                            <a href="" class="text-dark">
                                <h5>This is title of the news</h5>

                                <p>
                                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit, iste aliquid. Sed
                                    id nihil magni, sint vero provident esse numquam perferendis ducimus dicta
                                    adipisci iusto nam temporibus modi animi laboriosam?
                                </p>
                            </a>

                            <hr />

                             News 
                            <a href="" class="text-dark">
                                <div class="row mb-4 border-bottom pb-2">
                                    <div class="col-3">
                                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/031.webp"
                                             class="img-fluid shadow-1-strong rounded" alt="Five Lands National Park" />
                                    </div>

                                    <div class="col-9">
                                        <p class="mb-2"><strong>Lorem ipsum dolor sit amet</strong></p>
                                        <p>
                                            <u> 15.07.2020</u>
                                        </p>
                                    </div>
                                </div>
                            </a>

                             News 
                            <a href="" class="text-dark">
                                <div class="row mb-4 border-bottom pb-2">
                                    <div class="col-3">
                                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/032.webp"
                                             class="img-fluid shadow-1-strong rounded" alt="Paris - Eiffel Tower" />
                                    </div>

                                    <div class="col-9">
                                        <p class="mb-2"><strong>Lorem ipsum dolor sit amet</strong></p>
                                        <p>
                                            <u> 15.07.2020</u>
                                        </p>
                                    </div>
                                </div>
                            </a>

                             News 
                            <a href="" class="text-dark">
                                <div class="row mb-4 border-bottom pb-2">
                                    <div class="col-3">
                                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/033.webp"
                                             class="img-fluid shadow-1-strong rounded" alt="Louvre" />
                                    </div>

                                    <div class="col-9">
                                        <p class="mb-2"><strong>Lorem ipsum dolor sit amet</strong></p>
                                        <p>
                                            <u> 15.07.2020</u>
                                        </p>
                                    </div>
                                </div>
                            </a>

                             News 
                            <a href="" class="text-dark">
                                <div class="row mb-4 border-bottom pb-2">
                                    <div class="col-3">
                                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/034.webp"
                                             class="img-fluid shadow-1-strong rounded" alt="Times Square" />
                                    </div>

                                    <div class="col-9">
                                        <p class="mb-2"><strong>Lorem ipsum dolor sit amet</strong></p>
                                        <p>
                                            <u> 15.07.2020</u>
                                        </p>
                                    </div>
                                </div>
                            </a>
                        </div>
                         News block 
                    </div>

                    <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                         News block 
                        <div>
                             Featured image 
                            <div class="bg-image hover-overlay shadow-1-strong rounded-5 ripple mb-4"
                                 data-mdb-ripple-color="light">
                                <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/018.webp" class="img-fluid"
                                     alt="Golden Gate National Recreation Area" />
                                <a href="#!">
                                    <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                                </a>
                            </div>

                             Article data 
                            <div class="row mb-3">
                                <div class="col-6">
                                    <a href="" class="text-warning">
                                        <i class="fas fa-code"></i>
                                        Technology
                                    </a>
                                </div>

                                <div class="col-6 text-end">
                                    <u> 15.07.2020</u>
                                </div>
                            </div>

                             Article title and description 
                            <a href="" class="text-dark">
                                <h5>This is title of the news</h5>

                                <p>
                                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit, iste aliquid. Sed
                                    id nihil magni, sint vero provident esse numquam perferendis ducimus dicta
                                    adipisci iusto nam temporibus modi animi laboriosam?
                                </p>
                            </a>

                            <hr />

                             News 
                            <a href="" class="text-dark">
                                <div class="row mb-4 border-bottom pb-2">
                                    <div class="col-3">
                                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/011.webp"
                                             class="img-fluid shadow-1-strong rounded" alt="Brooklyn Bridge" />
                                    </div>

                                    <div class="col-9">
                                        <p class="mb-2"><strong>Lorem ipsum dolor sit amet</strong></p>
                                        <p>
                                            <u> 15.07.2020</u>
                                        </p>
                                    </div>
                                </div>
                            </a>

                             News 
                            <a href="" class="text-dark">
                                <div class="row mb-4 border-bottom pb-2">
                                    <div class="col-3">
                                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/012.webp"
                                             class="img-fluid shadow-1-strong rounded" alt="Hamilton Park" />
                                    </div>

                                    <div class="col-9">
                                        <p class="mb-2"><strong>Lorem ipsum dolor sit amet</strong></p>
                                        <p>
                                            <u> 15.07.2020</u>
                                        </p>
                                    </div>
                                </div>
                            </a>

                             News 
                            <a href="" class="text-dark">
                                <div class="row mb-4 border-bottom pb-2">
                                    <div class="col-3">
                                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/013.webp"
                                             class="img-fluid shadow-1-strong rounded" alt="Perdana Botanical Garden Kuala Lumpur" />
                                    </div>

                                    <div class="col-9">
                                        <p class="mb-2"><strong>Lorem ipsum dolor sit amet</strong></p>
                                        <p>
                                            <u> 15.07.2020</u>
                                        </p>
                                    </div>
                                </div>
                            </a>

                             News 
                            <a href="" class="text-dark">
                                <div class="row mb-4 border-bottom pb-2">
                                    <div class="col-3">
                                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/014.webp"
                                             class="img-fluid shadow-1-strong rounded" alt="Perdana Botanical Garden" />
                                    </div>

                                    <div class="col-9">
                                        <p class="mb-2"><strong>Lorem ipsum dolor sit amet</strong></p>
                                        <p>
                                            <u> 15.07.2020</u>
                                        </p>
                                    </div>
                                </div>
                            </a>
                        </div>
                         News block 
                    </div>
                </div>
            </section>
            Section: Content

             Pagination 
            <nav class="my-4" aria-label="...">
                <ul class="pagination pagination-circle justify-content-center">
                    <li class="page-item">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item active" aria-current="page">
                        <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
        </div>           <a href="#!">
                                    <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                                </a>
                            </div>

                             Article data 
                            <div class="row mb-3">
                                <div class="col-6">
                                    <a href="" class="text-info">
                                        <i class="fas fa-plane"></i>
                                        Travels
                                    </a>
                                </div>

                                <div class="col-6 text-end">
                                    <u> 15.07.2020</u>
                                </div>
                            </div>

                   
        Main layout-->
                <div class="blog_list">
        
                    <div class="boxContainer col-md-7">
        <c:forEach items="${listBlog}" var="Blog">
            <div class="box">
                <div class="video">
                    <a href="blogDetail?id=${Blog.getId()}"><img src="${Blog.getThumbnail()}" width="100%" height="100%" alt="Ảnh"></a>
                </div>
                <div class="content">
                    <h4>${Blog.getTitle()}</h4>
                    <p>${Blog.getContent()}</p>
                </div>

            </div>
        </c:forEach>
    </div>

    <div class="search">
        <form action="searchpost">
            <input
                value="${key}"

                type="search"
                placeholder="Search by exam name"
                aria-label="Search"
                name="keyword"
                />
            <button class="btn" type="submit">
                Search
            </button>
            <select>
        <c:forEach items="${listCategory}" var="Blog_Category">
            <option>${Blog_Category.getName()}</option>
        </c:forEach>
    </select>
    <div class="thumbnail_container">
        <c:forEach varStatus="loop" items="${listBlog}" var="Blog">
            <c:if test="${loop.index < 2}">
                <div class="tn1"> 
                ${Blog.getTitle()}
                <div class="video">
                    <a href="blogDetail?id=${Blog.getId()}"><img src="${Blog.getThumbnail()}" width="100%" height="100%" alt="Ảnh"></a>
                </div>
            </div>
            </c:if>
        </c:forEach>
        <div class="contact">
            <h3>Static<br><span>contacts/links</span></h3>


        </div>
    </div>          
</form>
</div>
</div>
        <%@include file = "Login.jsp"%>  
    </body>
    <%@include file="components/Footer.jsp" %>
</html>
