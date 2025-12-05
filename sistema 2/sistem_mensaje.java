import java.util.*;


interface SistemaMensaje {
    void enviar(String mensaje);
}


class SistemaWhatsApp implements SistemaMensaje {
    public void enviar(String mensaje) {
        System.out.println("[WhatsApp] " + mensaje);
    }
}

class SistemaEmail implements SistemaMensaje {
    public void enviar(String mensaje) {
        System.out.println("[Email] " + mensaje);
    }
}

class SistemaSMS implements SistemaMensaje {
    public void enviar(String mensaje) {
        System.out.println("[SMS] " + mensaje);
    }
}


class Notificacion {
    private List<SistemaMensaje> canales = new ArrayList<SistemaMensaje>();

    
    public Notificacion() {
        canales.add(new SistemaWhatsApp());
        canales.add(new SistemaEmail());
        canales.add(new SistemaSMS());
    }

    public void enviar(String mensaje) {
        for (SistemaMensaje canal : canales) {
            canal.enviar(mensaje);
        }
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Notificacion notificacion = new Notificacion();

        System.out.println("=== SISTEMA DE MENSAJES ===");
        System.out.print("Escribe el mensaje a enviar: ");
        String mensaje = sc.nextLine();

        System.out.println("\n=== ENVIANDO EN ORDEN PREDEFINIDO ===");
        notificador.enviar(mensaje);
        System.out.println("====================================");

        sc.close();
    }
}