function filterAccounts() {
    var input = document.getElementById("accountInput").value.toLowerCase();
    var accounts = document.getElementById("accountList").getElementsByTagName("li");

    for (var i = 0; i < accounts.length; i++) {
        var account = accounts[i].innerHTML.toLowerCase();
        if (account.includes(input)) {
            accounts[i].style.display = "block";
        } else {
            accounts[i].style.display = "none";
        }
    }
}

function selectAccount(account) {
    document.getElementById("accountInput").value = account;
    document.getElementById("accountList").style.display = "none";
}

document.addEventListener("click", function (event) {
    var targetElement = event.target;
    if (targetElement.id !== "accountInput") {
        document.getElementById("accountList").style.display = "none";
    }
});

document.getElementById("accountInput").addEventListener("focus", function () {
    document.getElementById("accountList").style.display = "block";
});

function filterSubject() {
    var input = document.getElementById("subjectInput").value.toLowerCase();
    var subjects = document.getElementById("subjectList").getElementsByTagName("li");

    for (var i = 0; i < subjects.length; i++) {
        var subject = subjects[i].innerHTML.toLowerCase();
        if (subject.includes(input)) {
            subjects[i].style.display = "block";
        } else {
            subjects[i].style.display = "none";
        }
    }
}

function selectSubject(subject) {
    document.getElementById("subjectInput").value = subject;
    document.getElementById("subjectList").style.display = "none";
}

document.addEventListener("click", function (event) {
    var targetElement = event.target;
    if (targetElement.id !== "subjectInput") {
        document.getElementById("subjectList").style.display = "none";
    }
});

document.getElementById("subjectInput").addEventListener("focus", function () {
    document.getElementById("subjectList").style.display = "block";
});