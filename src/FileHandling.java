import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileHandling {

    public static final String DIRECTORY = String.valueOf(Paths.get(System.getProperty("user.home") + "/Desktop"));
    static List<String> docuExt;
    static List<String> picExt;
    static List<String> progExt;
    static List<String> devExt;

    File folder;
    File makeFolder;
    File listOfFiles[];

    String s;

    public FileHandling() {
        folder = new File(DIRECTORY);
        listOfFiles = folder.listFiles();
        makeExtList();
        makeFolderStructure();
        cleanUp();
    }

    public void makeFolderStructure(){
        s = DIRECTORY + setFolderName();
        makeFolder = new File(s);
        makeFolder.mkdir();
        subFolder("Programmer");
        subFolder("Dokumenter");
        subFolder("Bilder");
        subFolder("Dev");
    }

    public void cleanUp(){
        for (File f : listOfFiles){
            for(String d : docuExt) {
                if (f.getName().contains("." + d)) {
                    System.out.println("Moving file: " + f.getName() + " to Dokumenter");
                    f.renameTo(new File(s + "/Dokumenter/" + f.getName()));
                }
            }
            for(String i : picExt){
                if (f.getName().contains("." + i)) {
                    System.out.println("Moving file: " + f.getName() + " to Bilder");
                    f.renameTo(new File(s + "/Bilder/" + f.getName()));
                }
            }
            for(String p : progExt){
                if (f.getName().contains("." + p)) {
                    System.out.println("Moving file: " + f.getName() + " to Dev");
                    f.renameTo(new File(s + "/Dev/" + f.getName()));
                }
            }
            for(String dev : progExt){
                if (f.getName().contains("." + dev)) {
                    System.out.println("Moving file: " + f.getName() + " to Programmer");
                    f.renameTo(new File(s + "/Dev/" + f.getName()));
                }
            }
        }
    }

    public void subFolder(String folder){
        makeFolder = new File(s + "/" + folder);
        makeFolder.mkdir();
    }

    public String setFolderName(){
        String curTime = LocalDateTime.now().toString();

        curTime = curTime.replace(":", ".");
        curTime = "Skrivebord" + curTime;

        return "/" + curTime;
    }

    public static void makeExtList(){
        docuExt = new ArrayList<>();
        picExt = new ArrayList<>();
        progExt = new ArrayList<>();
        devExt = new ArrayList<>();
        Collections.addAll(docuExt, "doc", "txt", "pdf", "docx", "log", "pages", "rtf");
        Collections.addAll(picExt, "png", "jpg", "psd", "gif");
        Collections.addAll(progExt, "exe", "dmg", "msi", "app", "jar");
        Collections.addAll(devExt, "html", "css", "php", "java", "js");
    }
}
