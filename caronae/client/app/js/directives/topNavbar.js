caronaeApp.directive("topNavbar", function() {
	return {
		restrict: "E",
		replace: true,
		templateUrl: "views/directives/topNavbar.html",
		controller: "SidebarCtrl"
	}
});
