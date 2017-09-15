/**
 * 
 */
(function($) {
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
})(jQuery);