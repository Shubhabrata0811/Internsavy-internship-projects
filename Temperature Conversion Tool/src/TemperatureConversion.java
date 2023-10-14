import javax.swing.*;
import java.awt.event.*;


public class TemperatureConversion extends JFrame implements ActionListener {

    public TemperatureConversion(){
        super("Temperature Conversion");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public double fahrenheitToCelsius(double fahrenheit){
        double celsius = (fahrenheit - 32) * 5 / 9;
        return celsius;
    }

    public double celsiusToFahrenheit(double celsius){
        double fahrenheit = (celsius * 9 / 5) + 32;
        return fahrenheit;
    }
    public static void main(String[] args) {
        // Declare variables
        String input;
        double fahrenheit;
        double celsius;
        int choice;

        String[] options = {"Fahrenheit to Celsius", "Celsius to Fahrenheit"};
        JComboBox<String> dropdown = new JComboBox<>(options);
        choice = JOptionPane.showOptionDialog(null, dropdown, "Select an option", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
        String selectedOption = (String) dropdown.getSelectedItem();

        if(selectedOption == "Fahrenheit to Celsius"){
            choice = 1;
        }else{
            choice = 2;
        }


        // If choice is 1, convert Fahrenheit to Celsius
        if (choice == 1) {
            input = JOptionPane.showInputDialog("Enter degrees Fahrenheit");
            fahrenheit = Double.parseDouble(input);
            celsius = (fahrenheit - 32) * 5 / 9;
            JOptionPane.showMessageDialog(null, fahrenheit + " degrees Fahrenheit is " + celsius + " degrees Celsius");
        }

        // If choice is 2, convert Celsius to Fahrenheit
        else if (choice == 2) {
            input = JOptionPane.showInputDialog("Enter degrees Celsius");
            celsius = Double.parseDouble(input);
            fahrenheit = (celsius * 9 / 5) + 32;
            JOptionPane.showMessageDialog(null, celsius + " degrees Celsius is " + fahrenheit + " degrees Fahrenheit");
        }

        // If choice is not 1 or 2, display error message
        else {
            JOptionPane.showMessageDialog(null, "Invalid choice");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}