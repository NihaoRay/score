/**
 * @author https://github.com/NihaoRay
 * @date 2017-09-16
 * @description jquery animate funtion
 */
(function($) {
	
	/**json数据序列化*/
	$.fn.serializeJSON = function() {
		var jsonObj = {};
		var array = this.serializeArray();
		$(array).each(
				function() {
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
	$.fn.animateLength = function(withPic, speedTime) {
		var $Obj = this;
		$Obj.click(function() {
			$Obj.animate({
  				width:withPic
  			}, speedTime);
		})
	};
})(jQuery);

/** 
     * @部分参数说明 
     */  
    (function($){  
        $.fn.extend({  
            //主函数   
            toggleLoading: function(options){
                // 找到遮罩层   
                var crust = this.children(".x-loading-wanghe");  
                // 当前操作的元素   
                var thisjQuery = this;  
                // 实现toogle(切换遮罩层出现与消失)效果的判断方法   
                if(crust.length>0){  
                    if(crust.is(":visible")){  
                        crust.fadeOut(500);  
                    }else{  
                        crust.fadeIn(500);  
                    }  
                    return this;  
                }  
                // 扩展参数   
                var op = $.extend({  
                    z: 9999,  
                    msg:'处理中...',  
                    iconUrl:'/static/jquery-plugin/loading/loading.gif',  
                    width:48,  
                    height:48,  
                    borderColor:'#333333',  
                    opacity:0.5,  
                    agentW:thisjQuery.outerWidth(),  
                    agentH:thisjQuery.outerHeight()  
                },options);  
                  
                if(thisjQuery.css("position")=="static")  
                    thisjQuery.css("position","relative");  
                //var w = thisjQuery.outerWidth(),h = thisjQuery.outerHeight();   
                  
                var w = op.agentW,h = op.agentH;                              
                crust = $("<div></div>").css({//外壳   
                    'position': 'absolute',  
                    'z-index': op.z,  
                    'display':'none',  
                    'width':w+'px',  
                    'height':h+'px',  
                    'text-align':'center',  
                    'top': '0px',  
                    'left': '0px',  
                    'font-family':'arial',  
                    'font-size':'12px',  
                    'font-weight':'500'  
                }).attr("class","x-loading-wanghe");  
                  
                var mask = $("<div></div>").css({//蒙版   
                    'position': 'absolute',  
                    'z-index': op.z+1,  
                    'width':'100%',  
                    'height':'100%',  
                    'background-color':'#333333',  
                    'top': '0px',  
                    'left': '0px',  
                    'opacity':op.opacity  
                });  
                //71abc6,89d3f8,6bc4f5   
                var msgCrust = $("<span></span>").css({//消息外壳   
                        'position': 'relative',  
                        'top': (h-30)/2+'px',  
                        'z-index': op.z+2,  
                        'height':'24px',  
                        'display':'inline-block',  
                        'background-color':'#333333',  
                        'padding':'2px',  
                        'color':'#000000',  
                        'border':'0px'+op.borderColor,  
                        'text-align':'left',  
                        'opacity':0.9  
                    });  
                var msg = $("<span>"+op.msg+"</span>").css({//消息主体   
                        'position': 'relative',  
                        'margin': '0px',  
                        'z-index': op.z+3,  
                        'line-height':'22px',  
                        'height':'22px',  
                        'display':'inline-block',  
                        'background-color':'#efefef',  
                        'padding-left':'25px',  
                        'padding-right':'5px',  
                        'border':'0px'+op.borderColor,  
                        'text-align':'left',  
                        'text-indent':'0'  
                    });  
                var msgIcon =  $("<img src="+op.iconUrl+" />").css({//图标   
                        'position': 'absolute',  
                        'top': '3px',  
                        'left':'3px',  
                        'z-index': op.z+4,  
                        'width':'18px',  
                        'height':'18px'  
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
    全部配置 	默认值 	说明
    z: 	9999 	图层z-index,当蒙版遮罩不住时候适当增大其值
    msg: 	数据加载中... 	提示信息
    iconUrl: 	images/loading.gif 	提示图片url
    height: 	18 	图标默认高(px)
    width: 	18 	图标默认宽(px)
    borderColor 	#6bc4f5 	提示的边框颜色
    opacity: 	0.5 	蒙版的透明度
    agentW: 	当前元素的宽度 	蒙版的宽度
    agentH: 	当前元素的高度 	蒙版的高度
    **/
(function($){  
        $.fn.extend({  
            //主函数   
            mask: function(options){
                // 找到遮罩层   
                var crust = this.children(".x-loading-ekingstar");  
                // 当前操作的元素   
                var thisjQuery = this;  
                // 扩展参数   
                var op = $.extend({  
                    z: 9999,  
                    borderColor:'#333333',  
                    opacity:0.0,  
                    agentW:thisjQuery.outerWidth(),  
                    agentH:thisjQuery.outerHeight()  
                },options);  
                  
                if(thisjQuery.css("position")=="static"){
                    thisjQuery.css("position","relative");  
                }  
                var w = op.agentW,h = op.agentH;                              
                crust = $("<div></div>").css({//外壳   
                    'position': 'absolute',  
                    'z-index': op.z,  
                    'display':'none',  
                    'width':'100%',  
                    'height':'100%',  
                    'top': '0px',  
                    'left': '0px'
                }).addClass("x-loading-ekingstar");  
                  
                var mask = $("<div></div>").css({//蒙版   
                    'position': 'absolute',  
                    'z-index': op.z+1,  
                    'width':'100%',  
                    'height':'100%',  
                    'background-color':'#333333',  
                    'top': '0px',  
                    'left': '0px',  
                    'opacity':op.opacity  
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

  //城市联动选择
  var  notJson = '[{\"cities\":[\"济南",\"青岛",\"淄博",\"枣庄",\"东营",\"烟台",\"潍坊",\"济宁",\"泰安",\"威海",\"日照",\"莱芜",\"临沂",\"德州",\"聊城",\"滨州",\"菏泽"],\"name\":\"山东"}, {\"cities\":[\"福州",\"厦门",\"莆田",\"三明",\"泉州",\"漳州",\"南平",\"龙岩",\"宁德"],\"name\":\"福建"}, {\"cities\":[\"台湾"],\"name\":\"台湾"}, {\"cities\":[\"石家庄",\"唐山",\"秦皇岛",\"邯郸",\"邢台",\"保定",\"张家口",\"承德",\"沧州",\"廊坊",\"衡水"],\"name\":\"河北"}, {\"cities\":[\"郑州",\"开封",\"洛阳",\"安阳",\"鹤壁",\"新乡",\"焦作",\"濮阳",\"许昌",\"漯河",\"三门峡",\"南阳",\"商丘",\"信阳",\"周口",\"驻马店"],\"name\":\"河南"}, {\"cities\":[\"重庆"],\"name\":\"重庆"}, {\"cities\":[\"武汉",\"黄石",\"十堰",\"宜昌",\"襄阳",\"鄂州",\"荆门",\"孝感",\"荆州",\"黄冈",\"咸宁",\"恩施",\"仙桃",\"潜江",\"天门",\"神农架"],\"name\":\"湖北"}, {\"cities\":[\"长沙",\"株洲",\"湘潭",\"衡阳",\"邵阳",\"岳阳",\"常德",\"张家界",\"益阳",\"郴州",\"永州",\"怀化",\"娄底",\"湘西"],\"name\":\"湖南"}, {\"cities\":[\"南昌",\"景德镇",\"萍乡",\"九江",\"新余",\"鹰潭",\"赣州",\"吉安",\"宜春",\"抚州",\"上饶"],\"name\":\"江西"}, {\"cities\":[\"海口",\"三亚",\"儋州"],\"name\":\"海南"}, {\"cities\":[\"哈尔滨",\"齐齐哈尔",\"鸡西",\"鹤岗",\"双鸭山",\"大庆",\"伊春",\"佳木斯",\"七台河",\"牡丹江",\"绥化",\"大兴安岭"],\"name\":\"黑龙江"}, {\"cities\":[\"天津"],\"name\":\"天津"}, {\"cities\":[\"贵阳",\"六盘水",\"遵义",\"安顺",\"毕节",\"铜仁",\"黔西南",\"黔东南",\"黔南"],\"name\":\"贵州"}, {\"cities\":[\"西安",\"铜川",\"宝鸡",\"咸阳",\"渭南",\"延安",\"汉中",\"榆林",\"安康",\"商洛"],\"name\":\"陕西"}, {\"cities\":[\"乌鲁木齐",\"克拉玛依",\"吐鲁番",\"哈密",\"昌吉",\"博尔塔拉",\"巴音郭楞",\"阿克苏",\"克孜勒苏",\"喀什",\"和田",\"伊犁",\"塔城",\"阿勒泰",\"石河子",\"阿拉尔",\"图木舒可",\"五家渠"],\"name\":\"新疆"}, {\"cities\":[\"澳门"],\"name\":\"澳门"}, {\"cities\":[\"南京",\"无锡",\"徐州",\"常州",\"苏州",\"南通",\"连云港",\"淮安",\"盐城",\"扬州",\"镇江",\"泰州",\"宿迁"],\"name\":\"江苏"}, {\"cities\":[\"合肥",\"芜湖",\"蚌埠",\"淮南",\"马鞍山",\"淮北",\"铜陵",\"安庆",\"黄山",\"滁州",\"阜阳",\"宿州",\"六安",\"池州",\"宣城"],\"name\":\"安徽"}, {\"cities\":[\"拉萨",\"日喀则",\"昌都",\"林芝",\"山南",\"那曲",\"阿里"],\"name\":\"西藏"}, {\"cities\":[\"长春",\"吉林",\"四平",\"辽源",\"通化",\"白山",\"松原",\"白城",\"延边"],\"name\":\"吉林"}, {\"cities\":[\"上海"],\"name\":\"上海"}, {\"cities\":[\"太原",\"大同",\"阳泉",\"长治",\"晋城",\"朔州",\"晋中",\"运城",\"忻州",\"临汾",\"吕梁"],\"name\":\"山西"}, {\"cities\":[\"兰州",\"嘉峪关",\"金昌",\"白银",\"天水",\"武威",\"张掖",\"平凉",\"酒泉",\"庆阳",\"定西",\"陇南",\"临夏",\"甘南"],\"name\":\"甘肃"}, {\"cities\":[\"银川",\"石嘴山",\"吴忠",\"固原",\"中卫"],\"name\":\"宁夏"}, {\"cities\":[\"香港"],\"name\":\"香港"}, {\"cities\":[\"成都",\"自贡",\"攀枝花",\"泸州",\"德阳",\"绵阳",\"广元",\"遂宁",\"内江",\"乐山",\"南充",\"眉山",\"宜宾",\"广安",\"达州",\"雅安",\"巴中",\"资阳",\"阿坝",\"甘孜",\"凉山"],\"name\":\"四川"}, {\"cities\":[\"杭州",\"宁波",\"温州",\"嘉兴",\"湖州",\"绍兴",\"金华",\"衢州",\"舟山",\"台州",\"丽水"],\"name\":\"浙江"}, {\"cities\":[\"南宁",\"柳州",\"桂林",\"梧州",\"北海",\"钦州",\"贵港",\"玉林",\"百色",\"贺州",\"河池",\"来宾",\"崇左"],\"name\":\"广西"}, {\"cities\":[\"昆明",\"曲靖",\"玉溪",\"保山",\"昭通",\"丽江",\"普洱",\"临沧",\"楚雄",\"红河",\"文山",\"西双版纳",\"大理",\"德宏",\"怒江",\"迪庆"],\"name\":\"云南"}, {\"cities\":[\"呼和浩特",\"包头",\"乌海",\"赤峰",\"通辽",\"鄂尔多斯",\"呼伦贝尔",\"巴彦淖尔",\"乌兰察布",\"兴安盟",\"锡林郭勒盟",\"阿拉善盟"],\"name\":\"内蒙古"}, {\"cities\":[\"沈阳",\"大连",\"鞍山",\"抚顺",\"本溪",\"丹东",\"锦州",\"营口",\"阜新",\"辽阳",\"盘锦",\"铁岭",\"朝阳",\"葫芦岛"],\"name\":\"辽宁"}, {\"cities\":[\"广州",\"韶关",\"深圳",\"珠海",\"汕头",\"佛山",\"江门",\"湛江",\"茂名",\"肇庆",\"惠州",\"梅州",\"汕尾",\"河源",\"阳江",\"清远",\"东莞",\"潮州",\"揭阳",\"云浮"],\"name\":\"广东"}, {\"cities\":[\"西宁",\"海东",\"海北",\"黄南",\"海南",\"果洛",\"玉树",\"海西"],\"name\":\"青海"}, {\"cities\":[\"北京"],\"name\":\"北京"}]';
    var provinceList = $.parseJSON(notJson);
    var provinces = new Object();
    var html = "";
    for(var i=0;i<provinceList.length;i++){
        var item = provinceList[i];
        provinces[item.name] = item;
        html+= "<option value='"+item.name+"'>"+item.name+"</option>";
    }
    $("#province").append(html);

    $(function () {
        $("#province").change(function () {
            var code = $(this).val();
            var province = provinces[code];
            var cities = province.cities;
            var  html ="";
            for (var j=0;j<cities.length;j++){
                html+="<option value='"+cities[j]+"'>"+cities[j]+"</option>"
            }
            $("#city").html(html);
        })
    })
