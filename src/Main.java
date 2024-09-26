import Model.DatabaseConnection;
import View.MainView;

import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        new MainView();

        DatabaseConnection dc = DatabaseConnection.getInstance();

        DatabaseConnection dc2 = DatabaseConnection.getInstance();

        System.out.println(dc);
        System.out.println(dc2);

    }
}