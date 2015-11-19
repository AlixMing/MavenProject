package com.ming.controller;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;

/**
 * IndexController
 */
@ControllerBind(controllerKey="/",viewPath="/home")
public class HomeController extends Controller {
	public void index() {
		System.out.println("hello java");
		renderFreeMarker("index.ftl");
	}
}





