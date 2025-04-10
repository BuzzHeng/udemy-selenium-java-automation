import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class testExercise {

    @Test
    public void testExercise() {
        PrintStream originalOut = System.out; // Save original System.out

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // Prepare to capture output
        System.setOut(new PrintStream(outputStream)); // Redirect System.out

        Exercise.main(new String[]{}); // Run the main method

        System.setOut(originalOut); // Restore System.out

        String[] lines = outputStream.toString().trim().split("\\R"); // Split output into lines

        String firstElement = lines[0]; // First printed element
        String lastElement = lines[1];  // Last printed element

        int reverseSize = lines.length - 3; // Reverse section size
        String[] reverseLines = new String[reverseSize]; // Store reverse output lines
        System.arraycopy(lines, 2, reverseLines, 0, reverseSize); // Copy reverse lines

        String totalLine = lines[lines.length - 1]; // Last line is the total

        // === Assertions ===

        assertTrue(firstElement.matches("\\d+"), "First element should be a number"); // Check first is number
        assertTrue(lastElement.matches("\\d+"), "Last element should be a number");   // Check last is number

        for (int i = 0; i < reverseLines.length - 1; i++) { // Check reverse order
            int current = Integer.parseInt(reverseLines[i]); // Current value
            int next = Integer.parseInt(reverseLines[i + 1]); // Next value
            assertTrue(current > next, "Reverse numbers should go down"); // Descending check
        }

        int calculatedSum = 0; // Initialize sum
        for (int i = 2; i < lines.length - 1; i++) { // Sum reverse section
            calculatedSum += Integer.parseInt(lines[i]); // Add each line
        }

        int printedSum = Integer.parseInt(totalLine); // Get printed total
        assertEquals(calculatedSum, printedSum, "Printed total should match calculated sum"); // Compare totals
        System.out.println("✅ Tests passed! Output format and values are correct."); // Success message
    }
}
