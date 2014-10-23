
// Definindo um novo módulo para nossa aplicação
var homeApp = angular.module ("homeApp", []);

homeApp.controller('HomeController', function($scope) {
  $scope.moversUp = [
    {
      name: 'Coca Cola',
      index: '3.5',
    },
    {
      name: 'Microsoft',
      index: '2.8',
    },
    {
      name: 'Google',
      index: '2.0',
    }
  ]; 

  $scope.moversDown = [
    {
      name: 'Go Pro',
      index: '-3.5',
    },
    {
      name: 'Yahoo',
      index: '-2.4',
    },
    {
      name: 'Euro',
      index: '-1.80',
    }
  ];

  $scope.mostDownloaded = [
    {
      name: 'Go Pro',
      index: '-3.5',
    },
    {
      name: 'Yahoo',
      index: '-2.4',
    },
    {
      name: 'Euro',
      index: '-1.80',
    }
  ];
});




