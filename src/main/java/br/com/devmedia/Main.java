package br.com.devmedia;

import br.com.devmedia.model.ItemVenda;
import br.com.devmedia.model.TipoVenda;
import br.com.devmedia.model.Venda;

import javax.validation.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        //Obtendo uma instancia de Validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Testando ItemVenda
        ItemVenda item = new ItemVenda(); //Obtendo a instancia criada
        item.setDescricao("Camisa Masculina M");
        item.setPreco(1F);
        item.setQuantidade(1);

        //Testando Venda
        Venda venda = new Venda();
        venda.setData(Calendar.getInstance().getTime());
        venda.setTipo(null);
        venda.setTotal(0);
        venda.setItens(new ArrayList<ItemVenda>(){{
            add(item);
        }});
        /*
         * Observando que a validação esta sendo feita em ambas as classes, devida anotação Valid em venda
         * Primeiro ele valida a classe item, depois utiliza a classe para validar a classe venda
         */


        /*
         * Validação do Item

        //Validando com o metodo validation do BeanValidator
        Set<ConstraintViolation<ItemVenda>>  itemViolation = validator.validate(item);// Metodo Retorna um Set de listas de Violations referente aos erros contido em ItemVenda

        // Com todos erros no List, basta percorrer para que possamos exibir todos os erros encontrados
        // Lambda
        itemViolation.stream().map (constraintViolation -> "Erro: "
                + constraintViolation.getMessage()
                +"["
                + constraintViolation.getRootBeanClass().getSimpleName()
                +","
                + constraintViolation.getPropertyPath()
                +"]"
        ).forEachOrdered(System.out::println);
        System.out.println("Classe ItemVenda Validada com sucesso");
        */



        //Validando o item Venda
        Set<ConstraintViolation<Venda>> VendaViolation = validator.validate(venda);// Metodo Retorna um Set de listas de Violations referente aos erros contido em ItemVenda

        // Com todos erros no List, basta percorrer para que possamos exibir todos os erros encontrados
        // Lambda
        VendaViolation.stream().map (constraintViolation -> "Erro: "
                + constraintViolation.getMessage()
                +"["
                + constraintViolation.getRootBeanClass().getSimpleName()
                +","
                + constraintViolation.getPropertyPath()
                +"]"
        ).forEachOrdered(System.out::println);

    }
}
