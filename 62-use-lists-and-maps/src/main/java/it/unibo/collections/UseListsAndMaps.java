package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *          unused
     */
    public static void main(final String... s) {
        /*
         * 1) Crea un nuovo ArrayList<Integer> e popolalo con i numeri
         * da 1000 (incluso) a 2000 (escluso).
         */
        /*
         * 2) Crea una nuova LinkedList<Integer> e, in un'unica riga di codice
         * senza utilizzare alcun costrutto di loop (for, while), popolarlo con
         * stesso contenuto dell'elenco del punto 1.
         */
        /*
         * 3) Usando i metodi "set" e "get" e "size", scambia il primo e l'ultimo
         * elemento della prima lista. Non è possibile utilizzare alcun "numero magico".
         * (Suggerimento: utilizzare una variabile temporanea)
         */
        /*
         * 4) Utilizzando un singolo for-each, stampa il contenuto dell'arraylist.
         */
        /*
         * 5) Misurare la performance dell'inserimento di nuovi elementi nella testata
         * la raccolta: misurare il tempo necessario per aggiungere 100.000 elementi
         * come
         * primo elemento della raccolta sia per ArrayList che per LinkedList,
         * utilizzando gli elenchi precedenti. Per misurare i tempi, utilizzare come
         * esempio
         * TestPerformance.java.
         */
        /*
         * 6) Misurare la prestazione di lettura di 1000 volte un elemento di cui
         * la posizione è al centro della raccolta sia per ArrayList che per
         * LinkedList, utilizzando le raccolte del punto 5. Per misurare
         * volte, utilizzare come esempio TestPerformance.java.
         */
        /*
         * 7) Costruisci una nuova Mappa che associa al nome di ogni continente il suo
         * popolazione:
         *
         * Africa -> 1.110.635.000
         *
         * Americhe -> 972.005.000
         *
         * Antartide -> 0
         *
         * Asia -> 4.298.723.000
         *
         * Europa -> 742.452.000
         *
         * Oceania -> 38.304.000
         */
        /*
         * 8) Calcola la popolazione mondiale
         */

        final int START = 1000;
        final int FINAL = 2000;
        final int INDEX_START = 0;
        final int INDEX_FINAL = 999;
        final int ELEMS = 100000;

        List<Integer> arraList = new ArrayList<>();

        for (int i = START; i < FINAL; i++) {
            arraList.add(i);
        }
        // System.out.println(arraList);

        List<Integer> linkedList = new LinkedList<Integer>();
        linkedList.addAll(arraList);
        System.out.println("  ");
        // System.out.println(linkedList);
        Integer swap = arraList.get(INDEX_START);

        arraList.set(INDEX_START, arraList.get(INDEX_FINAL));
        arraList.set(INDEX_FINAL, swap);
        System.out.println(arraList);

        for (Integer integer : arraList) {
            System.out.println(integer.toString());
        }

        long time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            arraList.add(i);
        }
        // System.out.println(arraList);

        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "Converting "
                        + arraList.size()
                        + " ints to String and inserting them in a Set took "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");
        System.out.println(// NOPMD
                "Converting "
                        + arraList.get(arraList.size() / 2)
                        + " ints to String and inserting them in a Set took "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");
        long time1 = System.nanoTime();

        for (int i = 1; i <= ELEMS; i++) {
            linkedList.add(i);
        }
        time1 = System.nanoTime() - time1;
        final var millis1 = TimeUnit.NANOSECONDS.toMillis(time1);
        System.out.println(// NOPMD
                "Converting "
                        + linkedList.size()
                        + " ints to String and inserting them in a Set took "
                        + time1
                        + "ns ("
                        + millis1
                        + "ms)");
        System.out.println(// NOPMD
                "Converting "
                        + linkedList.get(linkedList.size() / 2)
                        + " ints to String and inserting them in a Set took "
                        + time1
                        + "ns ("
                        + millis1
                        + "ms)");

        final Map<String, Long> Mondo = new HashMap<>();
        Mondo.put("Africa", 1110635000L);
        Mondo.put("Americhe", 972005000L);
        Mondo.put("Antartide", 0L);
        Mondo.put("Asie", 4298723000L);
        Mondo.put("Europe", 742452000L);
        Mondo.put("Oceanie", 38304000L);

        long Word_populations = 0L;
        for (final long population : Mondo.values()) {
            Word_populations += population;
        }
        System.out.println("WORLD POP IS:" + Word_populations);

    }
}
