import java.util.*;

interface SistemaMensaje {
    void enviar(String mensaje);
}


class SistemaWhatsApp implements SistemaMensaje {
    public void enviar(String mensaje) {
        System.out.println("Enviando por WhatsApp: " + mensaje);
    }
}

class SistemaEmail implements SistemaMensaje {
    public void enviar(String mensaje) {
        System.out.println("Enviando por Email: " + mensaje);
    }
}

class SistemaSMS implements SistemaMensaje {
    public void enviar(String mensaje) {
        System.out.println("Enviando por SMS: " + mensaje);
    }
}

class Notificacion {
    private List<CanalMensaje> canales = new ArrayList<>();


    public void agregarCanal(SistemaMensaje canal) {
        canales.add(canal);
    }

    public void enviar(String mensaje) {
        for (SistemaMensaje canal : canales) {
            canal.enviar(mensaje);
        }
    }
    public static void mostrarOpciones() {
        System.out.println("1. WhatsApp");
        System.out.println("2. Email");
        System.out.println("3. SMS");
        System.out.println("0. Enviar mensaje");
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Notificacion Notificacion = new Notificacion();
        boolean continuar = true;

        System.out.println("=== SISTEMA DE NOTIFICACIONES ===");
        System.out.println("Elegí el orden en que querés enviar los mensajes.");
        System.out.println("Cuando termines, presioná 0 para enviar.");

        while (continuar) {
            Notificacion.mostrarOpciones();
            System.out.print("Seleccion disponible: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    notificador.agregarSistema(new SistemaWhatsApp());
                    System.out.println("Sistema WhatsApp agregado.");
                    break;
                case 2:
                    Notificacion.agregarSistema(new SistemaEmai());
                    System.out.println("Sistema Email agregado.");
                    break;
                case 3:
                    Notificacion.agregarSistema(new SistemaSMS());
                    System.out.println("sistema SMS agregado.");
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        sc.nextLine(); 
        System.out.print("Escribí el mensaje a enviar: ");
        String mensaje = sc.nextLine();

        System.out.println("\n=== ENVIANDO MENSAJE ===");
        Notificacion.enviar(mensaje);
        System.out.println("=== ENVÍO FINALIZADO ===");
        sc.close();
    }
}