package lt.code.academy;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.code.academy.client.MongoClientProvider;
import org.bson.Document;

import java.util.List;

public class FirstMongoDocumentCollection {
    public static void main(String[] args) {
        //1 step
        MongoClient client = MongoClientProvider.getClient();

        // 2 step
        MongoDatabase database = client.getDatabase("newAgeDB");
        //3 step
        MongoCollection<Document> users = database.getCollection("users");

        Document document= new Document("name", "Anatolijus")
                .append("age", 25)
                        .append("phone", "+3706658558");


        Document secondDocument= new Document("name", "Gediminas")
                .append("age", 55)
                .append("phone", "+66666666");

        //users.insertOne(document);
        users.insertMany(List.of(document, secondDocument));

        FindIterable<Document> usersResults = users.find();

        for (Document d : usersResults) {
            // System.out.println(document);
            System.out.println(d);
        }


    }
}
