package com.example.book5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book5.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {
	
}
