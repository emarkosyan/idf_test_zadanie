package com.emarkosyan.idf_test_zadanie.repository;

import com.emarkosyan.idf_test_zadanie.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
