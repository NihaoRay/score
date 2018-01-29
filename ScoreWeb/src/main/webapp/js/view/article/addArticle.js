/**
  @author chenrui on 2018/1/20.
 */
$(document).ready(function(){
    //添加layer组件
    layui.use('layedit', function () {
        var layedit = layui.layedit;

        var index = layedit.build('demo', {
            //hideTool: ['image']
            uploadImage: {
                url: '/article/upload' ,
                type: 'post'
            }
            //,tool: []
            //,height: 100
        });
        save.onclick = function () {
            //alert(layedit.getContent(index));
            debugger;
            layedit.sync(index);
            var text = layedit.getContent(index);
            if(!text.trim()) {
                layer.msg("请输入文章内容",{icon: 7});
                return;
            }
            var textTitle = $("#content-flag").find(".article-title").val();
        };

        getChoose.onclick = function () {
            //layer.alert(layedit.getContent(index));
            //alert(layedit.getContent(index));
            //layedit.getContent(index);
        };
    });
});


