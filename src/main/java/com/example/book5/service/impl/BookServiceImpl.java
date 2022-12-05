package com.example.book5.service.impl;

import java.util.Base64;
import java.util.List;

import com.example.book5.converter.BookConverter;
import com.example.book5.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book5.entity.BookEntity;
import com.example.book5.repository.BookRepository;
import com.example.book5.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookConverter converter;
	
	public List<BookEntity> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public BookEntity save(BookEntity entity) {
		return bookRepository.save(entity);
	}

	@Override
	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}

	@Override
	public BookDto findById(Integer id) {
		return converter.toDto(bookRepository.getById(id));
	}
	
	
}
