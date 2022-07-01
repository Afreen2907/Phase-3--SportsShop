package com.simplilearn.workshop.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.workshop.domain.Admin;
import com.simplilearn.workshop.domain.Category;
import com.simplilearn.workshop.domain.Product;
import com.simplilearn.workshop.domain.User;
import com.simplilearn.workshop.errors.AdminNotFoundException;
import com.simplilearn.workshop.service.AdminService;
import com.simplilearn.workshop.service.CategoryService;
import com.simplilearn.workshop.service.ProductService;
import com.simplilearn.workshop.service.PurchaseItemService;
import com.simplilearn.workshop.service.PurchaseService;
import com.simplilearn.workshop.service.UserService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService; 

	@Autowired
	private PurchaseService purchaseService; 

	@Autowired
	private PurchaseItemService purchaseItemService; 
	
	@Autowired
	private UserService userService; 
	
	
	@PostMapping(path="/sports/admins/login")
	@ResponseBody
	public Admin loginAuthenticate(@RequestParam(name="adminId") String adminUserId, @RequestParam(name="pwd")String adminPwd) {
		
		Admin authenticateAdmin = adminService.authenticate(adminUserId, adminPwd);
		if(authenticateAdmin == null) {
			System.out.println("No Admin found");
			return null;
		}else {
			System.out.println("Authenticated");
		
		
		return authenticateAdmin;}
		
	}
	
	@PutMapping(path="/sports/admins/changePassword/{adminId}/{id}")
	public ResponseEntity<Admin> updatePwd(@PathVariable String adminId, @PathVariable long id, @RequestBody Admin theAdmin){
		
		Admin findAdmin = adminService.getAdminByIds(adminId, id);
		if(findAdmin == null) {
			throw new AdminNotFoundException("id - " + id);
		} else{
			findAdmin.setAdminId(adminId);
			findAdmin.setPwd(theAdmin.getPwd());
			findAdmin.setId(id);
		} 
		
		Admin savedAdmin = adminService.updatePwd(findAdmin);
		return new ResponseEntity("Password saved", HttpStatus.OK);
	}
	
	@GetMapping(path="sports/admins/listCat/{adminId}/{id}")
	public List<Category> categories(String adminId, long id){
		Admin findAdmin = adminService.getAdminByIds(adminId, id);
		if(findAdmin == null) {
			throw new AdminNotFoundException("Id - " +  id);
		}
		List<Category> list = categoryService.getAllCategories();
		
		return list;
	}
	
	@GetMapping(path="sports/admins/listProd/{adminId}/{id}")
	public List<Product> products(@PathVariable String adminId, @PathVariable long id){
		Admin findAdmin = adminService.getAdminByIds(adminId, id);
		if(findAdmin == null) {
			throw new AdminNotFoundException("Id - " +  id);
		}
		List<Product> list = productService.getAllProducts();
		
		return list;
	}
	
	@DeleteMapping(path="/sports/admins/deleteCat/{adminId}/{id}/{catId}")
	public ResponseEntity<Category> deleteCategory(@PathVariable String adminId, @PathVariable long id, @PathVariable long catId){
		Admin findAdmin = adminService.getAdminByIds(adminId, id);
		if(findAdmin == null) {
			throw new AdminNotFoundException("Id - " +  id);
		}
		categoryService.deleteCategory(catId);
		
		return ResponseEntity.noContent().build();
	}
	

	
	@PutMapping(name="/sports/admins/editCat/{adminId}/{id}/{catId}")
	public ResponseEntity<Category> updateCategory(@PathVariable String adminId, @PathVariable long id, @PathVariable long catId, @RequestBody Category theCat){
		Admin findAdmin = adminService.getAdminByIds(adminId, id);
		if(findAdmin == null) {
			throw new AdminNotFoundException("Id - " +  id);
		} else {
			Category findCategory = categoryService.getCategoryById(catId);
			
			if(findCategory == null) {
				throw new AdminNotFoundException("CAT ID - " +  catId);
			} else {
				findCategory.setId(catId);
				findCategory.setName(theCat.getName());
			}
			
		 Category savedCat = categoryService.updateCategory(findCategory);
		 
		 return new ResponseEntity(savedCat, HttpStatus.OK);
			
		}
		
		
	}
	@PutMapping(name="/sports/admins/updateCat/{adminId}/{id}/{catId}")
	public ResponseEntity<Category> updateProduct(@PathVariable String adminId, @PathVariable long id, @PathVariable long prodId, @RequestBody Product theProd){
		Admin findAdmin = adminService.getAdminByIds(adminId, id);
		if(findAdmin == null) {
			throw new AdminNotFoundException("Id - " +  id);
		} else {
			Product findProduct = productService.getProductById(prodId);
			
			if(findProduct == null) {
				throw new AdminNotFoundException("Prod ID - " +  prodId);
			} else {
				findProduct.setCategoryId(theProd.getCategoryId());
				findProduct.setDateAdded(theProd.getDateAdded());
				findProduct.setId(prodId);
				findProduct.setName(theProd.getName());
				findProduct.setPrice(theProd.getPrice());
			}
			
		 Product savedProd = productService.updateProduct(findProduct);
		 
		 return new ResponseEntity(savedProd, HttpStatus.OK);
			
		}
		
		
	}
	@GetMapping(path="sports/admins/listUsers/{adminId}/{id}")
	public List<User> members(@PathVariable String adminId, @PathVariable long id){
		Admin findAdmin = adminService.getAdminByIds(adminId, id);
		if(findAdmin == null) {
			throw new AdminNotFoundException("Id - " +  id);
		} 
		
		List<User> list = userService.getAllUsers();
		
		return list;
	}
	
	
}
