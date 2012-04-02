package logic;

//~--- JDK imports ------------------------------------------------------------

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

    int                        OperationID;
    int                        alternativeCount;
    List<AlternativeSolutions> possol;//stores the alternative solutions

    Operation() {
        alternativeCount = 0;
        possol       = null;
    }

    /**
     *
     * @return
     */
    public int getOperationID() {
        return OperationID;
    }

    /**
     *
     * @param OperationID
     */
    public void setOperationID(int OperationID) {
        this.OperationID = OperationID;
    }

    /**
     *
     * @return
     */
    public List<AlternativeSolutions> getPossol() {
        return possol;
    }

    /**
     *
     * @return
     */
    public int getAlternativeCount() {
        return alternativeCount;
    }

    /**
     *
     * @param alternativeCount
     */
    public void setAlternativeCount(int alternatives) {
        this.alternativeCount = alternatives;
    }

    /**
     * store the available machines and the corresponding time taken by Operation object
     * to Alternative Solutions
     * @param s
     */
    public void setAlternativeSolution(Scanner s) {

        possol = new ArrayList<AlternativeSolutions>();

        //TO DO : why???
        for (int i = 1; i <= this.getAlternativeCount() * 2; i = i + 2) {
            int     a   = s.nextInt();
            int     b   = s.nextInt();
            boolean add = possol.add(new AlternativeSolutions(a, b));
        }
    }

    void printOperationDetails() {
        for (int i = 0; i < possol.size(); i++) {
            System.out.println("On Machine " + possol.get(i).MachineID + " In Time " + possol.get(i).time);
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
