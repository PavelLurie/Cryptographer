package CaesarСipher.Option1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RussianAlphabet  {
    public Path russianAlphabet() throws IOException {
        File ruAlphabet = new File("D:\\Russian alphabet.txt\\");
        String line = ".,\":-!? АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя";

        Path path1 = Path.of("D:\\Russian alphabet.txt\\");
        Files.writeString(path1, line);
        return path1;
    }
}
