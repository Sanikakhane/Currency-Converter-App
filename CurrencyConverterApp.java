import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterApp extends JFrame {

    private JTextField inrTextField, usdTextField, krwTextField, aedTextField;

    public CurrencyConverterApp() {
        // Set up the JFrame
        setTitle("Currency Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel inrLabel = new JLabel("INR:");
        JLabel usdLabel = new JLabel("USD:");
        JLabel krwLabel = new JLabel("KRW:");
        JLabel aedLabel = new JLabel("AED:");

        inrTextField = new JTextField(10);
        usdTextField = new JTextField(10);
        krwTextField = new JTextField(10);
        aedTextField = new JTextField(10);
        aedTextField.setEditable(false); // AED is read-only

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        // Set up the layout using GroupLayout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inrLabel)
                        .addComponent(usdLabel)
                        .addComponent(krwLabel)
                        .addComponent(aedLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inrTextField)
                        .addComponent(usdTextField)
                        .addComponent(krwTextField)
                        .addComponent(aedTextField)
                        .addComponent(convertButton))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(inrLabel)
                        .addComponent(inrTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(usdLabel)
                        .addComponent(usdTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(krwLabel)
                        .addComponent(krwTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(aedLabel)
                        .addComponent(aedTextField))
                .addComponent(convertButton)
        );
    }

    private void convertCurrency() {
        try {
            // Get the amount in INR
            double inrAmount = Double.parseDouble(inrTextField.getText());

            // Conversion rates (as of the knowledge cutoff date in January 2022)
            double usdRate = 0.014; // 1 INR = 0.014 USD
            double krwRate = 16.74; // 1 INR = 16.74 KRW
            double aedRate = 0.051; // 1 INR = 0.051 AED

            // Perform the conversions
            double usdAmount = inrAmount * usdRate;
            double krwAmount = inrAmount * krwRate;
            double aedAmount = inrAmount * aedRate;

            // Display the converted amounts
            usdTextField.setText(String.format("%.2f", usdAmount));
            krwTextField.setText(String.format("%.2f", krwAmount));
            aedTextField.setText(String.format("%.2f", aedAmount));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric value for INR.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverterApp().setVisible(true);
            }
        });
    }
}
