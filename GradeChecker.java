import java.util.Scanner;

public class GradeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
      
        System.out.print("Enter student score (out of 100): ");
        
        // Input validation (optional, but good practice)
        if (!scanner.hasNextInt()) {
            System.out.println("Error: Invalid input. Please enter an integer score.");
            scanner.close();
            return;
        }
        
        int score = scanner.nextInt();
        String grade = "";
        String remark = "";
        
        // Basic range check
        if (score < 0 || score > 100) {
            grade = "N/A";
            remark = "Invalid Score. Must be between 0 and 100.";
        } else {
          
            
            if (score >= 80) { // 80-100 [cite: 31]
                grade = "1";
                remark = "Distinction";
            } else if (score >= 75) { // 75-79 [cite: 31]
                grade = "2";
                remark = "Distinction";
            } else if (score >= 66) { // 66-74 [cite: 31]
                grade = "3";
                remark = "Credit";
            } else if (score >= 60) { // 60-65 [cite: 31]
                grade = "4";
                remark = "Credit";
            } else if (score >= 50) { // 50-59 [cite: 31]
                grade = "5";
                remark = "Credit";
            } else if (score >= 45) { // 45-49 [cite: 31]
                grade = "6";
                remark = "Credit";
            } else if (score >= 35) { // 35-44 [cite: 31]
                grade = "7";
                remark = "Pass";
            } else if (score >= 30) { // 30-34 [cite: 31]
                grade = "8";
                remark = "Pass";
            } else { // 0-29 [cite: 31]
                grade = "9";
                remark = "Fail";
            }
        }
        
        
        System.out.println("\n--- Grading Result ---");
        System.out.println("Score: " + score);
        System.out.println("Grade: " + grade);
        System.out.println("Remark: " + remark);
        System.out.println("----------------------");

        scanner.close();
    }
}