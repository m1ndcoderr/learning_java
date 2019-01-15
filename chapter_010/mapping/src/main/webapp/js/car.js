// Draw table with car advertisements. Shows and hides loading animation.
window.onload = function () {
    $('#loading').show();
    $.get('../showcardetails', function (responseText) {
        $("#car_details").html(responseText);
        $('#loading').hide();
    });
};

// Changes sold parameter of advertisement.
$(document).on('click', '#sold_btn', function () {
    $.ajax('../changesold', {
        method: 'post',
        success: function (responseText) {
            if (responseText == "success") {
                $("#sold").html('Sold: Yes');
            }
        }
    });
});
