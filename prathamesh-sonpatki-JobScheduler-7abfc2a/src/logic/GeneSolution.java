package logic;

/**
 * @author chaitanya
 */
public class GeneSolution {
    int machineID;
    int time;

    /**
     *
     * @param machineID
     * @param time
     */
    public GeneSolution(int MachineID, int time) {
        this.machineID = MachineID;
        this.time      = time;
    }

    /**
     *
     * @param machineID
     */
    public void setMachineID(int MachineID) {
        this.machineID = MachineID;
    }

    /**
     *
     * @param time
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     *
     * @return
     */
    public int getMachineID() {
        return machineID;
    }

    /**
     *
     * @return
     */
    public int getTime() {
        return time;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
