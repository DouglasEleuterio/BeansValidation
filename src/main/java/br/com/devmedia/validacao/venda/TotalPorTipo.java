package br.com.devmedia.validacao.venda;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE) // Onde pode ser colocada, se type vai anotar um tipo, anotar em cima da classe que vai ser anotada
@Retention(RetentionPolicy.RUNTIME)//Ate que momento estes metadados estarão disponiveis, Runtime Disponiveis durante a execução do programa
@Constraint(validatedBy = {TotalPorTipoValidator.class})// Qual classe de fato vai implementar a validação
@Documented

public @interface TotalPorTipo {

    //Passando mensagem Globais e internacionalização
    String message () default "{br.com.devmedia.model.Venda.TIPO}";

    Class<?> [] groups () default {};//Pode ser anotada apenas para um grupo determinado de classes

    Class<? extends Payload> [] payload() default {};//Adicionar metadados a validação, por exemplo tipo Warning, Alert ....
}
