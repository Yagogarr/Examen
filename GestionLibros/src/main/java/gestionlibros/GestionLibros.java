/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gestionlibros;

/**
 *
 * @author yagog
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Año de publicación: " + anioPublicacion;
    }
}

public class GestionLibros {
    private ArrayList<Libro> libros;
    private Scanner scanner;

    public GestionLibros() {
        libros = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void agregarLibro() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine().trim();
        if (titulo.isEmpty()) {
            System.out.println("Error: El título no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine().trim();
        if (autor.isEmpty()) {
            System.out.println("Error: El autor no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese el año de publicación del libro: ");
        String anioStr = scanner.nextLine().trim();
        int anio;
        try {
            anio = Integer.parseInt(anioStr);
        } catch (NumberFormatException e) {
            System.out.println("Error: El año debe ser un número entero válido.");
            return;
        }

        if (anio < 0 || anio > 9999) {
            System.out.println("Error: Año de publicación inválido.");
            return;
        }

        Libro nuevoLibro = new Libro(titulo, autor, anio);
        libros.add(nuevoLibro);
        System.out.println("Libro agregado: " + nuevoLibro);
    }
    
    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("La lista de libros está vacía.");
        } else {
            System.out.println("Lista de libros:");
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }

    public void eliminarLibro() {
        System.out.print("Ingrese el título del libro a eliminar: ");
        String tituloEliminar = scanner.nextLine();
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(tituloEliminar)) {
                libros.remove(libro);
                System.out.println("Libro eliminado: " + libro);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Libro no encontrado.");
        }
    }

    public static void main(String[] args) {
        GestionLibros gestionLibros = new GestionLibros();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Agregar libro");
                System.out.println("2. Mostrar libros");
                System.out.println("3. Eliminar libro");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        gestionLibros.agregarLibro();
                        break;
                    case 2:
                        gestionLibros.mostrarLibros();
                        break;
                    case 3:
                        gestionLibros.eliminarLibro();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa.");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido para la opción.");
            }
        }
    }
}