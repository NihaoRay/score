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


