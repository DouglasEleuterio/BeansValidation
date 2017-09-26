package br.com.devmedia.model;

import br.com.devmedia.validacao.venda.TotalPorTipo;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

//Criaremos uma anotation para validar algumas regras epecificas
@TotalPorTipo// (message = "O tipo não permite valor informado") //Retornaremos a mensagem criada na anotation, sobrescrevendo a mensagem definida na string
public class Venda {

    @NotNull(message = "A lista de Itens não pode ser nula")
    @Size(min = 1, message = "A çista de itens deve conter pelo menos um item") /* Pelo menos um item */
    @Valid // Os itens precisam ser válidos, Validação Recursiv, Para validar a Classe venda (Essa que estamos) Todas as validações dos itens da classe iten venda serão validados
    private List<ItemVenda> itens;

    @NotNull(message = "A data da venda não pode ser nula")
    private Date data;

    /*
     * Se a venda for Brinde, será 0
     * Se a venda for normal, será >= 0,01
     */
    // Não conseguimos uma anotação com um simples If interno.
    @DecimalMin(value = "0", message = "O valor da venda deve ser igual ou maior a R$ 0,01")
    private float total;

    @NotNull
    private TipoVenda tipo;

    public Venda() {
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public TipoVenda getTipo() {
        return tipo;
    }

    public void setTipo(TipoVenda tipo) {
        this.tipo = tipo;
    }
}
