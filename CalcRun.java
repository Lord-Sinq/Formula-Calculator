/**
 * @author Sinclair DeYoung
 * @version 1.0
 * @since 2023-10-01
 * This is the main class that runs the calculator application.
 */

// Importing necessary classes for GUI components
import java.awt.*;
import javax.swing.*; // Importing Swing for GUI components

public class CalcRun {
    /**
     * @param args 
     * This is the main method that initializes and runs the calculator application.
     * It sets up the GUI components, including buttons and display.
     * It uses GridBagLayout for flexible layout management and adds buttons for digits and operations.
     * The main method creates a JFrame, sets its properties, and adds components to it.
     * It also handles button clicks to perform calculations and update the display.
     * The calculator supports basic operations like addition, subtraction, multiplication, and division.
     * The display shows the current input and result of calculations.
     * The calculator can handle multiple operations and updates the display accordingly.
     */
    
    private JPanel buttonPanel; // Panel to hold calculator buttons
    private JPanel mainPanel; // Main panel for the calculator
    private JButton[] numberButtons; // Array to hold number buttons (0-9)
    private JTextField display; // Text field for displaying calculations
    private double result; // Variable to store the result of calculations
    private String operator; // Variable to store the current operator
    private boolean calculating; // Flag to indicate if a calculation is in progress
    private JComboBox<String> formulaSelector; // ComboBox for selecting operators (e.g., +, -, *, /)
    /**
     * Constructor for the calcRun class.
     * It initializes the GUI components and sets up the layout for the calculator application.
     */
    
    public CalcRun(){
        /**
         * This is the main method that initializes and runs the calculator application.
         */
        // running the calc application
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout()); // Set the layout manager for the frame

        // initualize the display
        display = new JTextField(); // Create a text field for displaying calculations
        display.setEditable(false); // Make the display non-editable
        display.setFont(new Font("Arial", Font.PLAIN, 24)); // Set font for the display
        display.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right

        // initialize the forula panel
        mainPanel = new JPanel(); 
        mainPanel.setLayout(new BorderLayout()); // Set the layout manager for the formula panel
        mainPanel.setBorder(BorderFactory.createTitledBorder("Formula's")); // Add a border with title
        
        String[] formulas = {
            "Addition (+)",
            "Subtraction (-)",
            "Multiplication (*)",
            "Division (/)"
        }; // Array of formulas for the JComboBox
        formulaSelector = new JComboBox<>(formulas); // Create a JComboBox for selecting formulas
        formulaSelector.addActionListener(e -> {
            String selectedFormula = (String) formulaSelector.getSelectedItem(); // Get the selected formula
            display.setText("Selected Formula: " + selectedFormula); // Clear the display when a new formula is selected
        });
        mainPanel.add(formulaSelector, BorderLayout.NORTH); // Add the JComboBox to the main panel
        mainPanel.add(display, BorderLayout.CENTER); // Add the display to the main panel

        buttonPanel = new JPanel(new GridLayout(4, 4, 10, 10)); // Create a panel for the calculator buttons
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Buttons")); // Add a border with title
        
        JButton[] numberButtons = new JButton[10]; // Array to hold number buttons (0-9)
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i)); // Create buttons for digits 0-9
            int finalI = i; // Final variable for lambda expression
            numberButtons[i].addActionListener(e -> {
                display.setText(display.getText() + finalI); // Append digit to display when button is clicked
            });
            buttonPanel.add(numberButtons[i]); // Add button to the panel
        }

        // Adding operation buttons
        String[] operations = {"+", "-", "*", "/"}; // Array of operation symbols
        for (String operation : operations) {
            JButton operationButton = new JButton(operation); // Create a button for each operation
            operationButton.addActionListener(e -> {
                if (!display.getText().isEmpty()) {
                    result = Double.parseDouble(display.getText()); // Parse the current display value as a double
                    operator = operation; // Set the current operator
                    display.setText(""); // Clear the display for the next input
                }
            });
            buttonPanel.add(operationButton); // Add operation button to the panel
        }

        // create an instance of the calculator class
        Calculator calculator = new Calculator(); // Create an instance of the calculator class (assuming it's defined elsewhere)

        JButton equalsButton = new JButton("="); // Create an equals button
        equalsButton.addActionListener(e -> {
            // preform calculation (basic implementation)
            try {
                String[] parts = display.getText().split(" "); // Split the display text to get operands
                double num1 = Double.parseDouble(parts[0]); // Parse the first number
                String operator = parts[1]; // Get the operator from the display text
                double num2 = Double.parseDouble(parts[2]); // Parse the second number
                double result = switch (operator) { // Perform calculation based on the operator
                    case "+" -> num1 + num2; // Addition
                    case "-" -> num1 - num2; // Subtraction
                    case "*" -> num1 * num2; // Multiplication
                    //case "/" -> {if (num2 == 0) {throw new ArithmeticException("Division by zero is not allowed.");} yield num1 / num2;} // Division
                    case "/" -> num2 != 0 ? num1 / num2 : Double.NaN; // Division with check for zero
                    default -> 0; // Default case
                };
                display.setText(String.valueOf(result)); // Set the display to the result of the calculation
                
            } catch (Exception ex) {
                display.setText("Error: " + ex); // Display error if calculation fails
            }
        });
        buttonPanel.add(equalsButton); // Add equals button to the panel

        // add a clear button to reset the calculator
        JButton clearButton = new JButton("C"); // Create a clear button
        clearButton.addActionListener(e -> display.setText("")); // Clear the display when the button is clicked
        buttonPanel.add(clearButton); // Add clear button to the panel

        // add panel to the frame
        frame.add(mainPanel, BorderLayout.NORTH); // Add the main panel to the frame
        frame.add(buttonPanel, BorderLayout.CENTER); // Add the button panel to the frame

        //finalize and display the frame
        frame.pack(); // Pack the frame to fit the components
        frame.setVisible(true); // Make the frame visible
        frame.setLocationRelativeTo(null); // Center the frame on the screen
    } // End of constructor
}