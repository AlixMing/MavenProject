package com.ming.controller;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.ming.model.User;

/**
 * HomeController
 */
@ControllerBind(controllerKey="/",viewPath="/home")
public class HomeController extends Controller {
    private static final Logger logger = Logger.getLogger(HomeController.class); 
    
	public void index() {
		renderFreeMarker("index.ftl");
	}
	
	public void login(){
	    String name = getPara("user_name");

	    String password = getPara("user_password");
	    System.out.println("name:" + name);
	    System.out.println("password:" + password);
	    Page<User> userList = User.me.paginate(1, 5); 
	    logger.debug("userList size:" + userList.getList().size());
	    setAttr("userList", userList.getList());
	    renderFreeMarker("login.ftl");
	}
}





