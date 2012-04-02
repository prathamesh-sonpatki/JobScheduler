/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import org.jscience.mathematics.number.Real;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author chaitanya
 */
public class CrossOverController {
    ArrayList <Integer> selectedChromosomeIndices;
 void chooseChromosomes(int populationSize , Configuration config) {
     selectedChromosomeIndices = new ArrayList<Integer>(populationSize);

        for(int i = 0;i <populationSize; i++)
       {
           Random rand = new Random();
           Real prob = Real.valueOf(rand.nextDouble());
           if(prob.isLessThan(config.getCrossoverProbability()))
           {
                  selectedChromosomeIndices.add(i);
           }
       }
    }

 void performCrossOver(Population newPopulation , Configuration configuration)
    {
     
     for(int i = 0; i< selectedChromosomeIndices.size();i = i + 2)
     {
             TwoPointCrossover crossOver = new TwoPointCrossover();
             crossOver.performCrossover(newPopulation.getChromosomes()[i], newPopulation.getChromosomes()[i+1]);
     }
 }
}
