import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Stirrer {
    public static void main(String[] args) throws IOException {


        String path = "D:\\test.txt\\";
        String content = null;
        try {
            content = Files.readString(Paths.get(path));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        assert content != null;

        Path path1 = Path.of("d:\\test1.txt\\");
        Files.writeString(path1, encryptedString(content));
    }
    public static String encryptedString(String line){
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            list.add(line.charAt(i));
        }

        for (int i = 0; i < list.size(); i+=2) {
            while (i < list.size() - 1){
                list.set(i, list.set(i + 1, list.get(i)));
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == ' ' || list.get(i) == ','){
                list.remove(i);
            }else {
                sb.append(list.get(i));
            }
        }
        return sb.toString().toLowerCase();
    }
}
