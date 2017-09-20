window.XCZCommon = function () {
    return {
        ajax: function (options) {
            $.ajax({
                "type": "POST",
                "url": "/web/dispatch/proxy",
                "contentType": "application/x-www-form-urlencoded;charset=UTF-8",
                "async": this.isUndefinedOrNull(options.async) ? true : options.async,
                "dataType": "json",
                "data": options.params,
                "success": function (data, textStatus, xhr) {
                    if ($.isFunction(options.success)) {
                        options.success(data, textStatus, xhr);
                    }
                },
                "error": function (xhr, textStatus, errorThrown) {
                    if ($.isFunction(options.error)) {
                        options.error(xhr, textStatus, errorThrown);
                    }
                }
            });
        },
        isSuccess: function (res) {
            return res.retCode == 1;
        },
        getParams: function (array, method, methodType, pageNum) {
            array.push({name: "method", value: method});
            if (!this.isUndefinedOrNull(methodType)) {
                array.push({name: "methodType", value: "page"});
                if (this.isUndefinedOrNull(pageNum)) {
                    pageNum = 1;
                }
                array.push({name: "pageNum", value: pageNum});
            }
            return jQuery.param(array);
        },
        getPageNum: function (array, pageSize) {
            if (this.isUndefinedOrNull(pageSize)) {
                pageSize = 10;
            }
            var startIndex = 0;
            for (var i in array) {
                if (array[i].name == 'start' || array[i].name == 'iDisplayStart') {
                    startIndex = array[i].value;
                }
                if (array[i].name == 'length' || array[i].name == 'iDisplayLength') {
                    pageSize = array[i].value;
                }
            }
            var pageNum = startIndex / pageSize;
            pageNum += 1;
            return pageNum;
        },
        isUndefinedOrNull: function (object) {
            if (object == null || object == "undefined") {
                return true;
            }
            return false;
        },
        isUndefinedOrEmpty: function (object) {
            if (object == null || object == "undefined" || object == "") {
                return true;
            }
            return false;
        },
        //==== 页面跳转 ===
        //设置Cookie
        setCookie: function (cookieName, cookieValue,time) {
            var d = new Date();
            d.setTime(d.getTime() + (1 * 24 * 60 * 60 * 1000));
            if (!XCZCommon.isUndefinedOrEmpty(time)){
                d.setTime(d.getTime() + time);
            }
            var expires = "expires=" + d.toUTCString();
            document.cookie = cookieName + "=" + cookieValue + "; " + expires;
        },
        //清除Cookie
        //===== 数据格式化 ====
        getProvinceBycode: function (code) {
            var list = top.provinceList;
            var province = list[code];
            if (XCZCommon.isUndefinedOrNull(province)) {
                return "";
            }
            return province;
        },
        getCityBycode: function (parentCode, code) {
            var list = top.provinceList;
            var province = list[parentCode];
            if (XCZCommon.isUndefinedOrNull(province)) {
                return "";
            }
            var citys = province.citys;
            for (var city in citys) {
                if (city.code == code) {
                    return city.name;
                }
            }
        },
}
}();



