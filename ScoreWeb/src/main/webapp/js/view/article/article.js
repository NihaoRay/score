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
        user:{},
        photo:"/img/profile/chenrui.png"
    },
    methods: {
        /**获得当前用户*/
        getUser:function () {
            /*$.getJSON("")*/
            var flag = 1;
            userCenterCtrl(flag);
        },
        //初始化加载的方法
        created: function(){
            this.getUser();
        }
    }
});

//控制显示登录注册按钮，还是用户头像
function userCenterCtrl(user) {
    if(user) {
        $("#nav_user").hide();
        $(".log-in").show();
        $(".sign-up").show();
    } else {
        $("#nav_user").show();
        $(".log-in").hide();
        $(".sign-up").hide();
    }
}