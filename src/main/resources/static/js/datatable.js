$(document).ready( function () {
    var table = $('#reviewsTable').DataTable({
        "sAjaxSource": "/reviews",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "id"},
            { "mData": "review" }
        ]
    })
});