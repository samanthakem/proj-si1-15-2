caronaeApp.directive("topNavbar", function() {
	return {
		restrict: "E",
		replace: true,
		templateUrl: "views/topNavbar.html",
		controller: "SidebarCtrl"
	}
});