angular.module('smartWebApp')
    .directive('register', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl: 'ng/directives/register/register.tmpl.html',
            controller: function($scope, $state, $window, $location) {

            // variable declaration

             $scope.cityLists = [];
             $scope.selectedCity = "";



                $scope.getCity = function(){
                    $scope.cityLists =[
                    {id:1,label:"bangalore"},
                    {id:2,label:"Mangaloe"},
                    {id:3,label:"Delhi"},
                    {id:4,label:"Mumbai"}
                    ];

                };

                $scope.getCity();



            		

								
          
            }

        };
    }]);