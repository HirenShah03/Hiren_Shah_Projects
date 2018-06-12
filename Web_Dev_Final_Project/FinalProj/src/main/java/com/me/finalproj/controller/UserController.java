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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.captcha.botdetect.web.servlet.Captcha;
import com.me.finalproj.dao.UserDao;
import com.me.finalproj.exception.UserException;
import com.me.finalproj.pojo.User;
import com.me.finalproj.validator.UserValidator;

@Controller
@RequestMapping("/user/*")	
public class UserController {

	@Autowired
	@Qualifier("userDao")
	UserDao userDao;

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/user/*", method = RequestMethod.GET)
	protected String loginUser(HttpServletRequest request) {
		if(validateSession(request)) {
		return "home";
		}else
			return null;
	}
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	protected ModelAndView loginUser(HttpServletRequest request,  @ModelAttribute("user") User user, BindingResult result) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		try {

			System.out.println("loginUser");
			User u = userDao.get(user.getUserName(),user.getPassword());
			
			if (u != null && u.getStatus() == 1) {
				session.setAttribute("user", u);
				if(u.getRole().equalsIgnoreCase("admin") && validateSession(request))
				return new ModelAndView("admin-home");
				else
					return new ModelAndView("user-home");
					
			} else if (u != null && u.getStatus() == 0) {
				return new ModelAndView("home", "errorMessage", "Your account hasn't been activated yet!");
			} else {
				return new ModelAndView("home", "errorMessage", "Invalid username/password!");
			}
			
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			request.setAttribute("errorMessage", "error while login");
			return new ModelAndView("error", "errorMessage", "error while login");
		}

	}
	
	
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request,  @ModelAttribute("user") User user, BindingResult result) throws Exception {

		validator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("home", "user", user);
		}
		String captchacode=request.getParameter("captchaCode");
		Captcha captcha=Captcha.load(request, "CaptchaObject");
		HttpSession session=request.getSession();

		if(captcha.validate(captchacode)) {
			
		try {

			System.out.print("registerNewUser");

			User u = userDao.register(user);
			if(u != null){
			session.setAttribute("user", u);
			request.setAttribute("success", "Registration successfully done!");
			return new ModelAndView("home", "user", u);
			}
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while registration");
		}
	   }else {
			return new ModelAndView("home", "errorMessage", "Invalid Captcha. Re-enter again");
	
	 }
		return null;
	}

	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	protected String logoutUser(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "home";
	}
	
	@RequestMapping(value="/user/ajax", method=RequestMethod.POST)
	@ResponseBody
	public String approveRejectRequest(HttpServletRequest request)
	{
		String result = null;
		String username=request.getParameter("username");
//		System.out.println("here"+request.getParameter("id"));
		try {
			 boolean flag=userDao.getUserName(username);
			 if(flag) {
				 result="true";
			 }
			 else {
				 result="false";
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("here"+result);
		return result;
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
