package lt.code.academy.client;


import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.code.academy.data.User;

import java.util.List;


public class MongoObjectCollectionExample {
    public static void main(String[] args) {
        MongoClient client = MongoObjectClientProvider.getClient();
        MongoDatabase database =  client.getDatabase("newAgeDB");
        MongoCollection<User> userCollection =  database.getCollection("users", User.class);

       /* FindIterable<User> users = userCollection.find();
        for(User user: users) {
            System.out.println(user);*/


        MongoObjectCollectionExample example = new MongoObjectCollectionExample();
        example.printUsers(userCollection);

        List<User> data = List.of(new User(null, "Kazkas naujo", "Kitokia", 35, "a.b@codeacademy.lt", "37048579665"),
                new User(null, "Jonas", "Jonaitis", 62, "Jonas.Jonaitis@codeacademy.lt", "37048579665"),
                new User(null, "Ona", "Ona", 49, "Ona.Ona@codeacademy.lt", "37048579665"),
                new User(null, "Birute", "Bireute", 38, "Birute.Bireute@codeacademy.lt", "37048579665"));
        //kuriame kelis useriu
        userCollection.insertMany(data);

        example.printUsers(userCollection);
        //https://github.com/andriusbaltrunas/JAVAUA1-2022.11.14/blob/main/DB/MongoClientExample/src/main/java/lt/code/academy/MongoObjectCollectionExample.java

    }
    private void printUsers(MongoCollection<User> userCollection) {
        FindIterable<User> users = userCollection.find();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
