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
    
    public CustomImage getImage(int i){
        return lists.get(i);
    }
    
    public boolean hasInside(){
        return lists.size() > 0;
    }
    
    public int getSize(){
        return lists.size();
    }
    
    public boolean checkEx(String ex){
        for (String s : supportedTypes){
            if (ex.equals(s)){
                return true;
            }
        }
        
        return false;
    }
    
    public void getLists(String path){
        //add logic.
        int len;
        File f = new File(path);
        int i = 0;
        for (String s: f.list()){
            len = s.length();
            String temp = s.substring(len - 3);
            if (checkEx(temp)){ // valid
                // LGTM
                lists.add(new CustomImage(temp, s.substring(0, len - 4), path+"\\"+s));
            }
        }
        
    }
}
