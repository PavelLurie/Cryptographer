package CaesarСipher.Option1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class Encoder {
    static int key;
    public void main() throws IOException {

        Encoder encoder = new Encoder();
        Cryptographer cryptographer = new Cryptographer();

        encoder.enterKey();

        String content = Files.readString(Paths.get(Objects.requireNonNull(enterPath()).toUri()));

        Path path1 = Path.of("d:\\Encrypted file.txt\\");
        Files.writeString(path1, cryptographer.encryptedString(cryptographer.getAlphabet(), content, key));

        System.out.println("Программа зашифровала файл/The program encrypted the file");

    }
    public void enterKey() {
        System.out.print("Введите ключ шифрования/Enter the encryption key: ");
        Scanner scanner = new Scanner(System.in);
        int tempKey;
        try {
            tempKey = scanner.nextInt();
            if (tempKey == 0) {
                System.out.println("Ключ шифрования должен быть отличным от нуля");
                enterKey();
            } else {
                key = tempKey;
            }
        } catch (Exception e){
            System.out.println("Вводить нужно только цифры/Need to entering only numbers");
            enterKey();
        }
    }
    public static Path enterPath() throws IOException {
        System.out.print("Введите путь к файлу, который нужно зашифровать/Enter the path to the file to be encrypted: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path1 = Paths.get(reader.readLine());

        if (Files.exists(path1)){
            return path1;
        } else {
            System.out.println("Программа не нашла файл. Проверьте путь к файлу/The program did not find the file. Check the file path.");
            return enterPath();
        }
    }
}
