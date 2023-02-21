package CaesarСipher.Option1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class Decoder {
    static String alphabet = null;
    static String path = null;
    static int key;
    public static void main(String[] args) throws IOException {

        Decoder decoder = new Decoder();
        Cryptographer cryptographer = new Cryptographer();
        decoder.enterAlphabet();
        alphabet = Files.readString(Paths.get(path));

        decoder.enterKey();

        String content = Files.readString(Paths.get(Objects.requireNonNull(enterPath()).toUri()));

        Path path1 = Path.of("d:\\Decrypted file.txt\\");
        Files.writeString(path1, cryptographer.decrypt(alphabet, content, key));

        System.out.println("Программа расшифровала файл/The program decrypted the file");

    }
    public void enterAlphabet() throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите алфавит/Choose an alphabet: ");
        String languageSelection = scanner.nextLine().toLowerCase();

        if (languageSelection.equals("english")) {
            EnglishAlphabet englishAlphabet = new EnglishAlphabet();
            path = String.valueOf(englishAlphabet.englishAlphabet());
        } else if (languageSelection.equals("русский")){
            RussianAlphabet russianAlphabet = new RussianAlphabet();
            path = String.valueOf(russianAlphabet.russianAlphabet());
        }else {
            System.out.println("Поддерживается русский и english алфавит/Russian and English alphabets are supported");
            enterAlphabet();
        }
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
        System.out.print("Введите путь к файлу, который нужно расшифровать/Enter the path to the file to be decrypted: ");
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
