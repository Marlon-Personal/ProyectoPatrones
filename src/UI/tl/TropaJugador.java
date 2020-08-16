package UI.tl;

public class TropaJugador {
    int jugador;
    String nombreTropa;
    String urlImg;
    String localidad1;
    String localidad2;

    public TropaJugador(int jugador, String nombreTropa, String urlImg, String localidad1) {
        this.jugador = jugador;
        this.nombreTropa = nombreTropa;
        this.urlImg = urlImg;
        this.localidad1 = localidad1;
    }

    public TropaJugador(int jugador, String nombreTropa, String urlImg, String localidad1, String localidad2) {
        this.jugador = jugador;
        this.nombreTropa = nombreTropa;
        this.urlImg = urlImg;
        this.localidad1 = localidad1;
        this.localidad2 = localidad2;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    public String getNombreTropa() {
        return nombreTropa;
    }

    public void setNombreTropa(String nombreTropa) {
        this.nombreTropa = nombreTropa;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getLocalidad1() {
        return localidad1;
    }

    public void setLocalidad1(String localidad1) {
        this.localidad1 = localidad1;
    }

    public String getLocalidad2() {
        return localidad2;
    }

    public void setLocalidad2(String localidad2) {
        this.localidad2 = localidad2;
    }
}
