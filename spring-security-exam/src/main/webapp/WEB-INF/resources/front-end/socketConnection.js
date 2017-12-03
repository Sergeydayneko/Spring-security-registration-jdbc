// Открытие сокет соединения
var webSocket = ( () => {


    // Ensures only one connection is open at a time
    if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
        writeResponse("WebSocket is already opened.")
        return;
    }
    // Create a new instance of the websocket
    var webSocket = new WebSocket("ws://" + location.host + "/chat");

    /**
     * Binds functions to the listeners for the websocket.
     */
    webSocket.onopen = (event) =>{

        if(event.data === undefined)
            return;

        writeResponse(event);
        writeResponse("on open")

    };

    webSocket.onmessage = (event) =>{
        writeResponse(event);
        writeResponse("on message!!!")
    };

    webSocket.onclose = (event) => {
        writeResponse("Connection closed HERE")

    }

    return webSocket
})()