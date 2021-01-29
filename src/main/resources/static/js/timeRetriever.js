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
            var trHtml='';
            $.each(data, function (i,item){

               trHtml+=  '<tr><td>' + item.task + '</td><td>' + item.distractions + '</td><td>' + item.timeVal + '</td></tr>';
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