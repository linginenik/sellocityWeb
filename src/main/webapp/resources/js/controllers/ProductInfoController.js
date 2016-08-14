tracker.controller('ProductInfoController', ['$scope','$location','$window', '$state','SalesPlayService',
     function($scope,$location, $window, $state,SalesPlayService) {
	 
	   $scope.paintPoints;
		$scope.errors = [];
		
		$scope.salesPlay =SalesPlayService.getSalesPlayData();
		console.log("sales Map"+$scope.salesPlay.salesPlayMapping);
		$scope.paintPoints = $scope.salesPlay.salesPlayMapping;
		
	    $scope.addProductInfo = function(customerInfo){
	    	console.log("data"+customerInfo.pain0)
	    	console.log("data 1"+customerInfo.pain1)
			$scope.savingIndicator = true;
			SalesPlayService.addPaintPoints(customerInfo,$scope.salesPlay.spId).then(
					function(response) {
						$scope.savingIndicator = false;
						$scope.errors = response.errors;
						if ($scope.errors.length == 0) {
							$scope.paintPoints = response.data;
							
							$state.transitionTo("tab2");
						}
					});
			};
			$scope.previousAction = function(){
				$state.transitionTo("addsalesplay");
			};
		}
   	]);