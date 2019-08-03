package com.me.finalproj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.finalproj.dao.CategoryDao;
import com.me.finalproj.exception.CategoryException;
import com.me.finalproj.pojo.Product;

@Controller
@RequestMapping("/add/*")	
public class AddPostController {

	@Autowired
	@Qualifier("categoryDao")
	CategoryDao categoryDAO;

	@Autowired
	@Qualifier("product")
	Product product;

	@RequestMapping(value = "/add/post", method = RequestMethod.GET)
	protected ModelAndView addPost(HttpServletRequest request) throws CategoryException {
		if(validateSession(request)) {
		request.setAttribute("product", product);
		return new ModelAndView("addpost","categories", categoryDAO.list());
	}else {
		return new ModelAndView("home","errorMessage","Your Session Expired, kindly try to login again");
		
	 }
	}

	public static  boolean validateSession(HttpServletRequest request) {
		HttpSession session = (HttpSession) request.getSession();

	if(!(session.getAttribute("user")==null)) {
		return true;
	}
	else
		return false;
	}

}
