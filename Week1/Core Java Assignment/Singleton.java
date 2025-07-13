// Singleton Design Pattern
// It ensures only one instance of a class exists during runtime.
// Often used in logging, configuration, database connections.

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

