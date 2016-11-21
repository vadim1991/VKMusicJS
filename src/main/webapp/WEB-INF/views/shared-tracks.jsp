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
    <div id="logo"><a href="http://themeforest.quadcodes.com/site/musicvent/index.html"><img src="${imagePath}logo.png"
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

            </div>
            <!-- ## FIXY WRAPPER END ## -->

            <!-- ## PAGE CONTENT ## -->
            <div class="container">
                <section id="page-content" class="albumPadding">

                    <!-- BLOG-META START -->
                    <!-- BLOG-META END -->

                    <!-- ## PLAYER ## -->
                    <div id="jp_container_2" class="jp-audio">
                        <div class="jp-type-playlist">
                            <div id="jquery_jplayer_2" class="jp-jplayer" style="width: 0px; height: 0px;"><img
                                    id="jp_poster_0" style="width: 0px; height: 0px; display: none;">
                                <audio id="jp_audio_0" preload="metadata"
                                       src="http://3.s3.envato.com/files/5513511/preview.mp3"></audio>
                            </div>
                            <div class="album-wrapper clearfix">
                                <div class="album-controls">
                                    <!-- ## TRACK INFO ## -->
                                    <div class="track-info">
                                        <h3 class="track-heading"><i class="icon-note-beamed"></i> <span id="th-title">Whistle Blower</span>
                                        </h3>
                                        <p class="track-by"><i class="icon-user-1"></i> <span id="th-artist">by Adam Jamescuz</span>
                                        </p>
                                    </div>
                                    <!-- ## CONTROLS ## -->
                                    <div class="jp-gui jp-interface">
                                        <div class="jp-volume-controls">
                                            <a href="javascript:;" class="jp-mute" role="button" tabindex="0"><i class="icon-volume-off"></i></a>
                                            <div class="jp-volume-bar">
                                                <div class="jp-volume-bar-value"></div>
                                            </div>
                                            <a href="javascript:;" class="jp-volume-max" role="button" tabindex="0"><i class="icon-volume-off"></i></a>

                                        </div>
                                        <ul class="jp-controls clearfix">
                                            <li><a href="javascript:;" class="jp-previous" tabindex="1"><i
                                                    class="icon-backward"></i></a></li>
                                            <li><a href="javascript:;" class="jp-play" tabindex="1"><i
                                                    class="icon-play"></i></a></li>
                                            <li><a href="javascript:;" class="jp-pause" tabindex="1"
                                                   style="display: none;"><i class="icon-pause"></i></a></li>
                                            <li><a href="javascript:;" class="jp-next" tabindex="1"><i
                                                    class="icon-forward"></i></a></li>
                                            <li><a href="javascript:;" class="jp-stop" tabindex="1"><i
                                                    class="icon-stop"></i></a></li>
                                        </ul>
                                        <!-- ## PROGRESS BAR ## -->
                                        <div class="jp-progress">
                                            <div class="jp-seek-bar" style="width: 100%;">
                                                <div class="jp-play-bar" style="width: 0%;"></div>
                                            </div>
                                            <div class="jp-current-time">00:00</div>
                                            <div class="jp-duration">03:56</div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- ## PLAY LIST ## -->
                            <div class="playlist-heading">Track List
                                <!-- ## SHUFFLE/REPEAT ## -->
                                <ul class="jp-toggles clearfix">
                                    <li><a href="javascript:;" class="jp-shuffle" tabindex="1" title="shuffle"><i
                                            class="icon-shuffle-1"></i> Shuffle</a></li>
                                    <li><a href="javascript:;" class="jp-shuffle-off" tabindex="1" title="shuffle off"
                                           style="display: none;"><i class="icon-shuffle-1"></i>Shuffle Off</a></li>
                                    <li><a href="javascript:;" class="jp-repeat" tabindex="1" title="repeat"><i
                                            class="icon-loop"></i> Repeat</a></li>
                                    <li><a href="javascript:;" class="jp-repeat-off" tabindex="1" title="repeat off"
                                           style="display: none;"><i class="icon-loop"></i> Repeat Off</a></li>
                                </ul>
                            </div>
                            <!-- ## TRACK LIST ## -->
                            <div class="jp-playlist">
                                <ul></ul>
                            </div>
                            <!-- ## PLAYER FALLBACK ## -->
                            <div class="jp-no-solution" style="display: none;">
                                <span>Update Required</span>
                                To play the media you will need to either update your browser to a recent version or
                                update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
                            </div>
                        </div>
                    </div>
                    <!-- ## PLAYER END ## -->

                    <!-- POST CONTENT -->
                    <div class="postContent transparent">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repudiandae facere quam officiis
                        magnam asperiores id quibusdam quidem eaque sed incidunt! Modi magni deleniti veritatis expedita
                        doloribus aperiam alias autem numquam! Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                        Dolor voluptatum laudantium quibusdam iusto molestias ut suscipit illo quisquam culpa atque.
                        Voluptatibus quis cupiditate error tenetur optio doloremque. Sed sit optio.
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