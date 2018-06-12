package com.me.finalproj.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.finalproj.dao.CategoryDao;
import com.me.finalproj.exception.CategoryException;
import com.me.finalproj.pojo.Category;

public class CategoryValidator implements Validator{

	
	public boolean supports(Class aClass) {
		return Category.class.equals(aClass);
	}

	public void validate(Object obj, Errors errors) {
		Category newCategory = (Category) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.category", "Category Required");
		
		if (errors.hasErrors()) {
            return;//Skip the rest of the validation rules
        }
        
	
		try {
			CategoryDao categoryDao=new CategoryDao();
			Category c = categoryDao.get(newCategory.getName());
			if(c !=null)
				errors.rejectValue("name", "error.invalid.category", "Category already Exists");
			
		} catch (CategoryException e) {
			System.err.println("Exception in Category Validator");
		}
	}

}
