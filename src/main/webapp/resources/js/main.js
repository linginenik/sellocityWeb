var timepicker = angular.module('ui.timepicker', [])

.value('uiTimepickerConfig', {
    'step' : 15,
    'maxTime':'11:45 PM',
    'timeFormat': 'h:i A',
    'scrollDefaultTime': "12:00 AM"
});

var baseUrl =  '';
if(document.getElementById('baseUrl')){
 baseUrl = document.getElementById('baseUrl').value;
}

//var tracker = angular.module('tracker', ['ngRoute','ui.router','ui.bootstrap','ngCookies', 'ui.select2', ,'blueimp.fileupload','ui.timepicker','smart-table']);
var tracker = angular.module('tracker', ['ngRoute','ui.router','ui.bootstrap','ngCookies', 'ui.select2', ,'blueimp.fileupload','ui.timepicker']);
tracker.config(['$stateProvider','$routeProvider', '$provide','$httpProvider', function($stateProvider, $routeProvider, $provide, $httpProvider) {
	
	  //register the interceptor as a service
	  $provide.factory('myHttpInterceptor', function($q) {
			return {
		     'responseError': function(rejection) {
		    	if(rejection.status == 0){
		    		location.reload();
		    	}
		 	    return $q.reject(rejection);
		      }
		    };
	  	});
	  
	  $provide.factory('myHttpInterceptor', function($q) {
		  return function(promise) {
		    return promise.then(function(success) {
		      return success;
		    }, function(rejection) {
		    	if(rejection.status == 0){
		    		location.reload();
		    	}
		      return $q.reject(rejection);
		    });
		  };
		});
	  
	  $httpProvider.interceptors.push('myHttpInterceptor');
	  
$stateProvider
     .state('home', {
        url: "", // root route
        resolve: {
        	inputData: function ($state) {
        			return "";
        	}        	
        
        },     
        views: {
            "uiview": {
                templateUrl: 'resources/partials/sales-play-tab1.html',
                controller: 'SalesPlayController'
            }
        }
    })

    .state('tab2', {
        url: "/tab2", 
        
        views: {
            "uiview": {
                templateUrl: 'resources/partials/sales-play-tab2.html',
                controller: 'SalesPlayUploadController'
            }
        }
    }) 
    .state('successUpload', {
        url: "/uploadFile/success", 
        views: {
            "uiview": {
                templateUrl: 'resources/partials/upload-success.html',
                controller: 'UploadFileController'
            }
        }
    })     
    $stateProvider
    .state('newIncident', {
       url: "/incident", // root route
       views: {
           "uiview": {
               templateUrl: 'resources/partials/incident.html',
               controller: 'IncidentController'
           }
       }
    }) 
   $stateProvider
    .state('incidentsearch', {
       url: "/incidentsearch", // root route
       views: {
           "uiview": {
               templateUrl: 'resources/partials/incident-search-form.html',
               controller: 'IncidentSearchController'
           }
       }
    })    
    $stateProvider
    .state('incident', {
       url: "/incident/{id}", // root route
       resolve:{
       	inputData: function ($state) {
   			return $state.current.searchParams;
       	}, 
      loadedData:incidentResolver,
       },       
       views: {
           "uiview": {
               templateUrl: 'resources/partials/incident.html',
               controller: 'IncidentController'
           }
       }
    });
   }]);
var incidentResolver = ['$stateParams','IncidentService', function ($stateParams, IncidentService) {
	
	if($stateParams.id) {
		return IncidentService.loadIncident($stateParams.id); 
	} else {
		return {
			data:{},
			errors:[]
		};
	}											
	}];
