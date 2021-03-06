<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: alittlem1nd
  Date: 04.10.2017
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
            integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
            integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
            crossorigin="anonymous"></script>

    <link href="<c:url value="/resources/css/common_styles.css" />" rel="stylesheet">

    <title> Add new advertisement </title>
</head>
<body>
<div class="wrapper">
    <div class="jumbotron">
        <h1 class="display-3">New advertisement</h1>
        <p class="lead">Create new advertisement and sell your car! Enter your car details in the forms
            below.</p>
        <hr class="my-4">
        <div class="cut_jumbo">
            Quick and easy return to basic page by click on button
            <button type="button" class="btn btn-default" onclick="location.href='../html/basic.html'">Return to Car
                Store
            </button>
        </div>
    </div>
    <div style="text-align: center; padding-bottom: 20px; margin: auto; width: 60%">
        <div class="alert alert-danger" id="negative_message">You should sign up or register first. Auto redirect to
            register page...
        </div>
    </div>
    <div class="car_details_form" id="car_det">
        <div class="form-group-row">
            <h3>Car details</h3>
            <div class="form-inline">
                <label for="brands_list">Brand: </label>
                <select class="form-control" id="brands_list"></select>
                <label for="models_list">Model: </label>
                <select class="form-control" id="models_list"></select>
                <label for="bodies_list">Body: </label>
                <select class="form-control" id="bodies_list"></select>
            </div>
            <div class="form-inline">
                <label for="engines_list">Engine: </label>
                <select class="form-control" id="engines_list"></select>
                <label for="transmissions_list">Transmission: </label>
                <select class="form-control" id="transmissions_list"></select>
                <label for="drives_list">Drive: </label>
                <select class="form-control" id="drives_list"></select>
            </div>
            <div class="form-inline">
                <input type="number" class="form-control" id="hp" placeholder="Horse powers?">
                <input type="number" class="form-control" id="productionYear" placeholder="Year of production?">
                <input type="number" class="form-control" id="mileage" placeholder="Mileage (in kilometers)">
                <input type="text" class="form-control" id="color" placeholder="Type color">
                <input type="number" class="form-control" id="car_price" placeholder="Car price"></div>
        </div>
        <div class="text-area-carprice-picture">
        <textarea class="form-control" rows="5" id="adv_description"
                  placeholder="Type description of your car:"></textarea>
        </div>
        <button type="submit" class="btn btn-default" id="adv_submit" style="margin-bottom: 20px">Submit</button>
        <div class="alert alert-success" id="to_picture">Car details loaded. Now - picture...</div>
        <div class="alert alert-danger" id="error_message">Error. Incorrect input. Reload the page...</div>
    </div>
    <div id="img_form" style="display: none">
        <div class="image_load">
            <!-- This part to add IMAGE for car
              ----------------------------------->
            <h5 style="padding-bottom: 30px">Upload picture of your car</h5>
            <div>
                <form action="../imgload" method="post" enctype="multipart/form-data">
                    Image to upload: <input type="file" multiple accept="image/jpeg" name="car-picture"
                                            style="margin: auto; width: 40%; padding-bottom: 20px">
                    <p class="help-block" style="padding-bottom: 20px"><code>Image of your car should be 300x300. File
                        format:
                        JPEG.</code></p>
                    <p>
                        <button type="submit" id="image_submit" class="btn btn-default">Upload picture</button>
                    </p>
                </form>
            </div>
        </div>
    </div>

    <!-- Last form to click on button and create an advertisement :)) -->
    <div id="create_button" style="display: none">
        <div class="image_load">
            <h4 style="padding-bottom: 20px">At last, to create an advertisement, click this:</h4>
            <p>
                <button type="button" id="create_btn" class="btn btn-primary">Yes, do it!</button>
            </p>
            <p><h5>Or, suddenly, you can leave this page:</h5>
            <p>
                <button type="button" id="quit" class="btn btn-danger">Yeah, I'm leaving, now!</button>
            </p>
        </div>
    </div>


    <!-- Footer -->
    <footer class="footer">
        <p>Made by Evgeny Khodzitskiy, evgeny.hodz@gmail.com, GitHub:
            <a href="https://github.com/alittlemind" target="_blank">alittlemind</a></p>
    </footer>
    <!-- End of Footer -->
</div>
</body>
</html>
