
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author prathamesh
 */
public class Operation {

    int alternatives;
    List<PossibleSolutions> possol;

    
    Operation()
        {
            alternatives = 0 ;
            possol = null;
        }
    void getOperationDetails(String [] array) {
        
           

            alternatives = Integer.parseInt(array[0]);
            setAlternatives(array,alternatives);
            
        
            
    
    }

    private void setAlternatives(String[] array, int alternatives) {
        possol = new ArrayList<PossibleSolutions>();
            
        for(int i=1;i<=alternatives*2;i=i+2)
        {
           
           
            boolean add = possol.add(new PossibleSolutions(Integer.parseInt(array[i]), Integer.parseInt(array[i + 1])));

        }
    }

    void printOperationDetails()
    {  
        for(int i=0;i<possol.size();i++)
        {
            System.out.println("On Machine "+possol.get(i).MachineID+" In Time "+possol.get(i).time);
        }
           
       
    }
}
