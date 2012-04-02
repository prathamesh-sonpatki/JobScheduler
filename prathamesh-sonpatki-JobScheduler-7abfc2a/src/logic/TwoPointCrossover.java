package logic;

//~--- JDK imports ------------------------------------------------------------

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
import java.util.Random;


/**
 *
 * @author Pawan
 */
public class TwoPointCrossover implements CrossOverScheme {

    /**
     *
     * @param chromosome1
     * @param chromosome2
     */
    public void performCrossover(Chromosome chromosome1, Chromosome chromosome2) {
        Random random          = new Random();
       
        int    crossoverPoint1 = random.nextInt(chromosome1.getChromosomeLength());
        int    crossoverPoint2 = random.nextInt(chromosome2.getChromosomeLength());
       
        int temp;
        if (crossoverPoint1 > crossoverPoint2)
        {
           temp = crossoverPoint1;
            crossoverPoint1 = crossoverPoint2;
            crossoverPoint2 = temp;
        }
        if(crossoverPoint1!=0)
            crossoverPoint1--;
          if(crossoverPoint2!=0)
        crossoverPoint2--;
       // System.out.println(crossoverPoint1 + "  "+crossoverPoint2);
        for (int i = crossoverPoint1; i <= crossoverPoint2; i++)
        {
            // System.out.println(chromosome1.getChromeTimeString()[i]+"  "+chromosome2.getChromeTimeString()[i]);
            temp= chromosome1.getChromeMachineString()[i];
            chromosome1.getChromeMachineString()[i] = chromosome2.getChromeMachineString()[i];
            chromosome2.getChromeMachineString()[i] = temp;
            temp = chromosome1.getChromeTimeString()[i];
            chromosome1.getChromeTimeString()[i]    = chromosome2.getChromeTimeString()[i];
            chromosome2.getChromeTimeString()[i]    = temp;
        }
       
        
        chromosome1.integerStringToChromosome();
        chromosome2.integerStringToChromosome();
        
    }

   
}


//~ Formatted by Jindent --- http://www.jindent.com
