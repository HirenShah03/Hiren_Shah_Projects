package com.me.finalproj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.finalproj.dao.CategoryDao;
import com.me.finalproj.exception.CategoryException;
import com.me.finalproj.pojo.Category;
import com.me.finalproj.validator.CategoryValidator;

@Controller
@RequestMapping("/add/category")	
public class AddCategoryController {

	@Autowired
	@Qualifier("categoryValidator")
	CategoryValidator categoryValidator;
	
	@Autowired
	@Qualifier("categoryDao")
	CategoryDao categoryDAO;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(categoryValidator);
	}

	@RequestMapping(value="/add/category", method = RequestMethod.GET)
	public ModelAndView initializeForm() throws Exception {			
		return new ModelAndView("addcategory", "category", new Category());
	}
	
	@RequestMapping(value = "/add/category", method = RequestMethod.POST)
	public ModelAndView addCategory(HttpServletRequest request,@ModelAttribute("category") Category category, BindingResult result) throws Exception {
		if(validateSession(request)) {
		categoryValidator.validate(category, result);
		
		if (result.hasErrors()) {
			return new ModelAndView("addcategory", "category", category);
		}

		try {				
			category = categoryDAO.create(category.getName());
		} catch (CategoryException e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while adding category");
		}
		return new ModelAndView("addcategory", "success", "Category Added successfully");
		}
		else {
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
