package automationcraft.engine.database;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class MongoDBManage {
    ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:Gl7VPtk1saZBYPx8@cluster0-automationcraf.yyz8v.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");

    public void insertDocument(String collectionName){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client);
        MongoCollection<Document> collection = database.getCollection("search");
        Document document = new Document("palabra buscada","Vestido");
        //MongoCollection<SearchData> collection = database.getCollection(collectionName, SearchData.class);
        collection.insertOne(document);
    }
    public void insertDocuments(String collectionName, List<Document> docs){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertMany(docs);
    }
    public List<Document> getDocuments(Document queryFilter, String collectionName){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        List<Document> documents = new ArrayList<>();
        collection.find(queryFilter).into(documents);
        return documents ;
    }
    public List<Document> getDocuments(String collectionName){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        List<Document> documents = new ArrayList<>();
        collection.find().into(documents);
        return documents;
    }
    public void update(Document query,Document change, String collectionName){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.updateOne(query,new Document("$set",change));
    }
    public void deleteDocument(Document query, String collectionName){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.deleteOne(query);
        Assert.assertNull(collection.find(query));
    }

}
