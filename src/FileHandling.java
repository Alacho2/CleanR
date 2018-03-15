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
    String picVid = "PicVid";
    String doc = "Documents";
    String programs = "Programs";
    String develop = "Dev";

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
        subFolder(programs);
        subFolder(doc);
        subFolder(picVid);
        subFolder(develop);
    }

    public void cleanUp(){
        for (File f : listOfFiles){
            for(String d : docuExt) {
                if (f.getName().contains("." + d)) {
                    System.out.println("Moving file: " + f.getName() + " to " + doc);
                    f.renameTo(new File(s + "/"+doc+"/" + f.getName()));
                }
            }
            for(String i : picExt){
                if (f.getName().contains("." + i)) {
                    System.out.println("Moving file: " + f.getName() + " to " + picVid);
                    f.renameTo(new File(s + "/"+picVid+"/" + f.getName()));
                }
            }
            for(String p : progExt){
                if (f.getName().contains("." + p)) {
                    System.out.println("Moving file: " + f.getName() + " to " + programs);
                    f.renameTo(new File(s + "/"+programs+"/" + f.getName()));
                }
            }
            for(String dev : devExt){
                if (f.getName().contains("." + dev)) {
                    System.out.println("Moving file: " + f.getName() + " to " + develop);
                    f.renameTo(new File(s + "/"+develop+"/" + f.getName()));
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
        Collections.addAll(picExt, "png", "jpg", "psd", "gif", "mp4", "mkv", "flv", "avi");
        Collections.addAll(progExt, "exe", "dmg", "msi", "app", "jar");
        Collections.addAll(devExt, "html", "css", "php", "java", "js");
    }
}
