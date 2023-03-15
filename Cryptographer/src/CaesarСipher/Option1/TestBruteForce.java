package CaesarСipher.Option1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class TestBruteForce {
    private Cryptographer cryptographer = new Cryptographer();
    private Scanner scanner = new Scanner(System.in);


    public void main() throws IOException {
        TestBruteForce testBruteForce = new TestBruteForce();
        testBruteForce.bruteforce();
    }

    public void bruteforce() throws IOException {
        System.out.println("Введите путь к файлу, который нужно расшифровать");
        String line = scanner.nextLine();
        Path path = Paths.get(line);

        String content = Files.readString(path); // Чем эта запись отличается от записи ниже
        // String content = Files.readString(Paths.get(Objects.requireNonNull(path).toUri())); в классе Encoder в строке №23 и в классе Decoder в строке №21?

        System.out.println("Куда записать расшифрованный текст?");
        String pathToDecryptedFile = scanner.nextLine();

        // запросить у пользователя путь к зашифрованному тексту. Спросить куда записать расшифрованный текст
        // Открыть рерус для чтения. Счиать весь текст как единое сообщение.

        BufferedWriter bw = Files.newBufferedWriter(Paths.get(pathToDecryptedFile));
        for (int i = 0; i < cryptographer.alphabetLength(); i++) {
            String decrypt = cryptographer.decrypt(cryptographer.getAlphabet(), content, i);
            if (isValidateText(decrypt)){
                bw.write(decrypt);
                bw.close();
                System.out.println("Содержимое расшифровано. Ключ равен " + i);
                break;
                // понять почему пропадает символ переноса строки.
            }
        }
    }
    
    private boolean isValidateText(String text){
        boolean isValidate = false;
        for (String word : text.split(" ")) {
            if (word.length() > 28){
                return false;
            }
        }

        if (text.contains(". ") || text.contains(", ") || text.contains("! ") || text.contains("? ")){
            isValidate = true;
        }

        while(isValidate){
            System.out.println(text + System.lineSeparator() + "Понятен ли данный текст? Y/N");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")){
                return true;
            }else if (answer.equalsIgnoreCase("n")){
                isValidate = false;
            }else {
                System.out.println("Выбор только Y или N");
            }
        }
        return false;
    }
    
}
