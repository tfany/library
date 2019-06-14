layui.use(['form', 'layedit', 'laydate', 'upload'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate
        , upload = layui.upload
        , $ = layui.jquery
        , registerUrl = '/library/user/verifyregister'

    //日期
    laydate.render({
        elem: '#date'
    });
    laydate.render({
        elem: '#date1'
    });

    //创建一个编辑器
    var editIndex = layedit.build('LAY_demo_editor');

    //自定义验证规则
    form.verify({
        title: function (value) {
            if (value.length < 5) {
                return '标题至少得5个字符啊';
            }
        }
        , pass: [
            /^[\S]{6,12}$/
            , '密码必须6到12位，且不能出现空格'
        ]
        , content: function (value) {
            layedit.sync(editIndex);
        }
    });


    //监听提交
    form.on('submit(submit)', function (data) {
        var formData=new FormData();
        var userInfo={};
        var headImg = $('#head-img')[0].files[0];
        userInfo.name=data.field.name;
        userInfo.phoneNum=data.field.phoneNum;
        userInfo.password=data.field.password;
        userInfo.gender=data.field.gender;

        formData.append("userInfo",JSON.stringify(userInfo));
        formData.append("headImg",headImg);




        $.ajax({
            url: registerUrl,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    layer.alert('注册成功，卡号为'+data.userId, {icon: 6});
                    setTimeout(function(){
                        $(location).attr('href', '/library/frontend/login');
                    },1000);

                } else {
                    layer.msg('注册失败'+data.msg);
                }
            }
        })

    });


    var uploadInst = upload.render({
            elem: '#head-upload'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#head').attr('src', result); //图片链接（base64）
                });
            }
        }
    );
});

function viewmypic(mypic, upfile) {
    mypic.style.display = "";
    mypic.src = window.URL.createObjectURL(upfile.files[0]);
}