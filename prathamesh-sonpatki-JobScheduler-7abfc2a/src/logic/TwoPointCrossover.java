package logic;

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

        Random random = new Random();

        int crossoverPoint1 = random.nextInt(chromosome1.ChromosomeLength);
        int crossoverPoint2 = random.nextInt(chromosome1.ChromosomeLength);

        if(crossoverPoint1 > crossoverPoint2)
        {
            int temp = crossoverPoint1;
            crossoverPoint1 = crossoverPoint2;
            crossoverPoint2 = temp;
        }

        for(int i=crossoverPoint1;i<= crossoverPoint2;i++)
        {
            int temp;
            temp = chromosome1.ChromeMachineString[i];
            chromosome1.ChromeMachineString[i] = chromosome2.ChromeMachineString[i];
            chromosome2.ChromeMachineString[i] = temp;

            temp = chromosome1.ChromeTimeString[i];
            chromosome1.ChromeTimeString[i] = chromosome2.ChromeTimeString[i];
            chromosome2.ChromeTimeString[i] = temp;

        }

        chromosome1.StringToChromosome(chromosome1.ChromeMachine, chromosome1.ChromeTime, chromosome1.GeneCount);
        chromosome2.StringToChromosome(chromosome2.ChromeMachine, chromosome2.ChromeTime, chromosome2.GeneCount);

    }


}
