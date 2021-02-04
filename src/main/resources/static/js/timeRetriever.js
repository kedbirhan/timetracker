function loadSearchResult(id) {
    console.log(id)
    $.ajax({
        type: "GET",
        // contentType: "application/json",
        url: "/getTimeDate/"+ id,
        // data: JSON.stringify(loginForm),
        // dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            let trHtml = '';
            $.each(data, function (i,item){

               trHtml+=  '<tr id='+'row'+ item.id + '>' +
                   '<td>' +
                       item.timeVal
                   +
                   '</td>' +
                   '<td>' +
                       '<textarea rows="3">' +
                       item.taskAssigned +
                           '</textarea>'
                       +
                   '</td>' +
                   '<td>' +
                        '<textarea rows="3">' +
                        item.taskStatusProgress +
                        '</textarea>'+
                   '</td>' +
                   '<td>' + item.focusLevel + '</td>' +
                   '<td>' +
                   '<button onclick=updateTime('+ item.id + ")>"+ 'Update </button>' +
                  '</td>' +
                   '</tr>';
            });
            $('#timeList tbody').html(trHtml)
        },
        error: function (e) {

            var json = "<h4>Ajax Response Error</h4><pre>"
                + e.responseText + "</pre>";
            console.log("ERROR : ", e);

        }
    });

}
function updateTime(id){
    console.log(id)
    let timeLog = {};
    let rowId="#row"+id;
    let row= $(rowId)
    // var staus=row.find("textarea:eq(1)").val();
    timeLog.taskAssigned=row.find("textarea:eq(0)").val();
    timeLog.taskStatusProgress=row.find("textarea:eq(1)").val();
    timeLog.focusLevel=row.find("td:eq(3)").text();
    timeLog.id=id;
    timeLog.timeVal="null";
    console.log(timeLog)

    $.ajax({
        type: "POST",
        // contentType: "application/json",
        url: "/updateTime",
        data: JSON.stringify(timeLog),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log(data)

        },
        error: function (e) {

            var json = "<h4>Ajax Response Error</h4><pre>"
                + e.responseText + "</pre>";
            console.log("ERROR : ", e);

        }
    });

}
