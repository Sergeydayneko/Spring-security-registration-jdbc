/**
 * Add _csrf token for every Ajax query
 */

$(function () {
    let token = $("meta[name='_csrf']").attr("content");
    let header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr) {
        xhr.setRequestHeader(header, token);
    });
});