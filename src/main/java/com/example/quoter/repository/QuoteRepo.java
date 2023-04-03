package com.example.quoter.repository;

import com.example.quoter.entity.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepo extends CrudRepository<Quote, Long> {
}
