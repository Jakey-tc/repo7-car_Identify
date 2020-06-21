car.service("carService", function ($http){


    this.getCarInfo = function(){

        alert("点击确认并等待检测结果");
        //定义一个格式数据，一个html5的新对象，可以表示文件项。
        var formData = new FormData();
        //给文件项对象增加文件，第一个参数的file就是文件这个参数的name值。要与后台参数名对应，
        //第二个参数的file表示file标签，这里表示获取所有file标签中的第一个file标签即图片文件
        formData.append('file',file.files[0]);
        return $http({

            url:'car/upload',
            method:'post',
            //将上面的文件项传入
            data:formData,
            //指定数据格式，默认是json，指定位undefined就表示是multipart文件类型
            headers:{'Content-Type':undefined},
            //对表单进行二进制序列化
            transformRequest:angular.identity

        });
    }

    //错误代码1，原因还未知
  /*  this.getCarInfo = function () {

        alert("do");
        var formData = new FormData();
        //formData.append('fileTypeId', fileType);//其他需要上传的字段
        formData.append('files', file.files[0]);//文件
        return $http({
            url:'/car/upload',
            method:'post',
            data:formData,
            headers:{'Content-Type': undefined},//使用angular上传一定要加上这一句，不然传给后台的是空的。
            transformRequest:angular.identity
        });*/

    //错误代码2，原因还未知
        /*   $http({
               method: 'POST',
               url: 'car/upload',
               headers: {'Content-Type': undefined},
               params: formData //传递参数
           }).then(function succ(response) {
               //请求成功执行代码
               alert("success");
           }, function error(response) {
               //请求失败执行代码
               alert("error");
           });*/



});