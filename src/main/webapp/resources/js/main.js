$("#login").click(function () {
    var endPoint = "http://vkmusic.herokuapp.com/vklogin";
    var scope = "friends,audio,photos,notify";
    var params = {
        client_id : "5450850",
        redirect_uri : endPoint,
        response_type : "code",
        display : "page",
        scope : scope
    };
    var url = "http://oauth.vk.com/authorize?" + $.param(params);
    window.location.replace(url);
});