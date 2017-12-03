$(document).ready(function () {
    getMessages()

    function getMessages() {

        fetch('/chatMessages', {
            method: 'get',
            headers: {
                "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
            }
        })
            .then(function(response) {
                return response.json()
            })
            .then(function (messages) {

                _.each(messages, function (message) {
                    let userName = message.ownerName
                    let content = message.message_content
                    let sendDate = message.send_date

                    let messagesArea = `
                                <div class="areaSendDate">${sendDate} </div>
                                <div class="areaUserName">${userName} </div>
                                <div class="areaContent" >${content}</div>
                                `

                    $('#messageArea').append(messagesArea)

                })

             })
            .catch( function (reject) {
                console.log(reject)
            })

    }


    sendMessage = () => {


    //    Берем значения того, кто отправил и что он отправил
        let userName    = document.getElementById('username').value
        let userId      = document.getElementById('user_id').value
        let messageText = document.getElementById('messageinput').value

        if (messageText.length > 0 && messageText.trim() != "") {
            var messageJSON = {
                userName: userName,
                userId: userId,
                messageText: messageText
            }
        }

        // Отправляем сообщение по сокет соединению, предварительно конвертируя в JSON
        webSocket.send(JSON.stringify(messageJSON))

        //Очищаем строку ввода сообщения
        document.getElementById('messageinput').value = ""

        let sendDate = new Date().getDate()
        debugger

        let messageArea = `
                           <div class="areaSendDate">${sendDate} </div>
                           <div class="areaUserName">${userName} </div>
                            <div class="areaContent" >${messageText}</div>
                        `

        $('#messageArea').append(messageArea)
    }
})






writeResponse = event => {
    console.log(event)
}
