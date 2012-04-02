package logic;

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */

/**
 *
 * @author Pawan
 */
public class SinglePointCrossover extends Configuration implements CrossOverScheme {

    /**
     *
     * @param chromosome1
     * @param chromosome2
     */
    public void performCrossover(Chromosome chromosome1, Chromosome chromosome2) {
        int crossoverPoint = randomNumberGenerator.nextInt();

        for (int i = crossoverPoint; i < chromosome1.chromosomeLength; i++) {
            int temp;

            // temp = chromosome1.ChromeMachine[i];
            // chromosome1.ChromeMachine[i] = chromosome2.ChromeMachine[i];
            // chromosome2.ChromeMachine[i] = temp;

//          temp = chromosome1.ChromeTime[i];
            // chromosome1.ChromeTime[i] = chromosome2.ChromeTime[i];
            // chromosome2.ChromeTime[i] = temp;
        }

        chromosome1.integerStringToChromosome();
        chromosome2.integerStringToChromosome();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
