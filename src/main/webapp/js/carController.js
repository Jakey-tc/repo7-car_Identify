car.controller("carController", function ($scope, carService) {

    $scope.getCarInfo = function () {

        carService.getCarInfo().success(
            function (res) {
                if(res.success){
                    //获取图片地址
                    $scope.imgUrl = res.imgUrl;
                    //将json字符串转为json对象
                    var json = JSON.parse(res.resultString);
                    $scope.carInfo = json.result.damage_info;


                    //给probability检测精准属性添加一个%
                    $scope.carInfo[0].probability +=  "%";

                    //显示车辆信息的div
                    $("#car_info").css('display','flex');




                };

            }).error(
            function () {

                alert("检测失败");
            }
        );
    }
})