// Button action: show user's table.

function showTable() {

    $.ajax('../json', {
        method: 'GET',
        success: function (users) {
            var result = "<tr>" +
                "<th>Username</th>" +
                "<th>Login</th>" +
                "<th>Email</th>" +
                "<th>Create date</th>" +
                "<th>Role</th>" +
                "<th>Country</th>" +
                "<th>City</th>" +
                "</tr>";
            console.log(users.length);
            for (var i = 0; i < users.length; i++) {
                result += "<tr>" +
                    "<td>" + users[i].name + "</td>" +
                    "<td>" + users[i].login + "</td>" +
                    "<td>" + users[i].email + "</td>" +
                    "<td>" + users[i].create_date + "</td>" +
                    "<td>" + users[i].role + "</td>" +
                    "<td>" + users[i].country + "</td>" +
                    "<td>" + users[i].city + "</td>" +
                    "</tr>";
            }
            var table = document.getElementById("showtable");
            table.innerHTML(result);
        }
    });
}


