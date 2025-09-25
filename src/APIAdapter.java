import java.util.*;
import java.util.regex.*;

class APIAdapter implements OldAPI {
    private NewAPI newAPI;

    public APIAdapter(NewAPI newAPI) {
        this.newAPI = newAPI;
    }

    @Override
    public String getUsersXML(String filePath) {
        String json = newAPI.readUsersJSON(filePath);
        List<User> users = parseUsers(json);
        return buildXML(users);
    }

    // очень простой парсер JSON массива [{...},{...}]
    private List<User> parseUsers(String json) {
        List<User> users = new ArrayList<>();
        Pattern p = Pattern.compile("\\{\\s*\"id\"\\s*:\\s*(\\d+),\\s*\"name\"\\s*:\\s*\"([^\"]+)\",\\s*\"email\"\\s*:\\s*\"([^\"]+)\"\\s*}");
        Matcher m = p.matcher(json);
        while (m.find()) {
            int id = Integer.parseInt(m.group(1));
            String name = m.group(2);
            String email = m.group(3);
            users.add(new User(id, name, email));
        }
        return users;
    }

    // строим XML строку вручную
    private String buildXML(List<User> users) {
        StringBuilder sb = new StringBuilder();
        sb.append("<users>\n");
        for (User u : users) {
            sb.append("  <user>\n");
            sb.append("    <id>").append(u.getId()).append("</id>\n");
            sb.append("    <name>").append(u.getName()).append("</name>\n");
            sb.append("    <email>").append(u.getEmail()).append("</email>\n");
            sb.append("  </user>\n");
        }
        sb.append("</users>");
        return sb.toString();
    }
}

