import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordCounter {

    public static void main(String[] args) {
        System.out.print("Enter text: ");
        Map<String, Integer> wordsMap = putToMap(readTextFromConsole());
        printMap(sortByValue(wordsMap));
    }

    private static void printMap(Map<String, Integer> sortedMap) {
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println("Word: " + entry.getKey() + ", number of usage: " + entry.getValue());
        }
    }

    private static Map<String, Integer> putToMap(String text) {
        String[] splittedText = text.split(" ");
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : splittedText) {
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }
        return wordsMap;
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                return (e2.getValue()).compareTo(e1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    private static String readTextFromConsole() {
        //  open up standard input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = null;

        try {
            text = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }
        return text == null ? "" : text;
    }

}
