// Create user input in table validation.
function validate() {
    var result = true;
    if (document.getElementsByName('name').value == null) {
        alert('Field "Username" cannot be empty.');
        result = false;
    }
    if (document.getElementsByName('login').value == null) {
        alert('Field "Login" cannot be empty.');
        result = false;
    }
    if (document.getElementsByName('email').value == null) {
        alert('Field "Email" cannot be empty.');
        result = false;
    }
    if (document.getElementsByName('role_id').value == null) {
        alert('Field "Role id" cannot be empty.');
        result = false;
    }
    if (isNaN(document.getElementsByName('role_id').value)) {
        alert('Field "Role id" is not a number.');
        result = false;
    }
    if (document.getElementsByName('role_id').value != "1" ||
        document.getElementsByName('role_id').value != "3" ||
        document.getElementsByName('role_id').value != "21") {
        alert('Field "Role id" is not correct (choose between 1, 3, 21).');
        result = false;
    }
    if (document.getElementsByName('country').value == null) {
        alert('Field "Country" cannot be empty.');
        result = false;
    }
    if (document.getElementsByName('city').value == null) {
        alert('Field "City" cannot be empty.');
        result = false;
    }
    return result;
}