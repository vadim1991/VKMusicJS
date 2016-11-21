<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="main/head.jsp">
    <jsp:param name="pageName" value="My Tracks | Page"></jsp:param>
</jsp:include>

<body>

<c:set var="imagePath" value="../resources/images/template/"/>

<!-- ## LOGO ## -->
<aside id="logo-bar">
    <div id="logo"><a href="/tracks"><img src="${imagePath}logo.png"
                                             alt="LOGO"></a></div>
    <div id="ajax-load"></div>
</aside>

<!-- ## PAGE GLOBAL ## -->
<section id="page-global">

    <!-- ## NAV HEADER ## -->
    <jsp:include page="main/header.jsp">
        <jsp:param name="pageName" value="my-tracks"></jsp:param>
    </jsp:include>
    <!-- ## NAV HEADER END ## -->

    <!-- ## PAGE WRAPPER ## -->
    <div id="page-wrapper">

        <!-- ## PAGE ## -->
        <section id="page">

            <!-- ## FIXY WRAPPER ## -->
            <div id="fixy">
                <!-- ## PAGE HEADER ## -->
                <header id="page-header">
                    <h1>My tracks. <span>Browse through tracks </span></h1>
                </header>

                <header id="search-header" class="custom-header hide">
                    <h1>Search tracks. <span>Enter words</span></h1>
                </header>

                <header id="friends-header" class="custom-header hide">
                    <h1>Friends. <span id="chosen-friend">Choose friend</span></h1>
                </header>

            </div>
            <!-- ## FIXY WRAPPER END ## -->

            <!-- ## PAGE CONTENT ## -->
            <div class="container">
                <section class="webdesigntuts-workshop">
                    <div class="form">
                        <input type="search" id="search-text" placeholder="Search...">
                        <button id="search-submit">Search</button>
                    </div>
                </section>
                <section class="jp-playlist hide" id="friend-list">
                    <ul class="friend-list friends" id="style-15"></ul>
                </section>
                <section id="page-content" class="albumPadding">

                    <!-- BLOG-META START -->
                    <!-- BLOG-META END -->

                    <!-- ## PLAYER ## -->
                    <jsp:include page="fragments/player.jsp"></jsp:include>
                    <!-- ## PLAYER END ## -->

                    <!-- POST CONTENT -->
                    <div class="postContent transparent">
                    </div>
                    <!-- POST CONTENT END -->

                </section>
            </div>
            <!-- ## PAGE CONTENT END ## -->

        </section>
        <!-- ## PAGE END ## -->

    </div>
    <!-- ## PAGE WRAPPER END ## -->

    <!-- ## FOOTER ## -->
    <footer id="PriFooter">
        <div class="container clearfix">
        </div>
    </footer>
    <!-- ## FOOTER END ## -->
    <jsp:include page="main/footer.jsp">
        <jsp:param name="pageName" value="Login | Page"></jsp:param>
    </jsp:include>
</section>
<!-- ## PAGE GLOBAL END ## -->

</body>
</html>