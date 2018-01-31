/**
  @author chenrui on 2018/1/20.
 */
//生成的标题的全局变量
    var index=null;
    var layedit=null;

$(document).ready(function(){
    //添加layer组件
    layui.use('layedit', function () {
        layedit = layui.layedit;
        index = layedit.build('demo', {
            //hideTool: ['image']
            uploadImage: {
                url: '/article/upload' ,
                type: 'post'
            }
            //,tool: []
            //,height: 100
        });

        getChoose.onclick = function () {
            //layer.alert(layedit.getContent(index));
            //alert(layedit.getContent(index));
            //layedit.getContent(index);
        };
    });
});

//后台数据渲染
var articleVm = new Vue({
    el : "#container",
    data : {
        title:"请输入标题",
        titleImage:""
    },
    methods:{
        save:function (event) {
            debugger;
            //添加文本内容
            //layedit.setContent(index, "", false);
            var content=layedit.getContent(index);
            //回显id判断是否是新增还是修改
            var hiddenArticleId = $("#hiddenArticleId").val();
            var hiddenArticleTextId = $("#hiddenArticleTextId").val();
            articleVm.titleImage=$.cookie('titleImage');
            if($.cookie('titleImage') == "null") {
                articleVm.titleImage="/img/sys/logon.png";
            }
            $.ajax({
                type: "POST",
                url: "/article/save",
                data: {
                    "id":hiddenArticleId,
                    "textId.id":hiddenArticleTextId,
                    "textId.content":content,
                    "title":articleVm.title,
                    "titleImage":articleVm.titleImage
                },
                dataType: "json",
                success: function (result) {
                    debugger;
                    //清除刚刚保存的cookie
                    $.cookie("titleImage",null);
                    //回显提示数据
                    if (parseInt(result.code) == 0) {//登录成功
                         layer.tips('保存成功，继续编辑不会丢啦', '#layui-btn', {
                         tips: [1, '#d49532'],
                         time: 4000
                         });
                         //在回显域中添加id
                        console.log(result.result);
                        $("#hiddenArticleId").val(result.result.id);
                        $("#hiddenArticleTextId").val(result.result.textId.id);
                        return true;
                    }
                    else {
                        layer.tips('后台抽风了，等下再试试', '#layui-btn', {
                            tips: [1, '#d49532'],
                            time: 4000
                        });
                        return true;
                    }
                }
            });
        }
    }
});