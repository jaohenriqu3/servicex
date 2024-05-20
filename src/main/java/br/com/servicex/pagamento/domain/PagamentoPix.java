package br.com.servicex.pagamento.domain;

import br.com.servicex.ordemServico.domain.OrdemServico;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonTypeName("pagamentoPix")
public class PagamentoPix extends Pagamento{
    private static final long serialVersionUID = 1L;

    @Column(name = "CHAVE_PIX")
    private String chavePix;

    public PagamentoPix(){}

    public PagamentoPix(Integer idPagamento, StatusPagamento statusPagmento, OrdemServico ordemServico, String chavePix) {
        super(idPagamento, statusPagmento, ordemServico);
        this.chavePix = chavePix;
    }

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }
}
