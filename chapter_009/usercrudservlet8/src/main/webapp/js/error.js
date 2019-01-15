// Types message about user's errors.

window.onload = function () {
    $.get('../errormanager', function (responseText) {
        $("#error_message").html(responseText);
    });
};