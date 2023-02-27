package lt.code.academy.client;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.code.academy.data.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDocumentConverter {
    public static void main(String[] args) {
        MongoClient client = MongoClientProvider.getClient();
        MongoDatabase database =  client.getDatabase("newAgeDB");
        MongoCollection<Document> userCollection =  database.getCollection("users");

        List<User> users = new ArrayList<>();
        FindIterable<Document> documents = userCollection.find();
        for(Document document: documents) {
            users.add(new User(document.getObjectId("_id"),
                    document.getString("name"),
                    document.getString("surname"),
                    document.getInteger("age"),
                    document.getString("email"),
                    document.getString("phone")));
        }
        users.forEach((System.out::println));
    }
}
