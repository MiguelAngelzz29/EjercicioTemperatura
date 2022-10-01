
public class DepositoAgua {

    private final int grados = (int) (Math.random() * 100);

    public int grados() {

        return grados;
    }

    public int subirTemperatura(int temperatura) {

        return temperatura + grados();
    }

    public int bajarTemperatura(int temperatura) {

        return grados() - temperatura;
    }
}
