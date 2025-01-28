import java.util.Random;

public class FootballTeam {

    public int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    public double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    public int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }
        return shortest;
    }

    public int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] heights = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = random.nextInt(101) + 150;
        }

        FootballTeam team = new FootballTeam();
        int sum = team.findSum(heights);
        double mean = team.findMean(heights);
        int shortest = team.findShortest(heights);
        int tallest = team.findTallest(heights);

        System.out.println("Player Heights: ");
        for (int height : heights) {
            System.out.print(height + " ");
        }
        System.out.println();
        System.out.println("Sum of Heights: " + sum);
        System.out.println("Mean Height: " + mean);
        System.out.println("Shortest Height: " + shortest);
        System.out.println("Tallest Height: " + tallest);
    }
}
