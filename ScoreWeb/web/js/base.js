

window.XCZBaseData = function () {
    return {

        //服务端获取数据
        loadAjaxBaseData: function () {
            this.ajaxCityListData();
        },

        //页面加载数据
        initBaseData: function () {
            //加载城市列表
            this.loadProvinceDataList();
            $("select[name='province']").change(function () {
                var province = $(this).val();
                var c = $(this).parents("form").find("#city");
                XCZBaseData.loadCityCodeList(province, c);
            })

        },

        //设置省份城市数据
        setProvinceCityData: function (data, provinceElement, cityElement) {
            if (!XCZCommon.isUndefinedOrEmpty(provinceElement)) {
                //this.loadProvinceDataList();
                provinceElement.val(data.province);
            }
            if (!XCZCommon.isUndefinedOrEmpty(provinceElement) && !XCZCommon.isUndefinedOrEmpty(cityElement)) {
                this.loadCityCodeList(data.province, cityElement);
                cityElement.val(data.city);
            }
        },

        loadCorpListData: function () {
            var s = $("select[name='corpId']");
            if (XCZCommon.isUndefinedOrNull(s)) {
                return;
            }
            s.empty();//清除select中的 option
            var data = top.user.corpList;
            if (top.user.permissionType != 2) {
                s.append('<option value="">全选</option>');
            }
            for (var i = 0; i < data.length; i++) {
                s.append('<option value="' + data[i].corpId + '">' + data[i].corpName + '</option>');
            }
        },

        ajaxLoadCorpData: function () {
            var params_array = [];
            var params = XCZCommon.getParams(params_array, "/api/management/admin/support/corp/list");
            XCZCommon.ajax({
                params: params,
                "async": false,
                "success": function (res) {
                    if (XCZCommon.isSuccess(res)) {
                        user.corpList = res.data;
                    }
                }
            })
        },

        loadSupplierListData: function () {
            var s = $("#supplierId");
            if (XCZCommon.isUndefinedOrNull(s)) {
                return;
            }
            s.empty();//清除select中的 option
            var data = top.user.supplierList;
            if (top.user.permissionType != 3) {
                s.append('<option value="">全选</option>');
            }
            for (var i = 0; i < data.length; i++) {
                s.append('<option value="' + data[i].supplierId + '">' + data[i].supplierName + '</option>');
            }
        },

        ajaxLoadSupplierListData: function () {
            var params_array = [];
            var params = XCZCommon.getParams(params_array, "/api/management/admin/support/supplier/list");
            XCZCommon.ajax({
                params: params,
                "async": false,
                "success": function (res) {
                    if (XCZCommon.isSuccess(res)) {
                        user.supplierList = res.data;
                    }
                }
            })
        },

        ajaxCityListData: function () {
            var params = XCZCommon.getParams([], "/api/management/enterprise/city/query");
            XCZCommon.ajax({
                params: params,
                "success": function (res) {
                    if (XCZCommon.isSuccess(res)) {
                        XCZBaseData.paserCityCodeData(res.data);
                    }
                }
            })
        },

        paserCityCodeData: function (list) {
            var provinceCodeList = {}
            for (var i = 0; i < list.length; i++) {
                var view = list[i];
                if (view.parentCode == 0) {
                    var province = {name: view.alias, citys: [], code: view.code};
                    provinceCodeList[view.code] = view.alias;
                    provinceList[view.alias] = province;
                }
                if (view.parentCode != 0) {
                    var city = {name: view.alias, code: view.code, parentCode: view.parentCode};
                    var provinceAlias = provinceCodeList[view.parentCode];
                    var pro = provinceList[provinceAlias];
                    if (!XCZCommon.isUndefinedOrNull(pro)) {
                        pro.citys.push(city);
                    }
                }
            }
        },

        getCityListByProvince: function (provinceCode) {
            return top.provinceList[provinceCode];
        },

        loadProvinceDataList: function () {
            var s = $("select[name='province']");
            if (XCZCommon.isUndefinedOrNull(s)) {
                return;
            }

            for (var j = 0; j < s.length; j++) {
                var sel = s[j];
                $(sel).empty();
                var pros = provinceList;
                if (XCZCommon.isUndefinedOrEmpty(pros)) {
                    $(sel).append('<option value="">全部</option>');
                } else {
                    $(sel).append('<option value="">全部</option>');
                    for (var i in pros) {
                        $(sel).append('<option value="' + pros[i].name + '">' + pros[i].name + '</option>');
                    }
                }
            }
        },
        loadCityCodeList: function (provinceCode, c) {
            if (XCZCommon.isUndefinedOrNull(c)) {
                return;
            }
            c.empty();
            if (XCZCommon.isUndefinedOrEmpty(provinceCode) || XCZCommon.isUndefinedOrEmpty(this.getCityListByProvince(provinceCode))) {
                c.append('<option value="">全部</option>');
            } else {
                var data = this.getCityListByProvince(provinceCode).citys;
                c.append('<option value="">全部</option>');
                for (var i = 0; i < data.length; i++) {
                    c.append('<option data-code="' + data[i].code + '" value="' + data[i].name + '">' + data[i].name + '</option>');
                }
            }

        },

    }
}();
