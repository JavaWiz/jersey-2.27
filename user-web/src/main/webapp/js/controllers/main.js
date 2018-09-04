angular.module('todoController', [])

	// inject the Todo service factory into our controller
	.controller('mainController', function($scope, $http, $timeout, Todos) {
		$scope.user = {};
		$scope.loading = true;
		$scope.todos = Todos.todos;
		$scope.checkedTodos = [];
		
		// Toggle selection for a given fruit by name
		  $scope.toggleSelection = function toggleSelection(id) {
		    var idx = $scope.checkedTodos.indexOf(id);

		    // Is currently selected
		    if (idx > -1) {
		      $scope.checkedTodos.splice(idx, 1);
		    } 
		    // Is newly selected
		    else {
		      $scope.checkedTodos.push(id);
		    }
		  };
		// GET =====================================================================
		// when landing on the page, get all todos and show them
		// use the service to get all the todos
		Todos.get()
			.success(function(data) {
				console.log("List o Id :"+data);
				$scope.todos=data;
				$scope.loading = false;
			});

		// CREATE ==================================================================
		// when submitting the add form, send the text to the node API
		$scope.createTodo = function() {

			// validate the formData to make sure that something is there
			// if form is empty, nothing will happen
			if ($scope.user.id != undefined && $scope.user.name != undefined && $scope.user.profession != undefined) {
				$scope.loading = true;
				
				// call the create function from our service (returns a promise object)
				Todos.create($scope.user)
					// if successful creation, call our get function to get all the new todos
					.success(function(data) {
						$scope.user = {}; // clear the form so our user is ready to enter another
						$scope.getUserList();
					});
			}
		};

		// DELETE ==================================================================
		// delete a todo after checking it
		$scope.deleteTodo = function(id) {
			$scope.loading = true;
			console.log(id);
			Todos.delete(id)
				// if successful creation, call our get function to get all the new todos
				.success(function(data) {
					$scope.getUserList(); 
					$scope.loading = false;
				});
		};
		
		$scope.deleteTodos = function() {
			$scope.loading = true;
			console.log("List o Id :"+$scope.checkedTodos);
			angular.forEach($scope.checkedTodos, function(value, key){
			    console.log("value : "+value);
			    Todos.delete(value)
				.success(function(data) {
					$scope.getUserList();
				});
			});
		};
		
		$scope.getUserList=function(){
			$scope.loading = true;
			Todos.get()
			.success(function(data) {
				$scope.todos = data;
				$scope.checkedTodos = [];
				$scope.loading = false;
			});
		}
		
	});