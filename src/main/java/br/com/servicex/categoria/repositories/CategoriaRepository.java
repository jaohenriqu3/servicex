package br.com.servicex.categoria.repositories;

import br.com.servicex.categoria.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Categoria findByServicos_IdServico(Integer idServico);
    boolean existsByNomeCategoria(String nome);
}

