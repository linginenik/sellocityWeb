tracker.controller('SalesPlayUploadController', ['$scope','$location','$window', '$state','SalesPlayService',
     function($scope,$location, $window, $state,SalesPlayService) {

	   $scope.paintPoints = SalesPlayService.getProductList();
	   
		$scope.errors = [];
		   $scope.tabs = [{
	            title: 'One',
	            url: 'resources/partials/sales-play-tab3.html'
	        }, {
	            title: 'Two',
	            url: 'two.tpl.html'
	        }, {
	            title: 'Three',
	            url: 'three.tpl.html'
	    }];


	    $scope.currentTab = 'resources/partials/sales-play-tab3.html';

	    $scope.onClickTab = function (tab) {
	        $scope.currentTab = tab.url;
	    }
	    
	    $scope.isActiveTab = function(tabUrl) {
	        return tabUrl == $scope.currentTab;
	    }		
		

		$scope.addSalesPlay = function(customerInfo){
			var clientLogo = $scope.clientLogo;
			$scope.savingIndicator = true;
			SalesPlayService.addSalesPlay(customerInfo,clientLogo).then(
					function(response) {
						$scope.savingIndicator = false;
						$scope.errors = response.errors;
						if ($scope.errors.length == 0) {
							$scope.salesPlay = response.data;
							$scope.paintPoints = $scope.salesPlay.salesPlayMapping;
							
							$state.transitionTo("tab2");
						}
					});
			};
		
		}
   	]);