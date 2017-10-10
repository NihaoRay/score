/**
 * @author https://github.com/NihaoRay
 * @date 2017-09-16
 * @description jquery animate funtion
 */
(function ($) {

    /**json数据序列化*/
    $.fn.serializeJSON = function () {
        var jsonObj = {};
        var array = this.serializeArray();
        $(array).each(
            function () {
                if (jsonObj[this.name]) {
                    if ($.isArray(jsonObj[this.name])) {
                        jsonObj[this.name].push(this.value);
                    } else {
                        jsonObj[this.name] = [jsonObj[this.name], this.value];
                    }
                } else {
                    jsonObj[this.name] = this.value;
                }
            });
        return jsonObj;
    };

    /**动画延长*/
    $.fn.animateLength = function (withPic, speedTime) {
        var $Obj = this;
        $Obj.click(function () {
            $Obj.animate({
                width: withPic
            }, speedTime);
        })
    };
})(jQuery);

/**
 * @部分参数说明
 */
(function ($) {
    $.fn.extend({
        //主函数
        toggleLoading: function (options) {
            // 找到遮罩层
            var crust = this.children(".x-loading-wanghe");
            // 当前操作的元素
            var thisjQuery = this;
            // 实现toogle(切换遮罩层出现与消失)效果的判断方法
            if (crust.length > 0) {
                if (crust.is(":visible")) {
                    crust.fadeOut(500);
                } else {
                    crust.fadeIn(500);
                }
                return this;
            }
            // 扩展参数
            var op = $.extend({
                z: 9999,
                msg: '处理中...',
                iconUrl: '/static/jquery-plugin/loading/loading.gif',
                width: 48,
                height: 48,
                borderColor: '#333333',
                opacity: 0.5,
                agentW: thisjQuery.outerWidth(),
                agentH: thisjQuery.outerHeight()
            }, options);

            if (thisjQuery.css("position") == "static")
                thisjQuery.css("position", "relative");
            //var w = thisjQuery.outerWidth(),h = thisjQuery.outerHeight();

            var w = op.agentW, h = op.agentH;
            crust = $("<div></div>").css({//外壳
                'position': 'absolute',
                'z-index': op.z,
                'display': 'none',
                'width': w + 'px',
                'height': h + 'px',
                'text-align': 'center',
                'top': '0px',
                'left': '0px',
                'font-family': 'arial',
                'font-size': '12px',
                'font-weight': '500'
            }).attr("class", "x-loading-wanghe");

            var mask = $("<div></div>").css({//蒙版
                'position': 'absolute',
                'z-index': op.z + 1,
                'width': '100%',
                'height': '100%',
                'background-color': '#333333',
                'top': '0px',
                'left': '0px',
                'opacity': op.opacity
            });
            //71abc6,89d3f8,6bc4f5
            var msgCrust = $("<span></span>").css({//消息外壳
                'position': 'relative',
                'top': (h - 30) / 2 + 'px',
                'z-index': op.z + 2,
                'height': '24px',
                'display': 'inline-block',
                'background-color': '#333333',
                'padding': '2px',
                'color': '#000000',
                'border': '0px' + op.borderColor,
                'text-align': 'left',
                'opacity': 0.9
            });
            var msg = $("<span>" + op.msg + "</span>").css({//消息主体
                'position': 'relative',
                'margin': '0px',
                'z-index': op.z + 3,
                'line-height': '22px',
                'height': '22px',
                'display': 'inline-block',
                'background-color': '#efefef',
                'padding-left': '25px',
                'padding-right': '5px',
                'border': '0px' + op.borderColor,
                'text-align': 'left',
                'text-indent': '0'
            });
            var msgIcon = $("<img src=" + op.iconUrl + " />").css({//图标
                'position': 'absolute',
                'top': '3px',
                'left': '3px',
                'z-index': op.z + 4,
                'width': '18px',
                'height': '18px'
            });
            // 拼装遮罩层
            //msg.prepend(msgIcon);
            //msgCrust.prepend(msg);
            crust.prepend(mask);
            //crust.prepend(msgCrust);
            thisjQuery.prepend(crust);
            // alert(thisjQuery.html());
            crust.fadeIn(500);
            //模态设置
            return this;
        }
    });
})(jQuery);


/**
 相关配置

 配置&configure
 全部配置    默认值    说明
 z:    9999    图层z-index,当蒙版遮罩不住时候适当增大其值
 msg:    数据加载中...    提示信息
 iconUrl:    images/loading.gif    提示图片url
 height:    18    图标默认高(px)
 width:    18    图标默认宽(px)
 borderColor    #6bc4f5    提示的边框颜色
 opacity:    0.5    蒙版的透明度
 agentW:    当前元素的宽度    蒙版的宽度
 agentH:    当前元素的高度    蒙版的高度
 **/
(function ($) {
    $.fn.extend({
        //主函数
        mask: function (options) {
            // 找到遮罩层
            var crust = this.children(".x-loading-ekingstar");
            // 当前操作的元素
            var thisjQuery = this;
            // 扩展参数
            var op = $.extend({
                z: 9999,
                borderColor: '#333333',
                opacity: 0.0,
                agentW: thisjQuery.outerWidth(),
                agentH: thisjQuery.outerHeight()
            }, options);

            if (thisjQuery.css("position") == "static") {
                thisjQuery.css("position", "relative");
            }
            var w = op.agentW, h = op.agentH;
            crust = $("<div></div>").css({//外壳
                'position': 'absolute',
                'z-index': op.z,
                'display': 'none',
                'width': '100%',
                'height': '100%',
                'top': '0px',
                'left': '0px'
            }).addClass("x-loading-ekingstar");

            var mask = $("<div></div>").css({//蒙版
                'position': 'absolute',
                'z-index': op.z + 1,
                'width': '100%',
                'height': '100%',
                'background-color': '#333333',
                'top': '0px',
                'left': '0px',
                'opacity': op.opacity
            });
            // 拼装遮罩层
            crust.prepend(mask);
            thisjQuery.prepend(crust);
            crust.fadeIn(0);
            //模态设置
            return this;
        }
    });
})(jQuery);

