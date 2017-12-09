var webSocket = ( () => {

    if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
        writeResponse("WebSocket is already opened.")
        return;
    }

    var webSocket = new WebSocket("ws://" + location.host + "/chat");

    webSocket.onopen = (event) => {

        if(event.data === undefined)
            return;

        writeResponse(event);
        writeResponse("on open")
    }

    webSocket.onmessage = (event) =>{
        writeResponse(event);
        writeResponse("on message!!!")
    };

    webSocket.onclose = (event) => {
        writeResponse("Connection closed HERE")

    }

    return webSocket
})()