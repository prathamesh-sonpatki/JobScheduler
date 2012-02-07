package logic;

/*
 * MachineController ; This class will create required Machines for operations
 */

/**
 *
 * @author chaitanya
 */
public class MachineController {

    Machine [] machines;
    int TotalMachines;

    /**
     *
     * @return
     */
    public int getTotalMachines() {
        return TotalMachines;
    }

    /**
     *
     * @return
     */
    public Machine[] getMachines() {
        return machines;
    }

    /**
     *
     * @param TotalMachines
     */
    public void setTotalMachines(int TotalMachines) {
        this.TotalMachines = TotalMachines;
    }

    // Creates new Machines
    /**
     *
     */
    public void setMachines()
    {
        this.machines = new Machine[this.getTotalMachines()];
        for(int i = 0; i < this.getTotalMachines(); i++)
        {            
            this.machines[i] = new Machine(i);
        }

    }

    //Method for getting machine by Machine ID

    /**
     *
     * @param MachineID
     * @return
     */
    public Machine getMachine(int MachineID)
    {
     for(int i =0; i < this.getTotalMachines();i++)
     {
         if (this.getMachines()[i].getMachineID() == MachineID)
             return this.getMachines()[i];
     }
     return null;
    }

}
