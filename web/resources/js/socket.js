var socket = new WebSocket("ws://localhost:8080/CS230-Projekat/actions");
socket.onmessage = onMessage;

function onMessage(event) {
    console.log(event);
}

function addOsoba(ime, prezime, grad, fakultet) {
    socket.send(JSON.stringify(OsobaAction));
}

