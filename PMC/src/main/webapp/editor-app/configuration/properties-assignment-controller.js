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
var KisBpmAssignmentCtrl = [ '$scope', '$modal', function($scope, $modal) {

    // Config for the modal window
    var opts = {
        template:  'editor-app/configuration/properties/assignment-popup.html?version=' + Date.now(),
        scope: $scope
    };
    // Open the dialog
    $modal(opts);
}];

var KisBpmAssignmentReadPopupCtrl = [ '$scope', '$modal', function($scope, $modal) {
	if ($scope.property.value && $scope.property.value.assignment2 && $scope.property.value.assignment2.candidateUsers &&  $scope.property.value.assignment2.candidateUsers[0].value) {
		if (typeof $scope.property.value.assignment2.candidateUsers[0].value === 'string') {
			$scope.read = JSON.parse($scope.property.value.assignment2.candidateUsers[0].value);
		} else {
			$scope.read = $scope.property.value.assignment2.candidateUsers[0].value;
		}
	}
}];

var KisBpmAssignmentPopupCtrl = [ '$scope', '$http', '$modal', function($scope, $http, $modal) {
	
	if ($scope.property.value && $scope.property.value.assignment2) {
        $scope.assignment = $scope.property.value.assignment2;
    } else {
        $scope.assignment = {};
    }
	
	if (!$scope.assignment.candidateUsers) {
		$scope.assignment.candidateUsers = [];
	}
	
	if(!$scope.assignment.candidateUsers[0]) {
		$scope.assignment.candidateUsers[0] = {};
	}
	
	if(!$scope.assignment.candidateUsers[0].$$hashKey) {
		$scope.assignment.candidateUsers[0].$$hashKey = "05A";
	}
	
	if(!$scope.assignment.candidateUsers[0].value) {
		$scope.assignment.candidateUsers[0].value = {};
	} else {
		if (typeof $scope.assignment.candidateUsers[0].value === 'string') {
			$scope.assignment.candidateUsers[0].value = JSON.parse($scope.assignment.candidateUsers[0].value);
		}
	}
    
    if (!$scope.assignment.candidateUsers[0].value.showStatus) {
    	$scope.assignment.candidateUsers[0].value.showStatus = '';
    }
    
    if (!$scope.assignment.candidateUsers[0].value.filterStatus) {
    	$scope.assignment.candidateUsers[0].value.filterStatus = '';
    }
    
    if ($scope.assignment.candidateUsers[0].value.roleIds) {
    	$scope.roleIds = $scope.assignment.candidateUsers[0].value.roleIds;
    	$scope.roleStr = '';
    	for (r in $scope.roleIds) {
    		$scope.roleStr += $scope.roleIds[r].name + '，';
    	}
    	$scope.roleStr = $scope.roleStr.substr(0, $scope.roleStr.length-1);
    }
    
    if ($scope.assignment.candidateUsers[0].value.orgIds) {
    	$scope.orgIds = $scope.assignment.candidateUsers[0].value.orgIds;
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
        if($scope.property.value.assignment.candidateUsers[0].value.roleIds){
        	var roleIds = [];
        	for(k in $scope.property.value.assignment.candidateUsers[0].value.roleIds) {
        		roleIds.push(k);
        	}
        	$scope.property.value.assignment.candidateUsers[0].value.roleIds = roleIds;
        }
        if($scope.property.value.assignment.candidateUsers[0].value.orgIds){
        	var orgIds = [];
        	for(k in $scope.property.value.assignment.candidateUsers[0].value.orgIds) {
        		orgIds.push(k);
        	}
        	$scope.property.value.assignment.candidateUsers[0].value.orgIds = orgIds;
        }
        var value = JSON.stringify($scope.property.value.assignment.candidateUsers[0].value);
        value = value.replace(/\\/ig , '');
        $scope.property.value.assignment.candidateUsers[0].value = value;
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
    	assignment.candidateUsers = [];
    	assignment.candidateUsers[0] = {};
    	assignment.candidateUsers[0].$$hashKey = "05A";
    	assignment.candidateUsers[0].value = {};
    	var assignee = angular.element('[name=assignee]').val();
    	var showStatus = angular.element('[name=showStatus]').val();
    	var filterStatus = angular.element('[name=filterStatus]').val();
    	assignment.assignee = assignee;
    	assignment.candidateUsers[0].value.showStatus = showStatus;
    	assignment.candidateUsers[0].value.filterStatus = filterStatus;
    	assignment.candidateUsers[0].value.roleIds = $scope.roleIds;
    	assignment.candidateUsers[0].value.orgIds = $scope.orgIds;
    	return assignment;
    };
    
    $scope.$on('setRoles', function(d, data) {
    	$scope.roleIds = data;
    	var str = '';
    	console.log("================="+JSON.stringify($scope.roleIds));
    	if (JSON.stringify($scope.roleIds) != "{}"){
    		for (r in $scope.roleIds) {
    			str += $scope.roleIds[r].name + '，'
    		}
    		str = str.substr(0, str.length-1);
    	} else {
    		$scope.roleIds = null;
    	}
    	console.log("=================str"+str);
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

var KisBpmRolesPopupCtrl = [ '$scope', '$http', '$modal', function($scope, $http, $modal){

	$http({
        method: 'post',
        dataType: 'json',
        url: 'new/flow/role_list_data'
    }).success(function(data,status,headers,config) {
    	console.log(data.data);
    	$scope.rows = data.data;
    	for (var i=0; i<$scope.rows.length; i++) {
    		for (r in $scope.initRoleIds) {
    			if ($scope.rows[i].id == r) {
    				$scope.rows[i].selected = true;
    				break;
    			}
    		}
    	}
    }).error(function(data,status,headers,config) {
        // 当响应以错误状态返回时调用
    });
	
//	if (!$scope.roleIds) {
		$scope.initRoleIds = {};
//	} else {
//		console.log("======5");
//		$scope.initRoleIds = angular.extend({}, $scope.roleIds);
//	}
	
	$scope.selectRole = function($event) {
		var id = $event.target.id;
		var name = angular.element("#"+id).attr('value');
		var tr = angular.element("#tr"+id);
		if(tr.attr('selected')) {
			tr.removeAttr('selected');
			delete $scope.initRoleIds[id];
		} else {
			tr.attr('selected','selected');
			var role = {
				id: id,
				name: name
			}
			$scope.initRoleIds[id] = role;
		}
	}
	
	$scope.save = function() {
		$scope.$emit('setRoles', $scope.initRoleIds);
		$scope.$hide();
    };

    // Close button handler
    $scope.close = function() {
    	$scope.$hide();
    };
}]

var KisBpmOrgsPopupCtrl = [ '$scope', '$http', '$modal', function($scope, $http, $modal){
	
	 //接受子控制器发送的消息  
    $scope.$on("menu",function(event,params){  
    	$http({
            method: 'post',
            dataType: 'json',
            url: 'new/flow/organization_list_data'
        }).success(function(data,status,headers,config) {
        	var treeNodes = eval(data.data);//eval(data.treeNodes)
        	$scope.$broadcast("menuData", treeNodes);
        }).error(function(data,status,headers,config) {
            // 当响应以错误状态返回时调用
        });
    });  
	
//	if (!$scope.orgIds) {
		$scope.initOrgIds = {};
//	} else {
//		$scope.initOrgIds = angular.extend({}, $scope.orgIds);
//	}
	
	$scope.save = function() {
		var nodes = $scope.zTree.getCheckedNodes();
		var org = null;
		$scope.initOrgIds = {};
		for(var i=0; i<nodes.length; i++) {
			org = {
				id: nodes[i].id,
				name: nodes[i].name
			};
			$scope.initOrgIds[nodes[i].id] = org;
		}
		$scope.$emit('setOrgs', $scope.initOrgIds);
		$scope.$hide();
    };

    // Close button handler
    $scope.close = function() {
    	$scope.$hide();
    };
}]

activitiModeler.directive('tree',function(){  
    return{  
        require:'?ngModel',  
        restrict:'A',  
        link:function($scope,element,attrs,ngModel){ 
        	$scope.zTree = null;
            var setting = {  
        		check: {
    				enable: true,
    				autoCheckTrigger: true,
    				chkboxType: { "Y": "s", "N": "s" }
    			},
    			view: {
    				dblClickExpand: false,
    				showLine: false,
    				selectedMulti: false
    			},
    			data: {
    				simpleData: {
    					enable:true,
    					idKey: "id",
    					pIdKey: "pid",
    					rootPId: ""
    				}
    			}, 
    			callback: {
    				beforeClick: function(treeId, treeNode) {
    					if (treeNode.checked) {
    						$scope.zTree.checkNode(treeNode, false, true);
    					} else {
    						$scope.zTree.checkNode(treeNode, true, true);
    					}
    				},
    				onCheck : function(e, treeId, treeNode) {
    				}
    			} 
            };  
            //向控制器发送消息，进行菜单数据的获取  
            $scope.$emit("menu", attrs["value"]);//此处attrs["value"]为ul中的value值，此处作为标记使用  
            //接受控制器返回的菜单的消息  
            $scope.$on("menuData", function(event,data){  
            	console.log(data);
            	$scope.zTree = jQuery.fn.zTree.init(element, setting, data);//进行初始化树形菜单  
            	for(n in $scope.orgIds) {
            		var treeNode = $scope.zTree.getNodeByParam("id", n);
            		$scope.zTree.checkNode(treeNode, true, false);
            	}
            });  
        }  
    }  
});