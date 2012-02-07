package logic;


import java.util.List;
import java.util.Random;

/*
 * Gene Class -> It represents a Job.
 * A Gene will have different GeneSolutions which represent an operation of a job.
 */
/**
 *
 * @author chaitanya
 */
public class Gene {

    // used for Converting string to chromosome **Don't Touch**
    static int k;
    static int l;
    //Rest of the Data Members
    int geneLength;

    GeneSolution [] geneSolution;
    int MakeSpan;

    /**
     *
     */
    public Gene() {
        this.geneLength = 0;
        this.geneSolution = null;
        this.MakeSpan = 0;
    }

    /**
     *
     * @return
     */
    public GeneSolution[] getGeneSolution() {
        return geneSolution;
    }

    /**
     *
     * @return
     */
    public int getGeneLength() {
        return geneLength;
    }

    /**
     *
     * @param geneLength
     */
    public void setGeneLength(int geneLength) {
        this.geneLength = geneLength;
    }
    /**
     *
     */
    public void printGenes()
    {
        System.out.println("Gene Length "+this.getGeneLength());
        for(int i=0;i<this.getGeneLength();i++)
        {
            
           //geneSolution[i].printGeneSolution();

        }
        System.out.println();
    }
    /**
     *
     * @param job
     * @param i
     */
    public void setGeneSolution(Job job[],int i) {

        // Create random class object
       geneSolution = new GeneSolution[geneLength];
       Random r = new Random();
       
      
        
           for(int j=0;j<job[i].getTotalOperations();j++)
           {
            List<AlternativeSolutions> possol = job[i].getOperations()[j].getPossol();
          //  System.out.println(possol.size());
           
            geneSolution[j] = new GeneSolution(possol.get(r.nextInt(9999)%possol.size()).MachineID,possol.get(r.nextInt(9999)%possol.size()).time);
           
           }
     }
    //New method using integer array in place of string array
    /**
     *
     * @param Machine
     * @param Time
     * @param ChromLength
     */
    public void setGeneSolution(int [] Machine , int [] Time , int ChromLength)
    {

        
        for(int i=0;i<this.getGeneLength();i++)
        {
            geneSolution[i].setMachineID(Machine[l]);
            geneSolution[i].setTime(Time[l]);
            
            l=(l+1)%ChromLength;
        }
    }

    //Not required !
    /**
     *
     * @param Machine
     * @param Time
     */
    public void setGeneSolution(String Machine , String Time)
    {

        geneSolution = new GeneSolution[geneLength];
        for(int i=0;i<geneLength;i++)
        {
            geneSolution[i] = new GeneSolution(Integer.parseInt(Machine.charAt(l)+""), Integer.parseInt(Time.charAt(l)+""));
            
            l=(l+1)%36;
        }
    }
    }




