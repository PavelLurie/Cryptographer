package CaesarСipher.Option1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Draft {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("D:\\tets.txt\\");
        String content = Files.readString(path);

        System.out.println(content);

        Path path1 = Path.of("D:\\test.txt\\");
        String content1 = Files.readString(path1);

        Map<Character, Integer> newMap = one(content);
        Map<Character, Integer> newMap1 = one(content1);

        System.out.println(newMap.entrySet());
        System.out.println(newMap1.entrySet());
        System.out.println();
        //String line = null;

        while (!newMap.isEmpty()) {
            Character maxKey = null;
            for (Character key : newMap.keySet()) {
                if (maxKey == null || newMap.get(key) > newMap.get(maxKey)) {
                    maxKey = key;
                }
            }
            Character maxKey1 = null;
            for (Character key : newMap1.keySet()) {
                if (maxKey1 == null || newMap1.get(key) > newMap1.get(maxKey1)) {
                    maxKey1 = key;

                }
            }
            content = content.replace(maxKey, maxKey1);
            //System.out.println(content);
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

//        for (char aChar : content.toCharArray()) {
//            if (!chars.containsKey(aChar)) {
//                chars.put(aChar, 1);
//            } else {
//                chars.put(aChar, chars.get(aChar) + 1);
//            }

            //chars.merge(aChar, 1, Integer::sum);
        return chars;
    }
}



//Сформировать образ бренда.
//вваСтССазо.е абСон бСмфиод
