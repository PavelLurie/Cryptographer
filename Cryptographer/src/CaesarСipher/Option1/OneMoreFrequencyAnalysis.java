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
//        System.out.print("Введите путь к файлу, который нужно расшифровать/Enter the path to the file to be decrypted: ");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get("D:\\test.txt");
        String content = Files.readString(path);

//        System.out.print("Введите путь к файлу, который нужно анализировать/Enter the path to the file to be parsed: ");
//        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        Path path1 = Paths.get("D:\\test1.txt");
        String content1 = Files.readString(path1);
        //String line = null;
        Map<Character, Integer> newMap = one(content);
        Map<Character, Integer> newMap1 = one(content1);

        System.out.println(newMap);
        System.out.println(newMap1);


        while (!newMap.isEmpty()){
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
            //System.out.println(maxKey1);
            content = content.replace(maxKey, maxKey1);
            newMap1.remove(maxKey1);
            newMap.remove(maxKey);
        }
        System.out.println(content);
    }
    public static Map<Character, Integer> one(String content) {
        Cryptographer cryptographer = new Cryptographer();
        Map<Character, Integer> chars = new HashMap<>();
        String alphabet = cryptographer.getAlphabet();
        char [] alphabetChar = alphabet.toCharArray();

        char[] array = content.toCharArray();

        for (int i = 0; i < alphabetChar.length; i++) {
            int index = 0;
            for (int j = 0; j < array.length; j++) {
                if (alphabetChar[i] == array[j]){
                    index++;
                    chars.put(alphabetChar[i], index);
                }
            }
        }
        return chars;
    }

//    public static char two(String content){
//        Map<Character, Integer> newMap = one(content);
//        Character maxKey = null;
//        for (Character key : newMap.keySet()) {
//            if (maxKey == null || newMap.get(key) > newMap.get(maxKey)) {
//                maxKey = key;
//            }
//        }return maxKey;
//    }
}

//Цчпилщ#упч\