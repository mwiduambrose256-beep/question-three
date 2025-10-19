import java.util.Scanner;

public class MultiStudentGrader {
    
    
    public static int getGradeFromScore(int score) {
        if (score >= 80) return 1;    // Distinction 1 [cite: 31]
        if (score >= 75) return 2;    // Distinction 2 [cite: 31]
        if (score >= 66) return 3;    // Credit 3 [cite: 31]
        if (score >= 60) return 4;    // Credit 4 [cite: 31]
        if (score >= 50) return 5;    // Credit 5 [cite: 31]
        if (score >= 45) return 6;    // Credit 6 [cite: 31]
        if (score >= 35) return 7;    // Pass 7 [cite: 31]
        if (score >= 30) return 8;    // Pass 8 [cite: 31]
        return 9;                     // Fail 9 [cite: 31]
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int TOTAL_STUDENTS = 5; // Process scores for five (5) students 
        int studentsProcessed = 0;
        
        // Array to store counts for grades 1 through 9.
        // Index 0 stores count for Grade 1, Index 1 stores count for Grade 2, ..., Index 8 stores count for Grade 9.
        int[] gradeCounts = new int[9]; 
        
        System.out.println("--- Bukoto School: Multi-Student Grading ---");

        // i) Accept and process scores for five (5) students using a while loop. 
        while (studentsProcessed < TOTAL_STUDENTS) {
            System.out.print("\nEnter score for Student " + (studentsProcessed + 1) + " (0-100): ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Invalid input. Skipping student and continuing.");
                scanner.next(); // Consume the invalid input
                continue;
            }
            
            int score = scanner.nextInt();
            scanner.nextLine(); // Consume newline left by nextInt()
            
            if (score < 0 || score > 100) {
                System.out.println("Error: Score " + score + " is out of the valid range (0-100). Please re-enter the score.");
                // Decrement to re-process the current student's slot
                continue;
            }
            
            // Get grade (1 to 9)
            int grade = getGradeFromScore(score);
            
            // Increment the count for that specific grade (Grade 1 maps to index 0)
            gradeCounts[grade - 1]++;
            
            System.out.println("Score: " + score + " assigned Grade: " + grade);
            
            studentsProcessed++;
        }
        
       
        System.out.println("\n==================================");
        System.out.println("GRADE DISTRIBUTION SUMMARY");
        System.out.println("==================================");
        
        for (int i = 0; i < gradeCounts.length; i++) {
            int gradeNumber = i + 1;
            int count = gradeCounts[i];
            
            System.out.printf("Grade %s (%s): %d students\n", 
                              (gradeNumber), 
                              (gradeNumber <= 6 ? "Credit/Distinction" : gradeNumber <= 8 ? "Pass" : "Fail"), 
                              count);
        }
        System.out.println("==================================");

        scanner.close();
    }
}