angular.module('app', ['ngResource'])
    .controller('UserController', function ($resource) {
        var vm = this;
        var User = $resource('api/users');

        function refreshData() {
            vm.users = User.query(function success(data, headers) {
                    console.log('Pobrano dane: ' + data);
                    console.log(headers('Content-Type'));
                },
                function error(response) {
                    console.log(response.status);
                });
        }

        refreshData();
    });