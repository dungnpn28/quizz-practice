<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/CusHeader.css"/>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <title>Quizzero</title>
    </head>
    <body>
        <div class="header_content">
            <a href="cusHome"><img src="img\2.png" class="header_logo"></a>
            <div class="header_menu">
                <ul>
                    <li><a href="BlogListController">Post</a></li>
                    <li><a href="">Subject</a></li>
                    <li><a href="practiceList">Practice List</a></li>
                </ul>
            </div>

            <div class="action">
                <div class="profile" >
                    <img src="img\UserAva.png" onclick="toggleMenu()">
                </div>
                <div class="menu" id="submenu">
                    <ul>
                        <li>${userName}</li>
                        <li><img src="img/profile.png" alt=""><a href="UserProfile.jsp">View Profile</a></li>
                        <li><img src="img/setting.png" alt=""><a href="#" id="popUpLink">Change Password</a></li>
                        <li><img src="img/logout.png" alt=""><a href="logout">Log out</a></li>
                    </ul>
                </div>
            </div>
            <script>
                let submenu = document.getElementById("submenu");
                function toggleMenu() {
                    submenu.classList.toggle("open_menu");
                }
            </script>
            <div id="popUpModal" class="modal_popUp">
                <div class="modal-content_popUp">
                    
                    <h2>Change password</h2>

                    <form id="changePasswordForm" method="POST" action="changePassword">

                        Old password<input type="password" name="oldPass" placeholder="Old password" required><br/>
                        New password<input type="password" name="pass1" placeholder="new password" required><br/>
                        New password again<input type="password" name="pass2" placeholder="new password again" required>
                        <br/>
                        <button style="background: linear-gradient(to right, #5CE1E6, #0578A4)" type="submit">Change</button>
                        <button class="close-popup" style="background-color: #e64545">&times; Cancel</button>
                    </form>
                    <div id="errorMessage" class="error-message"></div>
                </div>
            </div>
            <script>
                var closeBtn = document.querySelector('.close-popup');
                var popUpModal = document.getElementById('popUpModal');

                closeBtn.addEventListener('click', function () {
                    popUpModal.style.display = 'none';
                });
            </script>
        </div>
        <script src="js/PopUp.js" type="text/javascript"></script>
    </body>

</html>
