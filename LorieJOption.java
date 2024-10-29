/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loriejoption;

import javax.swing.JOptionPane;

/**
 *
 * @author yuanb
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
            String[] product = {"[1]    balut", "[2]    biscuit", "[3]    Gin", "[4]    shabu", "[5]   tapsilog"};
            double[] prices = {15, 6, 120, 500, 60};
            String rer = "";
            double discount;
            while (store.equalsIgnoreCase("yes")) {

                String sel = JOptionPane.showInputDialog("Please select Product "
                        + "\n input number to Product Code "
                        + "\n Item               Cost              Code"
                        + "\n balut              PHP 15              1 "
                        + "\n biscuit            PHP 6               2 "
                        + "\n Gin                PHP 120             3 "
                        + "\n shabu              PHP 500             4 "
                        + "\n tapsilog           PHP 60              5 ");

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

                    if (code.equalsIgnoreCase("igop")) {
                        discount = (totalcost * (-0.5));
                        totalcost = totalcost + discount;
                        JOptionPane.showInputDialog("You selected \n" + rer);
                        JOptionPane.showInputDialog("Discount " + (discount * -1) + "\nTotal: PHP " + totalcost);
                    }
                    if (code.equalsIgnoreCase("mentallydrained")) {
                        discount = (totalcost * (-0.12));
                        totalcost = totalcost + discount;
                        JOptionPane.showInputDialog("You selected \n" + rer);
                        JOptionPane.showInputDialog("Discount " + (discount * -1) + "\nTotal: PHP " + totalcost);
                    }
                    if (code.equalsIgnoreCase("mahal kita")) {
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
                        JOptionPane.showMessageDialog(null, "Sorry pero kulang2 imong bayad! pagreorder ug usab. 3 attemps only!!");
                    }

                }

                main = true;
            }
        }
    }
}
