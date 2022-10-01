
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;

public class Vista {

    private Termostato termostato;

    Vista(Termostato termostato) {
        this.termostato = termostato;
    }

    public void controlarTmp(String[] args) {

        ///////////////////////////////////// 1. FASE DE DEFINICIÓN
        // create Options object
        Options options = new Options();
        Option subir = Option.builder("s").hasArg()
                .desc("Subir temperatura").build();
        Option bajar = Option.builder("b").hasArg()
                .desc("Bajar temperatura").build();

        OptionGroup group = new OptionGroup();
        group.addOption(subir);
        group.addOption(bajar);
        options.addOptionGroup(group);
        options.addOption("h", "help", false, "display help");

        ///////////////////////////////////// 2. FASE DE PARSEO
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            ///////////////////////////////////// 3. FASE DE INTERROGACIÓN
            // Si opción -h
            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("time", options);
            } else {
                // Si sube temperatura
                if (cmd.hasOption("s")) {
                    int tmpS = Integer.parseInt(
                            cmd.getOptionValue("s"));
                    termostato.aumentarTmp(tmpS);
                    // Si baja temperatura
                } else if (cmd.hasOption("b")) {
                    int tmpB = Integer.parseInt(
                            cmd.getOptionValue("b"));

                    termostato.disminuirTmp(tmpB);
                }
            }

        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());

        }
    }

    public void showTemperatura(int temperatura) {
        System.out.println("La temperatura actual del agua es " + termostato.temperaturaActual());
    }

    public void controlarTemperatura(int temperatura) {

        if (temperatura > 100) {
            System.out.println("ERROR, has hervido el agua");

        } else if (temperatura < 0) {
            System.out.println("ERROR, has congelado el agua");

        } else {
            System.out.println("Temperatura dentro de parámetros");

        }
    }

}
