package fileallocationsimulator;


public class Indexed {
    private String name;
    private int size;
    public int indexes[] = new int[size];
    //public boolean occupied = false;
    
    public Indexed() {
        name = "x";
        size = 0;
    }
    
    public Indexed(String Name, int Size){
        name = "x";
        size = Size;
        indexes = new int[size];
    }
    
    public void setName(String Name){
        name = Name;
    }
    
    public void setSize(int Size){
        size = Size;
    }
    
    public void setArray(int Size){
        indexes = new int[size];
        for(int i = 0; i < Size; i++){
            indexes[i] = 0;
        }   
    }
    
    public String getName(){
        return name;
    }
    
    public int getSize(){
        return size;
    }
    
    public void getIndexes(){
        
        System.out.println("The indexes of the file " + name + " are:");
        for (int i = 0; i < size; i++){
            System.out.println(indexes[i]);
        }    
    }
    
}
