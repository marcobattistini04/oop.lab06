package it.unibo.collections;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private final static int ELEMENTS = 100000;
    private final static int READ = 1000;
    private final static long AFRICA_POPULATION = 1110635000L;
    private final static long AMERICAS_POPULATION = 972005000L;
    private final static long ANTARCTICA_POPULATION = 0L;
    private final static long ASIA_POPULATION = 4298723000L;
    private final static long EUROPE_POPULATION = 742452000L;
    private final static long OCEANIA_POPULATION = 38304000L;
    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
          /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
         List<Integer> list = new ArrayList<>();
         for (int i = 1000; i < 2000; i++) {
            list.add(i);
         }

         /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

         List<Integer> list2 = new LinkedList<>();
         list2.addAll(list);

          /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
         int listSize = list.size();
         int temp = list.get(0);
         list.set(0, list.get(listSize - 1));
         list.set(listSize - 1, temp);

          /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        int elementsPrinted = 0;
         for(int elem : list) {
            System.out.print(elem + "   ");
            elementsPrinted ++;
            if(elementsPrinted == 10) {
                System.out.print("\n");
                elementsPrinted = 0;
            }
         }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
         long time = System.nanoTime();
         for (int i = 1; i <= ELEMENTS; i++) {
            list.addFirst(i);
        }

       
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Inserted " + ELEMENTS + " elements at the beginning of the ArrayList.\n" + "It tooked " + 
        time + " ns, (" + millis + " ms)");

        long time2 = System.nanoTime();
        for (int i = 1; i <= ELEMENTS; i++) {
           list2.addFirst(i);
       }
       time2 = System.nanoTime() - time2;
       final var millis2 = TimeUnit.NANOSECONDS.toMillis(time2);
       System.out.println("Inserted " + ELEMENTS + " elements at the beginning of the LinkedList.\n" + "It tooked " + 
       time2 + " ns, (" + millis2 + " ms)");

       /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
     
       time = System.nanoTime();
       for (int i = 1; i <= READ; i++) {
         list.get(list.size()/2);
       }
       time = System.nanoTime() - time;
       final var millis3 = TimeUnit.NANOSECONDS.toMillis(time);
       System.out.println("Read " + READ + " times the element in the middle of the ArrayList.\n" + "It tooked " + 
        time + " ns, (" + millis3 + " ms)");
        
       time = System.nanoTime();
       for (int i = 1; i <= READ; i++) {
         list.get(list2.size()/2);
       }
       time = System.nanoTime() - time;
       final var millis4 = TimeUnit.NANOSECONDS.toMillis(time);
       System.out.println("Read " + READ + " times the element in the middle of the LinkedList.\n" + "It tooked " + 
        time + " ns, (" + millis4 + " ms)");


         /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<String, Long> world = new HashMap<>();
        world.put("Africa", AFRICA_POPULATION);
        world.put("Americas", AMERICAS_POPULATION);
        world.put("Antarctica", ANTARCTICA_POPULATION);
        world.put("Oceania", OCEANIA_POPULATION);
        world.put("Europe", EUROPE_POPULATION);
        world.put("Asia", ASIA_POPULATION);

         /*
         * 8) Compute the population of the world
         */
        long world_population = 0L;
        for(long elem : world.values()) {
            world_population = world_population + elem;
        }

        System.out.println("The world polulation is: " + world_population);

    }
}
