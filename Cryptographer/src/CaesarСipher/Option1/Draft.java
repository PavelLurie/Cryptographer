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

        Path path1 = Path.of("D:\\test12.txt\\");
        String content1 = Files.readString(path1);

        char begin = two(content);
        char end = two(content1);

        Cryptographer cryptographer = new Cryptographer();
        String alphabet = cryptographer.getAlphabet();

        int temp = 0;
        int temp1 = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == begin){
                temp = i;
            }else if (alphabet.charAt(i) == end){
                temp1 = i;
            }
        }
        int key = temp - temp1;

        System.out.println(key);

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
        public static char two(String content){
        Map<Character, Integer> newMap = one(content);
        Character maxKey = null;
        for (Character key : newMap.keySet()) {
            if (maxKey == null || newMap.get(key) > newMap.get(maxKey)) {
                maxKey = key;
            }
        }return maxKey;
    }
}



//Сформировать образ бренда.
//вваСтССазо.е абСон бСмфиод
//        for (char aChar : content.toCharArray()) {
//            if (!chars.containsKey(aChar)) {
//                chars.put(aChar, 1);
//            } else {
//                chars.put(aChar, chars.get(aChar) + 1);
//            }

//chars.merge(aChar, 1, Integer::sum);
