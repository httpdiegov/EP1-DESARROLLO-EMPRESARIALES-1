package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoModel {
    public static List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<Producto>();

        String query = "Select * from Product";

        DatabaseConnection dc = DatabaseConnection.getInstance();
        Connection connection = dc.getConnection();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (stmt.execute(query)) {
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    Producto producto = new Producto(
                            rs.getInt("productId"),
                            rs.getString("productName"),
                            rs.getInt("supplierId"),
                            rs.getInt("categoryId"),
                            rs.getInt("quantityPerUnit"),
                            rs.getDouble("unitPrice"),
                            rs.getInt("unitsInStock"),
                            rs.getInt("unitsOnOrder"),
                            rs.getInt("reorderLevel"),
                            rs.getInt("discontinued")
                    );
                    productos.add(producto);
                }
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productos;
    }

    public static boolean addProducto(Producto producto) {
        DatabaseConnection dc = DatabaseConnection.getInstance();
        Connection connection = dc.getConnection();

        String query = "INSERT INTO `northwind`.`product`" +
                "(`productId`," +
                "`productName`," +
                "`supplierId`," +
                "`categoryId`," +
                "`quantityPerUnit`," +
                "`unitPrice`," +
                "`unitsInStock`," +
                "`unitsOnOrder`," +
                "`reorderLevel`," +
                "`discontinued`)" +
                "VALUES" +
                "(?,?,?,?,?,?,?,?,?,?);\n";


        try {
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setInt(1, producto.getProductId());
            pstmt.setString(2, producto.getProductName());
            pstmt.setInt(3, producto.getSupplierId());
            pstmt.setInt(4, producto.getCategoryId());
            pstmt.setInt(5, producto.getQuantityPerUnit());
            pstmt.setDouble(6, producto.getUnitPrice());
            pstmt.setInt(7, producto.getUnitsInStock());
            pstmt.setInt(8, producto.getUnitsOnOrder());
            pstmt.setInt(9, producto.getReorderLevel());
            pstmt.setInt(10, producto.getDiscontinued());

            int rs = pstmt.executeUpdate();

            if(rs>0) {
                return true;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
}
