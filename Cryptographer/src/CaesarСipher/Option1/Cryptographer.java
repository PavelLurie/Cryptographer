package CaesarСipher.Option1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Cryptographer {
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

        Path path1 = Path.of("D:\\test1.txt\\");
        Files.writeString(path1, encryptedString(content));
    }

    public static String encryptedString(String line) {
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        String encryptedLine = "";

        if (key < 0) {
            for (int i = 0; i < line.length(); i++) {
                int temp = (line.charAt(i) + key);
                int num = 1103 - (1103 - temp) % 64;
                encryptedLine += (char) num;
            }
        } else {
            for (int i = 0; i < line.length(); i++) {
                int temp = (line.charAt(i) + key);
                int num = (temp - 1103) % 64 + 1103;
                encryptedLine += (char) num;
            }

        }return encryptedLine;

    }
}