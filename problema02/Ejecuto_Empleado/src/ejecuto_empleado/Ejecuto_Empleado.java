package ejecuto_empleado;
import java.util.Scanner;
public class Ejecuto_Empleado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Empleado[] empleados = new Empleado[10];
        
        int cantidadEmpleados = 0;

        while (true) {
            System.out.println("\n'Gestionar una lista de empleados de una empresa y su nómina de pagos'");
            System.out.println("======================================================================");
            System.out.println("Ingrese (1) para agregar un empleado");
            System.out.println("Ingrese (2) para mostrar información de los empleados");
            System.out.println("Ingrese (3) para calcular aumento de salario");
            System.out.println("Ingrese (4) para salir");
            System.out.print("\nSeleccione una opción: ");
            int opcion = scanner.nextInt();
            
            // Limpieza buffer
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    if (cantidadEmpleados < 10) { 
                        System.out.print("-Ingrese el nombre del empleado: ");
                        String nombre = scanner.nextLine();
                        System.out.print("-Ingrese la edad del empleado: ");
                        int edad = scanner.nextInt();
                        System.out.print("-Ingrese el salario del empleado: ");
                        double salario = scanner.nextDouble();
                        empleados[cantidadEmpleados] = new Empleado(nombre, salario, edad);
                        cantidadEmpleados++;
                        
                    } else {
                        System.out.println("No se puede agregar más empleados");
                    }
                    break;
                case 2:
                    System.out.println("\nMostrar información de los empleados:");
                    mostarseparador();
                    for (int i = 0; i < cantidadEmpleados; i++) {
                        System.out.println(empleados[i].mostrarInformacion());
                    }
                    break;
                case 3:
                    double sumaSalarios = 0;
                    for (int i = 0; i < cantidadEmpleados; i++) {
                        sumaSalarios += empleados[i].getSalario();
                    }
                    double salarioPromedio = sumaSalarios / cantidadEmpleados;

                    System.out.print("\nIngrese el porcentaje de aumento salarial: ");
                    double porcentaje = scanner.nextDouble();

                    for (int i = 0; i < cantidadEmpleados; i++) {
                        if (empleados[i].getSalario() < salarioPromedio) {
                            double nuevoSalario = empleados[i].getSalario() * (1 + porcentaje / 100);
                            empleados[i].setSalario(nuevoSalario);
                            System.out.println("Nuevo salario de " + empleados[i].getNombre() + ": " + nuevoSalario);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("La opción que ingreso no es valida.Por favor, intente de nuevo");
            }
        }

    }
    //Metodo de separador
    public static void mostarseparador(){
        System.out.println("===========================================");
    }
}

