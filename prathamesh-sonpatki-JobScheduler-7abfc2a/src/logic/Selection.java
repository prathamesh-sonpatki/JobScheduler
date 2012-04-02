package logic;

import java.util.Random;
import org.jscience.mathematics.number.Real;

/**
 *
 * @author Pawan
 */
class Selection {

    void select(int index,Population origPop, Population newPop) {

       
       int i = 0;
       
       Real  prob = Real.valueOf(new Random().nextDouble());
      
       if(prob.isLessThan(origPop.getChromosomes()[0].getWeightInRouletteWheel()))
       {
           
           newPop.setChromosomes(index,origPop.getChromosomes()[0]);
           newPop.getChromosomes()[index].setSelectedCount(newPop.getChromosomes()[index].getSelectedCount()+1);
           
       }
       else 
       {
           i = 1;
  
          
           
                    while( i < origPop.getPopulationSize() && prob.isLargerThan(origPop.getChromosomes()[i].getCumulativeRouletteWeight()))
                    {
                              i++;
                    }
           if(i  <=origPop.getPopulationSize())
           {
                   newPop.setChromosomes(index,origPop.getChromosomes()[i-1]);
                  newPop.getChromosomes()[index].setSelectedCount(newPop.getChromosomes()[index].getSelectedCount()+1);
                   
                  
                   
           }
            
        }
     
    }

    
}
