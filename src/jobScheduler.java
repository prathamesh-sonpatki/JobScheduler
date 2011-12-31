/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prathamesh
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
    public class jobScheduler{
    private static final int NUMBER_OF_EVOLUTIONS = 5000;
    private static final int POPULATION_SIZE = 5000;
        
       public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        Operation[] op = new Operation[6];
        
           String line = null;
        String [] array = new String[10];
        int i=0;
        BufferedReader buffer = new BufferedReader(new FileReader("input.txt"));
        for(line = buffer.readLine();line!=null;line=buffer.readLine())
            {
            array = line.split(" ");
            op[i]=new Operation();
            op[i].getOperationDetails(array);
            System.out.println("Operation "+i+" can be done in following ways:");

            op[i++].printOperationDetails();

                   
            }
       

       }

}
