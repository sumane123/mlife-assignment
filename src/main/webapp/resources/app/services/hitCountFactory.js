(function() {
	var hitCountFactory = function($http) {

		var factory = {};

		factory.getHitCount = function(config) {
			console.log(config);
			return $http.get('/Analytics/rest/v1/websites', config)
		};

		return factory;
	};

	hitCountFactory.$inject = [ '$http' ];

	angular.module('dashBoardApp').factory('hitCountFactory', hitCountFactory);

}());