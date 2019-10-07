import java.util.*;

public class MapWorks {

    /**
     * Keine Objekte erwuenscht.
     */
    private MapWorks() {
        throw new AssertionError("No objects allowed");
    }

    /**
     * Berechnet eine Liste mit den Primfaktoren einer Zahl.
     *
     * @param number Positive Zahl.
     * @return Liste der Primfaktoren in aufsteigender Groesse. Leer bei number = 1.
     * @throws IllegalArgumentException wenn die Zahl kleiner als 1 ist.
     */
    public static List<Integer> getFactors(int number) {
        if (number < 1)
            throw new IllegalArgumentException();
        final List<Integer> factors = new ArrayList<>();
        int factor = 2;
        int rest = number;
        while (rest > 1)
            if (rest % factor == 0) {
                factors.add(factor);
                rest /= factor;
            } else
                factor++;
        return factors;
    }

    /**
     * Zerlegt eine Zahl in Primafaktoren und liefert einen Map,
     * die jeden Primfaktor auf die Anzahl der Vorkommen abbildet.
     *
     * @param number Eine ganze, positive Zahl.
     * @return Abbildung von Primfaktoren auf die Anzahl der Vorkommen.
     * Leer, wenn die Zahl kleiner als 2 ist;
     * @throws IllegalArgumentException wenn die Zahl kleiner als 1 ist.
     */
    public static Map<Integer, Integer> factorsToCount(int number) {
        if (number < 1) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> aList = getFactors(number);

        for (int index = 0; index < aList.size(); index++) {
            if (map.containsKey(aList.get(index))) {
                map.put(aList.get(index), map.get(aList.get(index)) + 1);
            } else {
                map.put(aList.get(index), 1);
            }
        }
        return map;
    }

    /**
     * Konvertiert alle Keys und Values einer gegebenen Map in ganze Zahlen und
     * baut daraus eine neue Map auf.
     *
     * @param dictionary Abbildung von Strings auf Strings.
     *                   Alle Keys und Values muessen ganze Zahlen enthalten.
     * @return Neue Map, die Zahlen auf Zahlen abbildet.
     * @throws IllegalArgumentException wenn ein Key doppelt vorkommt.
     * @throws NumberFormatException    wenn ein Key oder Value keine Zahl ist.
     * @see Integer#parseInt(String)
     */
    public static Map<Integer, Integer> parsedDictionary(Map<String, String> dictionary) {
        Map<Integer, Integer> parsedMap = new HashMap<>();

        for (Map.Entry<String, String> each : dictionary.entrySet()) {
            if (parsedMap.containsKey(each.getKey())) {
                throw new IllegalArgumentException("Double key");
            }
            try {
                parsedMap.put(Integer.parseInt(each.getKey()), Integer.parseInt(each.getValue()));
            } catch (Exception ex) {
                throw new NumberFormatException("Key or value is no number");
            }
        }
        return parsedMap;
    }

    /**
     * Entfernt aus einer Map alle Eintraege, deren Werte mehr als einmal vorkommen.
     *
     * @param dictionary Eine Abbildung von Strings auf Strings,
     *                   die diese Methode eventuell kuerzt.
     *                   Nachher kommt jeder Wert nur einmal vor.
     */
    public static void stripDuplicates(Map<String, String> dictionary) {
        Map<String, String> stripMap = new HashMap<>();

        for (Map.Entry<String, String> each : dictionary.entrySet()) {
            stripMap.put(each.getValue(), each.getKey());
        }
        dictionary.clear();
        for (Map.Entry<String, String> each : stripMap.entrySet()) {
            dictionary.put(each.getValue(), each.getKey());
        }
    }


    /**
     * Uebertraegt die Eintraege aller gegebenen Maps in eine neue Map.
     * Bildet jeden Schluessel auf die Menge aller Werte ab, die in den gegebenen Maps vorkommen.
     *
     * @param dictionaries Maps.
     * @return Neue Map mit allen Schluessel der dictionaries.
     * Enthaelt zu jedem Schluessel alle Werte, die in den dictionaries vorkommen.
     */
    public static Map<String, Set<String>> joined(Map<String, String>... dictionaries) {
        Map<String, Set<String>> joinedMap = new HashMap<>();
        Set<String> newSet;
        for (int indexDictionaries = 0; indexDictionaries < dictionaries.length; indexDictionaries++) {
            for (Map.Entry<String, String> each : dictionaries[indexDictionaries].entrySet()) {
                System.out.println(each);
                if (!joinedMap.containsKey(each.getKey())) {
                    newSet = new HashSet<>();
                    joinedMap.put(each.getKey(), newSet);
                    joinedMap.get(each.getKey()).add(each.getValue());
                }
                joinedMap.get(each.getKey()).add(each.getValue());
            }
        }
        return joinedMap;
    }
}
