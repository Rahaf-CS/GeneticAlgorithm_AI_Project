package aiproject1;
/**
 *
 * @author Layan
 */
public class Population {
    
    Gene[] genes = new Gene[5000]; //array of genes
    int optimal; //what we want to reach
    
    public void initializePopulation(int size){
        for (int i = 0; i < genes.length; i++) {
            genes[i] = new Gene();
        }
    }
    //get optimal gene
    public Gene getOptimal(){
        int lowerFit = Integer.MAX_VALUE; // the worst case 
        int maxOPTindex = 0;//
       
        //loop to find lowest value fitness in array genes
         for(int i=0;i<genes.length;i++){
         if(lowerFit>=genes[i].fitness) //anything better than the worst case
             lowerFit=genes[i].fitness;
              maxOPTindex = i;
         
         }
        optimal = genes[maxOPTindex].fitness; // new optimal gene
        return genes[maxOPTindex];// return the optimal gene
    }//END GET OPTIMAL
    
    //get gene with second lowest fitness for selection
    public Gene getSecondOptimal(){
        int lowfit1=0;
        int lowfit2=0;
        
        for(int i=0;i<genes.length;i++){
            
        if(genes[i].fitness<genes[lowfit1].fitness){
            
        lowfit2=lowfit1;
        lowfit1=i;
        
        }//end if
        else if(genes[i].fitness<genes[lowfit2].fitness){
            lowfit2=i;
            }//end else 
        }//end for
        
        //get gene with second lowest fitness for selection
        return genes[lowfit2]; 
    }//END GET SECOND OPTIMAL
    
    //get least optimal gene index
    public int getLeastOptimal(){
        int LeastOptimalindex = 0;
        int LeastOptimalValue=0;
        
        for(int i=0;i<genes.length;i++){
        
            if(LeastOptimalValue<=genes[i].fitness){
                
            LeastOptimalValue=genes[i].fitness;
            LeastOptimalindex=i;
            
            }//end if
        }//end for
        
        return LeastOptimalindex;// return the least optimal gene index
    }//END LEAST OPTIMAL INDEX
    
    //calculate fitness for each gene
    public void calculateFitnessAll(){
        for (Gene gene : genes) {
            gene.calcfitness();
        } //end for
        
        getOptimal();
        
    }//END CALC FITNESS ALL 
    
}//END POPULATION
