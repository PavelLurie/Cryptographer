package CaesarСipher.Option1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FrequencyAnalysis {
    public static void main(String[] args) throws IOException {
        System.out.print("Введите путь к файлу, который нужно расшифровать/Enter the path to the file to be decrypted: ");
        String content = tree();

        System.out.print("Введите путь к файлу, который нужно анализировать/Enter the path to the file to be parsed: ");
        String content1 = tree();

        char begin = two(content);
        char end = two(content1);

        System.out.println(one(content1));
        System.out.println(one(content1).size());

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

        System.out.println(cryptographer.decrypt(cryptographer.getAlphabet(), content, key));
        System.out.println("Ключ шифрования: " + key);

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

    public static String tree() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());
        return Files.readString(path);
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
