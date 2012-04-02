package logic;

import org.jscience.mathematics.number.Real;

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */

/**
 *
 * @author Pawan
 */
public class Configuration {
    CrossOverScheme       crossoverScheme;
    RandomNumberGenerator randomNumberGenerator;
    Real populationSize;
    Real crossoverProbability;
    Real mutationProbability;

     Configuration()
    {
         crossoverProbability = Real.valueOf(0.8);
         mutationProbability = Real.valueOf(0.4);
     }
    final void setCrossoverScheme(String option) {
        if (option.equals("Single Point Crossover")) {

            // crossoverScheme = new SinglePointCrossover();
        } else if (option.equals("Two Point Crossover")) {

            // crossoverScheme = new TwoPointCrossover();
        }
    }

    public Real getCrossoverProbability() {
        return crossoverProbability;
    }

    public void setCrossoverProbability(Real crossoverProbability) {
        this.crossoverProbability = crossoverProbability;
    }

    public Real getMutationProbability() {
        return mutationProbability;
    }

    public void setMutationProbability(Real mutationProbability) {
        this.mutationProbability = mutationProbability;
    }

    public Real getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(Real populationSize) {
        this.populationSize = populationSize;
    }

    final void setRandomNumberGenerator(String option) {
        if (option.equals("MersenneTwister")) {
            randomNumberGenerator = new MersenneTwister();
        }
    }

    CrossOverScheme getCrossoverScheme() {
        return this.crossoverScheme;
    }

    RandomNumberGenerator getRandomNumberGenerator() {
        return this.randomNumberGenerator;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
