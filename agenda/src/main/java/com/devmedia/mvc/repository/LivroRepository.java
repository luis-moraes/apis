package com.devmedia.mvc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devmedia.mvc.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	/**
	 * Encontra todos os livros de um autor.
	 * 
	 * @param autor
	 * @return lista de livros
	 */
	List<Livro> findByAutor(String autor);
	
	/**
	 * Encontra um livro a partir do seu título. Retorna uma lista pois podem existir
	 * mais de um livro com mesmo título.
	 * 
	 * @param titulo
	 * @return lista de livros
	 */
	List<Livro> findByTitulo(String titulo);
	
	/**
	 * Encontra um livro a partir de seu isbn. 
	 * 
	 * @param isbn
	 * @return livro
	 */
	Livro findByIsbn(String isbn);

}