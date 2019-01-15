// Add item to DB.
$(document).on('click', '#add_item', function () {
    $.ajax('../additem', {
        method: 'post',
        data: {
            description: $('#add_item_desc').val()
        }
    });
    makeRedirect();
});

// Update description of item in DB.
$(document).on('click', '#update_item', function () {
    $.ajax('../updatedesc', {
        method: 'post',
        data: {
            id: $('#upd_item_id').val(),
            description: $('#upd_item_desc').val()
        }
    });
    makeRedirect();
});

// Update boolean value of item of item in DB.
$(document).on('click', '#set_done_item', function () {
    $.ajax('../updatedone', {
        method: 'post',
        data: {
            id: $('#upd_item_done').val()
        }
    });
    makeRedirect();
});

// Delete item from DB.
$(document).on('click', '#delete_item', function () {
    $.ajax('../deleteitem', {
        method: 'post',
        data: {
            id: $('#delete_item_id').val()
        }
    });
    makeRedirect();
});

// Shows list of items.
$(document).on('click', '#show_list', function () {
    var check = document.getElementById("show_all_done").checked;
    $('#items_list').html("");
    if (check == true) {
        $.get('../getall', function (responseText) {
            $("#items_list").html(responseText);
        });
    }
    if (check == false) {
        $.get('../getunfulfilled', function (responseText) {
            $("#items_list").html(responseText);
        });
    }
});

// Reload the page.
function makeRedirect() {
    location.href = "../html/index.html";
}