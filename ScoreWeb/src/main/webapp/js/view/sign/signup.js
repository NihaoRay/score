/**
  @author chenrui on 2018/1/20.
 */
//后台数据交互和json数据渲染
var vm = new Vue({
    el:"#inputForm",
    data: {
        username:"",
        email:"",
        password:"",
        error:""
    },
    methods: {
        signup:function (event) {
            debugger;
            if(!vm.username) {
                vm.error = "请输入首次登陆昵称"
                return false;
            }
            if(!vm.password) {
                vm.error = "请输入首次使用密码"
                return false;
            }
            if(!vm.email) {
                vm.error = "请输入邮箱"
                return false;
            }
            vm.error="";
            //封装数据
            var data = "username=" + vm.username + "&password="+vm.password+"&email="+vm.email;
            //加载loading
            var index = layer.load(1, {
                shade: [0.1,'#fff'] //0.1透明度的白色背景
            });

            $.ajax({
                type: "POST",
                url: "/user/save",
                data: data,
                dataType: "json",
                success: function (result) {
                    //关闭loading层
                    layer.close(index);
                    if (parseInt(result.code) == 202) {//注册成功跳转到登陆页面
                        if(!result.result) {
                            location.href="/";
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
