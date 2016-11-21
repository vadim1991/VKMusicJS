<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="imagePath" value="../resources/images/template/"/>
<header id="nav-header" class="clearfix">
    <!-- ## PRIMARY NAV ## -->
    <nav id="primary-nav">
        <ul class="clearfix">
            <li class="active">
                <a href="#my-tracks" id="my-tracks">
                    <i class="icon-music-1"></i>
                    <p>My Tracks</p>
                </a>
            </li>
            <li>
                <a href="#friends" id="friends">
                    <i class="icon-user-1"></i>
                    <p>Friends</p>
                </a>
            </li>
            <li>
                <a href="#search" id="search">
                    <i class="icon-calendar-2"></i>
                    <p>Search</p>
                </a>
            </li>
        </ul>
    </nav>

    <div id="logo"><a href="/tracks"><img src="${imagePath}logo.png"
                                                                                             alt="LOGO"></a></div>
</header>