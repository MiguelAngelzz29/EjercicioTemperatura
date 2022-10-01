
public class Termostato {

    private DepositoAgua deposito;
    private Vista vista;

    public Termostato() {
        deposito = new DepositoAgua();
        vista = new Vista(this);
    }

    public static void main(String[] args) {
        args = new String[]{"-s", "99"};

        Termostato termostato = new Termostato();
        termostato.inciarVista(args);
    }

    private void inciarVista(String[] args) {
        vista.controlarTmp(args);
    }

    void aumentarTmp(int temperatura) {
        int temperaturaFinal = deposito.subirTemperatura(temperatura);
        vista.controlarTemperatura(temperaturaFinal);

    }

    void disminuirTmp(int temperatura) {
        int temperaturaFinal = deposito.bajarTemperatura(temperatura);
        vista.controlarTemperatura(temperaturaFinal);
    }

    int temperaturaActual() {
        return deposito.grados();
    }
}
