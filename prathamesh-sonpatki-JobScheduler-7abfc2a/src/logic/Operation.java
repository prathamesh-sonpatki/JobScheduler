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
    int                        alternatives;
    List<AlternativeSolutions> possol;

    Operation() {
        alternatives = 0;
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
    public int getAlternatives() {
        return alternatives;
    }

    /**
     *
     * @param alternatives
     */
    public void setAlternatives(int alternatives) {
        this.alternatives = alternatives;
    }

    /**
     *
     * @param s
     */
    public void setAlternativeSolution(Scanner s) {
        possol = new ArrayList<AlternativeSolutions>();

        for (int i = 1; i <= this.getAlternatives() * 2; i = i + 2) {
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
