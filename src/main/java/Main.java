import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(MapWorks.factorsToCount(450));
        Map<String, String> dictionaryMap = new HashMap<>();
        dictionaryMap.put("12", "34");
        dictionaryMap.put("56", "78");
        System.out.println(MapWorks.parsedDictionary(dictionaryMap));
        Map<String,String> stripMap = new HashMap<>();
        stripMap.put("A","E");
        stripMap.put("B","K");
        stripMap.put("C","F");
        stripMap.put("D","E");
        MapWorks.stripDuplicates(stripMap);
        System.out.println(stripMap);
        Map<String,String> varargMap1 = new HashMap<>();
        Map<String,String> varargMap2 = new HashMap<>();
        varargMap1.put("1","2");
        varargMap1.put("3","4");

        varargMap2.put("1","3");
        varargMap2.put("4","5");
        System.out.println(MapWorks.joined(varargMap1, varargMap2));

    }
}
