import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        CV cv = new CV();
        String html = cv.generateHtml();
        Path output = Path.of("cv.html");
        try {
            Files.writeString(output, html, StandardCharsets.UTF_8);
            System.out.println("Đã tạo file: " + output.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


