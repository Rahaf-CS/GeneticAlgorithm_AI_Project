package aiproject1;
import java.util.Random;
/**
 *
 * @author Layan
 */
public class Gene {

    int fitness = 0;
    int geneLength = GeneticAlgorithm.length;
    char [] genes = new char [geneLength]; //[X,Y,X,X,Y...]
    
    public Gene(){
           Random rn = new Random();
          //constructor > random > X Y  
      for(int i=0;i<genes.length;i++){
          double v=0;
          v=Math.abs(rn.nextInt()%2);
          if(v==0) genes[i]='X';
          else genes[i]='Y';
      }
     
    fitness=0;
    }
    //calculate fitness
    public void calcfitness(){
        fitness=0;
        int subX=0, subY=0;
        
        for(int i=0;i<genes.length;i++){
        if (genes[i]=='X'){
          subX+=GeneticAlgorithm.getJob(i);  }//end if,values of x
        else 
            subY+=GeneticAlgorithm.getJob(i);//values of y
        }//END FOR

        fitness = Math.abs(subX - subY); //f(n) = S1 - S2 
    }

}//END GENE
