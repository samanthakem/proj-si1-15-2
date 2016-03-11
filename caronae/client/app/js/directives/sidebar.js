caronaeApp.directive("sidebar", function() {
	return {
		restrict: "E",
		replace: true,
		templateUrl: "views/sidebar.html",
		controller: "SidebarCtrl"
	}
});