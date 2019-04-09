var username
$(function () {
    $("<link>").attr({
        rel: "stylesheet",
        type: "text/css",
        href: "/abl/css/seimg.css"
    }).appendTo("head");
    $("body").append(
        "<div class=\"modal fade showABLSeaInsModal bd-example-modal-lg\" id=\"showABLSeaInsModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
        "  <div class=\"modal-dialog modal-lg\" role=\"document\">\n" +
        "    <div class=\"modal-content\" style='top: 100px;'>\n" +
        "      <div class=\"modal-header\">\n" +
        "        <h5 class=\"modal-title\" id=\"exampleModalLabel\">选择插入的图片</h5>\n" +
        "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
        "          <span aria-hidden=\"true\">&times;</span>\n" +
        "        </button>\n" +
        "      </div>\n" +
        "      <div class=\"modal-body\" >\n" +
        "<ul class=\"nav nav-tabs\" id=\"myTab\" role=\"tablist\">\n" +
        "  <li class=\"nav-item\" id='imgli'>\n" +
        "    <a class=\"nav-link active\" id=\"ablInsertImage-tab\" data-toggle=\"tab\" href=\"#ablInsertImage\" role=\"tab\" aria-controls=\"ablInsertImage\" aria-selected=\"true\">选择图片</a>\n" +
        "  </li>\n" +
        "<li class=\"nav-item\">\n" +
        "    <a class=\"nav-link\" id=\"ablUploadImage-tab\" data-toggle=\"tab\" href=\"#ablUploadImage\" role=\"tab\" aria-controls=\"ablUploadImage\" aria-selected=\"false\">上传图片</a>\n" +
        "  </li>" +
        "</ul>" +
        "<div class=\"tab-content\" id=\"myTabContent\">\n" +
        "   <div class=\"tab-pane fade show active\" id=\"ablInsertImage\" role=\"tabpanel\" aria-labelledby=\"ablInsertImage-tab\" >" +
        "        <div class='container-fluid'>" +
        "           <div class='row' id='modal-file-showABLSeaInsModal' style='max-height: 300px;overflow-y: auto;min-height: 300px;'>" +
        "                                                                    " +
        "           </div>" +
        "       </div>" +
        "   </div>\n" +
        "   <div class=\"tab-pane fade\" id=\"ablUploadImage\" role=\"tabpanel\" aria-labelledby=\"ablUploadImage-tab\">" +
        "      <br/>" +
        "      <div class='text-center border border-dark onFileDrop' ondrop='onImgDrop(event)'>" +
        "         <img style='pointer-events: none' src='" + location.protocol + "//" + window.location.host + "/abl/img/upimg.png' class='rounded mx-auto d-block' alt=' 图片挂掉了！！！！'>" +
        "         <p style='pointer-events: none'>文件拖动至此上传</p>" +
        "      </div>\n" +
        "      <br/>" +
        " <p> 目前只支持jpg,jpeg,gif,png,bmp类型的图片，且文件小于100MB</p>" +
        "      <div class='alert alert-light' role='alert'>\n" +
        "      </div>" +
        "   </div>\n" +
        "</div>" +
        "      </div>\n" +
        "      <div class=\"modal-footer\">\n" +
        "        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">关闭</button>\n" +
        "      </div>\n" +
        "    </div>\n" +
        "  </div>\n" +
        "</div>" +
        "<div class=\"modal fade\" id=\"waringModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
        "  <div class=\"modal-dialog\" role=\"document\">\n" +
        "    <div class=\"modal-content\">\n" +
        "      <div class=\"modal-header\">\n" +
        "        <h5 class=\"modal-title\" id=\"headContent\">提示</h5>\n" +
        "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
        "          <span aria-hidden=\"true\">&times;</span>\n" +
        "        </button>\n" +
        "      </div>\n" +
        "      <div class=\"modal-body\" id='bodyContent'>\n" +
        "        ...\n" +
        "      </div>\n" +
        "      <div class=\"modal-footer\">\n" +
        "        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n" +
        "      </div>\n" +
        "    </div>\n" +
        "  </div>\n" +
        "</div>");
    $("body").append(
        "<div class=\"modal fade showABLSeaVideoModal bd-example-modal-lg\" id=\"showABLSeaVideoModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
        "  <div class=\"modal-dialog modal-lg\" role=\"document\">\n" +
        "    <div class=\"modal-content\" style='top: 100px;'>\n" +
        "      <div class=\"modal-header\">\n" +
        "        <h5 class=\"modal-title\" id=\"exampleModalLabel\">选择插入的视频</h5>\n" +
        "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
        "          <span aria-hidden=\"true\">&times;</span>\n" +
        "        </button>\n" +
        "      </div>\n" +
        "      <div class=\"modal-body\" >\n" +
        "<ul class=\"nav nav-tabs\" id=\"myTab\" role=\"tablist\">\n" +
        "  <li class=\"nav-item\" id='vidli'>\n" +
        "    <a class=\"nav-link active\" id=\"ablInsertVideo-tab\" data-toggle=\"tab\" href=\"#ablInsertVideo\" role=\"tab\" aria-controls=\"ablInsertVideo\" aria-selected=\"false\">选择视频</a>\n" +
        "</li>" +
        "<li class=\"nav-item\">\n" +
        "    <a class=\"nav-link\" id=\"ablUploadVideo-tab\" data-toggle=\"tab\" href=\"#ablUploadVideo\" role=\"tab\" aria-controls=\"ablUploadVideo\" aria-selected=\"false\">上传视频</a>\n" +
        "  </li>" +
        "</ul>" +
        "<div class=\"tab-content\" id=\"myTabContent\">\n" +
        "<div class=\"tab-pane fade show active\" id=\"ablInsertVideo\" role=\"tabpanel\" aria-labelledby=\"ablInsertVideo-tab\" >" +
        "        <div class='container-fluid'>" +
        "           <div class='row' id='modal-file-showABLSeaVideoModal' style='max-height: 300px;overflow-y: auto;min-height: 300px;'>" +
        "                                                                    " +
        "           </div>" +
        "       </div>" +
        "</div> " +
        "   <div class=\"tab-pane fade\" id=\"ablUploadVideo\" role=\"tabpanel\" aria-labelledby=\"ablUploadVideo-tab\">" +
        "      <br/>" +
        "      <div class='text-center border border-dark onFileDrop' ondrop='onVideoDrop(event)'>" +
        "         <img style='pointer-events: none' src='" + location.protocol + "//" + window.location.host + "/abl/img/upimg.png' class='rounded mx-auto d-block' alt=' 图片挂掉了！！！！'>" +
        "         <p style='pointer-events: none'>文件拖动至此上传</p>" +
        "      </div>\n" +
        "      <br/>" +
        " <p> 目前只支持wmv,avi,dat,mp4,rmvb,rm,flv类型的视频，且文件小于100MB</p>" +
        "      <div class='alert alert-light' role='alert'>\n" +
        "      </div>" +
        "   </div>\n" +
        "</div>" +
        "      </div>\n" +
        "      <div class=\"modal-footer\">\n" +
        "        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">关闭</button>\n" +
        "      </div>\n" +
        "    </div>\n" +
        "  </div>\n" +
        "</div>" +
        "<div class=\"modal fade\" id=\"waringModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
        "  <div class=\"modal-dialog\" role=\"document\">\n" +
        "    <div class=\"modal-content\">\n" +
        "      <div class=\"modal-header\">\n" +
        "        <h5 class=\"modal-title\" id=\"headContent\">提示</h5>\n" +
        "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
        "          <span aria-hidden=\"true\">&times;</span>\n" +
        "        </button>\n" +
        "      </div>\n" +
        "      <div class=\"modal-body\" id='bodyContent'>\n" +
        "        ...\n" +
        "      </div>\n" +
        "      <div class=\"modal-footer\">\n" +
        "        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n" +
        "      </div>\n" +
        "    </div>\n" +
        "  </div>\n" +
        "</div>");
    $("body").append(
        "<div class=\"modal fade showABLSeaDocModal bd-example-modal-lg\" id=\"showABLSeaDocModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
        "  <div class=\"modal-dialog modal-lg\" role=\"document\">\n" +
        "    <div class=\"modal-content\" style='top: 100px;'>\n" +
        "      <div class=\"modal-header\">\n" +
        "        <h5 class=\"modal-title\" id=\"exampleModalLabel\">选择插入的文件</h5>\n" +
        "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
        "          <span aria-hidden=\"true\">&times;</span>\n" +
        "        </button>\n" +
        "      </div>\n" +
        "      <div class=\"modal-body\" >\n" +
        "<ul class=\"nav nav-tabs\" id=\"myTab\" role=\"tablist\">\n" +
        "  <li class=\"nav-item\" id='docli'>\n" +
        "    <a class=\"nav-link active\" id=\"ablInsertDoc-tab\" data-toggle=\"tab\" href=\"#ablInsertDoc\" role=\"tab\" aria-controls=\"ablInsertDoc\" aria-selected=\"false\">选择文件</a>\n" +
        "</li>" +
        "<li class=\"nav-item\">\n" +
        "    <a class=\"nav-link\" id=\"abUploadDoc-tab\" data-toggle=\"tab\" href=\"#abUploadDoc\" role=\"tab\" aria-controls=\"abUploadDoc\" aria-selected=\"false\">上传文件</a>\n" +
        "  </li>" +
        "</ul>" +
        "<div class=\"tab-content\" id=\"myTabContent\">\n" +
        "<div class=\"tab-pane fade show active\" id=\"ablInsertDoc\" role=\"tabpanel\" aria-labelledby=\"ablInsertDoc-tab\" >" +
        "        <div class='container-fluid'>" +
        "           <div class='row' id='modal-file-showABLSeaDocModal' style='max-height: 300px;overflow-y: auto;min-height: 300px;'>" +
        "<table class=\"table table-borderless\" id='doc-table'>\n" +
        "  <thead>\n" +
        "    <tr>\n" +
        "      <th scope=\"col\">文件名</th>\n" +
        "      <th scope=\"col\">选择</th>\n" +
        "    </tr>\n" +
        "  </thead>\n" +
        "  <tbody>\n" +
        "  </tbody>\n" +
        "</table>                             " +
        "           </div>" +
        "       </div>" +
        "</div> " +
        "   <div class=\"tab-pane fade\" id=\"abUploadDoc\" role=\"tabpanel\" aria-labelledby=\"abUploadDoc-tab\">" +
        "      <br/>" +
        "      <div class='text-center border border-dark onFileDrop' ondrop='onDocDrop(event)'>" +
        "         <img style='pointer-events: none' src='" + location.protocol + "//" + window.location.host + "/abl/img/upimg.png' class='rounded mx-auto d-block' alt=' 图片挂掉了！！！！'>" +
        "         <p style='pointer-events: none'>文件拖动至此上传</p>" +
        "      </div>\n" +
        "      <br/>" +
        " <p> 目前只支持txt,doc,xls,xml,xlsx类型的文件，且文件小于100MB</p>" +
        "      <div class='alert alert-light' role='alert'>\n" +
        "      </div>" +
        "   </div>\n" +
        "</div>" +
        "      </div>\n" +
        "      <div class=\"modal-footer\">\n" +
        "        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">关闭</button>\n" +
        "      </div>\n" +
        "    </div>\n" +
        "  </div>\n" +
        "</div>" +
        "<div class=\"modal fade\" id=\"waringModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
        "  <div class=\"modal-dialog\" role=\"document\">\n" +
        "    <div class=\"modal-content\">\n" +
        "      <div class=\"modal-header\">\n" +
        "        <h5 class=\"modal-title\" id=\"headContent\">提示</h5>\n" +
        "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
        "          <span aria-hidden=\"true\">&times;</span>\n" +
        "        </button>\n" +
        "      </div>\n" +
        "      <div class=\"modal-body\" id='bodyContent'>\n" +
        "        ...\n" +
        "      </div>\n" +
        "      <div class=\"modal-footer\">\n" +
        "        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n" +
        "      </div>\n" +
        "    </div>\n" +
        "  </div>\n" +
        "</div>");
    document.addEventListener('dragover', function (e) {
        e.stopPropagation();
        e.preventDefault();
    }, false);
    document.addEventListener('drop', function (e) {
        e.stopPropagation();
        e.preventDefault();
    }, false);
    document.addEventListener('drop', function (e) {
        e.stopPropagation();
        e.preventDefault();
    }, false);
    $('#showABLSeaInsModal').on('hidden.bs.modal', function (e) {
        $(".alert").addClass("alert-light")
        $(".alert").text("")
    })
    var resizeLayout = function () {
        var hei = $(window).height();
        $(".maxheight").each(function (i, n) {
            if (n.tagName == 'TEXTAREA') {
                var parenttop = n.offsetParent.offsetTop;
                $(this).css("height", hei - parenttop);
            } else {
                $(this).css("height", hei);
            }
        });
    };

    resizeLayout();
    $(window).resize(function () {
        resizeLayout();
    });
});
var imgCallbacks = null;
var videoCallbacks = null;
var docCallbacks = null;
var showABLSeaInsModal = function (username, callback) {
    if (username == "" || username == undefined) {
        username = null
    }
    imgCallbacks = callback;
    $.ajax({
        url: window.location.protocol + "//" + window.location.host + "/abl/store/local/getPath/img/" + username,
        type: "post",
        cache: false,
        processData: false,
        contentType: false,
        async: true,
        success: function (data) {
            $("#modal-file-showABLSeaInsModal").children().remove();
            if (data.code == 0) {
                $.each(data.data, function (i, n) {
                    $("#modal-file-showABLSeaInsModal").append("<div class='col-md-2  text-center'>" +
                        "<div class='custom-control custom-checkbox mr-sm-2' style='position: absolute;margin-left: 5px'>\n" +
                        "</div>" +
                        "<img width='100px' height='100px' " +
                        "src='" + location.protocol + "//" + window.location.host + "/abl/store/local/getContent/" + n.id + "' " +
                        "alt='图片挂掉了！！！！' class='img-thumbnail' data-toggle='tooltip' data-placement='bottom' title='" + n.documentName + "'>" +
                        "<button type='button' class='btn btn-outline-success btn-sm seimg' value='" + location.protocol + "//" + window.location.host + "/abl/store/local/getContent/" + n.id + "'>选择</button>" +
                        "</div>")

                })
                $(document).ready(function () {
                    $('[data-toggle="tooltip"]').tooltip();
                });
                $(".seimg").on("click", function (event) {
                    if (typeof callback === "function") {
                        console.log($(this).val())
                        callback($(this).val())
                        $('#showABLSeaInsModal').modal('hide');
                    }
                });
                $('#showABLSeaInsModal').modal('show');
            }
        },
        error: function (data) {

        },

    });
};

function onImgDrop(event) {
    $(".alert").text("上传中...")
    $(".alert").removeClass("alert-success")
    $(".alert").removeClass("alert-danger")
    $(".alert").removeClass("alert-light")
    $(".alert").addClass("alert-warning")
    var fileObj = event.dataTransfer.files;
    if (fileObj != null) {
        var formData = new FormData();
        formData.append("formData", fileObj[0]);
        formData.append("username", "group");
        $.ajax({
            url: window.location.protocol + "//" + window.location.host + "/abl/store/local/upload",
            type: "post",
            cache: false,
            processData: false,
            contentType: false,
            data: formData,
            async: true,
            success: function (data) {
                if (data.code == 0) {
                    $("#modal-file-showABLSeaInsModal").prepend("<div class='col-md-2 text-center'>" +
                        "<div class='custom-control custom-checkbox mr-sm-2' style='position: absolute;margin-left: 5px'>\n" +
                        "</div>" +
                        "<img width='100px' height='100px' " +
                        "src='" + location.protocol + "//" + window.location.host + "/abl/store/local/getContent/" + data.data + "' " +
                        "alt='图片挂掉了！！！！' class='img-thumbnail' data-toggle='tooltip' data-placement='bottom' title='" + fileObj[0].name + "'>" +
                        "<button type='button' class='btn btn-outline-success btn-sm seimg' value='" + location.protocol + "//" + window.location.host + "/abl/store/local/getContent/" + data.data + "'>选择</button>" +
                        "</div>")
                    $(document).ready(function () {
                        $('[data-toggle="tooltip"]').tooltip();
                    });

                    $(".seimg").on("click", function (event) {
                        if (typeof imgCallbacks === "function") {
                            console.log($(this).val())
                            imgCallbacks($(this).val())
                            $('#showABLSeaInsModal').modal('hide');
                        }
                    });
                    $(".alert").removeClass("alert-warning")
                    $(".alert").addClass("alert-success")
                    $(".alert").text("上传成功:" + fileObj[0].name)
                }
            },
            error: function (data) {
                $(".alert").text(data.msg)
                $(".alert").removeClass("alert-warning")
                $(".alert").addClass("alert-danger")
            },
        });
    }
};

var showABLSeaVideoModal = function (username, callback) {
    if (username == "" || username == undefined) {
        username = null
    }
    videoCallbacks = callback;
    $.ajax({
        url: window.location.protocol + "//" + window.location.host + "/abl/store/local/getPath/video/" + username,
        type: "post",
        cache: false,
        processData: false,
        contentType: false,
        async: true,
        success: function (data) {
            $("#modal-file-showABLSeaVideoModal").children().remove();
            if (data.code == 0) {
                $.each(data.data, function (i, n) {
                    $("#modal-file-showABLSeaVideoModal").append("<div class='col-md-2 text-center'>" +
                        "<div class='custom-control custom-checkbox mr-sm-2' style='position: absolute;margin-left: 5px'>\n" +
                        "</div>" +
                        "<video width='100px' height='100px' " +
                        "src='" + location.protocol + "//" + window.location.host + "/abl/store/local/getContent/" + n.id + "' " +
                        "data-toggle='tooltip' data-placement='bottom' title='" + n.documentName + "'>您的浏览器不支持 video 标签。</video>" +
                        "<button type='button' class='btn btn-outline-success btn-sm sevideo' value='" + location.protocol + "//" + window.location.host + "/abl/store/local/getContent/" + n.id + "'>选择</button>" +
                        "</div>")

                })
                $(document).ready(function () {
                    $('[data-toggle="tooltip"]').tooltip();
                });

                $(".sevideo").on("click", function (event) {
                    if (typeof callback === "function") {
                        console.log($(this).val())
                        callback($(this).val())
                        $('#showABLSeaVideoModal').modal('hide');
                    }
                });
                $('#showABLSeaVideoModal').modal('show');
            }
        },
        error: function (data) {

        },

    });
};

function onVideoDrop(event) {
    $(".alert").removeClass("alert-light")
    $(".alert").removeClass("alert-danger")
    $(".alert").removeClass("alert-success")
    $(".alert").addClass("alert-warning")
    $(".alert").text("上传中...")
    var fileObj = event.dataTransfer.files;
    if (fileObj != null) {
        var formData = new FormData();
        formData.append("formData", fileObj[0]);
        formData.append("username", "group");
        $.ajax({
            url: window.location.protocol + "//" + window.location.host + "/abl/store/local/upload",
            type: "post",
            cache: false,
            processData: false,
            contentType: false,
            data: formData,
            async: true,
            success: function (data) {
                if (data.code == 0) {
                    $("#modal-file-showABLSeaVideoModal").prepend("<div class='col-md-2 text-center'>" +
                        "<div class='custom-control custom-checkbox mr-sm-2' style='position: absolute;margin-left: 5px'>\n" +
                        "</div>" +
                        "<video width='100px' height='100px' " +
                        "src='" + location.protocol + "//" + window.location.host + "/abl/store/local/getContent/" + data.data + "' " +
                        "data-toggle='tooltip' data-placement='bottom' title='" + fileObj[0].name + "'>您的浏览器不支持 video 标签。</video>" +
                        "<button type='button' class='btn btn-outline-success btn-sm sevideo' value='" + location.protocol + "//" + window.location.host + "/abl/store/local/getContent/" + data.data + "'>选择</button>" +
                        "</div>")
                    $(document).ready(function () {
                        $('[data-toggle="tooltip"]').tooltip();
                    });

                    $(".sevideo").on("click", function (event) {
                        if (typeof videoCallbacks === "function") {
                            console.log($(this).val())
                            videoCallbacks($(this).val())
                            $('#showABLSeaVideoModal').modal('hide');
                        }
                    });
                    $(".alert").removeClass("alert-warning")
                    $(".alert").addClass("alert-success")
                    $(".alert").text("上传成功:" + fileObj[0].name)
                }
            },
            error: function (data) {
                $(".alert").removeClass("alert-warning")
                $(".alert").addClass("alert-danger")
                $(".alert").text("上传失败")
            },
        });
    }
};
var showABLSeaDocModal = function (username, callback) {
    if (username == "" || username == undefined) {
        username = null
    }
    docCallbacks = callback;
    $.ajax({
        url: window.location.protocol + "//" + window.location.host + "/abl/store/local/getPath/doc/" + username,
        type: "post",
        cache: false,
        processData: false,
        contentType: false,
        async: true,
        success: function (data) {
            $("#doc-table").children("tbody").children().remove();
            if (data.code == 0) {
                $.each(data.data, function (i, n) {
                    var src = location.protocol + "//" + window.location.host + "/abl/store/local/getContent/" + n.id;
                    $("#doc-table").children("tbody").append(
                        "    <tr>\n" +
                        "      <th scope='row'>" + n.id + "</th>\n" +
                        "      <td><a href='" + src + "' target='view_window'>" + n.documentName + "</a></td>\n" +
                        "      <td><button class='btn btn-outline-success btn-sm sedoc' value='" + src + "'>选择</button></td>\n" +
                        "    </tr>\n")
                })
                $(".sedoc").on("click", function (event) {
                    if (typeof callback === "function") {
                        console.log($(this).val())
                        callback($(this).val())
                        $('#showABLSeaDocModal').modal('hide');
                    }
                });
                $('#showABLSeaDocModal').modal('show');
            }
        },
        error: function (data) {

        },

    });
};

function onDocDrop(event) {
    $(".alert").removeClass("alert-success")
    $(".alert").removeClass("alert-danger")
    $(".alert").removeClass("alert-light")
    $(".alert").addClass("alert-warning")
    $(".alert").text("上传中...")
    var fileObj = event.dataTransfer.files;
    if (fileObj != null) {
        var formData = new FormData();
        formData.append("formData", fileObj[0]);
        formData.append("username", "group");
        $.ajax({
            url: window.location.protocol + "//" + window.location.host + "/abl/store/local/upload",
            type: "post",
            cache: false,
            processData: false,
            contentType: false,
            data: formData,
            async: true,
            success: function (data) {
                if (data.code == 0) {
                    var src = location.protocol + "//" + window.location.host + "/abl/store/local/getContent/" + data.data;
                    $("#doc-table").children("tbody").prepend(
                        "    <tr>\n" +
                        "      <td><a href='" + src + "' target='view_window'>" + fileObj[0].name + "</a></td>\n" +
                        "      <td><button class='btn btn-outline-success btn-sm sedoc' value='" + src + "'>选择</button></td>\n" +
                        "    </tr>\n")
                    $(".sedoc").on("click", function (event) {
                        if (typeof docCallbacks === "function") {
                            console.log($(this).val())
                            docCallbacks($(this).val())
                            $('#showABLSeaDocModal').modal('hide');
                        }
                    });
                    $(".alert").removeClass("alert-warning")
                    $(".alert").addClass("alert-success")
                    $(".alert").text("上传成功:" + fileObj[0].name)
                }
            },
            error: function (data) {
                $(".alert").removeClass("alert-warning")
                $(".alert").addClass("alert-danger")
                $(".alert").text(data.msg)
            },
        });
    }
};