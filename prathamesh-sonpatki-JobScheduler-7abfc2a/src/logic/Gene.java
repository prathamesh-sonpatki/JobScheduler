package logic;

import java.util.List;
import java.util.Random;

/*
 * Gene Class -> It represents a Job.
 * A Gene will have different GeneSolutions which represent an operation of a jobs.
 */
/**
 *
 * @author chaitanya
 */
public class Gene {

    // used for Converting string to chromosome **Don't Touch**
    private int optimalMakespan = 30;
    private int threshold = 5;
    static int l;
    int makeSpan;

    static int k;

    public int getOptimalMakespan() {
        return optimalMakespan;
    }

    public int getThreshold() {
        return threshold;
    }

    public int getMakeSpan() {
        return makeSpan;
    }
    // Rest of the Data Members
    int geneLength;
    GeneSolution[] geneSolution;

    /**
     * Initializing the Gene object
     */
    public Gene() {
        this.geneLength = 0;
        this.geneSolution = null;
        this.makeSpan = 0;
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
    public void printGenes() {
      

       

      
    }

    /**
     *
     * @param jobs
     * @param i
     */
    public void setGeneSolution(Job jobs[], int i) {

        // Create random class object
        geneSolution = new GeneSolution[geneLength];

        Random r = new Random();

        for (int j = 0; j < jobs[i].getTotalOperationCount(); j++) {

            List<AlternativeSolutions> possol = jobs[i].getOperations()[j].getPossol();

            int random = r.nextInt(9999) % possol.size();
            geneSolution[j] = new GeneSolution(possol.get(random).MachineID, possol.get(random).time);
        }
    }

    public static void setL(int l) {
        Gene.l = l;
    }

    public void setMakeSpan(int makeSpan) {
        this.makeSpan = makeSpan;
    }

    public void setOptimalMakespan(int optimalMakespan) {
        this.optimalMakespan = optimalMakespan;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    // New method using integer array in place of string array
    /**
     *
     * @param Machine
     * @param Time
     * @param ChromLength
     */
    

    public void setGeneSolution(int[] Machine, int[] Time, int ChromLength) {
        for (int i = 0; i < this.getGeneLength(); i++) {
            this.geneSolution[i].setMachineID(Machine[l]);
            this.geneSolution[i].setTime(Time[l]);
            l = (l + 1) % ChromLength;
        }
    }

   
    /**
     *
     * @param Machine
     * @param Time
     */
    public void setGeneSolution(GeneSolution origGeneSolution[])
    {
        this.geneSolution = new GeneSolution[geneLength];
        for(int i =0; i<geneLength; i++)
        {
            this.geneSolution[i] = new GeneSolution(origGeneSolution[i].getMachineID(),origGeneSolution[i].getTime());
        }
    }


}
//~ Formatted by Jindent --- http://www.jindent.com

