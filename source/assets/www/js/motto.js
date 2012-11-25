var minit=function(){
	document.addEventListener('deviceready',onDeviceReady, true);
};

var mottoexecute=function(){
	$(".app").remove();
	window.plugins.mottoplugin.mottos(
			'getting',
			this.success,
			this.error);
};
var onDeviceReady=function(){
	$(".app").remove();
	window.plugins.mottoplugin.mottos(
			'getting',
			this.success,
			this.error);
};
var mottoplugin=function(){};
mottoplugin.prototype.mottos=function(
		message,successCallback,errorCallback){
	cordova.exec(
			successCallback,
			errorCallback,
			'JMotto',
			'actiona',
			['']);
};

if(!window.plugins)
{
	window.plugins={};
};
if(!window.plugins.mottoplugin){
	window.plugins.mottoplugin=new mottoplugin();
};
var success = function(data){ //当Java方法返回成功时，通过data.key 获得Java中传来的JSONObject数据
                var ret=data.mottos;//"1111111 : " + data.testData1 + '   and 2222222 : ' + data.testData2;
                //var titles="";
                //for(var i=0;i<ret.length;i++)
                //	{
                //		titles+="<div>"+ret[i]+"</div>";
                //	}
				if(ret)
                {
                var types=ret.split("|*|");var title="";var con="";
                for(var i=0;i<types.length;i++)
                	{
                		var te=types[i].split("|+|");
                		title+="　<a href='#h_"+te[1]+"'>"+te[1]+"</a>";
                		con+="<div>";
                		con+="<h1 id='h_"+te[1]+"'>"+te[1]+"<a title='返回顶部' lang='返回顶部' href='#navmenu'>↑</a></h1>";
                		if(te[2])
                		{
						var tec=te[2].split("||");
                		for(var y=0;y<tec.length;y++)
                			{
                				con+="<dd><img width='12' src='img/diamond.png' />"+tec[y].split("|-|")[1];
                				con+="</dd>";
                			}
                		};
                		//title+="</a>";
                		con+="</div>";
                	}
                };                
                //document.getElementById("div-con").innerHTML=title;//data.mottos;
                $("#navmenu").html(title);
                $("#div-con").html(con);
                //document.getElementById("div-con").innerHTML+=con;
                //document.getElementById("div-con").innerText+=title;
                //alert(data);
            };
              
var error = function(e){
                alert(e);
            };
  //window.plugins.JTester.tester(success, error, "first testor data", "second tester data");