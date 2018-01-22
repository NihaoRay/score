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
})


//后台数据交互和json数据渲染
var vm = new Vue({



});