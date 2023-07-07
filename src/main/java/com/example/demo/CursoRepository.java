package com.example.demo;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called CursoRepository
// CRUD refers Create, Read, Update, Delete

public interface CursoRepository extends CrudRepository<Curso, Integer> {
}
