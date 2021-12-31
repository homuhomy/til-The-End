import javax.swing.*;

public class jpane {
    public static void main(String[] args) {
        int g = -1;
        while (g < 0) {
            String input = JOptionPane.showInputDialog("Please enter your name: ");
            if (input.length() > 0){
                g++;
                System.out.println("Thank You");
            }
            else
                System.out.println("Enter your name!");
        }
    }
}
