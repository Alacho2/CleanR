import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CorrectFileHandling {

    public static final Path DIRECTORY = Paths.get(System.getProperty("user.home"), "Desktop");
    List<String> fileNames;
    Files file;

    String folderName;

    public CorrectFileHandling(){
        fileList();
        makeFolderStructure();

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

    public void getFileList(){
        for (String s : fileNames){
            System.out.println(s);
        }
    }

    public List<String> fileList(){
        fileNames = new ArrayList<>();
        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(DIRECTORY)) {
            for (Path path : directoryStream){
                fileNames.add(path.getFileName().toString());
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
}
