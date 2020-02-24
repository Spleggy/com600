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
    console.log("in send");
    var content = document.getElementById("msg").value;
    var auc_name= document.getElementById("auc_name").value;
    var json = JSON.stringify({
        "type":"bid",
        "auc_name":auc_name,
        "content":content
    });
    console.log(json);
    ws.send(json);
}
function start(){
    console.log("in start");
    var auc_name= document.getElementById("auc_name").value;
    console.log(auc_name);
    var json = JSON.stringify({
        "type":"start",
        "auc_name":auc_name,
        "content":"START"
    });
    console.log(json);
    ws.send(json);
}