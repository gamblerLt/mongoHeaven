package lt.code.academy;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.code.academy.client.MongoClientProvider;
import org.bson.Document;

public class FirstMongoDocumentCollection {
    public static void main(String[] args) {
        //1 step
        MongoClient client = (MongoClient) MongoClientProvider.getClient();
        // 2 step
        MongoDatabase database = client.getDatabase("myMongoDB");
        //3 step
        MongoCollection<Document> users = database.getCollection("users");
    }
}
