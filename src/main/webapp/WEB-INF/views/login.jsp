<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html charset=us-ascii"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<jsp:include page="main/head.jsp">
    <jsp:param name="pageName" value="Login | Page"></jsp:param>
</jsp:include>
<body>
<main class="intro container">
    <section class="profile">
        <div class="photo round">
            <img src="../resources/images/logo.jpg" alt="Vadym Vlasenko">
        </div>

        <h2 class="job-title">VK Music Player</h2>

        <div>
            <button class="button" id="login"
                    title="Зайти через ВКонтакте">Sign in with VK
            </button>
        </div>
    </section>
</main>
</body>
<script src="../resources/js/template/jquery.min.js"></script>
<script src="../resources/js/main.js"></script>
<script src="http://vk.com/js/api/xd_connection.js?2" type="text/javascript"></script>
</html>