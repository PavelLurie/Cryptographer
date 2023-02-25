package CaesarСipher.Option1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static void main(String[] args) throws IOException {
        Encoder encoder = new Encoder();
        Decoder decoder = new Decoder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("""
                    Выбирите действие, введя его номер:
                    1 - Зашифровать текст
                    2 - Расшивровать текст
                    3 - Подобрать ключ (Brute force)
                    4 - Расшифровать текст с помощью статического анализа
                    5 - Выйти из программы""");
            String answer = br.readLine();
            switch (answer) {
                case "1" -> encoder.main();
                case "2" -> decoder.main();
                case "3" -> System.out.println("Подобрать ключ");
                case "4" -> System.out.println("Стат.анализ");
                case "5" -> {
                    return;
                }
            }
        }
    }
}
