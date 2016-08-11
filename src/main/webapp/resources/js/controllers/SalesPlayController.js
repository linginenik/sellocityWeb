tracker.controller('SalesPlayController', ['$scope','$location','$window', '$state','SalesPlayService',
     function($scope,$location, $window, $state,SalesPlayService) {
	  $scope.salesPlay;
	   $scope.paintPoints;
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
		
//
//		$scope.statusNames = new Array("New", "Closed", "Open");
//		$scope.statusTypes = IncidentSearchService.loadStatus();
//		$scope.formatIncidentNo = function(incident) {
//			if(incident) {
//				$scope.incident = incident;
//	  			return incident.incidentNo;	
//			}
////			}else{
////				return $scope.incident.incidentNo;
////			}
//		};  
//		$scope.changeEntityId = function(entity){
//			console.log(entity.incidentNo);
//			$scope.incident= entity;
//  		}; 		
//		
//		$scope.changeIncidentNo = function(selectedItem){
//			$scope.incident.incidentNo = selectedItem.incidentNo;
//		};
//		$scope.cancel = function(){
//			$state.transitionTo("incidentsearch");
//		}
		$scope.addSalesPlay = function(customerInfo){
			if(! (customerInfo.painPoint1 || customerInfo.painPoint2 || customerInfo.painPoint3 || customerInfo.painPoint4 ) ){
				alert("Pl enter one pain point");
				return;
			}
			var clientLogo = $scope.clientLogo;
			$scope.savingIndicator = true;
			SalesPlayService.addSalesPlay(customerInfo,clientLogo).then(
					function(response) {
						$scope.savingIndicator = false;
						$scope.errors = response.errors;
						if ($scope.errors.length == 0) {
							$scope.salesPlay = response.data;
							$scope.paintPoints = $scope.salesPlay.salesPlayMapping;
							SalesPlayService.setProductList($scope.paintPoints);
							$state.transitionTo("tab2");
						}
					});
			};
		
		}
   	]);