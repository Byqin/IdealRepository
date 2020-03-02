const myApp = angular.module('loginApp', []);

myApp.controller('loginController', ['$scope','$http', function($scope,$http){
    $scope.userId = null;
    $scope.password = null;
    $scope.phone = null;
    $scope.email = null;
    $scope.userNameEn = null;
    $scope.userNameCn = null;
    $scope.userAge = null;
    $scope.id = null;
    $scope.sex = null;
    $scope.birthday = null;

    $scope.spicy = function(spice){
        $scope.userId = spice;
    };

    $scope.registerUser = function(){
        console.log("开始请求日志:"+$scope.userId);
        $scope.post("/user/saveInfo",{
            userId:getValue($scope.userId),
            password:getValue($scope.password),
            userPhone:getValue($scope.phone) ,
            email:getValue($scope.email) ,
            userNameEn:getValue($scope.userNameEn) ,
            userNameCn:getValue($scope.userNameCn) ,
            userAge:getValue($scope.userAge),
            id:getValue($scope.id),
            sex:getValue($scope.sex),
            birthday:getValue($scope.birthday)
        },(data=>{
            $("#signIn").trigger('click')
        }));
    }

    $scope.login = function (){
        $scope.post("/user/queryList",{
            userId:getValue($scope.userId)
        },emptyApply);
    }

    $scope.post = function(path,data,apply){
        console.log("开始请求日志:"+data);
        $http({
            method:'post',
            url:path,
            data:data,
            headers: {
                'Content-Type': 'application/json;charset=UTF-8'
            }
        }).then(function(resp){
            console.log('post success');
            console.log(resp);
            if(resp.data && resp.data.code == '0000'){
                apply(resp.data.data);
            }else{
                alert(resp.data.message);
            }
        },function(resp){
            console.log('post error');
            console.log(resp);
        });
    }

    const emptyApply = function(x){}

    const getValue = function(data){
        if((!data && data != 0) || data == ''){
            return null;
        }
        return data;
    }
}]);
