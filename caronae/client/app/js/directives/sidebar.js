caronaeApp.directive("sidebar", function() {
	return {
		restrict: "E",
		replace: true,
		templateUrl: "views/directives/sidebar.html",
		controller: "SidebarCtrl"
	}
});
