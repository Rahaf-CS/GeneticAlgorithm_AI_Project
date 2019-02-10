# GeneticAlgorithm_AI_Project
AI_Project 2018 : (Genetic Algorithm using Java)
Introduction: In this project we provide an optimal solution for the Multiprocessor Scheduling problem (MPSP). which means that for a given set of N jobs each with an associated completion time, and two identical processors, we divide the set of jobs into two subset such that the difference between their sums of processing time is minimum.

Strategy: We are going to consider the Multiprocessor Scheduling Problem (MPSP) as an optimization problem, therefore the searching algorithm we choose to implement is the Genetic algorithm, it’s a local search algorithm with the objective function that we specified in Phase 1 that we now call the fitness function: F(n) = ∑S1 -∑S2.

Pseudocode: Genetic algorithm begins with a set of k randomly generated states, called the population. Each state, or individual, is represented as (X and Y), then each individual is rated by the fitness function, if one of the individuals is the goal then the algorithm stops. else select from the states using selection function and generate new solution by the crossover function and the mutation function. The algorithm keeps repeating this process until population has converged.

fitness function: Determines how fit an individual by calculating the difference of the sum of values in X minus the sum of values in Y.

Selection function: Two pairs of individuals are selected based on their fitness scores. Individuals with lower value fitness have more chance to be selected for reproduction.

Crossover function: A crossover point is chosen at random from within the genes, then the Offspring are created by exchanging the genes of parents among themselves until the crossover point is reached. Then the new offspring are added to the population.

mutation function: In certain new offspring formed, it will flip some Y’s to x and some X’s to Y.

Implementation: In our program we have three classes: the main class, the gene class, and the population class. The gene class which contains the array of gene, constructer, and the function that calculate the fitness of a gene. The population class contains a set of functions that calculate the most optimal gene, the second most optimal gene, and the least optimal index, also a function that calculate the fitness for each gene. The main class (Genetic Algorithm) contains three objects, an array list of jobs, and five other functions.
