package com.omur.crudoperations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.omur.crudoperations.service.ProductService;

import jakarta.validation.Valid;

import com.omur.crudoperations.entity.Product;

@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }   

    @GetMapping("/")
    public String homePage(){
        return "redirect:/products";
    }

    @GetMapping("/products/add")
    public String addProductPage(Product product){
        return "add-product";
    }

    @GetMapping("/products/edit/{id}")
    public String editProductPage(@PathVariable("id") Integer id, Model model){ 
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("page-title", "Edit Product Id = "+id);
        return "edit-product";
    }

    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("products", productService.getAll());
        return "products";
    }

    @PostMapping("/products/add")
    public String addProduct(@Valid Product product, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            return "add-product";
        }
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product Added");
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message", "ID = "+id+", Product Deleted");
        return "redirect:/products";
    }

    @PostMapping("/products/edit/{id}")
    public String editProduct(@Valid Product product, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            return "edit-product";
        }
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product Edited");
        return "redirect:/products";
    }
}
