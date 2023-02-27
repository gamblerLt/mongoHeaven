package lt.code.academy;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.code.academy.client.MongoClientProvider;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class MongoCollectionDeleteExample {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClientProvider.getClient();
        MongoDatabase database =  mongoClient.getDatabase("newAgeDB");
        MongoCollection<Document> userCollection =  database.getCollection("users");

       // userCollection.deleteOne(new Document("_id", new ObjectId("63fce07d29cd253f056eb3dc")));
        //deletemany
        userCollection.deleteMany(and(eq("name", "Anatolijus"), eq("age", 25)));

        FindIterable<Document> users = userCollection.find();
        for(Document user: users) {
            System.out.println(user);
        }
    }
}
