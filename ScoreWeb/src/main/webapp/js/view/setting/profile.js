/**
 @author chenrui on 2018/1/20.
 */
$(document).ready(function(){
    //添加layer组件
    layui.use('util', function() {
        var util = layui.util,
            $ = layui.$;
        util.fixbar({
            bar1: true,
            bar2: false
        });
    });
    //控制导航栏中的，用户下来菜单是否显示
    $(".user").hover(function(){
        $(".dropdown-menu").show();
    },function (){
        $(".dropdown-menu").hide();
    });

    //页面初始化加载created方法
    vm.created();
});

//后台数据交互和json数据渲染
var vm = new Vue({
    el:"#nav_user",
    data:{
        user:{}
    },
    methods: {
        /**获得当前用户*/
        getUser:function () {
            /*$.getJSON("")*/
            var flag = false;
            /*vm.user = {"id":"1","createDate":"2018-01-17 12:24:42","delFlag":"1","isNewRecord":false,"no":"chenrui","username":"admin","email":"1","phone":"1","mobile":"1","userType":"1","photo":"/img/profile/chenrui.png"};*/
            $.getJSON("/sys/getCurrentUser?_"+$.now(), function(result){
                if(parseInt(result.code) == 404) {
                    flag=true;
                    userCenterCtrl(flag);
                }
                else {
                    flag = false;
                    userCenterCtrl(flag);
                    vm.user=result.result;
                }
            });
        },
        //初始化加载的方法
        created: function(){
            this.getUser();
        }
    }
});

//控制显示登录注册按钮，还是用户头像
function userCenterCtrl(flag) {
    if(flag) {
        $("#nav_user").hide();
        $(".log-in").show();
        /*$(".sign-up").show();*/
    } else {
        $("#nav_user").show();
        $(".log-in").hide();
        /*$(".sign-up").hide();*/
    }
}