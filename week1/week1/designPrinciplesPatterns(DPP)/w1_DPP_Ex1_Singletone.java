public class w1_DPP_Ex1_Singletone {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Hello from logger1");
        logger2.log("Hello from logger2");

        if (logger1 == logger2) {
            System.out.println("Same instance");
        }
    }
}

class Logger {
    private static Logger instance;

    private Logger() {
        System.out.println("Logger initialized");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String msg) {
        System.out.println("Log: " + msg);
    }
}
