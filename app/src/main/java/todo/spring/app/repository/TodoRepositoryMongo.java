package todo.spring.app.repository;

import todo.spring.app.entity.Todo;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class TodoRepositoryMongo implements TodoRepository {
    private final MongoCollection<Document> collection;

    public TodoRepositoryMongo() {
        // Assuming MongoDB is running locally on default port 27017
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("todosDB");
        this.collection = database.getCollection("todos");
    }

    @Override
    public List<Todo> findAll() {
        List<Todo> todos = new ArrayList<>();
        for (Document doc : collection.find()) {
            todos.add(documentToTodo(doc));
        }
        return todos;
    }

    @Override
    public Todo findById(Long id) {
        Document doc = collection.find(new Document("_id", id)).first();
        return (doc != null) ? documentToTodo(doc) : null;
    }

    @Override
    public Todo save(Todo todo) {
        Document doc = new Document("description", todo.getDescription())
                .append("completed", todo.isCompleted());
        collection.insertOne(doc);
        todo.setId(doc.getLong("_id"));
        return todo;
    }

    @Override
    public void deleteById(Long id) {
        collection.deleteOne(new Document("_id", id));
    }

    private Todo documentToTodo(Document doc) {
        return new Todo(
                doc.getLong("_id"),
                doc.getString("description"),
                doc.getBoolean("completed"));
    }
}
