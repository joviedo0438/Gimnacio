/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gimnacio;

import java.util.Scanner;

/**
 *
 * @author joviedo
 */
public class Gimnacio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        Scanner scanner = new Scanner(System.in);

    
        String[] horarios = {"2:00 p.m.", "3:00 p.m.", "4:00 p.m.", "5:00 p.m.", "6:00 p.m.", "7:00 p.m."};
        Gim[] reservas = new Gim[horarios.length]; // Vector para almacenar las reservas

        while (true) {
            System.out.println("\n--- Sistema de Reservas del Gimnasio ---");
            System.out.println("1. Reservar Hora");
            System.out.println("2. Consultar Reservas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                
                System.out.println("\n--- Horarios Disponibles ---");
                for (int i = 0; i < horarios.length; i++) {
                    if (reservas[i] == null) {
                        System.out.println((i + 1) + ". " + horarios[i]);
                    }
                }
                System.out.print("Seleccione un horario (número): ");
                int seleccion = scanner.nextInt() - 1;
                scanner.nextLine();

                if (seleccion >= 0 && seleccion < horarios.length && reservas[seleccion] == null) {
                    System.out.print("Ingrese el ID del empleado: ");
                    int idEmpleado = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombreEmpleado = scanner.nextLine();

                    reservas[seleccion] = new Gim(idEmpleado, nombreEmpleado);
                    System.out.println("¡Reserva realizada con éxito!");
                } else {
                    System.out.println("Horario no válido o ya reservado.");
                }
            } else if (opcion == 2) {
                // Consultar reservas
                System.out.println("\n--- Reservas ---");
                for (int i = 0; i < horarios.length; i++) {
                    if (reservas[i] != null) {
                        System.out.println(horarios[i] + " - " + reservas[i].getNombreEmpleado() + " (ID: " + reservas[i].getIdEmpleado() + ")");
                    } else {
                        System.out.println(horarios[i] + " - Disponible");
                    }
                }
            } else if (opcion == 3) {
                System.out.println("¡Gracias por usar el sistema de reservas!");
                break;
            } else {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        scanner.close();
        
     
        }
    
}
