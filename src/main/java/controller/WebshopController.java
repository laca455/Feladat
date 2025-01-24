package com.example.webshop.controller;

import com.example.webshop.model.Product;
import com.example.webshop.repository.ProductRepository
import com.example.webshop.repository.UserRepository
import com.example.webshop.repository.OrderRepository
import com.example.webshop.repository.CategoryRepository

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebshopController {

    @Autowired
    private ProductRepository productRepository;
    private UserRepository
    Private OrderRepository

    @GetMapping("/")
    public String index(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "index";
    }
}
