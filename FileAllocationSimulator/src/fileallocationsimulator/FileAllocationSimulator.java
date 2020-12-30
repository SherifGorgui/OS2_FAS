package fileallocationsimulator;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;
import java.util.InputMismatchException;
import java.util.LinkedList;

public class FileAllocationSimulator {
    
    static File myObject = new File();
    static ArrayList<File> Files = new ArrayList();
    static boolean Occupied;
    
    static boolean checkEmpty(String []Array, int random, int size){
        try {
        for (int i = random; i < (random + size); i++){
             
            if ( Array[i] == null ){
                //System.out.println("TEST CHECK EMPTY");
                Occupied = true;
            }
            else {
                Occupied = false;
                break;
            }
        } }
        catch(Exception e){
             
        }
         
        return Occupied;
    }
   
    
    static boolean checkEmpty3(ArrayList arraylist, Indexed n, int r){
        try {
            if (arraylist.get(r) == null){
                //System.out.println("TEST CHECK EMPTY");
                Occupied = false;
            }
            else {
                Occupied = true;
            }
        }
        catch(Exception e){
             
        }
         //System.out.println("test Check empty" + Occupied);
        return Occupied;
    }
     
     

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String Block[];
        boolean cont = true;
        String name;
        int size;
        int c;
        
        System.out.println("Please enter the disk space: ");
        int DiskSpace = input.nextInt();
        
        Block = new String[DiskSpace];
        int index = 0;
        
        while(true){
        System.out.println("Choose the desired file allocation method:");
        System.out.println("Enter 1 for Contiguous method.");
        System.out.println("Enter 2 for Linked method.");
        System.out.println("Enter 3 for Indexed method.");
        System.out.println("Enter 4 to exit.");
        try {
            c = input.nextInt();
            if(c > 4 || c < 1){
                    //if he chooses any number other than those three we return an error message
                    System.out.println("please choose either 1, 2 or 3");
                    continue;
                }
            if(c == 1){
                break;
            }
            if(c == 2){
                break;
            }
            if(c == 3){
                break;
            }
            if(c == 4){
                System.exit(0);
            }
            
        } catch(InputMismatchException ex){
                System.out.println("Please choose either 1, 2 or 3!");
                input.nextLine();
            }
        }
        
        switch(c){
        
            case 1:
                // Contiguous Method
                while (cont){
            
                    System.out.println("Please add a new file while making sure the size doesn't exceed the disk space:");
                    System.out.println("File Name: ");
                    name = input.next();
            
                    do{
                        System.out.println("File Size: ");
                        size = input.nextInt();
                    } while(size > DiskSpace);
            
                    File myObject = new File();
                    Files.add(myObject);
            
                    Files.get(index).setFileName(name);
                    Files.get(index).setFileSize(size);
           


                    int Rand = (int) Math.floor(Math.random() * DiskSpace);
            
                    while ((Rand + size) > DiskSpace){
                        Rand = (int) Math.floor(Math.random() * DiskSpace);
                    }
            
                    if (checkEmpty(Block, Rand, size)){
                        //System.out.println("TEST");
                        for (int i = Rand; i < ((Rand + size)); i++){
                            Block[i] = name;
                        }
                    }
                    else{
                        System.out.println("The Generated Starting block is already taken!");
                        System.out.println("Please continue the program and Re-Add the file");
                        continue;
                    }
            
                    Files.get(index).setStartBlock((Rand + 1));
                    Files.get(index).setEndBlock(((Rand + size)));
                    index++;
            
            
                    System.out.println("Do you want to add a new file? Enter 1 for yes or 2 for no: ");
                    int choice = input.nextInt();
            
                    if (choice == 1){
                        cont = true;
                    }
                    else if (choice == 2){
                        cont = false;
                    }
                } // end of while loop
                
                System.out.println("The Files in the disk:");
        
                try {
                    for (int k = 0; k <= Files.size(); k++){
                        System.out.println( k+1 + " - " + "File Name: " + Files.get(k).getFileName() + " Starting Block: " + Files.get(k).getStartBlock() + " Ending Block: " + Files.get(k).getEndBlock() + " File Size: " + Files.get(k).getFileSize());
                    }
                }
                catch (Exception e){
            
                }
        
                System.out.println("Blocks: ");
        
                for(int l = 0; l < Block.length; l++){
                    System.out.println("Block " + (l+1) + " - " + Block[l]);
                }
                
            break;
            
            case 2:
                // Linked method
                //LinkedList<Integer> link = new LinkedList<Integer>();
                
                while(cont){
                    int blockIndex;
                
                    System.out.println("Please add a new file while making sure the size doesn't exceed the disk space:");
                    System.out.println("File Name: ");
                    name = input.next();
            
                    do{
                        System.out.println("File Size: ");
                        size = input.nextInt();
                    } while(size > DiskSpace);
                
                    File myObject = new File();
                    Files.add(myObject);
            
                    Files.get(index).setFileName(name);
                    Files.get(index).setFileSize(size);
                
                    
                    while(true){
                        System.out.println("Please enter the starting block index");
                        blockIndex = input.nextInt();
                        if (Block[blockIndex] == null){
                            Block[blockIndex] = name;
                            break;
                        }
                        else{
                            System.out.println("Please enter another starting block index");
                            continue;
                        }
                    }      
                    Files.get(index).setStartBlock(blockIndex);
                
                    while(size > 1){
                        Files.get(index).link.add(blockIndex);
                        while(true){
                            System.out.println("Please enter the next block index");
                            blockIndex = input.nextInt();
                            if (Block[blockIndex] == null){
                                Block[blockIndex] = name;
                                Files.get(index).setEndBlock(blockIndex);
                                Files.get(index).link.add(blockIndex);
                                break;
                            }
                            else{
                                System.out.println("Please enter another block index");
                                continue;
                            }
                        }
                        size--;
                    }
                    
                    
                    index++;
                    
                    System.out.println("Do you want to add a new file? Enter 1 for yes or 2 for no: ");
                    int choice = input.nextInt();
            
                    if (choice == 1){
                        cont = true;
                    }
                    else if (choice == 2){
                        cont = false;
                    } 
                } // end of while loop
                
                
                System.out.println("The Files in the disk:");
        
                try {
                    for (int k = 0; k <= Files.size(); k++){
                        System.out.println( k+1 + " - " + "File Name: " + Files.get(k).getFileName() + " Starting Block: " + Files.get(k).getStartBlock() + " Ending Block: " + Files.get(k).getEndBlock() + " File Size: " + Files.get(k).getFileSize());
                        System.out.println("The linked allocation directory: ");
                        System.out.println(" ");
                        for (int l = 0; l < Files.get(k).link.size(); l++){
                            System.out.print(Files.get(k).link.get(l) + " ---> ");
                        }
                        System.out.println(" ");
                    }
                }
                catch (Exception e){
            
                }
                
                System.out.println(" ");
                System.out.println("Blocks: ");
        
                for(int l = 0; l < Block.length; l++){
                    System.out.println("Block " + (l+1) + " - " + Block[l]);
                }
                
                
            break;
            
            case 3:
                // Indexed method
                ArrayList<Indexed> indexed = new ArrayList(DiskSpace);
                Indexed Ind = new Indexed();
                
                for(int t =0; t < DiskSpace; t++){
                    indexed.add(t, Ind);
                }
                
                
                while(cont){
                    
                    System.out.println("Please add a new file while making sure the size doesn't exceed the disk space:");
                    System.out.println("File Name: ");
                    name = input.next();
            
                    do{
                        System.out.println("File Size: ");
                        size = input.nextInt();
                        //System.out.println("TEST");
                    } while(size > DiskSpace);
                    //System.out.println("TEST");
            
                    int Rand = (int) Math.floor(Math.random() * DiskSpace);
                    //System.out.println("test 1  " +Rand);
            
                    while ((Rand + size) > DiskSpace){
                        Rand = (int) Math.floor(Math.random() * DiskSpace);
                    }
                    //System.out.println("test 2  " +Rand);
                    
                    int Current = Rand;
                    //int CurrentSize = size;
                    int ArrayIndex = 0;
                    
                    indexed.get(Current).setSize(size);
                    indexed.get(Current).setArray(size);
                    
                    //System.out.println("test 3  " + Rand);
                    
                    while(size > 0){
                        //System.out.println("test while  " + Rand);
                        if (checkEmpty3(indexed, Ind, Rand)){
                        indexed.get(Rand).setName(name);
                        indexed.get(Current).indexes[ArrayIndex] = Rand;
                        Rand = (int) Math.floor(Math.random() * DiskSpace);
                        size--;
                        ArrayIndex++;
                        //System.out.println("test 4  " +Rand);
                        }
                        else{
                            continue;
                        }
                    }
                    
                    System.out.println("Do you want to add a new file? Enter 1 for yes or 2 for no: ");
                    int choice = input.nextInt();
            
                    if (choice == 1){
                        cont = true;
                    }
                    else if (choice == 2){
                        cont = false;
                    }
                } // end of while loop
                
                System.out.println("The Files in the disk: ");
                
                int index2 = 0;
                String TESTT = "x";
                
                while(index2 < indexed.size()){
                    if (indexed.get(index2).getName() == TESTT){
                        index2++;
                        continue;
                    }
                    else{
                        System.out.println("File Name: " + indexed.get(index2).getName() + " - Index Block: " + (index2+1));
                        System.out.println("Indexes: ");
                        for( int k = 0; k < indexed.get(index2).indexes.length; k++){
                            System.out.println(indexed.get(index2).indexes[k]);
                        }
                    }
                    index2++;
                }
                
                
            break;    
        }
        
        // end of switch case
        
        
        
    }
    
}
