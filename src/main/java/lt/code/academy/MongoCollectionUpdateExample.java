package lt.code.academy;


import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.Updates;
import lt.code.academy.client.MongoClientProvider;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;


public class MongoCollectionUpdateExample {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClientProvider.getClient();
        MongoDatabase database =  mongoClient.getDatabase("newAgeDB");
        MongoCollection<Document> userCollection =  database.getCollection("users");

        MongoCollectionUpdateExample example = new MongoCollectionUpdateExample();
        example.printCollection(userCollection);

        //updatina pirma surasta pgl filtra reiksme
       // userCollection.updateOne(eq("name", "Anatolijus"), set("age", 5895));

        userCollection.updateOne(eq("_id", new ObjectId("63fce07d29cd253f056eb3dd")),
                combine(set("name", "Kazkas naujo"), set("age", 99999)));



       //pavyzdyje su many keite ir importo nustatymus su static
        //userCollection.updateMany(Filters.and())
       /* userCollection.updateMany(eq("pone","+3706658558"),
                combine(set("name", "Kazkas kitas"), set("age", 3000)));*/





        System.out.println("Po update");
        example.printCollection(userCollection);

    }

    private void printCollection(MongoCollection<Document> collection) {
        FindIterable<Document> documents = collection.find();
        for(Document document: documents) {

            System.out.println(document);


        }
    }
}
