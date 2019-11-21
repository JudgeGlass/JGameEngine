package net.judgeglass.jgameengine.core.io;

public class Log {
    public static void info(final String message){
        System.out.println("[INFO]: " + message);
    }

    public static void error(final String message){
        System.err.println("[ERROR]: " + message);
    }

    public static void warn(final String message){
        System.out.println("[WARN]: " + message);
    }
}
