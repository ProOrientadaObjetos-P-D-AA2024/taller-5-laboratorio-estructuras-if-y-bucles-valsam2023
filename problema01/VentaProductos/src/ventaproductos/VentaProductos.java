package ventaproductos;

import java.util.Scanner;

public class VentaProductos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el precio del producto: ");
        double precio = entrada.nextDouble();
        System.out.println("Ingrese el número de productos: ");
        int cantidad = entrada.nextInt();
        // Calculalo el descuento y el precio final
        double descuento = calcularDescuento(precio, cantidad);
        double precioFinal = calcularPrecioFinal(precio, descuento);
        System.out.println("El descuento aplicado: " + descuento + "%");
        System.out.println("El precio final después del descuento: $" + precioFinal);
    }

    public static double calcularDescuento(double precio, int cantidad) {
        if (precio >= 1000 && cantidad >= 10) {
            return 10.0;
        } else {
            return 5.0;
        }
    }

    public static double calcularPrecioFinal(double precio, double descuento) {
        double precioConDescuento = precio - (precio * (descuento / 100));
        return precioConDescuento;
    }
}
