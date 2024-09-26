package Controller;

import Model.Producto;
import Model.ProductoModel;

import java.util.List;

public class ProductoController {
    public static List<Producto> getProductos(){
        return ProductoModel.getProductos();
    }

    public static boolean addProducto(Producto producto){
        return ProductoModel.addProducto(producto);
    }
}
