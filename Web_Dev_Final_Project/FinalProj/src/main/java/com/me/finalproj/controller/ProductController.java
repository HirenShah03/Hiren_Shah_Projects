package com.me.finalproj.controller;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.me.finalproj.dao.CategoryDao;
import com.me.finalproj.dao.ProductDao;
import com.me.finalproj.pojo.Category;
import com.me.finalproj.pojo.Product;
import com.me.finalproj.pojo.User;

@Controller
@RequestMapping("**/products/**")	
public class ProductController {

	@Autowired
	@Qualifier("productDao")
	ProductDao productDao;
	
	@Autowired
	ServletContext context; 

	@Autowired
	@Qualifier("product")
	Product product;

	@Autowired
	@Qualifier("categoryDao")
	CategoryDao categoryDAO;

	@RequestMapping(value = "/add/products", method = RequestMethod.POST)
	protected ModelAndView addHousing(HttpServletRequest request,@RequestParam("imagepaths") MultipartFile file,@ModelAttribute("product") Product product) throws Exception {
		if(validateSession(request)) {
    	HttpSession session = (HttpSession) request.getSession();
		Set<Category> categories = new HashSet<Category>();
		String uploadPath=context.getRealPath(File.separator)+"\\resources\\data\\";
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String[] categoriesArray=product.getCategoryArray();
		int quotation=Integer.parseInt(request.getParameter("quotations").substring(1));
		
		
		for(String c:categoriesArray) {
			Category category;
			category=categoryDAO.get(c);
			categories.add(category);
		}
		product.setTitle(title);
		product.setDescription(description);
		product.setQuotation(quotation);
		product.setImagepath("\\resources\\data\\"+file.getOriginalFilename());
		product.setUser((User)session.getAttribute("user"));
		product.setCategories(categories);
		
        FileCopyUtils.copy(file.getBytes(), new File(uploadPath+file.getOriginalFilename()));
        productDao.addProduct(product);

		for(Category c: product.getCategories()){
        	c = categoryDAO.get(c.getName());
        	c.getProducts().add(product);
        	categoryDAO.update(c);
        }
		return new ModelAndView("addpost","success","Product Successfully Posted!!");
		
	}else {
		return new ModelAndView("home","errorMessage","Your Session Expired, kindly try to login again");
		
	}
	}
	@RequestMapping(value = "/search/products", method = RequestMethod.GET)
	protected ModelAndView searchHousing(HttpServletRequest request) throws Exception {
		if(validateSession(request)) {
		request.setAttribute("product", product);
		return new ModelAndView("searchProduct","categories", categoryDAO.list());
	}else {
		return new ModelAndView("home","errorMessage","Your Session Expired, kindly try to login again");
		
	 }
	}
	
	@RequestMapping(value="/search/products/ajaxload", method=RequestMethod.GET)
	@ResponseBody
	public String searchAjax(HttpServletRequest request)
	{
		String productJson=null;
		if(validateSession(request)) {

		try {
			List<Product> productList=productDao.getApproved();
			 JSONArray jArray = null;
//				housingJson = new Gson().toJson(productList);
				JSONObject jObject = new JSONObject();
				try
				{
				    jArray = new JSONArray();
				    for (Product product : productList)
				    {
				         JSONObject studentJSON = new JSONObject();
				         studentJSON.put("id", product.getId());
				         studentJSON.put("title", product.getTitle());
				         studentJSON.put("imagepath", product.getImagepath());
				         studentJSON.put("quotation", product.getQuotation());
				         jArray.put(studentJSON);
				    }
				    jObject.put("StudentList", jArray);
				} catch (JSONException jse) {
				}

				System.out.println(jArray);
				productJson=jArray.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return productJson;
	}
	
	@RequestMapping(value="/search/products/searchByTitle", method=RequestMethod.POST)
	@ResponseBody
	public String searchByTitle(HttpServletRequest request)
	{
		String productJson=null;
		if(validateSession(request)) {

		String search=request.getParameter("search");
		try {
			List<Product> productList=productDao.getSearched(search);
			 JSONArray jArray = null;
//				housingJson = new Gson().toJson(productList);
				JSONObject jObject = new JSONObject();
				try
				{
				    jArray = new JSONArray();
				    for (Product product : productList)
				    {
				         JSONObject studentJSON = new JSONObject();
				         studentJSON.put("id", product.getId());
				         studentJSON.put("title", product.getTitle());
				         studentJSON.put("imagepath", product.getImagepath());
				         studentJSON.put("quotation", product.getQuotation());
				         jArray.put(studentJSON);
				    }
				    jObject.put("StudentList", jArray);
				} catch (JSONException jse) {
				}

				System.out.println(jArray);
				productJson=jArray.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return productJson;
	}
	@RequestMapping(value = "/validate/products", method = RequestMethod.GET)
	protected String validateHousing(HttpServletRequest request) throws Exception {
		if(validateSession(request)) {

		return "productAdmin";
		}else
			return null;
	}

	@RequestMapping(value="/validate/products/ajaxload", method=RequestMethod.GET)
	@ResponseBody
	public String ajaxService(HttpServletRequest request)
	{
		String housingJson=null;
		if(validateSession(request)) {

		try {
			List<Product> productList=productDao.getPending();
			 JSONArray jArray = null;
//			housingJson = new Gson().toJson(productList);
			JSONObject jObject = new JSONObject();
			try
			{
			    jArray = new JSONArray();
			    for (Product product : productList)
			    {
			         JSONObject studentJSON = new JSONObject();
			         studentJSON.put("id", product.getId());
			         studentJSON.put("title", product.getTitle());
			         studentJSON.put("imagepath", product.getImagepath());
			         studentJSON.put("quotation", product.getQuotation());
			         jArray.put(studentJSON);
			    }
			    jObject.put("StudentList", jArray);
			} catch (JSONException jse) {
			}

			System.out.println(jArray);
			housingJson=jArray.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return housingJson;
	}

	
	@RequestMapping(value="/validate/products/ajaxload", method=RequestMethod.POST)
	@ResponseBody
	public String approveRejectRequest(HttpServletRequest request)
	{
		String result = null;
		if(validateSession(request)) {
		long id=Long.parseLong(request.getParameter("id"));
		String decision=request.getParameter("decision");
//		System.out.println("here"+request.getParameter("id"));
		try {
			 boolean flag=productDao.updateRequest(id,decision);
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

	@RequestMapping(value="/search/products/addfilter", method=RequestMethod.GET)
	@ResponseBody
	public String addFilter(HttpServletRequest request)
	{
		String categoryJson=null;
		if(validateSession(request)) {
		try {
			List<Category> catList=categoryDAO.list();
			 JSONArray jArray = null;
//				housingJson = new Gson().toJson(productList);
				JSONObject jObject = new JSONObject();
				try
				{
				    jArray = new JSONArray();
				    for (Category category : catList)
				    {
				         JSONObject studentJSON = new JSONObject();
				         studentJSON.put("categoryId", category.getCategoryId());
				         studentJSON.put("name", category.getName());
				         studentJSON.put("products", category.getProducts());
				         jArray.put(studentJSON);
				    }
				    jObject.put("StudentList", jArray);
				} catch (JSONException jse) {
				}

				System.out.println(jArray);
				categoryJson=jArray.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return categoryJson;
	}
	
	@RequestMapping(value="/search/products/filter", method=RequestMethod.POST)
	@ResponseBody
	public String filterContents(HttpServletRequest request,@RequestParam(value="clickedItem[]") String[] clickedItem)
	{
		String productJson=null;
		if(validateSession(request)) {
		Long[] clicked=new Long[clickedItem.length];
		for (int i = 0; i < clicked.length; i++){
			clicked[i] = Long.parseLong(clickedItem[i]); 
			System.out.println(clicked[i]);
		}
		List<Long> list = Arrays.asList(clicked);	
		try {
			List<Product> productList;
			if(clicked.length==0) {
				productList=productDao.getApproved();
				
			}else {
			productList=productDao.getFiltered(list);
			}
			 JSONArray jArray = null;
//				housingJson = new Gson().toJson(productList);
				JSONObject jObject = new JSONObject();
				try
				{
				    jArray = new JSONArray();
				    for (Product product : productList)
				    {
				         JSONObject studentJSON = new JSONObject();
				         studentJSON.put("id", product.getId());
				         studentJSON.put("title", product.getTitle());
				         studentJSON.put("imagepath", product.getImagepath());
				         studentJSON.put("quotation", product.getQuotation());
				         jArray.put(studentJSON);
				    }
				    jObject.put("StudentList", jArray);
				} catch (JSONException jse) {
				}

				System.out.println(jArray);
				productJson=jArray.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return productJson;
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
