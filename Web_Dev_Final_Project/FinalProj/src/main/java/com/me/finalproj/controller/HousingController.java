package com.me.finalproj.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.me.finalproj.dao.HousingDao;
import com.me.finalproj.pojo.Housing;
import com.me.finalproj.pojo.Product;
import com.me.finalproj.pojo.User;

@Controller
@RequestMapping("**/housing/**")	
public class HousingController {

	@Autowired
	@Qualifier("housingDao")
	HousingDao housingDao;

	@Autowired
	ServletContext context; 

	@Autowired
	@Qualifier("housing")
	Housing housing;
	
	@Autowired
	@Qualifier("product")
	Product product;

	@RequestMapping(value = "/add/housing", method = RequestMethod.POST)
	protected ModelAndView addHousing(HttpServletRequest request,@RequestParam("imagepath") MultipartFile file) throws Exception {
		if(validateSession(request)) {

		HttpSession session = (HttpSession) request.getSession();
//		String uploadPath="F:\\MS Work\\SEM2\\Web Development\\Java_Workspace_Eclipse\\FinalProj\\data\\";
		String uploadPath=context.getRealPath(File.separator)+"\\resources\\data\\";
//		System.out.println(context.getContextPath());
		System.out.println(uploadPath);
		System.out.println(System.getProperty("user.dir"));
		String title=request.getParameter("title");
		String aptNo=request.getParameter("aptNo");
		String street=request.getParameter("street");
		int zipcode=Integer.parseInt(request.getParameter("zipcode"));
		int quotation=Integer.parseInt(request.getParameter("quotation").substring(1));
		
		housing.setTitle(title);
		housing.setAptNo(aptNo);
		housing.setStreet(street);
		housing.setZipcode(zipcode);
		housing.setQuotation(quotation);
		housing.setImagepath("\\resources\\data\\"+file.getOriginalFilename());
		housing.setUser((User)session.getAttribute("user"));
		
        FileCopyUtils.copy(file.getBytes(), new File(uploadPath+file.getOriginalFilename()));
		request.setAttribute("product", product);
        housingDao.addHousing(housing);
		return new ModelAndView("addpost","success","Housing Successfully Posted!!");
		}else {
			return new ModelAndView("home","errorMessage","Your Session Expired, kindly try to login again");
			
		}
	}
	
	@RequestMapping(value = "/validate/housing", method = RequestMethod.GET)
	protected String validateHousing(HttpServletRequest request) throws Exception {
		if(validateSession(request)) {

		return "housingAdmin";
		}else
			return null;
	}

	@RequestMapping(value="/validate/housing/ajaxload", method=RequestMethod.GET)
	@ResponseBody
	public String ajaxService(HttpServletRequest request)
	{
		String housingJson=null;
		if(validateSession(request)) {
		try {
			List<Housing> housingList=housingDao.getPending();
			housingJson = new Gson().toJson(housingList);
			System.out.println(housingJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return housingJson;
	}

	
	@RequestMapping(value="/validate/housing/ajaxload", method=RequestMethod.POST)
	@ResponseBody
	public String approveRejectRequest(HttpServletRequest request)
	{

		String result = null;
		if(validateSession(request)) {

		long id=Long.parseLong(request.getParameter("id"));
		String decision=request.getParameter("decision");
		System.out.println("here"+request.getParameter("id"));
		try {
			 boolean flag=housingDao.updateRequest(id,decision);
			 if(flag) {
				 result="done";
			 }
			 else {
				 result="error";
			 }
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return result;
	}
	@RequestMapping(value = "/search/housing", method = RequestMethod.GET)
	protected String searchHousing(HttpServletRequest request) throws Exception {
		return "searchHousing";
	}
	
	@RequestMapping(value="/search/housing/ajaxload", method=RequestMethod.GET)
	@ResponseBody
	public String searchAjax(HttpServletRequest request)
	{
		String housingJson=null;
		if(validateSession(request)) {

		try {
			List<Housing> housingList=housingDao.getApproved();
			housingJson = new Gson().toJson(housingList);
			System.out.println(housingJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return housingJson;
	}

	@RequestMapping(value="/search/housing/searchByStreet", method=RequestMethod.POST)
	@ResponseBody
	public String searchStreet(HttpServletRequest request)
	{
		String housingJson=null;
		if(validateSession(request)) {

		String search=request.getParameter("search");
		try {
			List<Housing> housingList=housingDao.getSearched(search);
			housingJson = new Gson().toJson(housingList);
			System.out.println(housingJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return housingJson;
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
