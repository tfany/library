$(function () {
    //获取店铺出初始信息
    var loginUrl = '/library/user/verifylogin';


    $('#login').click(function () {
        var cardNumber = $('#card-number').val();
        var password = $('#password').val();
        var formData = new FormData();
        formData.append('cardNumber', cardNumber);
        formData.append('password', password);
        $.ajax({
            url: loginUrl,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    alert("成功");
                } else {
                    alert("失败");
                }
            }
        })
    })
})