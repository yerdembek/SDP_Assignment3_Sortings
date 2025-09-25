import java.nio.file.*;
import java.util.*;

class NewAPI {
    public String readUsersJSON(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (Exception e) {
            e.printStackTrace();
            return "[]";
        }
    }
}

