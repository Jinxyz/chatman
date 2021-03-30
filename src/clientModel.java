public class clientModel {
    private Client client;

    public clientModel(Client client) {
        this.client = client.connect();
        this.client = client.chat();
    }
}
