/**
 * @author chenrui
 * @date 2017-11-03
 * @description js组件
 */

/*获取url中的param参数*/
function getUrlParam(param){
    var reg = new RegExp("(^|&)" + param + "=([^&]*)(&|$)");
    var regGet = window.location.search.substr(1).match(reg);
    if(regGet != null && regGet[2].toString().length > 0){
        return decodeURI(regGet[2]);
    }
}

/**时间格式化，将时间戳改成相应的时间*/
function formatDate(time, format) {
    if (time == null) {
        return "";
    }
    if (format == null) {
        format = "yyyy-MM-dd hh:mm:ss";
    }

    Date.prototype.format = function (format) {
        var o = {
            "M+": this.getMonth() + 1,
            // month
            "d+": this.getDate(),
            // day
            "h+": this.getHours(),
            // hour
            "m+": this.getMinutes(),
            // minute
            "s+": this.getSeconds(),
            // second
            "q+": Math.floor((this.getMonth() + 3) / 3),
            // quarter
            "S": this.getMilliseconds()
            // millisecond
        };
        if (/(y+)/.test(format) || /(Y+)/.test(format)) {
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        }
        for (var k in o) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
            }
        }
        return format;
    };
    return (new Date(time)).format(format);
}
