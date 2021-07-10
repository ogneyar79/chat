function showMessage() {
    $.get('/get_mes', function (data) {
        console.log("Beginining of work function $.get")
        let chatmessage = "<div class='chat-view'>";
        for (var i = 0; i < data.length; i++) {
            console.log(data[i]);
            chatmessage = chatmessage + "<div class=\"chat-item\">\n" +
                "                    <div class=\"d-flex\">\n" +
                "                        <div class=\"p-1\">\n" +
                "                            <div class=\"d-flex align-items-end\">\n" +
                "                                <div class=\"sender-name\">" + data[i].userName + "</div>\n<div class=\'chat-time\'>" + data[i].userName + "</div>\n</div>\n" +
                "                            <div class=\"float-right\">\n" +
                "                            </div>\n <div class=\"chat-text\">\n" + data[i].report +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>";
        }
        chatmessage = chatmessage + "</div>";
        $("#chatview").html(chatmessage);
        console.log("End of work function $.get")
    });
}

function sendMessage() {
    //         const msg = $('#ajaxmessage').serialize();
    console.log(" I want start ajax")
    const msg = JSON.stringify({
        userName: $("#userName").val(),
        report: $("#report").val(),
    })
    console.log(msg.toString());
    $.ajax({
        type: 'POST',
        cache: false,
        url: 'http://localhost:8080/message',
        contentType: "application/json",
        dataType: 'json',
        data: msg,
        success: function () {
            console.log(" 89 Data sent");
            showMessage();
        }
    })
}
window.onload = function () {
    console.log(" function window.onload = 96 function () show message")
    document.getElementById("button-addon2").addEventListener("click", sendMessage);
    document.getElementById("button-addon2").addEventListener("click", handler2);
    showMessage();
}
function handler2() {
    alert('Мы схватили кнопку с id button-addon2 готовы к ajax send message to server');
    console.log("Thanks");
    document.getElementById("report").value = "";
}