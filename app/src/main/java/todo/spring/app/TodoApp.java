package todo.spring.app;

public class TodoApp {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new TodoApp().getGreeting());
    }
}
