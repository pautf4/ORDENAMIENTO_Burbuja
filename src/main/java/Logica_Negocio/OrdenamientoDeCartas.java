/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica_Negocio;

/**
 *
 * @author PC
 */
import java.util.ArrayList;

class Carta implements Comparable<Carta> {
    private String palo;
    private int valor;

    public Carta(String palo, int valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }

    @Override
    public int compareTo(Carta otra) {
        if (this.palo.equals(otra.palo)) {
            return Integer.compare(this.valor, otra.valor);
        } else {
            return this.palo.compareTo(otra.palo);
        }
    }
}

public class OrdenamientoDeCartas {

    public static void ordenarCartas(ArrayList<Carta> cartas) {
        boolean ordenado;
        do {
            ordenado = true;
            for (int i = 0; i < cartas.size() - 1; i++) {
                if (cartas.get(i).compareTo(cartas.get(i + 1)) > 0) {
                    // Intercambiar cartas
                    Carta temp = cartas.get(i);
                    cartas.set(i, cartas.get(i + 1));
                    cartas.set(i + 1, temp);
                    ordenado = false;
                }
            }
        } while (!ordenado);
    }

    public static void main(String[] args) {
        ArrayList<Carta> mano = new ArrayList<>();
        mano.add(new Carta("Corazones", 2));
        mano.add(new Carta("Picas", 14));  // As de picas
        mano.add(new Carta("Diamantes", 11));  // Jota de diamantes
        mano.add(new Carta("Corazones", 10));
        mano.add(new Carta("Tréboles", 7));

        System.out.println("Mano desordenada: " + mano);

        ordenarCartas(mano);

        System.out.println("Mano ordenada: " + mano);
    }
}