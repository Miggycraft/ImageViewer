package gui.imageviewer;

public class CustomImage {
    String fileExtension;
    String fileName;
    String fileDir;

    public CustomImage(String fileExtension, String fileName, String fileDir) {
        this.fileExtension = fileExtension;
        this.fileName = fileName;
        this.fileDir = fileDir;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }
    
    public void debugPrintInfo(){
        System.out.println(fileExtension + "\n" + fileName + "\n" + fileDir);
    }
    
    public String pasteInfo(){
        String s = "File Name: " + fileName + "\n"
                 + "File Directory:" + fileDir + "\n"
                 + "File Type: " + fileExtension;
        
        return s;
    }
    
}
