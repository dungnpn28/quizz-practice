<%-- 
    Document   : SubjectDetailAE
    Created on : Jun 25, 2023, 4:52:04 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">-->
        <link rel="stylesheet" href="css/SubjectDetailAE.css" type="text/css"/>
        <script src="js/subjectDetail.js" type="text/javascript"></script>



    </head>
    <body>
        <%@include file="components/CusHeader.jsp"%>
        <div class="wrapper">
            <%@include file="components/navbar.jsp" %>
            <div id="content">
                <h1>SUBJECT DETAILS</h1>
                <div id="confirmation-dialog" class="modal">
                    <div class="modal-content">
                        <p>Are you sure?</p>
                        <div class="buttons">
                            <button id="confirm-yes">Yes</button>
                            <button id="confirm-no" onclick="modalCloseHandler(event)">No</button>
                        </div>
                    </div>
                </div>

                <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link ${tab eq "home"?"active":""}" onclick="goToTab('home',${subjectId})" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="true">Overview</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link  ${tab eq "profile"?"active":""}" onclick="goToTab('profile',${subjectId})" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile" aria-selected="false">Dimension</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link  ${tab eq "contact"?"active":""}" onclick="goToTab('contact',${subjectId})" id="pills-contact-tab" data-bs-toggle="pill" data-bs-target="#pills-contact" type="button" role="tab" aria-controls="pills-contact" aria-selected="false">Price Package</button>
                    </li>
                </ul>
                    
                <div class="tab-content" id="pills-tabContent">
                    <div class="tab-pane  ${tab eq "home"?"show active":""}" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                        <form id="editoverview" action="editoverviewsubject" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
                            <div class="container row">
                                <h1>OVERVIEW</h1>
                                <input type="hidden" name="subjectId" id="subjectId" value="${subjectId}">
                                <div class="col-md-8">
                                    <!-- Input fields, dropdowns, and checkboxes -->
                                    <div class="mb-3">
                                        <label for="subjectName" class="form-label form-label-lg">Subject Name:</label>
                                        <input name="name" type="text" class="form-control form-control-lg" id="subjectName" placeholder="Enter subject name" value="${subject.getName()}" oninput="validateSubjectName()"">
                                        <div id="nameError" class="text-danger"> </div>

                                    </div>
                                    <div class="mb-3">
                                        <label for="category" class="form-label form-label-lg">Category:</label>
                                        <select class="form-select form-select-lg" name="category" id="category">                                          
                                            <c:forEach var="list_sc" items="${list_sc}">

                                                <option value="${list_sc.getId()}" ${list_sc.getId() == subject.category_id?"selected":""} >${list_sc.getName()}</option>

                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="mb-3 form-check">
                                        <c:if test="${sessionScope.user.getRole_id() == 5}">
                                            <input type="checkbox" class="form-check-input" name="featured" id="featured" ${subject.featured?"checked":""}>
                                        </c:if>
                                        <c:if test="${sessionScope.user.getRole_id() == 4}">
                                            <input type="checkbox" class="form-check-input" name="featured" id="featured" ${subject.featured?"checked disabled":" disabled"}>
                                        </c:if>
                                        <label class="form-check-label form-check-label-lg" for="featured">Featured Subject</label>
                                    </div>
                                    <div class="mb-3">
                                        <label for="status" class="form-label form-label-lg">Status:</label>
                                        <c:if test="${sessionScope.user.getRole_id() == 5}">
                                            <select class="form-select form-select-lg" id="status" name="status">
                                                <option value="false" ${subject.status== false?"selected":""}>Deactive</option>
                                                <option value="true" ${subject.status == true ?"selected":""}>Active</option>
                                                <!-- Add more options if needed -->
                                            </select>
                                        </c:if>
                                        <c:if test="${sessionScope.user.getRole_id() == 4}">
                                            <select class="form-select form-select-lg" id="status" name="status">
                                                <option value="false" ${subject.status== false?"selected":"hidden"}>Deactive</option>
                                                <option value="true" ${subject.status == true ?"selected":"hidden"}>Active</option>
                                                <!-- Add more options if needed -->
                                            </select>

                                        </c:if>

                                    </div>
                                    <div class="mb-3">

                                        <label for="author" class="form-label form-label-lg">Author:</label>
                                        <c:if test="${sessionScope.user.getRole_id() == 5}">
                                            <select class="form-select form-select-lg" id="author" name="owner">
                                                <c:forEach var="list_expert" items="${list_expert}">

                                                    <option value="${list_expert.getUser_id()}" ${subject.author_id == list_expert.getUser_id()?"selected":""}>${list_expert.getFull_name()}</option>

                                                </c:forEach>
                                                <!-- Add more options if needed -->
                                            </select>
                                        </c:if>
                                        <c:if test="${sessionScope.user.getRole_id() == 4}">
                                            <select class="form-select form-select-lg" id="author" name="owner">
                                                <c:forEach var="list_expert" items="${list_expert}">

                                                    <option value="${list_expert.getUser_id()}" ${subject.author_id == list_expert.getUser_id()?"selected":""} ${subject.author_id != list_expert.getUser_id()?"disabled hidden":""}>${list_expert.getFull_name()}</option>

                                                </c:forEach>
                                                <!-- Add more options if needed -->
                                            </select>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="col-md-4 d-flex flex-column justify-content-center align-items-center">
                                    <!-- Image -->
                                    <img id="imagePreview" src="uploads/${subject.illustration}" alt="Image" class="img-fluid">
                                    <br>
                                    <input id="fileInput" name="image" type="file" accept="image/*" onchange="loadFile(event)" hidden>
                                    <div class="mt-3">
                                        <button type="button" class="btn btn-primary" onclick="chooseFile()">Change avatar</button>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="mb-3">
                                        <label for="description" class="form-label form-label-lg">Description:</label>
                                        <textarea class="form-control form-control-lg" id="description" name="description" placeholder="Enter description" oninput="validateDescription()">${subject.description}</textarea>
                                    </div>
                                    <div id="descriptionError" class="text-danger"> </div>
                                </div>
                                <div class="text-center mt-4">
                                    <button class="btn btn-primary" type="button" onclick="openConfirmationDialogSubject()">Submit</button>
                                    <button class="btn btn-danger"><a href="subjectdetailae?subjectId=${subjectId}">Cancel</a></button>
                                </div>
                            </div>
                        </form>

                    </div>


                    <div class="tab-pane ${tab eq "profile"?"show active":""}" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                        <h1>DIMENSION</h1>
                        <div class="table-content">
                            <div class="table-view">

                                <button class="btn btn-primary" onclick="openAddDimensionForms()">Add New</button>

                                <div class="edit-pricePackage" id="add-dimension">
                                    <div class="edit-content">
                                        <div class="edit-dimension-close">
                                            <button onclick="closeAddDimensionForms()" class="btn btn-danger">x</button>
                                        </div>
                                        <form id="addDimensionForm" name="addForm" action="adddimension" method="post">
                                            <a href="" id="add-dimension-close" style="display: none;"></a>
                                            <label>Name: </label>

                                            <input name="name" id="names" type="text" required oninput="validateNameInputs()">
                                            <div id="nameDimensionErrors" class="text-danger"> </div>

                                            <label>Type:</label>
                                            <select name="type">
                                                <c:forEach var="list_dimension_type" items="${list_dimension_type}">
                                                    <option value="${list_dimension_type.id}">${list_dimension_type.name}</option>
                                                </c:forEach>
                                            </select>
                                            <br>
                                            <label>Description: </label>
                                            <input name="description" id="descriptions" type="text" required oninput="validateDescriptionInputs()">
                                            <div id="descriptionDimensionErrors" class="text-danger"> </div>

                                            <br>


                                            <input type="hidden" name="subjectId" value="${subjectId}">
                                            <input type="hidden" name="index" value="${tagD}"> <br>

                                            <input type="hidden" name="subjectId" value="${s}">
                                            <input type="button" value="Add New" class="btn btn-primary" onclick ="openAddConfirmationDialog(${subjectId},${tagD})">
                                        </form>

                                    </div>

                                </div>

                                <table class="table table-hover"> 
                                    <thead>
                                        <tr class="table-menu">
                                            <th scope="col">#</th>
                                            <th scope="col">Type</th>
                                            <th scope="col">Dimension</th>

                                            <th scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:if test="${dimensionList.size() == 0}">
                                            <tr>NO RESULT</tr>
                                        </c:if>
                                        <c:forEach items="${dimensionList}" var="dimensionList">
                                            <tr class="table-info">
                                                <th scope="row">${dimensionList.getId()}</th>
                                                    <c:forEach items="${list_dimension_type}" var="list_dimension_type">
                                                        <c:if test="${list_dimension_type.id == dimensionList.type_id}">
                                                        <td>${list_dimension_type.name}</td>
                                                    </c:if>
                                                </c:forEach>
                                                <td>${dimensionList.getName()}</td>

                                                <td>
                                                    <a href="#edit-dimention-${dimensionList.getId()}">  <button class="btn btn-primary" onclick="openEditDimensionForms(${dimensionList.getId()})" ><img src="img/magnifying-glass.png" style="height:20px;width:20px;"></button></a>
                                                    <button class="btn btn-danger" onclick="openDeleteConfirmation(${dimensionList.getId()},${subjectId},${tagD})"><img src="img/recycle-bin.png" style="height:20px;width: 20px;"></button>
                                                </td>

                                            </tr>
                                        <div class="edit-pricePackage" id="edit-dimension-${dimensionList.getId()}">
                                            <div class="edit-content">
                                                <a href="" id="edit-dimension-close" style="display: none;"></a>

                                                <div class="button-close">
                                                    <button onclick="closeEditDimensionForms(${dimensionList.getId()})" class="btn btn-danger">x</button>
                                                </div>
                                                <form id="edit-dimension-detail-${dimensionList.getId()}" action="editdimension" method="post" >

                                                    <label>ID:</label>
                                                    <input name="id" type="text" value="${dimensionList.getId()}" readonly> <br>
                                                    <label>Name:</label>
                                                    <input name="name" id="name-${dimensionList.getId()}" type="text" value="${dimensionList.name}" required oninput="validateNameInput(${dimensionList.getId()})"><br>      
                                                    <div id="nameDimensionError-${dimensionList.getId()}" class="text-danger"></div>
                                                    <label>Type:</label>
                                                    <select name="type">
                                                        <c:forEach var="list_dimension_type" items="${list_dimension_type}">
                                                            <option value="${list_dimension_type.id}" ${dimensionList.type_id == list_dimension_type.id ?"selected":""}>${list_dimension_type.name}</option>
                                                        </c:forEach>
                                                    </select><br>
                                                    <label>Description:</label>
                                                    <input name="description" id="description-${dimensionList.getId()}" type="text" value="${dimensionList.description}" required oninput="validateDescriptionInput(${dimensionList.getId()})">
                                                    <div id="descriptionDimensionError-${dimensionList.getId()}" class="text-danger"> </div>


                                                    <input type="hidden" name="subjectId" value="${subjectId}">
                                                    <input type="hidden" name="index" value="${tagD}"> <br>

                                                    <input type="button" value="Update" onclick="abc(${dimensionList.getId()},${subjectId},${tagD})" class="btn btn-primary">
                                                </form>    
                                            </div>

                                        </div>
                                        <div id="confirmation-dialog-${dimensionList.getId()}" class="modal">
                                            <div class="modal-content">
                                                <p>Are you sure?</p>
                                                <div class="buttons">
                                                    <button id="confirm-yes-${dimensionList.getId()}">Yes</button>
                                                    <button id="confirm-no-${dimensionList.getId()}" onclick="modalCloseHandler(event)">No</button>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    </tbody>


                                </table>
                                <ul class="pagination">
                                    <c:forEach begin="1" end="${endPD}" var="i">
                                        <a class="${tagD == i?"active":""}" href="subjectdetailae?indexD=${i}&subjectId=${subjectId}&tab=profile">${i}</a>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>



                    <div class="tab-pane ${tab eq "contact"?"show active":""}" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">
                        <h1>PRICE PACKAGE</h1>
                        <div class="table-content">

                            <div class="edit-pricePackage" id="add-pricePackage">
                                <div class="edit-content">
                                    <div class="edit-dimension-close">
                                        <button onclick="closeAddForms()" class="btn btn-danger">x</button>
                                    </div>
                                    <form id="addForm" name="addForm" action="addnewpricepackagedetail" method="POST" onsubmit="return validateForm()">
                                        <a href="" id="add-pricePackage-close" style="display: none;"></a>
                                        <label>Package's Name: </label>

                                        <input name="name" type="text" required>
                                        <br>
                                        <label>Description:</label> <input name="description" type="text" required>
                                        <br>
                                        <label>Duration(months):</label> <input name="duration" type="text"required>
                                        <br>
                                        <label>List Price:</label> <input name="price" type="text"required>
                                        <br>
                                        <label>Sale Price:</label> <input name="sale" type="text"required>
                                        <br>
                                        <label>Status:<label> <input type="radio" name="status" value="1" checked=""> Active
                                                <input type="radio" name="status" value="0"> Deactive
                                                <br>
                                                <input type="hidden" name="subjectId" value="${subjectId}">
                                                <input type="hidden" name="index" value="${tag}"> <br>

                                                <input type="hidden" name="subjectId" value="${s}">
                                                <input type="submit" value="Add New" class="btn btn-primary" onclick ="return confirm('Are you sure you want to add?')">
                                                </form>
                                                </div>
                                                </div>
                                                </div>
                                                <div class="table-view">                        
                                                    <c:if test="${sessionScope.user.getRole_id() == 5}">
                                                        <div class="dropdown">
                                                            <button class="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                                                Add New
                                                            </button>
                                                            <ul class="dropdown-menu">
                                                                <li class="dropdown">
                                                                    <button class="dropdown-item dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Add existing package</button>
                                                                    <ul class="dropdown-menu dropdown-submenu">
                                                                        <!--                                            <li><a class="dropdown-item" href="#">Submenu item 1</a></li>
                                                                                                                    <li><a class="dropdown-item" href="#">Submenu item 2</a></li>-->
                                                                        <c:forEach items="${allPricePackageList}" var="allPricePackageList">
                                                                            <c:set var="count" value="0" />
                                                                            <c:forEach items="${pricePackageList}" var="pricePackage">
                                                                                <c:if test="${allPricePackageList.id == pricePackage.id}">
                                                                                    <c:set var="count" value="${count + 1}" /> <!-- Tăng giá trị biến đếm count -->
                                                                                </c:if>
                                                                            </c:forEach>
                                                                            <c:if test="${count eq 0}">
                                                                                <li><a class="dropdown-item" href="addnewpricepackagedetail?price=${allPricePackageList.id}&subjectId=${subjectId}">
                                                                                        <span class="label" style="color: red;font-weight: bold;">name:</span>
                                                                                        <span class="value">${allPricePackageList.name}</span>
                                                                                        <span class="label" style="color: red;font-weight: bold;">description:</span>
                                                                                        <span class="value" >${allPricePackageList.description}</span>
                                                                                        <span class="label" style="color: red;font-weight: bold;">duration:</span>
                                                                                        <span class="value">${allPricePackageList.duration}</span>
                                                                                        <span class="label" style="color: red;font-weight: bold;">price:</span>
                                                                                        <span class="value">${allPricePackageList.price}</span>
                                                                                        <span class="label" style="color: red;font-weight: bold;">sale:</span>
                                                                                        <span class="value">${allPricePackageList.sale}</span>
                                                                                    </a></li>
                                                                                </c:if>
                                                                            </c:forEach>
                                                                    </ul>
                                                                </li>
                                                                <li><a class="dropdown-item" href="#" onclick="openAddForms()">Add new</a></li>
                                                            </ul>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${sessionScope.user.getRole_id() == 5}">
                                                        <div id="pricepackage">


                                                            <table class="table table-hover">

                                                                <tr class="table-menu">
                                                                    <th scope="col">#</th>
                                                                    <th scope="col">Package</th>
                                                                    <th scope="col">Description</th>
                                                                    <th scope="col">Duration</th>
                                                                    <th scope="col">List Price</th>
                                                                    <th scope="col">Sale Price</th>                
                                                                    <th scope="col">Status</th>

                                                                    <th scope="col">Action</th>

                                                                </tr>
                                                                <c:if test="${pricePackageListWithPaging.size() == 0}">
                                                                    <tr>NO RESULT</tr>
                                                                </c:if>
                                                                <c:forEach items="${pricePackageListWithPaging}" var="pricePackageListWithPaging">
                                                                    <tr class="table-info">
                                                                        <th scope="row">${pricePackageListWithPaging.getId()}</th>
                                                                        <td>${pricePackageListWithPaging.getName()}</td>
                                                                        <td>${pricePackageListWithPaging.getDescription()}</td>
                                                                        <c:if test="${pricePackageListWithPaging.getDuration() == 0}">
                                                                            <td></td>
                                                                        </c:if>
                                                                        <c:if test="${pricePackageListWithPaging.getDuration() != 0}">
                                                                            <td>${pricePackageListWithPaging.getDuration()}</td>
                                                                        </c:if>
                                                                        <td>${pricePackageListWithPaging.getPrice()}</td>
                                                                        <td>${pricePackageListWithPaging.getSale()}</td>
                                                                        <c:if test="${pricePackageListWithPaging.getStatus() == 1}">
                                                                            <td><div class="active-button">Active</div></td>
                                                                        </c:if>
                                                                        <c:if test="${pricePackageListWithPaging.getStatus() == 0}">
                                                                            <td><div class="deactive-button">Deactive</div></td>
                                                                        </c:if>
                                                                        <td>
                                                                            <div class="button-container">
                                                                                <a href="#edit-pricePackage-${pricePackageListWithPaging.getId()}">  <button class="btn btn-primary" onclick="openEditForms(${pricePackageListWithPaging.getId()})" >EDIT</button></a>
                                                                                <c:if test="${pricePackageListWithPaging.getStatus() == 1}">
                                                                                    <a href="editstatuspricepackage?tab=${tab}&price=${pricePackageListWithPaging.getId()}&subjectId=${subjectId}&index=${tag}&status=0"><img src="img/remove.png"></a>
                                                                                    </c:if>
                                                                                    <c:if test="${pricePackageListWithPaging.getStatus() == 0}">
                                                                                    <a href="editstatuspricepackage?tab=${tab}&price=${pricePackageListWithPaging.getId()}&subjectId=${subjectId}&index=${tag}&status=1" ><img src="img/check.png"></a>
                                                                                    </c:if>   
                                                                            </div>
                                                                        </td>

                                                                    </tr>
                                                                    <div class="edit-pricePackage" id="edit-pricePackage-${pricePackageListWithPaging.getId()}">
                                                                        <div class="edit-content">
                                                                            <a href="" id="edit-pricePackage-close" style="display: none;"></a>

                                                                            <div class="button-close">
                                                                                <button onclick="closeEditForms(${pricePackageListWithPaging.getId()})" class="btn btn-danger">x</button>
                                                                            </div>
                                                                            <form id="editeditPricePackagedetail-${pricePackageListWithPaging.getId()}" action="editpricepackage" method="post" onsubmit="return validateFormPricePackageDetail(${pricePackageListWithPaging.getId()})" >

                                                                                <label>ID:</label>
                                                                                <input name="id" type="text" value="${pricePackageListWithPaging.getId()}" readonly> <br>
                                                                                <label>Package's Name:</label>
                                                                                <input name="name" type="text" value="${pricePackageListWithPaging.getName()}" required><br>
                                                                                <div id="namePackageError-${pricePackageListWithPaging.getId()}" class="text-danger"> </div>
                                                                                <label>Description:</label>
                                                                                <input name="description" type="text" value="${pricePackageListWithPaging.getDescription()}" required><br>
                                                                                <div id="descriptionPackageError-${pricePackageListWithPaging.getId()}" class="text-danger"> </div>
                                                                                <label>Duration(months):</label>
                                                                                <input name="duration" type="text" value="${pricePackageListWithPaging.getDuration()}" required><br>
                                                                                <div id="durationPackageError-${pricePackageListWithPaging.getId()}" class="text-danger"> </div>

                                                                                <label>List Price:</label>
                                                                                <input name="price" type="text" value="${pricePackageListWithPaging.getPrice()}" required><br>
                                                                                <div id="listPricePackageError-${pricePackageListWithPaging.getId()}" class="text-danger"> </div>

                                                                                <label>Sale Price:</label>
                                                                                <input name="sale" type="text" value="${pricePackageListWithPaging.getSale()}" required><br>
                                                                                <div id="salePricePackageError-${pricePackageListWithPaging.getId()}" class="text-danger"> </div>

                                                                                <label>Status:</label>

                                                                                <input type="radio" name="status" value="1" ${pricePackageListWithPaging.getStatus() == 1?"checked":""} >Active
                                                                                <input type="radio" name="status" value="0" ${pricePackageListWithPaging.getStatus() == 0?"checked":""} > Deactive
                                                                                <br>
                                                                                <input type="hidden" name="subjectId" value="${subjectId}">
                                                                                <input type="hidden" name="index" value="${tag}"> <br>

                                                                                <input type="submit" value="Update" class="btn btn-primary">
                                                                            </form>    
                                                                        </div>
                                                                    </div>
                                                                </c:forEach>

                                                            </table>
                                                            <ul class="pagination">
                                                                <c:forEach begin="1" end="${endP}" var="i">
                                                                    <a class="${tag == i?"active":""}" href="subjectdetailae?index=${i}&subjectId=${subjectId}&tab=contact">${i}</a>
                                                                </c:forEach>
                                                            </ul>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${sessionScope.user.getRole_id() == 4}">
                                                        <div id="pricepackage">
                                                            <table class="table table-hover">
                                                                <tr class="table-menu">
                                                                    <th scope="col">#</th>
                                                                    <th scope="col">Package</th>
                                                                    <th scope="col">Description</th>
                                                                    <th scope="col">Duration</th>
                                                                    <th scope="col">List Price</th>
                                                                    <th scope="col">Sale Price</th>                
                                                                    <th scope="col">Status</th>
                                                                </tr>

                                                                <c:if test="${pricePackageListWithPaging.size() == 0}">
                                                                    <tr>NO RESULT</tr>
                                                                </c:if>
                                                                <c:forEach items="${pricePackageListWithPaging}" var="pricePackageListWithPaging">
                                                                    <c:if test="${pricePackageListWithPaging.getStatus() == 1}">
                                                                        <tr class="table-info">
                                                                            <th scope="row">${pricePackageListWithPaging.getId()}</th>
                                                                            <td>${pricePackageListWithPaging.getName()}</td>
                                                                            <td>${pricePackageListWithPaging.getDescription()}</td>
                                                                            <c:if test="${pricePackageListWithPaging.getDuration() == 0}">
                                                                                <td></td>
                                                                            </c:if>
                                                                            <c:if test="${pricePackageListWithPaging.getDuration() != 0}">
                                                                                <td>${pricePackageListWithPaging.getDuration()}</td>
                                                                            </c:if>
                                                                            <td>${pricePackageListWithPaging.getPrice()}</td>
                                                                            <td>${pricePackageListWithPaging.getSale()}</td>
                                                                            <c:if test="${pricePackageListWithPaging.getStatus() == 1}">
                                                                                <td><div class="active-button">Active</div></td>
                                                                            </c:if>
                                                                        </tr>
                                                                    </c:if>
                                                                </c:forEach>

                                                            </table>
                                                            <ul class="pagination">
                                                                <c:forEach begin="1" end="${endP}" var="i">
                                                                    <a class="${tag == i?"active":""}" href="subjectdetailae?index=${i}&subjectId=${subjectId}&tab=contact">${i}</a>
                                                                </c:forEach>
                                                            </ul>
                                                        </div>
                                                    </c:if>
                                                </div>
                                                </div>
                                                </div>
                                                </div>
                                                <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
                                                <script src="js/navBar.js" type="text/javascript"></script>
                                                </body>
                                                </html>
