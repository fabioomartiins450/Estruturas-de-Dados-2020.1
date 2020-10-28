package Estrutura_de_Dados.Fila.FilaAtividade;

public class FilaArrayInfinito implements IFila {
    //  Atributos
    private No[] fila;
    private int qtdNos;
    private final int limiteFila;

    //  Construtor
    public FilaArrayInfinito() {
        this.fila = new No[Integer.MAX_VALUE];
        this.qtdNos = 0;
        this.limiteFila = Integer.MAX_VALUE;
    }

    //Métodos
    @Override
    public void incluir(Object valor) throws FilaCheiaException {
        if (qtdNos == fila.length)
            throw new FilaCheiaException("A fila está cheia!");

        No novo = new No(valor);
        this.fila[this.qtdNos] = novo;
        this.qtdNos++;
    }

    @Override
    public Object remover() throws FilaVaziaException {
        if (estaVazia())
            throw new FilaVaziaException("A fila está vazia!");

        No removido = this.fila[0];

        for (int i = 0; i < qtdNos; i++) {
            if (i == qtdNos-1) break;
            this.fila[i] = this.fila[i+1];
        }
        this.qtdNos--;
        fila[qtdNos] = null;
        return removido;
    }

    @Override
    public int getQtd() {
        return this.qtdNos;
    }

    @Override
    public int getQtdMaxSuportada() {
        return this.limiteFila;
    }

    @Override
    public boolean estaVazia() {
        return this.qtdNos == 0;
    }

    @Override
    public void limpar() {
        this.fila = new No[this.limiteFila];
    }

    @Override
    public Object visualizarProximo() throws FilaVaziaException {
        if (estaVazia()) throw new FilaVaziaException("A Fila está vazia!");
        return this.fila[0].getInfo();
    }
}
