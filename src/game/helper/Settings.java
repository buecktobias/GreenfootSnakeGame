package game.helper;

public class Settings {
    private final static String filePath = "/home/tobias/Documents/Informatik/Grundbegriffe_2_OOP_IntelliJ_v1/src/images/";
    public static String getFilePath(){
        return Settings.filePath;
    }
    public static String getFilePath(String filename){
        return Settings.getFilePath() + "/" + filename;

    }
}

