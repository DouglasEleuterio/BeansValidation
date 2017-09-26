package br.com.devmedia.model;

public enum TipoVenda {

    /*
     * Implementar a regra, onde:
     * Se o tipo de venda for Brinde, o valor pode ser menor que 0,01
     *
     */
    VendaBrinde("Brinde"),
    VendaProduto("Padrão");

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    TipoVenda(String tipo) {
        this.tipo = tipo;
    }
}
