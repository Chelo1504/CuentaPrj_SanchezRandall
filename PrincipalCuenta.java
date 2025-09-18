import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Write a description of class PrincipalCuenta here.
 * 
 * @author (Randall Sanchez) 
 * @version (a version number or a date)
 */

public class PrincipalCuenta {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Cuenta> cuentas = new ArrayList<>();
    int actual = -1; // índice de la cuenta seleccionada

    System.out.println("======================================");
    System.out.println("   Menú - Clase Cuenta");
    System.out.println("======================================");

    boolean salir = false;
    while (!salir) {
        System.out.println("\nMenú principal");
        System.out.println("1) Crear Cuenta");
        System.out.println("2) Conocer la cantidad de Cuentas Creadas");
        System.out.println("3) Listar Cuentas");
        System.out.println("4) Seleccionar Cuenta actual");
        System.out.println("5) Depositar");
        System.out.println("6) Retirar");
        System.out.println("7) Consultar Saldo");
        System.out.println("8) Consultar Estado (toString)");
        System.out.println("9) Cambiar Nombre Cuenta");
        System.out.println("0) Salir");
        System.out.print("Opción: ");
        String op = sc.nextLine().trim();
        switch (op) {
            case "1": { // Crear cuenta
                System.out.print("Nombre del cuenta habiente (enter para 'Sin nombre'): ");
                String nombre = sc.nextLine().trim();
                System.out.print("Saldo inicial: ");
                String saldoStr = sc.nextLine().trim();
                double saldoInicial;
                try {
                    saldoInicial = Double.parseDouble(saldoStr);
                } catch (NumberFormatException e) {
                    System.out.println("Saldo inválido, se usará 0.0");
                    saldoInicial = 0.0;
                }
                Cuenta c;
                if (nombre.isEmpty()) {
                    c = new Cuenta(saldoInicial);
                } else {
                        c = new Cuenta(nombre, saldoInicial);
                }
                cuentas.add(c);
                actual = cuentas.size() - 1;
                System.out.println("Cuenta creada y seleccionada (índice " + actual + ").");
                break;
            }
            case "2": { // Cantidad de cuentas creadas
                System.out.println("Cantidad de cuentas creadas: " + Cuenta.getCantidadCuentaCreadas());
                break;
            }
            case "3": { // Listar cuentas
                if (cuentas.isEmpty()) {
                    System.out.println("No hay cuentas creadas.");
                } else {
                    System.out.println("Índice | Código | Nombre | Saldo");
                    for (int i = 0; i < cuentas.size(); i++) {
                        Cuenta c = cuentas.get(i);
                        System.out.printf("  %d    | %s | %s | %.2f%n",
                            i, c.getCodCuentas(), c.toString().split("\n")[1], c.getSaldo());
                    }
                }
                break;
            }
            case "4": { // Seleccionar cuenta
                if (cuentas.isEmpty()) {
                    System.out.println("Cree una cuenta primero.");
                    break;
                }
                System.out.print("Índice de la cuenta a seleccionar: ");
                String idxS = sc.nextLine().trim();
                try {
                    int idx = Integer.parseInt(idxS);
                    if (idx >= 0 && idx < cuentas.size()) {
                        actual = idx;
                        System.out.println("Cuenta índice " + actual + " seleccionada.");
                    } else {
                        System.out.println("Índice fuera de rango.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Índice inválido.");
                    }
                    break;
            }
            case "5": { // Depositar
                if (actual < 0 || cuentas.isEmpty()) {
                    System.out.println("Debe crear y seleccionar una cuenta primero.");
                    break;
                }
                System.out.print("Monto a depositar: ");
                String s = sc.nextLine().trim();
                double monto;
                try {
                    monto = Double.parseDouble(s);
                } catch (NumberFormatException e) {
                    System.out.println("Número inválido.");
                    break;
                }
                cuentas.get(actual).depositar(monto);
                System.out.printf("Saldo actual: %.2f%n", cuentas.get(actual).getSaldo());
                break;
            }
            case "6": { // Retirar
                if (actual < 0 || cuentas.isEmpty()) {
                    System.out.println("Debe crear y seleccionar una cuenta primero.");
                    break;
                }
                System.out.print("Monto a retirar: ");
                String s = sc.nextLine().trim();
                double monto;
                try {
                    monto = Double.parseDouble(s);
                } catch (NumberFormatException e) {
                    System.out.println("Número inválido.");
                    break;
                }
                cuentas.get(actual).retirar(monto);
                System.out.printf("Saldo actual: %.2f%n", cuentas.get(actual).getSaldo());
                break;
            }
            case "7": { // Consultar saldo
                if (actual < 0 || cuentas.isEmpty()) {
                    System.out.println("Debe crear y seleccionar una cuenta primero.");
                    break;
                }
                System.out.printf("Saldo actual: %.2f%n", cuentas.get(actual).getSaldo());
                break;
            }
            case "8": { // Consultar estado
                if (actual < 0 || cuentas.isEmpty()) {
                    System.out.println("Debe crear y seleccionar una cuenta primero.");
                    break;
                }
                System.out.println(cuentas.get(actual).toString());
                break;
            }
            case "9":{
                if (actual <0 || cuentas.isEmpty()){
                    System.out.println("Debe crear y seleccionar una cuenta primero.");
                    break;
                }
                System.out.print("Nuevo nombre del cuenta habiente: ");
                String nuevoNombre = sc.nextLine().trim();
                if (nuevoNombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío.");
                } else {
                    cuentas.get(actual).setnombreCuentaHabiente(nuevoNombre);
                    System.out.println("Nombre actualizado correctamente.");
                }
                break;
            }
            case "0": {
                salir = true;
                System.out.println("¡Hasta luego!");
                break;
            }
            default:
                System.out.println("Opción inválida.");
        }
    }
    sc.close();
}
}
