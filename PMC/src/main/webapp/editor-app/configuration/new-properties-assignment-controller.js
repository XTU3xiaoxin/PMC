/*
 * Activiti Modeler component part of the Activiti project
 * Copyright 2005-2014 Alfresco Software, Ltd. All rights reserved.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

/*
 * Assignment
 */
var NewKisBpmAssignmentCtrl = [ '$scope', '$modal', function($scope, $modal) {

    // Config for the modal window
    var opts = {
        template:  'editor-app/configuration/properties/new-assignment-popup.html?version=' + Date.now(),
        scope: $scope
    };
    // Open the dialog
    $modal(opts);
}];

var NewKisBpmAssignmentReadCtrl = [ '$scope', '$modal', function($scope, $modal) {
	if ($scope.property.value &&  $scope.property.value != '') {
		if (typeof $scope.property.value == 'string') {
			$scope.value = JSON.parse($scope.property.value);
		} else {
			$scope.value = $scope.property.value;
		}
		$scope.read = $scope.value.assignment2;
	}
}];

var NewKisBpmAssignmentPopupCtrl = [ '$scope', '$http', '$modal', function($scope, $http, $modal) {
	debugger;
	if ($scope.property.value && $scope.property.value != '') {
		if (typeof $scope.property.value == 'string') {
			$scope.value = JSON.parse($scope.property.value);
		} else {
			$scope.value = $scope.property.value;
		}
	} else {
		$scope.value = {};
	}
	
	if ($scope.value.assignment2) {
        $scope.assignment = $scope.value.assignment2;
    } else {
        $scope.assignment = {};
    }
    
    if (!$scope.assignment.showStatus) {
    	$scope.assignment.showStatus = '';
    }
    
    if (!$scope.assignment.filterStatus) {
    	$scope.assignment.filterStatus = '';
    }
    
    if ($scope.assignment.roleIds) {
    	$scope.roleIds = $scope.assignment.roleIds;
    	$scope.roleStr = '';
    	for (r in $scope.roleIds) {
    		$scope.roleStr += $scope.roleIds[r].name + '，';
    	}
    	$scope.roleStr = $scope.roleStr.substr(0, $scope.roleStr.length-1);
    }
    
    if ($scope.assignment.orgIds) {
    	$scope.orgIds = $scope.assignment.orgIds;
    	$scope.orgStr = '';
    	for (r in $scope.orgIds) {
    		$scope.orgStr += $scope.orgIds[r].name + '，';
    	}
    	$scope.orgStr = $scope.orgStr.substr(0, $scope.orgStr.length-1);
    }
    
    $scope.getRoleList = function() {
    	var opts = {
            template: 'editor-app/configuration/properties/rolelist.html?version=' + Date.now(),
            scope: $scope,
        };
        // Open the dialog
    	$modal(opts);
    }
    
    $scope.getOrgList = function() {
    	var opts = {
            template: 'editor-app/configuration/properties/orgTree.html?version=' + Date.now(),
            scope: $scope,
        };
        // Open the dialog
    	$modal(opts);
    }

    $scope.save = function() {
    	debugger;
        $scope.property.value = {};
        $scope.property.value.assignment = handleAssignmentInput();
        $scope.property.value.assignment2 = handleAssignmentInput();
        var flag = ($scope.property.value.assignment === $scope.property.value.assignment2);
        if($scope.property.value.assignment.roleIds){
        	var roleIds = [];
        	for(k in $scope.property.value.assignment.roleIds) {
        		roleIds.push(k);
        	}
        	$scope.property.value.assignment.roleIds = roleIds;
        }
        if($scope.property.value.assignment.orgIds){
        	var orgIds = [];
        	for(k in $scope.property.value.orgIds) {
        		orgIds.push(k);
        	}
        	$scope.property.value.assignment.orgIds = orgIds;
        }
        var value = JSON.stringify($scope.property.value);
        $scope.property.value = value;
        $scope.updatePropertyInModel($scope.property);
        $scope.close();
    };

    // Close button handler
    $scope.close = function() {
//    	handleAssignmentInput($scope);
    	$scope.property.mode = 'read';
    	$scope.$hide();
    };
    
    var handleAssignmentInput = function() {
    	var assignment = {};
    	var assignee = angular.element('[name=assignee]').val();
    	var showStatus = angular.element('[name=showStatus]').val();
    	var filterStatus = angular.element('[name=filterStatus]').val();
    	assignment.assignee = assignee;
    	assignment.showStatus = showStatus;
    	assignment.filterStatus = filterStatus;
    	assignment.roleIds = $scope.roleIds;
    	assignment.orgIds = $scope.orgIds;
    	return assignment;
    };
    
    $scope.$on('setRoles', function(d, data) {
    	$scope.roleIds = data;
    	var str = '';
    	if (JSON.stringify($scope.roleIds) != "{}"){
    		for (r in $scope.roleIds) {
    			str += $scope.roleIds[r].name + '，'
    		}
    		str = str.substr(0, str.length-1);
    	} else {
    		$scope.roleIds = null;
    	}
    	angular.element('#rolesShow').html(str);
    });
    
    $scope.$on('setOrgs', function(d, data) {
    	$scope.orgIds = data;
    	var str = '';
    	if (JSON.stringify($scope.orgIds) != "{}"){
    		for (r in $scope.orgIds) {
    			str += $scope.orgIds[r].name + '，'
    		}
    		str = str.substr(0, str.length-1);
    	} else {
    		$scope.orgIds = null;
    	}
    	angular.element('#orgsShow').html(str);
    });
}];
