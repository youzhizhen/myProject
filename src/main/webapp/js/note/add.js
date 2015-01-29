define(function(){
	
	//定义一个对象
	var Person = function() {  
		   var obj = new Object();  
		   obj.name= "liying";
		   obj.age=11;
		   obj.test = function() {  
		       alert("test this method");
		   };
		   return obj;  
	};
	
	//返回一个对象
	return new Person();
});