package com.perscholasjava.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {
	@Autowired BookRepository bookrepo;
	
	public void save(Book book) {
		bookrepo.save(book);
	}
	
	public List<Book> listAll(){
		return (List<Book>) bookrepo.findAll();
	}
	
	public Book get(Long id) {
		try {
			return bookrepo.findById(id).get();
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void delete(Long id) {
		try {
			bookrepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		
	}

}
