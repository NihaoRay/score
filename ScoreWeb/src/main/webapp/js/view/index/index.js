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
    listVm.created();
});

//后台数据交互和json数据渲染
var vm = new Vue({
    el:"#nav_user",
    data:{
        user:{},
        url:"/view/profile/profile.html"
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
                    //拼接url携带id
                    vm.url=vm.url+"?id="+vm.user.id;
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

//后台数据交互和json数据渲染
var listVm = new Vue({
    el:"#queryList",
    data:{
        list:{}
    },
    methods: {
        /**获得当前用户*/
        queryList:function () {
            /*$.getJSON("")*/
            var flag = false;
            $.getJSON("/notauth/article/queryList?_"+$.now(), function(result){
                listVm.list = result.result;
            });
            //var listJson = {"success":false,"result":[{"id":"53f8bc018e9d4ea2977d8d8b32cf75f4","createBy":{"id":"1","delFlag":"0","isNewRecord":false,"username":"admin","photo":"/img/profile/chenrui.png"},"createDate":"2018-02-01 11:32:45","updateDate":"2018-02-01 11:35:04","delFlag":"0","isNewRecord":false,"title":"陈瑞，测试，你好","titleImage":"/img/profile/chenrui2.png","isPublish":"0"},{"id":"c34afec19cac4eeb9136b31d1515d14b","createBy":{"id":"1","delFlag":"0","isNewRecord":false,"username":"admin","photo":"/img/profile/chenrui.png"},"createDate":"2018-02-01 11:46:07","updateDate":"2018-02-01 11:46:07","delFlag":"0","isNewRecord":false,"title":"开发者","titleImage":"/img/profile/chenrui2.png","isPublish":"0"},{"id":"9ed10086cfda4f6795e47672acc1c83d","createBy":{"id":"1","delFlag":"0","isNewRecord":false,"username":"admin","photo":"/img/profile/chenrui.png"},"createDate":"2018-02-01 20:56:17","updateDate":"2018-02-01 20:59:04","delFlag":"0","isNewRecord":false,"title":"I love sun yet qing","titleImage":"/img/profile/chenrui2.png","isPublish":"0"},{"id":"62c5555a74b44ed6835a4bbb2d0df6bf","createBy":{"id":"1","delFlag":"0","isNewRecord":false,"username":"admin","photo":"/img/profile/chenrui.png"},"createDate":"2018-02-01 21:08:42","updateDate":"2018-02-01 21:09:01","delFlag":"0","isNewRecord":false,"title":"请输入标题","titleImage":"/img/profile/chenrui2.png","isPublish":"0"}],"code":0};
            //listVm.list = listJson.result;
        },
        //初始化加载的方法
        created: function(){
            this.queryList();
        }
    }
});