// 'Quit'. All session saved parameters will be null.
$(document).on('click', '#quit', function () {
    $.ajax('../quit', {
        method: 'post'
    });
    alert('You have quit (all parameters of session are null now).');
    window.location.href = "../html/basic.html";
});