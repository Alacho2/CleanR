import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class FileHandling {

    public static final String DIRECTORY = String.valueOf(Paths.get(System.getProperty("user.home") + "/Desktop"));

    File folder;
    File makeFolder;
    File listOfFiles[];
    ArrayList<String> picExt = new ArrayList<>();


    String s;

    public FileHandling() {
        folder = new File(DIRECTORY);
        listOfFiles = folder.listFiles();
        picExt.add("pdf");
    }

    public void makeFolderStructure(){
        s = DIRECTORY + setFolderName();
        makeFolder = new File(s);
        makeFolder.mkdir();
        subFolder("Programmer");
        subFolder("Dokumenter");
        subFolder("Bilder");
    }

    public void subFolder(String folder){
        makeFolder = new File(s + "/" + folder);
        makeFolder.mkdir();
    }

    public void cleanUp(){
        for(File f : listOfFiles){
            if(f.getName().contains(".txt")){

        }
    }
    }

    public String setFolderName(){
        String curTime = LocalDateTime.now().toString();

        curTime = curTime.replace(":", ".");
        curTime = "Skrivebord" + curTime;

        return "/" + curTime;
    }
}
