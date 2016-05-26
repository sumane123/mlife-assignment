(function() {

	var dashBoardController = function($scope, $log, hitCountFactory) {
		$scope.sortBy = 'visits';
		$scope.reverse = true;
		$scope.date1 = "2013-01-06";

		function init() {

			function formatDate(date) {
				var d = new Date(date), month = '' + (d.getMonth() + 1), day = ''
						+ d.getDate(), year = d.getFullYear();

				if (month.length < 2)
					month = '0' + month;
				if (day.length < 2)
					day = '0' + day;

				return [ year, month, day ].join('-');
			}

			var myDate = formatDate($scope.date1);
			console.log(myDate);
			var parameters = {
				date : myDate,
				limit : 5
			};
			var config = {
				params : parameters
			};

			hitCountFactory.getHitCount(config).then(function(response) {
				$scope.hitCount = response.data.result;
			}, function(data, status, headers, config) {
				$log.log(data.error + ' ' + status);
			});
		}

		init();

		$scope.getWebstat = function(date2) {

			function formatDate(date) {
				var d = new Date(date), month = '' + (d.getMonth() + 1), day = ''
						+ d.getDate(), year = d.getFullYear();

				if (month.length < 2)
					month = '0' + month;
				if (day.length < 2)
					day = '0' + day;

				return [ year, month, day ].join('-');
			}

			var myDate = formatDate(date2);
			console.log(myDate);
			var parameters = {
				date : myDate,
				limit : 5
			};
			var config = {
				params : parameters
			};

			hitCountFactory.getHitCount(config).then(function(response) {
				$scope.hitCount = response.data.result;
			}, function(data, status, headers, config) {
				$log.log(data.error + ' ' + status);
			});

		}

		$scope.doSort = function(propName) {
			$scope.sortBy = propName;
			$scope.reverse = !$scope.reverse;
		};
	};

	dashBoardController.$inject = [ '$scope', '$log', 'hitCountFactory' ];

	angular.module('dashBoardApp').controller('dashBoardController',
			dashBoardController);

}());