/**
  @author chenrui on 2018/1/20.
 */
//后台数据交互和json数据渲染
var vm = new Vue({
    el:"#inputForm",
    data:{
        username: "",
        password: "",
        error:""
    },
    methods:{
        /*refreshCode: function () {
         $("#code").attr("src", "/user/getCode?timestamp="+$.now());
         },*/
        login:function (event) {
            if(!vm.username) {
                vm.error = "请输入用户名"
                return false;
            }
            if(!vm.password) {
                vm.error = "请输入密码"
                return false;
            }
            var data = "username=" + vm.username + "&password="+vm.password;
            //加载loading
            var index = layer.load(1, {
                shade: [0.1,'#fff'] //0.1透明度的白色背景
            });

            $.ajax({
                type: "POST",
                url: "/sys/login",
                data: data,
                dataType: "json",
                success: function (result) {
                    //关闭loading层
                    layer.close(index);
                    if (parseInt(result.code) == 202) {//登录成功
                        if(!result.result) {
                            location.href="/index.html";
                            return true;
                        }
                        location.href=result.result;
                        return true;
                    }
                    else {
                        vm.error = result.message;
                    }
                }
            });
        }
    }
});

