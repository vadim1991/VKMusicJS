var playlist;
var offsetTracksValue = 0;
var offsetFriendsValue = 0;
var countTracksValue = 30;
var countFriendsValue = 30;
var hasMore = true;
var hasMoreFriends = true;
var wasLoadedFriend = false;
var action = "myTracks";
var friendID;
var userID;
var token;

$(document).ready(function () {
    getUserInformationFromCookie();
    var script = document.createElement('SCRIPT');
    script.src = buildAudioGetURL(userID, "loadMyTracks");
    document.getElementsByTagName("head")[0].appendChild(script);
});

function getUserInformationFromCookie() {
    userID = $.cookie('user_id');
    token = $.cookie('access_token');
}

function buildAudioGetURL(ownerID, callbackFunctionName) {
    var obj = {
        owner_id: ownerID,
        access_token: token,
        count: countTracksValue,
        offset: offsetTracksValue,
        callback: callbackFunctionName,
        v: "5.37"
    };
    return 'https://api.vk.com/method/audio.get?' + $.param(obj);
}

function buildAudioSearchURL(searchText, callbackFunctionName) {
    var obj = {
        q: searchText,
        access_token: token,
        auto_complete: true,
        sort: 2,
        count: countTracksValue,
        offset: offsetTracksValue,
        callback: callbackFunctionName,
        v: "5.37"
    };
    return 'https://api.vk.com/method/audio.search?' + $.param(obj);
}

$(document).ready(function () {
    $(".scrollbar").scroll(function () {
        if ($(this)[0].scrollHeight - $(this).scrollTop() === $(this).outerHeight() && hasMore) {
            var ownerID = userID;
            if ("search" === action) {
                createSpinner("#overflow-scroll");
                var searchText = $("#search-text").val();
                var script = document.createElement('SCRIPT');
                script.src = buildAudioSearchURL(searchText, "loadMoreTracks");
                document.getElementsByTagName("head")[0].appendChild(script);
                return;
            } else {
                if (action === "friends") {
                    ownerID = friendID;
                }
                createSpinner("#overflow-scroll");
                var script = document.createElement('SCRIPT');
                script.src = buildAudioGetURL(ownerID, "loadMoreTracks");
                document.getElementsByTagName("head")[0].appendChild(script);
            }
        }
    });
});

function loadMoreTracks(result) {
    var data = convertToTracks(result.response.items);
    if (data.length == 0) {
        hasMore = false;
    }
    offsetTracksValue += countTracksValue;
    data.forEach(function (track) {
        playlist.add(track);
    });
    $("#jquery_jplayer_1").bind($.jPlayer.event.loadeddata, function (event) {
        jPlayerPlus();
    });
    hideSpinner("#overflow-scroll");
}

$("#search").click(function () {
    changeActiveMenu($(this));
    hideHeadersForSearch();
});

$("#my-tracks").click(function () {
    changeActiveMenu($(this));
    hideHeadersForMyTracks();
    if (action === "myTracks") {
        return;
    }
    action = "myTracks";
    hasMore = true;
    offsetTracksValue = 0;
    var script = document.createElement('SCRIPT');
    script.src = buildAudioGetURL(userID, "loadAndSetTracks");
    document.getElementsByTagName("head")[0].appendChild(script);
    $("#jquery_jplayer_1").bind($.jPlayer.event.loadeddata, function (event) {
        jPlayerPlus();
    });
});

$(document).ready(function () {
    $("#search-submit").click(function () {
        hasMore = true;
        offsetTracksValue = 0;
        var searchText = $("#search-text").val();
        action = "search";
        if (searchText.length > 0) {
            var script = document.createElement('SCRIPT');
            script.src = buildAudioSearchURL(searchText, "loadAndSetTracks");
            document.getElementsByTagName("head")[0].appendChild(script);
        }
    });
    $('#search-text').bind('keypress', function (e) {
            var code = e.keyCode || e.which;
            if (code == 13) {
                $("#search-submit").trigger("click");
            }
     });
});

function loadMyTracks(result) {
    var tracks = convertToTracks(result.response.items);
    action = "myTracks";
    offsetTracksValue += countTracksValue;
    playlist = new jPlayerPlaylist({
        jPlayer: "#jquery_jplayer_1",
        cssSelectorAncestor: "#jp_container_1"
    }, tracks, {
        playlistOptions: {
            enableRemoveControls: true
        },
        swfPath: "./assets/js/jplayer/",
        supplied: "mp3",
        smoothPlayBar: true,
        audioFullScreen: true
    });
    $("#jquery_jplayer_1").bind($.jPlayer.event.loadeddata, function (event) {
        jPlayerPlus();
    });
}

$(document).ready(function () {
    $(".friend-list").scroll(function () {
        if ($(this)[0].scrollHeight - $(this).scrollTop() === $(this).outerHeight() && hasMoreFriends) {
            createSpinner("#friend-list");
            $.ajax({
                url: "/friends",
                method: "post",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify({count: countFriendsValue, offset: offsetFriendsValue}),
                success: function (data) {
                    if (data.length == 0) {
                        hasMoreFriends = false;
                    }
                    offsetFriendsValue += countFriendsValue;
                    addFriendsToPage(data);
                    hideSpinner("#friend-list");
                }
            });
        }
    })
});

$("#friends").click(function () {
    changeActiveMenu($(this));
    if (wasLoadedFriend) {
        hideHeadersForFriends();
        $("#friend-list").show("slow");
        return;
    }
    hasMoreFriends = true;
    offsetFriendsValue = 0;
    hideHeadersForFriends();
    $.ajax({
        url: "/friends",
        method: "post",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({count: countFriendsValue, offset: offsetFriendsValue}),
        success: function (data) {
            wasLoadedFriend = true;
            addFriendsToPage(data);
            offsetFriendsValue += countFriendsValue;
            $("#friend-list").show("slow");
        }
    });
});

function hideHeadersForFriends() {
    $("#page-header").hide("slow");
    $("#search-header").hide("slow");
    $(".webdesigntuts-workshop").hide("slow");
    $("#friends-header").show("slow");
}

function hideHeadersForMyTracks() {
    $("#search-header").hide("slow");
    $("#friend-list").hide("slow");
    $(".webdesigntuts-workshop").hide("slow");
    $("#friends-header").hide("slow");
    $("#page-header").show("slow");
}

function hideHeadersForSearch() {
    $("#page-header").hide("slow");
    $("#friend-list").hide("slow");
    $("#search-header").show("slow");
    $("#friends-header").hide("slow");
    $(".webdesigntuts-workshop").show("slow");
}

function createSpinner(elementID) {
    $(elementID).waitMe({
        effect: "bounce",
        text: 'Please waiting...',
        bg: 'rgba(255,255,255,0.2)',
        color: '#000'
    });
}

function hideSpinner(elementID) {
    $(elementID).waitMe("hide");
}

function changeActiveMenu(element) {
    $(element).parent().parent().find('li').removeClass("active");
    $(element).parent().addClass("active");
}

$(document).on("click", '.friend', function (event) {
    $(".friend").removeClass("green");
    $(this).addClass("green");
    var friendName = $(this).find(".track-title").text();
    $("#chosen-friend").text(friendName);
    action = "friends";
    offsetTracksValue = 0;
    friendID = $(this).attr("data-id");
    var script = document.createElement('SCRIPT');
    script.src = buildAudioGetURL(friendID, "loadAndSetTracks");
    document.getElementsByTagName("head")[0].appendChild(script);
});

function loadAndSetTracks(result) {
    var tracks = convertToTracks(result.response.items);
    playlist.setPlaylist(tracks);
    offsetTracksValue += countTracksValue;
}

$(document).on("click", '.soundcloud', function (event) {
    var currentElement = $(this);
    $.ajax({
        url: "/share",
        method: "post",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: {
            id: playlist.playlist[$(this).parent().parent().index()].aid
        },
        success: function (data) {
            currentElement.addClass("green");
        }
    });
});

$(document).on("click", '.add', function (event) {
    var currentElement = $(this);
    var track = playlist.playlist[$(this).parent().parent().index()];
    $.ajax({
        url: "/tracks/add",
        method: "post",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({ownerID: track.owner_id, audioID: track.aid}),
        success: function (data) {
            currentElement.addClass("green");
        }
    });
});

$(document).on("click", '.delete', function (event) {
    var index = $(this).parent().parent().index();
    var track = playlist.playlist[index];
    $.ajax({
        url: "/tracks/delete",
        method: "post",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({ownerID: track.owner_id, audioID: track.aid}),
        success: function (data) {
            playlist.remove(index);
        }
    });
});

function addFriendsToPage(data) {
    data.forEach(function (friend) {
        var element = "<li><a class='friend' href='#friend&id=" + friend.uid + "' data-id='" + friend.uid + "'><img class='friend-img' src='" + friend.photo_50 + "'><span class='track-title'>" + friend.last_name + " " + friend.first_name + "</span></a></li>";
        var friends = $("#friend-list").find(".friends");
        friends.append(element);
    });
}

function convertToTracks(items) {
    var tracks = [];
    items.forEach(function (item) {
        var isMyTrack = userID == item.owner_id;
        var track = new Object();
        track.aid = item.id;
        track.artist = item.artist;
        track.title = item.title;
        track.url = item.url;
        track.duration = item.duration;
        track.genre = item.genre;
        track.album = item.album;
        track.soundcloud = false;
        if (isMyTrack) {
            track.added = false;
            track.delete = true;
        } else {
            track.added = true;
            track.delete = false;
        }
        track.mp3 = item.url;
        track.owner_id = item.owner_id;
        track.lyrics_id = item.lyrics_id;
        tracks.push(track);
    });
    return tracks;
}