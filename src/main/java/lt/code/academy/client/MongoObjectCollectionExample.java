package lt.code.academy.client;


import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.code.academy.data.User;


public class MongoObjectCollectionExample {
    public static void main(String[] args) {
        MongoClient client = MongoObjectClientProvider.getClient();
        MongoDatabase database =  client.getDatabase("newAgeDB");
        MongoCollection<User> userCollection =  database.getCollection("users", User.class);

        FindIterable<User> users = userCollection.find();
        for(User user: users) {
            System.out.println(user);
        }
    }
}
