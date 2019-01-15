// Fills up some table elements. Shows error message if user didn't sign in and redirect him to sign in page.
window.onload = function () {
    $.get('../datachecker', function (responseText) {
        if (responseText == "null_user") {
            $('#negative_message').show();
            setTimeout(function () {
                window.location.href = "../html/sign_in.html";
            }, 3000);
        } else if (responseText == "data_in"){
            $('#create_button').show();
        } else {
            showCarDetails();
        }
    });
};

// Fills up car details form.
function showCarDetails() {
    $.get('../listofbrands', function (responseText) {
        $("#brands_list").html(responseText);
    });
    $.get('../listofmodels', function (responseText) {
        $("#models_list").html(responseText);
    });
    $.get('../listofbodystyles', function (responseText) {
        $("#bodies_list").html(responseText);
    });
    $.get('../listofengines', function (responseText) {
        $("#engines_list").html(responseText);
    });
    $.get('../listoftransmissions', function (responseText) {
        $("#transmissions_list").html(responseText);
    });
    $.get('../listofwheeldrives', function (responseText) {
        $("#drives_list").html(responseText);
    });
    $('#car_det').show();
}

// Submit add advertisement form.
$(document).on('click', '#adv_submit', function () {
    $.ajax('../addadv', {
        method: 'post',
        data: {
            brand: $('#brands_list').val(),
            model: $('#models_list').val(),
            body: $('#bodies_list').val(),
            engine: $('#engines_list').val(),
            transmission: $('#transmissions_list').val(),
            wheeldrive: $('#drives_list').val(),
            horsepowers: $('#hp').val(),
            productionYear: $('#productionYear').val(),
            mileage: $('#mileage').val(),
            color: $('#color').val(),
            description: $('#adv_description').val(),
            price: $('#car_price').val()
        },
        success: function (responseText) {
            if (responseText == "success") {
                $('#to_picture').show();
                setTimeout(function () {
                    $('#car_det').hide();
                    $('#img_form').show();
                }, 2000);
            }

            if (responseText == "fail") {
                $('#error_message').show();
                setTimeout(function () {
                    window.location.href = "../html/add_new_adv.html";
                }, 2000);
            }
        }
    });
});

// Creates new advertisement.
$(document).on('click', '#create_btn', function () {
    $.ajax('../advcreator', {
        method: 'post',
        success: function (responseText) {
            if (responseText == "success"){
                window.location.href = "../html/basic.html";
            }
        }
    });
});