package Estrutura_de_Dados.Fila.FilaAtividade;

public class FilaLimite implements IFila {

    //  Atributos
    private No inicio, fim;
    private int qtdNos;
    private final int limiteFila;

    //  Construtor
    public FilaLimite(int limiteFila) {
        this.inicio = null;
        this.fim = null;
        this.qtdNos = 0;
        this.limiteFila = limiteFila;
    }


    //  Métodos

    @Override
    public void incluir(Object valor) throws FilaCheiaException {
        No novo = new No(valor);
        if (estaVazia()) {
            this.inicio = novo;
            this.fim = inicio;
            this.qtdNos++;
        } else if (qtdNos == limiteFila) {
            throw new FilaCheiaException("A Fila está cheia!");
        } else {
            this.fim.setProximo(novo);
            this.fim = novo;
            this.qtdNos++;
        }
    }

    @Override
    public Object remover() throws FilaVaziaException {
        if (estaVazia())
            throw new FilaVaziaException("A fila já está vazia!");
        this.inicio = inicio.getProximo();
        this.qtdNos--;
        return inicio.getAnterior();
    }

    @Override
    public int getQtd() {
        return qtdNos;
    }

    @Override
    public int getQtdMaxSuportada() {
        return limiteFila;
    }

    @Override
    public boolean estaVazia() {
        return qtdNos == 0;
    }

    @Override
    public void limpar() {
        this.inicio = null;
    }

    @Override
    public Object visualizarProximo() throws FilaVaziaException {
        if (estaVazia())
            throw new FilaVaziaException("A fila está vazia!");
        return this.inicio.getInfo();
    }
}
