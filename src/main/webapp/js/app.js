$(document).ready(function() {
    $('#toSend').click(function () {
           $.ajax({
                url : 'Servlet',
                data : {
                    inputNumber : $('#inputNumber').val()
                },
                success: function (responseText) {
                    $('#textarea').append(responseText + "\n");
                    document.getElementById("inputNumber").value = "";

                },
                error: function (jqXHR) {
                    alert("error:" + jqXHR.status + " exception:" + jqXHR.responseText);
                }
            });

    });
});


    function check(input) {
        input.value = input.value.replace(/[^\d]/g, '');
        if (input.value.length===4) {
            if (input.value[0] === input.value[1]  || input.value[0] === input.value[2]||
                input.value[0] === input.value[3]  || input.value[1] === input.value[2] ||
                input.value[1] === input.value[3] || input.value[2] === input.value[3]) {
                input.value = input.value.replace(/^[0-9]{4}$/, "");
            }
        }
    }