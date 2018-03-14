import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CorrectFileHandling {

    public static final Path DIRECTORY = Paths.get(System.getProperty("user.home"), "Desktop");
    static List<String> docuExt;
    static List<String> picExt;
    static List<String> progExt;
    List<Files> fileNames;
    Files file;

    String folderName;

    public CorrectFileHandling(){
        makeExtList();
        fileList();
        makeFolderStructure();

    }

    public void cleanUp(){
        for(Files f : fileNames){
            if(docuExt.contains(f)){

            }
        }
    }

    public void makeFolderStructure(){
        folderName = setFolderName();
        try {
            file.createDirectory(Paths.get(String.valueOf(DIRECTORY), folderName));
            makeSubfolder("Dokumenter");
            makeSubfolder("Bilder");
            makeSubfolder("Programmer");
        } catch(IOException e ){
            e.printStackTrace();
        }
    }

    public void makeSubfolder(String mappe){
        try {
            file.createDirectory(Paths.get(String.valueOf(DIRECTORY + folderName), mappe));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Files> fileList(){
        fileNames = new ArrayList<>();
        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(DIRECTORY)) {
            for (Path f : directoryStream){

            }
        } catch (IOException e) {
            System.out.println("Couldn't find your home directory");
            e.printStackTrace();
        }
        return fileNames;
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
        Collections.addAll(docuExt, "doc", "txt", "pdf", "docx", "log", "pages");
        Collections.addAll(picExt, "png", "jpg", "psd", "gif");
        Collections.addAll(progExt, "exe", "dmg", "msi", "app", "jar");
    }
}
