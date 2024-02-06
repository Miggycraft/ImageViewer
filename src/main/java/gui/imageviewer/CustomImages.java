package gui.imageviewer;

//ugly af name lmaoooooooooooo
// gusto q ito rin ang hhandle ng file checker (checks if path is valid)

import java.io.File;
import java.util.ArrayList;

public class CustomImages {
    String supportedTypes[] = {"jpeg", "png", "gif", "jpg"}; // not sure if jpg is valid
    ArrayList<CustomImage> lists = new ArrayList();
    
    public void addImage(CustomImage ci){
        lists.add(ci);
    }
    
    public void removeImage(int i){
        lists.remove(i);
    }
    
    public void clearImages(){
        lists.clear();
    }
    
    public boolean checkEx(String ex){
        for (String s : supportedTypes){
            if (ex.equals(s)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isValid(String path){
        //add logic.
        int len;
        File f = new File(path);
        for (String s: f.list()){
            len = s.length();
            String temp = s.substring(len - 3);
            if (checkEx(temp)){
                System.out.println(s);
            }
        }
        

        return true;
    }
}
