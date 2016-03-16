
angular.module( 'customerStorage.customer', [
  'ui.router'
])

.config(function config( $stateProvider ) {
  $stateProvider.state( 'customer-storage', {
    url: '/customer',
    views: {
      "main": {
        controller: 'CustomerStorageCtrl',
        templateUrl: 'customer-storage/customer-storage.tpl.html'
      }
    },
    data:{ pageTitle: 'Store Customer' }
  });
})

.controller( 'CustomerStorageCtrl', function HomeController( $scope ) {

      $scope.sortType = 'name';
      $scope.sortReverse = false;
      $scope.searchFish = '';

      $scope.sushi = [
        { name: 'Cali Roll', fish: 'Crab', tastiness: 2 },
        { name: 'Philly', fish: 'Tuna', tastiness: 4 },
        { name: 'Tiger', fish: 'Eel', tastiness: 7 },
        { name: 'Rainbow', fish: 'Variety', tastiness: 6},
        { name: 'Tuna Roll', fish: 'Tuna', tastiness: 9}
      ];

});

