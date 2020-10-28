package Estrutura_de_Dados.Fila.FilaAtividade;

public class No {
    // Atributos
    private Object info;
    private No proximo;
    private No anterior;

    // Construtor
    public No(Object info) {
        this.info = info;
        this.proximo = null;
        this.anterior = null;
    }

    // Metodos
    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}
