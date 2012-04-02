package logic;

/**
 * Save the machine and corresponding time for alternative solution
 * @author prathamesh
 */
public class AlternativeSolutions {
    int MachineID;
    int time;

    /**
     * contains machine and time required to perform operation
     * @param machine
     * @param t
     */
    public AlternativeSolutions(int machine, int t) {
        MachineID = machine;
        time      = t;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
