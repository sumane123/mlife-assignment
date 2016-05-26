(function() {
    
    var app = angular.module('dashBoardApp', ['ngRoute','ngAnimate','jkuri.datepicker']);
    
    app.config(function($routeProvider) {
        $routeProvider
            .when('/', {
                controller: 'dashBoardController',
                templateUrl: 'app/views/dashBoard.html'
            })
           
            .otherwise( { redirectTo: '/' } );
    });
    
}());