package lt.code.academy;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class MyFirsMongoClient {
    public static void main(String[] args) {
        //1. sukurti mongo klienta
        //jeigu tame paciame VM
        MongoClient client = new MongoClient();
        // jeigu kitame VM:
      //  MongoClient client = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

        //2. prisijungiame prie db
        MongoDatabase database = client.getDatabase("taskDB");
        System.out.println(database.getName());
        MongoIterable<String> collectionNames = database.listCollectionNames();
        for(String name: collectionNames) {
            System.out.println(name);
        }
        ListCollectionsIterable<org.bson.Document> collections = database.listCollections();
        for(Document document: collections) {
            System.out.println(document);
            System.out.println("name");
        }


    }
}
