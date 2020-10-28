package Estrutura_de_Dados.Fila.FilaAtividade;

public class Fila implements IFila {
    //  Atributos
    private No inicio, fim;
    private int qtdNos;

    //  Construtor
    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.qtdNos = 0;
    }

    //  Método
    @Override
    public void incluir(Object valor) throws FilaCheiaException {
        No novo = new No(valor);
        if (estaVazia()) {
            this.inicio = novo;
            this.fim = novo;
            this.qtdNos++;
        } else if(qtdNos == Integer.MAX_VALUE) {
            throw new FilaCheiaException("A Fila está cheia!");
        } else {
            this.fim.setProximo(novo);
            this.fim = novo;
            this.qtdNos++;
        }
    }

    @Override
    public Object remover() throws FilaVaziaException {
        if (estaVazia()) throw new FilaVaziaException("A fila já está vazia!");
        this.inicio = inicio.getProximo();
        this.qtdNos--;
        return this.inicio.getAnterior();
    }

    @Override
    public int getQtd() {
        return qtdNos;
    }

    @Override
    public int getQtdMaxSuportada() {
        return Integer.MAX_VALUE;
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
