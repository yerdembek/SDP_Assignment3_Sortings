


public class Main {
    public static void main(String[] args) {
        NewAPI newApi = new NewAPI();
        OldAPI adapter = new APIAdapter(newApi);

        String xml = adapter.getUsersXML("src/users.json");

        System.out.println(xml);
    }
}
