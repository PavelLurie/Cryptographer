package CaesarСipher.Option2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Сipher {
    public static void main(String[] args) throws IOException {
        String path = "D:\\test12.txt\\";
        String content = null;
        try {
            content = Files.readString(Paths.get(path));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        assert content != null;

        Path path1 = Path.of("D:\\test2.txt\\");
        Files.writeString(path1, encryptedString(content));
    }

    public static String encryptedString(String line) {
        ArrayList<Character> alphabetList = new ArrayList<>();
        alphabetList.add('.');
        alphabetList.add(',');
        alphabetList.add('"');
        alphabetList.add(':');
        alphabetList.add('-');
        alphabetList.add('!');
        alphabetList.add('?');
        alphabetList.add(' ');
        for (char i = 'А'; i <= 'я' ; i++) {
            alphabetList.add(i);
        }

        ArrayList<Character> StringList = new ArrayList<>();
        ArrayList<Character> newStringList = new ArrayList<>();
        int key = 4;

        for (int i = 0; i < line.length(); i++) {
            StringList.add(line.charAt(i));
        }

        for (int i = 0; i < StringList.size(); i++) {
            for (int j = 0; j < alphabetList.size(); j++) {
                if (StringList.get(i).equals(alphabetList.get(j))){
                    try {
                        newStringList.add(alphabetList.get(j + key));
                    }
                    catch (Exception e) {
                        for (int k = key; k < key - 1; k++) {
                            newStringList.add(alphabetList.get(k));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < newStringList.size(); i++) {
            sb.append(newStringList.get(i));
        }
        return sb.toString();
    }
}