package br.com.cielo.bootcampdesafio03.data_structure;

public class Fila<T> {
    private T[] array;
    private int tamanho;
    private int capacidade;
    private int frente;
    private int traseira;

    public Fila() {
        this.capacidade = 10;
        this.array = (T[]) new Object[capacidade];
        this.tamanho = 0;
        this.frente = 0;
        this.traseira = -1;
    }

    public void inserir(T item) {
        if (tamanho == capacidade) {
            redimensionarArray();
        }

        traseira = (traseira + 1) % capacidade;
        array[traseira] = item;
        tamanho++;
    }

    public T remover() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }

        T itemRemovido = array[frente];
        frente = (frente + 1) % capacidade;
        tamanho--;
        return itemRemovido;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public void atualizar(T item) {
        for (int i = frente; i <= traseira; i++) {
            if (array[i].equals(item)) {

                for (int j = i; j < traseira; j++) {
                    array[j] = array[j + 1];
                }
                array[traseira] = item;
                return;
            }
        }

        inserir(item);
    }

    private void redimensionarArray() {
        int novaCapacidade = capacidade * 2;
        T[] novoArray = (T[]) new Object[novaCapacidade];

        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = array[(frente + i) % capacidade];
        }

        array = novoArray;
        frente = 0;
        traseira = tamanho - 1;
        capacidade = novaCapacidade;
    }


    public T[] toArray() {
        T[] result = (T[]) new Object[tamanho];
        int index = 0;

        for (int i = frente; i <= traseira; i++) {
            result[index++] = array[i];
        }

        return result;
    }



    @Override
    public String toString() {
        if (isEmpty()) {
            return "A fila está vazia.";
        } else {
            StringBuilder builder = new StringBuilder("Elementos na fila: ");
            for (int i = frente; i <= traseira; i++) {
                builder.append(array[i]).append(" ");
            }
            return builder.toString();
        }
    }



}