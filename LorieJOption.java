/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loriejoption;

import javax.swing.JOptionPane;

/**
 *
 * @author lorie
 */
public class LorieJOption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean main = true;

        while (main == true) {

            String store = JOptionPane.showInputDialog("Welcome to tindahan sa mga boang! \n Do you want to go shop?");
            String code;
            boolean check = false;

            boolean repeat = false;
            double totalcost = 0.00;
            String[] product = {"[1]    Nike", "[2]    Jordan", "[3]    Fendi", "[4]    Fila", "[5]   LV"};
            double[] prices = {7000, 3600, 5000, 1000, 7000};
            String rer = "";
            double discount;
            while (store.equalsIgnoreCase("yes")) {

                String sel = JOptionPane.showInputDialog("Please select Product "
                        + "\n input number to Product Code "
                        + "\n Item               Cost              Code"
                        + "\n Nike              PHP 7000              1 "
                        + "\n Jordan            PHP 3600              2 "
                        + "\n Fendi             PHP 5000              3 "
                        + "\n Fila              PHP 1000              4 "
                        + "\n LV                PHP 7000              5 ");

                int select = Integer.parseInt(sel);
                double price = 0;
                String productName = "";

                switch (select) {
                    case 1:
                        price = prices[0];
                        productName = product[0];

                        check = true;
                        break;
                    case 2:
                        price = prices[1];
                        productName = product[1];

                        check = true;
                        break;
                    case 3:
                        price = prices[2];
                        productName = product[2];
                        check = true;
                        break;
                    case 4:
                        price = prices[3];
                        productName = product[3];

                        check = true;
                        break;
                    case 5:
                        price = prices[4];
                        productName = product[4];

                        check = true;
                        break;
                }
                if (check == true) {
                    String quant = JOptionPane.showInputDialog("You selected " + productName + " for PHP " + price + "\nEnter quantity:");
                    int quantity = Integer.parseInt(quant);
                    double subtotal = price * quantity;
                    totalcost += subtotal;
                    rer += productName + "\t" + quantity + "\t" + price + "\n";
                    JOptionPane.showMessageDialog(null, "Subtotal: " + quantity + " * " + price + " = PHP " + subtotal);
                    // Ask if user wants to order another item
                    store = JOptionPane.showInputDialog("Do you want to order another item? (yes/no)");

                }
                if (store.equalsIgnoreCase("no")) {
                    code = JOptionPane.showInputDialog("You selected \n" + rer + "\nTotal: PHP " + totalcost + "\nDO you have a voucher? Please input in the system. Otherwise, input no");

                    if (code.equalsIgnoreCase("5%")) {
                        discount = (totalcost * (-0.5));
                        totalcost = totalcost + discount;
                        JOptionPane.showInputDialog("You selected \n" + rer);
                        JOptionPane.showInputDialog("Discount " + (discount * -1) + "\nTotal: PHP " + totalcost);
                    }
                    if (code.equalsIgnoreCase("12%")) {
                        discount = (totalcost * (-0.12));
                        totalcost = totalcost + discount;
                        JOptionPane.showInputDialog("You selected \n" + rer);
                        JOptionPane.showInputDialog("Discount " + (discount * -1) + "\nTotal: PHP " + totalcost);
                    }
                    if (code.equalsIgnoreCase("10%")) {
                        discount = (totalcost * (-0.1));
                        totalcost = totalcost + discount;
                        JOptionPane.showInputDialog("You selected \n" + rer);
                        JOptionPane.showInputDialog("Discount " + (discount * -1) + "\nTotal: PHP " + totalcost);
                    }
                    if (code.equalsIgnoreCase("50%")) {
                        discount = (totalcost * (-0.50));
                        totalcost = totalcost + discount;
                        JOptionPane.showInputDialog("You selected \n" + rer);
                        JOptionPane.showInputDialog("Discount " + (discount * -1) + "\nTotal: PHP " + totalcost);
                    }

                    double payment = 0;
                    int nil = 0;
                    for (int i = 0; i < 3; i++) {
                        String pay = JOptionPane.showInputDialog("Please enter the amount of money to pay: ");
                        payment = Double.parseDouble(pay);

                        // Check if payment is sufficient
                        if (payment < totalcost) {
                            JOptionPane.showMessageDialog(null, "Insufficient funds. Retry Again");
                            nil += 1;

                        } else {
                            double change = payment - totalcost;

                            JOptionPane.showMessageDialog(null, "Payment accepted. Your change is PHP " + change + "\n Products: \n" + rer + "\nThank you for Shopping With Us!");
                            repeat = true;
                        }

                    }
                    if (nil == 3) {
                        JOptionPane.showMessageDialog(null, "Sorry you dont have enough balance! please select another item. 3 attemps only!!");
                    }

                }

                main = true;
            }
        }
    }
}
