package br.com.cielo.bootcampdesafio02.data_structure;

import static org.junit.jupiter.api.Assertions.*;

import br.com.cielo.bootcampdesafio02.data_structure.Fila;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilaTest {

    private Fila<Integer> fila;

    @BeforeEach
    public void setUp() {
        fila = new Fila<>();
    }

    @Test
    public void testInserir() {
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);

        assertEquals(3, fila.tamanho());
    }

    @Test
    public void testRemover() {
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);

        int itemRemovido = fila.remover();

        assertEquals(1, itemRemovido);
        assertEquals(2, fila.tamanho());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(fila.isEmpty());

        fila.inserir(1);

        assertFalse(fila.isEmpty());
    }

    @Test
    public void testTamanho() {
        assertEquals(0, fila.tamanho());

        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);

        assertEquals(3, fila.tamanho());
    }

    @Test
    public void testAtualizar() {
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);

        fila.atualizar(2);

        assertEquals(1, fila.remover());
        assertEquals(3, fila.remover());
        assertEquals(2, fila.remover());
    }


    @Test
    public void testToArray() {
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);

        assertEquals(1, fila.remover());
    }



    @Test
    public void testToString() {
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);

        String expected = "Elementos na fila: 1 2 3 ";
        String result = fila.toString();

        assertEquals(expected, result);
    }
}