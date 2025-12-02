public class Semafaro {
    private int idSemafaro;
    private Estado estadoActual;
    private int tiempoEstado;

    public Semafaro(int idSemafaro) {
        this.idSemafaro = idSemafaro;
        this.estadoActual = Estado.ROJO;
        this.tiempoEstado = 1; // 1 minuto
    }

    public void cambiarEstado() {
        estadoActual = estadoActual.getSiguienteEstado();
        tiempoEstado = estadoActual.getDuracion();
    }

    public void decrementarTiempo() {
        tiempoEstado--;
        if (tiempoEstado == 0) {
            cambiarEstado();
        }
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }
}

public enum Estado {
    ROJO(1, Estado.VERDE),
    VERDE(1, Estado.AMARILLO),
    AMARILLO(1, Estado.ROJO);

    private int duracion;
    private Estado siguienteEstado;

    Estado(int duracion, Estado siguienteEstado) {
        this.duracion = duracion;
        this.siguienteEstado = siguienteEstado;
    }

    public int getDuracion() {
        return duracion;
    }

    public Estado getSiguienteEstado() {
        return siguienteEstado;
    }
}