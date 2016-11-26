/*jshint sub:true*/
' use strict';
angular.module("smartWebApp").controller("uploadCtrl", function($scope, $state, $window,$document, Upload, $location, toaster, $timeout, $http) {
	("Inside upload Controller");
	
	$scope.uploadObject = {};
	
	$scope.uploadList = [];
	 $scope.chooseItems = {
	          "TrainDetails": "TrainDetails",
	          "TrainStation": "TrainStation",

	        }
	 
	 $scope.checkFileType = function (files) {
         $scope.Iserror = false;
         var fileExtension = files[0].name.split('.')[files[0].name.split('.').length - 1].toLowerCase();
         if (fileExtension !== "csv") {
           alert("Please choose csv Type files ");
           $scope.Iserror = true;
         } else {
           $scope.Iserror = false;
         }
       };
       
       $scope.processUpload = function (file) {
           var fileName = file.name;
           var fileExtension = fileName.split('.')[fileName.split('.').length - 1].toLowerCase();
           
           ("train stat"+$scope.uploadObject.traindetails);

           Upload.upload({
             url: apiUploadUrl + "/"+"createUpload",
             data: { Uploadfile: file, 
            	 	 name: 'file', 
            	 	 dataType: $scope.uploadObject.chooseItems, 
            	 	 fileType: fileExtension, 
            	 	 username: "SANTOSH", 
            	 	 description: $scope.uploadObject.description, 
            	 	 status: $scope.uploadObject.description 
            	 	}
           }).progress(function (evt) {
            
             $scope.progressBar = parseInt(100.0 * evt.loaded / evt.total);
           }).success(function (data, status, headers, config) {
             $scope.uploadList.push(data);
             toaster
               .pop({
                 type: 'success',
                 title: 'Upload '+$scope.uploadObject.chooseItems+' Succcessfully!!!!',
                 body: 'Upload '+$scope.uploadObject.chooseItems+' Succcessfully!!!!',
               });

             ('upload succesfully...')
           }).error(function (err) {
             (err.stack);
           })


        //   (file);
         };

         $scope.saveUpload = function () {
           if ($scope.form.Uploadfile.$valid && $scope.Uploadfile) {
             $scope.processUpload($scope.Uploadfile);
           }

         }
         
         $scope.countChar = function (val) {

             var max = 500;
             // var len = val.value.length;
             var len = $scope.uploadObject.description.length;
             if (len >= max) {

               document.getElementById("charNum").innerHTML = " you have reached the limit";
             } else {
               var char = max - len;
               document.getElementById("charNum").innerHTML = char + " characters left";
               //angular.element(document.querySelector('[id="charNum"]'));
             }


           }
	       
 
});
