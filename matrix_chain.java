public class MatrixChainMultiplication {
    public static int matrixChainOrder(int[] arr) {
        int n = arr.length - 1; // Number of matrices
        int[][] dp = new int[n][n]; // DP table
        int stepCount = 0; // Step counter

        // Fill DP table (Base Case: Single matrix multiplication cost is 0)
        for (int len = 2; len <= n; len++) { // Length of chain
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE; // Initialize with large value
                
                for (int k = i; k < j; k++) {
                    // Cost calculation for splitting at k
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i] * arr[k + 1] * arr[j + 1];
                    stepCount++; // Count each multiplication step

                    dp[i][j] = Math.min(dp[i][j], cost); // Store minimum cost
                }
            }
        }

        System.out.println("Total Multiplication Steps: " + stepCount); // Print step count
        return dp[0][n - 1]; // Answer is stored at dp[0][n-1]
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40};  // Example 1
        System.out.println("Minimum Multiplications: " + matrixChainOrder(arr1)); // Expected: 18000

        int[] arr2 = {5, 10, 3, 12, 5};  // Example 2
        System.out.println("Minimum Multiplications: " + matrixChainOrder(arr2)); // Expected: 270
    }
}
