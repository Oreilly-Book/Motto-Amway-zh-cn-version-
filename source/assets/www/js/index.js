/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
 
 //add on 2012-11-05



var app = {
    // Application Constructor
    initialize: function() {
    	
//    	window.plugins.JsMotto.motto(success, error, "1", "2");
//    	alert("OKDKL");
       // this.bindEvents();
    },
    // Bind Event Listeners
    //
    // Bind any events that are required on startup. Common events are:
    // 'load', 'deviceready', 'offline', and 'online'.
    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
    },
    // deviceready Event Handler
    //
    // The scope of 'this' is the event. In order to call the 'receivedEvent'
    // function, we must explicity call 'app.receivedEvent(...);'
    onDeviceReady: function() {
        //app.receivedEvent('deviceready');
       // window.plugins.JsMotto.motto(success, error, "1", "2");
    },
    // Update DOM on a Received Event
    receivedEvent: function(id) {
//        var parentElement = document.getElementById(id);
//        var listeningElement = parentElement.querySelector('.listening');
//        var receivedElement = parentElement.querySelector('.received');
//
//        listeningElement.setAttribute('style', 'display:none;');
//        receivedElement.setAttribute('style', 'display:block;');
		
        console.log('Received Event: ' + id);
    }
};



var jmottos = function(){
	//alert("js invoked");
var success = function(data){ //当Java方法返回成功时，通过data.key 获得Java中传来的JSONObject数据
    alert(data);            
	//var ret=data.mottos;//"1111111 : " + data.testData1 + '   and 2222222 : ' + data.testData2;
                //var titles="";
                //for(var i=0;i<ret.length;i++)
                //	{
                //		titles+="<div>"+ret[i]+"</div>";
                //	}
//				if(ret)
//                {
//                var types=ret.split("|*|");var title="";var con="";
//                for(var i=0;i<types.length;i++)
//                	{
//                		var te=types[i].split("|+|");
//                		title+="<div>"+te[1];
//                		con+="<div>"+te[1];
//                		if(te[2])
//                		{
//						var tec=te[2].split("||");
//                		for(var y=0;y<tec.length;y++)
//                			{
//                				con+="<dd>"+tec[y].split("|-|")[1];
//                				con+="</dd>";
//                			}
//                		};
//                		title+="</div>";
//                		con+="</div>";
//                	}
//                };                
//                document.getElementById("div-con").innerHTML=title;//data.mottos;
//                document.getElementById("div-con").innerHTML+="<div></div>"+con;
//                document.getElementById("div-con").innerText+=title;
                //alert(data);
            };
              
var error = function(e){
                alert(e);
            };
 
window.plugins.JsMotto.motto(success, error);
//"first test data", "second test data"是向Java传递的参数
}
 
