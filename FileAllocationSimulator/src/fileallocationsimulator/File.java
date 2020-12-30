package fileallocationsimulator;

import java.util.LinkedList;


public class File {
    private String FileName;
    private int FileSize;
    private int StartBlock;
    private int EndBlock;
    public LinkedList<Integer> link = new LinkedList<Integer>();
    
    public File() {
        
    }
    
    public File(String name, int size){
        FileName = name;
        FileSize = size;
    }

    
    
    public void setFileName(String name){
        FileName = name;
    }
    
    public void setFileSize(int size){
        FileSize = size;
    }
    
    public void setStartBlock(int startBlock){
        StartBlock = startBlock;
    }
    
    public void setEndBlock(int endBlock){
        EndBlock = endBlock;
    }
    
    public String getFileName(){
        return FileName;
    }
    
    public int getFileSize(){
        return FileSize;
    }
    
    public int getStartBlock(){
        return StartBlock;
    }
    
    public int getEndBlock(){
        return EndBlock;
    }
    
    
}
