package br.com.servicex.categoria.services;

import br.com.servicex.categoria.domain.Categoria;
import br.com.servicex.categoria.repositories.CategoriaRepository;
import br.com.servicex.servico.domain.Servico;
import br.com.servicex.servico.repositories.ServicoRepository;
import br.com.servicex.servico.services.ServicoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceTest {
    @InjectMocks
    private CategoriaService categoriaService;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Test
    public void testCriarCategoria_Sucess(){
        Categoria categoria = new Categoria();
        categoria.setNomeCategoria("Nova Categoria");

        //MONTANDO CENARIO
        when(categoriaRepository.existsByNomeCategoria(categoria.getNomeCategoria())).thenReturn(false);
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        //EXECUTANDO
        Categoria result = categoriaService.criarCategoria(categoria);

        //VALIDANDO
        assertNotNull(result);
        assertNotNull(result);
        assertEquals("Nova Categoria", result.getNomeCategoria());
        verify(categoriaRepository).existsByNomeCategoria(categoria.getNomeCategoria());
        verify(categoriaRepository).save(any(Categoria.class));
    }

    @Test
    public void testDeletarCategoria_Sucess(){
        Integer id = 1;
        doNothing().when(categoriaRepository).deleteById(id);
        // doNothing().when(categoriaService).buscarCategoriaPorId(id);
        // doNothing().when(categoriaService).buscarCategoriaPorId(id);

        categoriaService.deletarCategoria(id);

        verify(categoriaRepository).deleteById(id);
        verify(categoriaService).buscarCategoriaPorId(id);
    }
}

