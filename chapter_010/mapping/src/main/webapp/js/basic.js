// Draw table with car advertisements. Shows and hides loading animation.
window.onload = function () {
    $('#loading').show();
    $.get('../showallads', function (responseText) {
        $("#cars_table").html(responseText);
        $('#loading').hide();
    });
};

//Redirect to car page with saved id of advertisement to create that page.
function redirect_by_id() {
    var advertisement_id = event.srcElement.id;
    $.ajax('../idkeeper', {
        method: 'post',
        data: {
            advertisement_id: advertisement_id
        }
    });
    location.href = "../html/car.html";
}
