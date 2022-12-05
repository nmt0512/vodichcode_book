package com.example.book5.service;

import java.util.List;

import com.example.book5.dto.BookDto;
import com.example.book5.entity.BookEntity;

public interface BookService {
	List<BookEntity> findAll();
	BookEntity save(BookEntity entity);
	void deleteBook(Integer id);
	BookDto findById(Integer id);
}
