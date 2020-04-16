import java.io.*; 
  
class GFG { 
  
// Initial values of  
// Aplha and Beta 
static int MAX = 1000; 
static int MIN = -1000; 
static int count=0;
// Returns optimal value for 
// current player (Initially called 
// for root and maximizer) 
static int minimax(int depth, int nodeIndex,  
                   Boolean maximizingPlayer, 
                   int values[], int alpha, 
                   int beta) 
{ 
    // Terminating condition. i.e  
    // leaf node is reached 
    if (depth == 3) 
        return values[nodeIndex]; 
  
    if (maximizingPlayer) 
    { 
        int best = MIN; 
  
        // Recur for left and 
        // right children 
        for (int i = 0; i < 2; i++) 
        { 
            int val = minimax(depth + 1, nodeIndex * 2 + i, 
                              false, values, alpha, beta); 
            best = Math.max(best, val); 
            alpha = Math.max(alpha, best); 
  
            // Alpha Beta Pruning 
            if (beta <= alpha) 
                {count++;break;} 
        } 
        return best; 
    } 
    else
    { 
        int best = MAX; 
  
        // Recur for left and 
        // right children 
        for (int i = 0; i < 2; i++) 
        { 
              
            int val = minimax(depth + 1, nodeIndex * 2 + i, 
                              true, values, alpha, beta); 
            best = Math.min(best, val); 
            beta = Math.min(beta, best); 
  
            // Alpha Beta Pruning 
            if (beta <= alpha) 
                {count++;break;} 
        } 
        return best; 
    } 
} 
  
    // Driver Code 
    public static void main (String[] args) 
    { 
          
        int values[] = {10, -7, 24, 30, 90, -30, 20, 32}; 
        System.out.println("The optimal value is : " + 
                            minimax(0, 0, true, values, MIN, MAX)); 
      System.out.println("no of prunings are:"+count);
    } 
} 