angular.module('app', ['ngResource'])
    .controller('UserController', function ($http, $resource) {
        var vm = this;
        var User = $resource('api/users/:userId');
        vm.user = new User();

        function refreshData() {
            vm.users = User.query(
                function success(data, headers) {
                    console.log('Pobrano dane: ' + data);
                    console.log(headers('Content-Type'));
                },
                function error(response) {
                    console.log(response.status);
                });
        }

        vm.addUser = function (user) {
            console.log(vm.user.__proto__);
            vm.user.$save(function (data) {
                refreshData();
                vm.user = new User();
            });
        }

        vm.loadData = function (id) {
            vm.details = User.get({userId: id});
        }
        refreshData();
    });