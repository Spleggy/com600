var ws;

function connect() {
    var username = document.getElementById("username").value;
    var auc_name= document.getElementById("auc_name").value;
    var host = document.location.host;
    var pathname = document.location.pathname;
    
    ws = new WebSocket("ws://" +host  + pathname + "chat/" + username);

    ws.onmessage = function(event) {
    var log = document.getElementById("log");
        console.log(event.data);
        var message = JSON.parse(event.data);
        log.innerHTML += message.from + " : " + message.content + "\n";
    };
}

function send() {
    var content = document.getElementById("msg").value;
    var json = JSON.stringify({
        "type":"bid",
        "auc_name":auc_name,
        "content":content
    });

    ws.send(json);
}
function start(){
    var json = JSON.stringify({
        "type":"start",
        "auc_name":auc_name,
        "content":"START"
    });
    ws.send(json);
}