window.host ={
	ip:"http://10.36.138.181:10086",
	fdfsip:"http://10.36.138.254:8080"
	
}
window.url ={
	//用户注册的地址
	register:host.ip+ "/user/register",
	
	//用户登录的地址
	login:host.ip+"/user/login",
	
	//头像上传的地址
	uploaderHeader:host.ip+"/res/uploaderHeader"
	
}

window.util ={
	getImg:function(url){
		
		return.host.fdfsip+"/"+url;
		
	},
	setUser:function(userObj){
		plus.strorage.setItem("login_user",JSON.stringify(userObj));
		
	},
	getUser:function(){
		var jsonStr=plus.stroage.getImg("login_user");
		return jsonStr ?JSON.parse(jsonStr):null;
	},
	
	//发送ajax的工具方法
	ajax:function(ele){
		//打开弹出框
		plus.nativeUI.showWaiting();
		//发送ajax
		mui.ajax(ele.url,{
			data: ele.data?ele.data:{},
			dataType:"json",//服务器返回json的格式
			type:"post",//HTTP的请求类型
			timeout:10000,
			success:function(data){
				//关闭等待框
				plus.nativeUI.closeWaiting();
				//调用传递过来的success方法
				if(ele.success){
					ele.success(data);
				}
				
			},
			error:function(xhr,type,errorThrown){
				
				plus.nativeUI.closeWaiting();
				
				plus.nativeUI.toast("请求异常，请刷新重试！");
			}
			
		})
	}
	
	
	
}
