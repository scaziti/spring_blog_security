package org.generation.blogPessoal.repository;

import java.util.List;
import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Informo o tipo de entidade que estou trabalhando e a tipagem do ID (Long primitivo)
@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>
{
	// busca todos pelos pelo titulo, onde o containing seria similar ao 'like' dp MySQL, ignorando se for maísc. ou minusc. 
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
}
