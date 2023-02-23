package lt.code.academy;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lt.code.academy.client.MongoClientProvider;
import org.bson.Document;

import static com.mongodb.client.model.Filters.*;

public class MyFirsMongoCollection {
    public static void main(String[] args) {
        MongoClient client = MongoClientProvider.getClient();
        MongoDatabase database = client.getDatabase("taskDB");
        MongoCollection<Document> myCollection = database.getCollection("Exams");

       // FindIterable<Document> results = myCollection.find(Filters.lt("grade","7"));//filtravimas gali buti ivairus RBA JO NEBUTI
       // FindIterable<Document> results = myCollection.find().sort(new BasicDBObject("grade", -1)); // - 1 reiskia dsc

        FindIterable<Document> results = myCollection.find(and(lt("grade", "7"), eq("name", "Jonas")));
        for(Document r: results) {
            System.out.printf("%s %s %s %n", r.get("name"), r.get("surname"), r.get("grade"));
        }
        /*Iterator<Document> iterator = myCollection.find().iterator();
		while(iterator.hasNext()) {
			Document r = iterator.next();
			System.out.printf("%s %s %s %s %n", r.get("name"), r.get("surname"), r.get("responsibility"), r.get("salary"));
		}*/
    }
}
