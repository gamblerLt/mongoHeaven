package lt.code.academy;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.code.academy.client.MongoClientProvider;
import org.bson.Document;

import java.util.List;

public class FirstMongoDocumentCollection {
    public static void main(String[] args) {
        //1 step
        MongoClient client = (MongoClient) MongoClientProvider.getClient();
        // 2 step
        MongoDatabase database = client.getDatabase("myMongoDB");
        //3 step
        MongoCollection<Document> users = database.getCollection("users");

        Document document= new Document("name", "Anatolijus")
                .append("age", 25)
                        .append("phone", "+3706658558");

        users.insertOne(document);
       // users.insertMany(List.of(document, document2, document3, document4));


    }
}
