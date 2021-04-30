package com.perscholasjava.book;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/")
	public String home( Model model) {
		// Add the book attribute if doesn't come from a redirect
		if(!model.containsAttribute("book")) {
			model.addAttribute("book", new Book());
		}
		
		// Get all books
		List<Book> bookList = bookService.listAll();
		
		// Send them as a model attribute
		model.addAttribute("bookList", bookList);
		
		return "index";
	}
	
	@RequestMapping(value="/addBook", method=RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") @Valid Book book, BindingResult error, RedirectAttributes attr) {
		// If validation errors are present, redirect with all the errors
		if(error.hasErrors()) {
			
			attr.addFlashAttribute("org.springframework.validation.BindingResult.book", error);
			attr.addFlashAttribute("book", book);
			return "redirect:/";
		}
		
		bookService.save(book);
		return "redirect:/";
	}
	@RequestMapping("/edit")
    public ModelAndView editBookForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_book");
        Book book = bookService.get(id);
        mav.addObject("book", book);
     
        return mav;
    }
	@RequestMapping("/delete")
    public String deleteBook(@RequestParam long id) {
        bookService.delete(id);
        return "redirect:/";       
    }


}
