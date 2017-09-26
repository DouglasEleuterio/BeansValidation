package br.com.devmedia.validacao.venda;

import br.com.devmedia.model.TipoVenda;
import br.com.devmedia.model.Venda;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//Nesta classe implementaremos a validação, por isso precisa implementar um ConstraintValidator
public class TotalPorTipoValidator  implements ConstraintValidator<TotalPorTipo, Venda>{ // (Venda) Classe que estamos validando

    // Não vem ao nosso caso
    @Override
    public void initialize(TotalPorTipo totalPorTipo) {

    }

    //Implementaremos a regra de validação
    @Override
    public boolean isValid(Venda venda, ConstraintValidatorContext context) { // Ele recebe a venda e montamos um contexto de validação
    //Customizaremos as definições

        if (venda == null){ // Se a venda for nulo já mato ela.
            return false;
        }

        boolean valido = false; // Instancio o valido do tipo boolean e instancio para false para não correr risco

        if (venda.getTipo() == TipoVenda.VendaProduto && venda.getTotal() > 0 ){
            valido = true;
        }

        if (venda.getTipo() == TipoVenda.VendaBrinde && venda.getTotal() == 0) {
            valido = true;
        }

        /*
         * Se não conseguimos validar, e gerado uma mensagem de erro pouco generica.
         * Erro: Valor inválido para o tipo da venda.[Venda,]
         * Para tratar melhor essa mensagem e informar o ponto a ser corrigido, implementaremos o Context
         */
        if (!valido){
            context.disableDefaultConstraintViolation(); // Desabilido o Consutrutor do Constrant Violatione construo um novo
            context
                    .buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()) // Pego a mensagem desse novo Contexto, que está associada na nossa Anotation
                    //Crio o template com estes dados

                    //Com o template em mãos
                    // adiciono o nome da propriedade "Tipo(String)" e adiciono o constrantViolation
                    .addPropertyNode("tipo").addConstraintViolation();
        }

        return valido;
    }
}
