package View;

import Controller.ProductoController;
import Model.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarView extends JFrame {

    private JTextField productIdField, productNameField, supplierIdField, categoryIdField, quantityPerUnitField,
            unitPriceField, unitsInStockField, unitsOnOrderField, reorderLevelField, discontinuedField;

    public AgregarView() {
        setTitle("Agregar Producto");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new GridLayout(11, 2));
        setVisible(true);


        add(new JLabel("Product ID:"));
        productIdField = new JTextField();
        add(productIdField);

        add(new JLabel("Product Name:"));
        productNameField = new JTextField();
        add(productNameField);

        add(new JLabel("Supplier ID:"));
        supplierIdField = new JTextField();
        add(supplierIdField);

        add(new JLabel("Category ID:"));
        categoryIdField = new JTextField();
        add(categoryIdField);

        add(new JLabel("Quantity Per Unit:"));
        quantityPerUnitField = new JTextField();
        add(quantityPerUnitField);

        add(new JLabel("Unit Price:"));
        unitPriceField = new JTextField();
        add(unitPriceField);

        add(new JLabel("Units In Stock:"));
        unitsInStockField = new JTextField();
        add(unitsInStockField);

        add(new JLabel("Units On Order:"));
        unitsOnOrderField = new JTextField();
        add(unitsOnOrderField);

        add(new JLabel("Reorder Level:"));
        reorderLevelField = new JTextField();
        add(reorderLevelField);

        add(new JLabel("Discontinued:"));
        discontinuedField = new JTextField();
        add(discontinuedField);

        JButton addButton = new JButton("Agregar Producto");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear el objeto Producto con los datos ingresados
                Producto producto = new Producto(
                        Integer.parseInt(productIdField.getText()),
                        productNameField.getText(),
                        Integer.parseInt(supplierIdField.getText()),
                        Integer.parseInt(categoryIdField.getText()),
                        Integer.parseInt(quantityPerUnitField.getText()),
                        Double.parseDouble(unitPriceField.getText()),
                        Integer.parseInt(unitsInStockField.getText()),
                        Integer.parseInt(unitsOnOrderField.getText()),
                        Integer.parseInt(reorderLevelField.getText()),
                        Integer.parseInt(discontinuedField.getText())
                );

                boolean success = ProductoController.addProducto(producto);

                if (success) {
                    JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar el producto.");
                }
            }
        });

        add(addButton);
    }
}
