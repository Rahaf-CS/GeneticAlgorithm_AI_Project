package aiproject1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Layan
 */
public class GeneticAlgorithm {
    
    public static int length = 0;
    private static ArrayList jobs = new ArrayList(); // array of jobs
    static Population population = new Population();
    static Gene firstOptimal;
    static Gene secondOptimal;
    int generation = 0;
    
    public static void main(String[] args) throws IOException{
        FileInputStream in = null;

      try {
         in = new FileInputStream("MPSP_35.txt"); //text file to test !!

          Scanner scanner = new Scanner(in);
          scanner.useDelimiter("\\D");
          int k;

          while (scanner.hasNext()){
            k = scanner.nextInt();
            jobs.add(k);
            length++;
         }//while
           
      } finally {
         if (in != null) {
            in.close();
         }
     }//END read
      
     //Initialization
        Random rand = new Random();
        GeneticAlgorithm GA = new GeneticAlgorithm();
        
        GeneticAlgorithm.population.initializePopulation(length);//population
        
        GeneticAlgorithm.population.calculateFitnessAll();//calculate fitness for all genes
        
        System.out.println("Generation: "+ GA.generation + " Most Optimal: "
                + GeneticAlgorithm.population.optimal);
                //^ start with generation 0 ^
              
      int min = GeneticAlgorithm.population.optimal , g = GA.generation;
      char [] seok = new char[length];//stores the optimal gene
              
      while(GeneticAlgorithm.population.optimal !=0){
        GA.generation++;
        GeneticAlgorithm.selection();
        GeneticAlgorithm.crossover();
        if(rand.nextInt()%7 < length){
            GeneticAlgorithm.mutation();
        }
        GA.addOptimalOffspring();
        GeneticAlgorithm.population.calculateFitnessAll();
        System.out.println("Generation: "+ GA.generation + " Most Optimal: "+GeneticAlgorithm.population.optimal);
       
        if(GeneticAlgorithm.population.optimal < min){
            min = GeneticAlgorithm.population.optimal;
            g = GA.generation;
            
            System.arraycopy(GeneticAlgorithm.population.getOptimal().genes, 0, seok, 0, length);
        }
        
        if(GA.generation > 2000){
            break;
        }//due to hardware limitation we terminate the search if it gets too long
//if we let it search 10k generation for example, it might find the optimal solution but my laptop will burn...
        
    }//END WHILE
      
          ArrayList s1 = new ArrayList();
          ArrayList s2 = new ArrayList();

        System.out.println("Solution found in generation: "+g);
        System.out.println("Fitness: "+min);
        System.out.print("Genes: ");
        for(int i= 0; i< length ; i++){
            System.out.print(seok[i]+" "); 

            if(seok[i]=='X'){
                s1.add(jobs.get(i));
            }else{
                s2.add(jobs.get(i));
            }
        }
        System.out.println();
        
        System.out.print("Jobs in subset 1: ");
        for(int i=0;i<s1.size();i++){
        System.out.print(s1.get(i)+" "); 
        } 
        
        System.out.println();
        
        System.out.print("Jobs in subset 2: ");
        for(int i=0;i<s2.size();i++){
        System.out.print(s2.get(i)+" ");
        }
        
        System.out.println();
 
    }//END MAIN
    
    public static int getJob(int i){
        int time = (int) jobs.get(i);
        return time;
    }
    //Selection
    public static void selection() {
        //select the most optimal
        firstOptimal=population.getOptimal();
        
        //select the second most optimal
        secondOptimal=population.getSecondOptimal();
    }
    //Crossover
    public static void crossover(){
        Random rn=new Random();

        //Select a random crossover point
         int crossOverPoint=rn.nextInt(length)+0;
         
         // Swap values among parents
         for(int i=0;i<crossOverPoint;i++){
         char temp=firstOptimal.genes[i];
         firstOptimal.genes[i]=secondOptimal.genes[i];
         secondOptimal.genes[i]=temp;
         }//end if   
    }
    //Mutation
    public static void mutation(){
        Random rand = new Random();
        int mutationPoint = rand.nextInt(length)+0;

        if(firstOptimal.genes[mutationPoint]=='X')
            firstOptimal.genes[mutationPoint]='Y';
        else
            firstOptimal.genes[mutationPoint]='X';
        mutationPoint = rand.nextInt(length)+0;
        if(secondOptimal.genes[mutationPoint]=='X')
            secondOptimal.genes[mutationPoint]='Y';
        else
            secondOptimal.genes[mutationPoint]='X';
    }
    //Get optimal gene / offspring
    Gene getOptimalOffspring(){
        if(firstOptimal.fitness > secondOptimal.fitness)
            return firstOptimal;
        else
            return secondOptimal;
    }
    //Replace least fittest gene from most fittest offspring
    void addOptimalOffspring(){
        firstOptimal.calcfitness();
        secondOptimal.calcfitness();
        
        int leastOptimalIndex = population.getLeastOptimal();
        //replace least optimal with most
        population.genes[leastOptimalIndex] = getOptimalOffspring();
    }
    
}//END GENETIC ALGORITHM
/*
MADE FOR CS340
BY: LAYAN , NADA , RAHAF
LAST REVISION: 4/8/2018
*/
