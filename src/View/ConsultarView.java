package View;
import Controller.ProductoController;
import Model.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ConsultarView extends JFrame {

    private JTable table;

    public ConsultarView() {
        setTitle("Consultar Productos");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);

        // Crear el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Product ID");
        model.addColumn("Product Name");
        model.addColumn("Supplier ID");
        model.addColumn("Category ID");
        model.addColumn("Quantity Per Unit");
        model.addColumn("Unit Price");
        model.addColumn("Units In Stock");
        model.addColumn("Units On Order");
        model.addColumn("Reorder Level");
        model.addColumn("Discontinued");


        List<Producto> productos = ProductoController.getProductos();
        for (Producto producto : productos) {
            model.addRow(new Object[]{
                    producto.getProductId(),
                    producto.getProductName(),
                    producto.getSupplierId(),
                    producto.getCategoryId(),
                    producto.getQuantityPerUnit(),
                    producto.getUnitPrice(),
                    producto.getUnitsInStock(),
                    producto.getUnitsOnOrder(),
                    producto.getReorderLevel(),
                    producto.getDiscontinued()
            });
        }


        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}
