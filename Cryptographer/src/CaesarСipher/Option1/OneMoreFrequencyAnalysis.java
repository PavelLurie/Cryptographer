package CaesarСipher.Option1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class OneMoreFrequencyAnalysis {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("D:\\test.txt");
        String content = Files.readString(path);

        Path path1 = Path.of("D:\\test1.txt");
        String content1 = Files.readString(path1);

        Map<Character, Integer> newMap = tree(content);
        Map<Character, Integer> newMap1 = tree(content1);
        char temp = '^';
        String line = null;

        while (!newMap.isEmpty()) {
            Character maxKey = null;
            for (Character key : newMap.keySet()) {
                if (maxKey == null || newMap.get(key) > newMap.get(maxKey)) {
                    maxKey = key;
                }
            }

            Character maxKey1 = null;
            for (Character key1 : newMap1.keySet()) {
                if (maxKey1 == null || newMap1.get(key1) > newMap1.get(maxKey1)) {
                    maxKey1 = key1;
                }
            }

            line = content.replace(maxKey, temp);
            newMap.remove(maxKey);

            content = line.replace(temp, maxKey1);
            newMap1.remove(maxKey1);

        }

        //System.out.println(content);
        System.out.println();

    }

    public static Map<Character, Integer> tree(String content) {
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : content.toCharArray()) {
            if (!map.containsKey(aChar)) {
                map.put(aChar, 1);
            } else {
                map.put(aChar, map.get(aChar) + 1);
            }
        }
        map.remove('\n');
        return map;
    }

}