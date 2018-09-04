var config = {headers:  {
        /*'Authorization': 'Basic d2VudHdvcnRobWFuOkNoYW5nZV9tZQ==',*/
        'Accept': 'application/json;odata=verbose',
        "X-Testing" : "testing"
    }
};

angular.module('todoService', [])

	// super simple service
	// each function returns a promise object 
	.factory('Todos', ['$http',function($http) {
		return {
			get : function() {
				return $http.get('/user-web/api/UserService/users', config);
			},
			create : function(todoData) {
				return $http({
			          method  : 'POST',
			          url     : '/user-web/api/UserService/users',
			          data    : todoData
			         });
			},
			delete : function(id) {
				return $http.delete('/user-web/api/UserService/users/' + id, config);
			}
		}
	}]);