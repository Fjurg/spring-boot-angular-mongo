
angular.module( 'customerStorage.customer', [
  'ui.router',
  'ngResource'
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

    .controller( 'CustomerStorageCtrl', function CustomerStorageCtrl( $scope, $http ) {

        $http.get('http://localhost:8080/api/list').then(function (response) {
            console.log('Success', response);
            $scope.resp = response;
            // For JSON responses, response.data contains the result
        }, function(err) {
            console.error('ERR', err);
            // err.status will contain the status code
        });

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

    /*
.controller( 'CustomerStorageCtrl', function CustomerStorageCtrl( $scope ) {

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
     */

