/*app.controller('UploadController',['UploadService','$http','$scope','$rootScope','$cookieStore',function(UploadService,$http,$scope,$rootScope,$cookieStore){

	var self=this;
	
       self.uploadFormData=function()
        {
    	   console.log("Upload Controller called");
            // headers: {'Content-Type': false},
            // file2.files[0]
            //alert(file2.files[0].name);
            var form = new FormData();
            form.append("file",file.files[0]);
             $http({
                method: 'POST',
                url: 'http://localhost:8005/ChatBoxRestService/uploadfile',
                headers: {'Content-Type': undefined},
                data: form,
                
                transformRequest: function(data, headersGetterFunction) {
                	console.log(data);
                     return data;
                        
                }
                })
                 .then(function(response) {  
                             alert("success");
                                }
                                              
                                )}
        
       
       
       self.imageUpload=function(){
			console.log("Profile Image Upload Controller");
			UploadService.getUploadedImage()
			.then(function(response){
				self.uploadImage=response.data;
				console.log(self.uploadImage);
				self.icu=$cookieStore.get('currentUser').userId;
				console.log(self.icu);
			},function(error){
				alert(error);
			});
		}
       
       
       
       
       
       
       
       
       
       
       
}]);
             
      */