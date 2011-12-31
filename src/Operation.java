
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    int OperationID;
    List<PossibleSolutions> possol;

    public int getOperationID() {
        return OperationID;
    }

    public void setOperationID(int OperationID) {
        this.OperationID = OperationID;
    }

    
    Operation()
        {
            alternatives = 0 ;
            possol = null;
        }

    public int getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(int alternatives) {
        this.alternatives = alternatives;
    }
    

    public void setPossSol(Scanner s) {
        possol = new ArrayList<PossibleSolutions>();
            
        for(int i=1;i<=alternatives*2;i=i+2)
        {
           
           
            boolean add = possol.add(new PossibleSolutions(s.nextInt(),s.nextInt()));

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
