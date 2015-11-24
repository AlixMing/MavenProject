package com.ming.controller;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Page;
import com.ming.model.User;

/**
 * IndexController
 */
@ControllerBind(controllerKey="/",viewPath="/home")
public class HomeController extends Controller {
	public void index() {
	    Page<User> userList = User.me.paginate(1, 5); 
	    System.out.println(userList.getList().size());
	    setAttr("userList", userList.getList());
		renderFreeMarker("index.ftl");
	}
	
	public void hello(){
	    System.out.println("......");
	    renderJson(JsonKit.toJson("hello"));
	}
}





