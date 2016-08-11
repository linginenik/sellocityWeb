tracker.factory("SalesPlayService", function($http,$filter){
	var productList;
	var service = {
		getResource : function() {
			return 'salesplay';
		},
		
		getHttp : function() {
			return $http;
		},
		setProductList : function (dataValues){
			this.productList=dataValues;
		},
		getProductList : function (){
			return this.productList;
		},		
		getBaseUrl : function() {
			return baseUrl;
		},
	    loadIncident : function(id) {
    		var url = baseUrl + 'incident/'+ id + '/?_=' + Math.random();
				return $http.get(url).then(this.successHandler, this.errorHandler);
	    },
	    
	    searchIncident : function(id) {
    		var url = baseUrl + 'searchIncident/'+ id + '/?_=' + Math.random();
				return $http.get(url).then(this.successHandler, this.errorHandler);
	    },		
	    addSalesPlay : function(salesPlayData,clientLogo){
	    	var fd = new FormData();
	        fd.append('file', clientLogo);
	        console.log("DATA.."+salesPlayData);
	        fd.append("data", JSON.stringify(salesPlayData));
	        
	    	var method = 'POST';
	    	var url = baseUrl + '/selloCityWeb/customer/salesplay';
	    	return $http.post(url, fd, {
	            transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
	        }).then(this.successHandler, this.errorHandler);		

		    },	    
	};
	return angular.extend(service, BaseService);
});