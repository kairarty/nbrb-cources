$(function() {  // блокировка выбора следующих дат
    $('[type="date"]').prop('max', function(){
        return new Date().toJSON().split('T')[0];
    });
});

function getForm(form) {
    let formData = form.elements;
    let date = (formData.date.value);
    let cur = (formData.currName.value);
    let errP = $('#emptyText');
    if (date === "" || cur === "") {
        errP.text("Выберите все параметры и повторите попытку!")
    } else {
        errP.empty();
        $.get("getFormInfo/" + cur + "," + date, function(inputCurse) {
            $('#curse').text('Курс выбранной валюты: ' + inputCurse)
        });
    }
}