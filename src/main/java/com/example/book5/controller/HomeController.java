package com.example.book5.controller;
import java.io.ByteArrayInputStream;
import org.apache.commons.io.IOUtils;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.book5.entity.BookEntity;
import com.example.book5.entity.UserEntity;
import com.example.book5.service.BookService;
import com.example.book5.service.UserService;

@Controller
@RequestMapping("/book")
public class HomeController {
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;

	//Item Controller

	@GetMapping
	public String viewAll(Model model) {
		if (userService.isUserLoggedIn())
			model.addAttribute("loggedin", true);
		model.addAttribute("books", bookService.findAll());
		return "books";
	}

	@GetMapping("/addbook")
	public String getAddBookView(Model model) {
		model.addAttribute("book", new BookEntity());
		return "book-detail";
	}

	@PostMapping("/save/{id}")
	public String addBook(@PathVariable("id") Integer id, @ModelAttribute("book") BookEntity entity) {
		if(id != null)
			entity.setBookId(id);
		bookService.save(entity);
		return "redirect:/book";
	}

	@GetMapping("/{id}")
	public String getUpdateBookView(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("book", bookService.findById(id));
		model.addAttribute("updating", true);
		return "book-detail";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Integer id) {
		bookService.deleteBook(id);
		return "redirect:/book";
	}
	//



	//User Controller
	
	@GetMapping("/login")
	public String loginCheck() {
		return "login";
	}

	@GetMapping("/register")
	public String viewSignup(Model model) {
		model.addAttribute("user", new UserEntity());
		return "register";
	}
	@PostMapping("/register")
	public String userRegistration( @ModelAttribute("user") UserEntity entity) {
		userService.addUser(entity);
		return "redirect:/book/login";
	}
	//
}
