'use strict';


function addTheme() {

    let form = document.getElementById("form-theme");
    let data = new FormData(form);
    let name = "_csrf"
    let value = document.getElementsByName("_csrf_token")[0].getAttribute("content")
    data.append(name, value);

    fetch("http://localhost:9889/addTheme", {
        method: 'POST',
        body: data
    }).then(r =>
        r.json());
    window.location.replace("http://localhost:9889/");
}

function sendMessage(id) {
    let form = document.getElementById("form-message");
    let data = new FormData(form);
    let name = "_csrf"
    let value = document.getElementsByName("_csrf_token")[0].getAttribute("content")
    data.append(name, value);
    data.append("id", id);

    fetch("http://localhost:9889/addComment", {
        method: 'POST',
        body: data
    }).then(r => r.json());
    window.location.replace("http://localhost:9889/theme/" + id);
}