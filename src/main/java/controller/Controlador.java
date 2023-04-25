
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import static javax.swing.JOptionPane.showMessageDialog;

import vista.VentanaPrincipal;
import vista.VentanaCables;
import vista.VentanaContraseña;
import vista.VentanaButton;
import vista.VentanaCablesComplicados;
import vista.VentanaCodigoMorse;
import vista.VentanaLaberinto;
import vista.VentanaMemoria;
import vista.VentanaPerilla;
import vista.VentanaQuienVaPrimero;
import vista.VentanaSecuenciaDeCables;
import vista.VentanaSimonDice;
import vista.VentanaTeclado;

import model.Mapa;

public class Controlador implements ActionListener {
    
    //Ventanas
    private VentanaPrincipal viewPrincipal;
    private VentanaCables viewCables;
    private VentanaContraseña viewContraseña;
    private VentanaButton viewButton;
    private VentanaCablesComplicados viewCablesComplicados;
    private VentanaCodigoMorse viewCodigoMorse;
    private VentanaLaberinto viewLaberinto;
    private VentanaMemoria viewMemoria;
    private VentanaPerilla viewPerilla;
    private VentanaQuienVaPrimero viewQuienVaPrimero;
    private VentanaSecuenciaDeCables viewSecuenciaDeCables;
    private VentanaSimonDice viewSimonDice;
    private VentanaTeclado viewTeclado;

    //Atributos
    private ArrayList<String> contraseñas = new ArrayList<String>();
    private ArrayList<String> tecladoCombinacionTemp;
    private ArrayList<String> tecladoCombinacion1 = new ArrayList<String>();
    private ArrayList<String> tecladoCombinacion2 = new ArrayList<String>();
    private ArrayList<String> tecladoCombinacion3 = new ArrayList<String>();
    private ArrayList<String> tecladoCombinacion4 = new ArrayList<String>();
    private ArrayList<String> tecladoCombinacion5 = new ArrayList<String>();
    private ArrayList<String> tecladoCombinacion6 = new ArrayList<String>();
    private String[][] matrizFrecuencias;
    private String[][] matrizCodigoMorse;
    private String[][] matrizPalabrasQuienVaPrimero;
    private int etapa;
    private String[] etiqueta;
    private String[] posicion;
    private String resultadoSimonDice;
    private Map<String, String> mapaPalabrasQuienVaPrimero;
    private Mapa[] mapas = {
                new Mapa(1, 2, 6, 3, "mapa1"),
                new Mapa(5, 2, 2, 4, "mapa2"),
                new Mapa(4, 4, 6, 4, "mapa3"),
                new Mapa(1, 1, 1, 4, "mapa4"),
                new Mapa(5, 3, 4, 6, "mapa5"),
                new Mapa(5, 1, 3, 5, "mapa6"),
                new Mapa(2, 1, 2, 6, "mapa7"),
                new Mapa(4, 1, 3, 4, "mapa8"),
                new Mapa(3, 2, 1, 5, "mapa9")
        };
            
    
    //Constructor
    public Controlador(VentanaPrincipal viewPrincipal, VentanaCables viewCables, VentanaContraseña viewContraseña, VentanaButton viewButton, VentanaCablesComplicados viewCablesComplicados, VentanaCodigoMorse viewCodigoMorse, VentanaLaberinto viewLaberinto, VentanaMemoria viewMemoria, VentanaPerilla viewPerilla, VentanaQuienVaPrimero viewQuienVaPrimero, VentanaSecuenciaDeCables viewSecuenciaDeCables, VentanaSimonDice viewSimonDice, VentanaTeclado viewTeclado) {
        this.viewPrincipal = viewPrincipal;
        this.viewCables = viewCables;
        this.viewContraseña = viewContraseña;
        this.viewButton = viewButton;
        this.viewCablesComplicados = viewCablesComplicados;
        this.viewCodigoMorse = viewCodigoMorse;
        this.viewLaberinto = viewLaberinto;
        this.viewMemoria = viewMemoria;
        this.viewPerilla = viewPerilla;
        this.viewQuienVaPrimero = viewQuienVaPrimero;
        this.viewSecuenciaDeCables = viewSecuenciaDeCables;
        this.viewSimonDice = viewSimonDice;
        this.viewTeclado = viewTeclado;
        
        this.viewPrincipal.btnCables.addActionListener(this);
        this.viewPrincipal.btnContraseña.addActionListener(this);
        this.viewPrincipal.btnButton.addActionListener(this);
        this.viewPrincipal.btnCablesComplicados.addActionListener(this);
        this.viewPrincipal.btnCodigoMorse.addActionListener(this);
        this.viewPrincipal.btnLaberinto.addActionListener(this);
        this.viewPrincipal.btnMemoria.addActionListener(this);
        this.viewPrincipal.btnPerilla.addActionListener(this);
        this.viewPrincipal.btnQuienVaPrimero.addActionListener(this);
        this.viewPrincipal.btnSecuenciaDeCables.addActionListener(this);
        this.viewPrincipal.btnSimonDice.addActionListener(this);
        this.viewPrincipal.btnTeclado.addActionListener(this);
        
        this.viewContraseña.jButton1.addActionListener(this);
        this.viewTeclado.btnOrdenar.addActionListener(this);
        this.viewCodigoMorse.btnConvertir.addActionListener(this);
        this.viewMemoria.btnReset.addActionListener(this);
        this.viewMemoria.btnOkey.addActionListener(this);
        this.viewMemoria.btnMonitor1.addActionListener(this);
        this.viewMemoria.btnMonitor2.addActionListener(this);
        this.viewMemoria.btnMonitor3.addActionListener(this);
        this.viewMemoria.btnMonitor4.addActionListener(this);
        this.viewQuienVaPrimero.btnBuscarPrimerPalabra.addActionListener(this);
        this.viewQuienVaPrimero.btnBuscarSegundaPalabra.addActionListener(this);
        this.viewSimonDice.btnReset.addActionListener(this);
        this.viewSimonDice.btnAzul.addActionListener(this);
        this.viewSimonDice.btnAmarillo.addActionListener(this);
        this.viewSimonDice.btnRojo.addActionListener(this);
        this.viewSimonDice.btnVerde.addActionListener(this);
        this.viewCablesComplicados.btnBuscar.addActionListener(this);
        this.viewLaberinto.btnBuscar.addActionListener(this);
    }

    //Metodo que inicia la vista. 
    public void iniciar() {
                                        
        viewPrincipal.setTitle("MANUAL BOMBITAS");
        viewPrincipal.setLocationRelativeTo(null);

        contraseñas.add("abajo");
        contraseñas.add("altar");
        contraseñas.add("bajar");
        contraseñas.add("bomba");
        contraseñas.add("bueno");
        contraseñas.add("cable");
        contraseñas.add("cerca");
        contraseñas.add("corto");
        contraseñas.add("delta");
        contraseñas.add("donde");
        contraseñas.add("estar");
        contraseñas.add("falta");
        contraseñas.add("gomas");
        contraseñas.add("grasa");
        contraseñas.add("hogar");
        contraseñas.add("hueso");
        contraseñas.add("listo");
        contraseñas.add("lugar");
        contraseñas.add("magia");
        contraseñas.add("miedo");
        contraseñas.add("mundo");
        contraseñas.add("nunca");
        contraseñas.add("otros");
        contraseñas.add("pasar");
        contraseñas.add("pasos");
        contraseñas.add("perca");
        contraseñas.add("plata");
        contraseñas.add("punto");
        contraseñas.add("queso");
        contraseñas.add("ronda");
        contraseñas.add("salto");
        contraseñas.add("suena");
        contraseñas.add("tasar");
        contraseñas.add("traba");
        contraseñas.add("valor");
        
        tecladoCombinacion1.add("Ϙ");
        tecladoCombinacion1.add("Ѧ");
        tecladoCombinacion1.add("ƛ");
        tecladoCombinacion1.add("ϰ");
        tecladoCombinacion1.add("Ѭ");
        tecladoCombinacion1.add("ϗ");
        tecladoCombinacion1.add("Ͽ");
        
        tecladoCombinacion2.add("Ӭ");
        tecladoCombinacion2.add("Ϙ");
        tecladoCombinacion2.add("Ͽ");
        tecladoCombinacion2.add("Ҩ");
        tecladoCombinacion2.add("☆");
        tecladoCombinacion2.add("ϗ");
        tecladoCombinacion2.add("¿");
     
        tecladoCombinacion3.add("©");
        tecladoCombinacion3.add("Ѽ");
        tecladoCombinacion3.add("Ҩ");
        tecladoCombinacion3.add("Җ");
        tecladoCombinacion3.add("Ԇ");
        tecladoCombinacion3.add("ƛ");
        tecladoCombinacion3.add("☆");

        tecladoCombinacion4.add("Ϭ");
        tecladoCombinacion4.add("¶");
        tecladoCombinacion4.add("Ѣ");
        tecladoCombinacion4.add("Ѭ");
        tecladoCombinacion4.add("Җ");
        tecladoCombinacion4.add("¿");
        tecladoCombinacion4.add("ټ");

        tecladoCombinacion5.add("ψ");
        tecladoCombinacion5.add("ټ");
        tecladoCombinacion5.add("Ѣ");
        tecladoCombinacion5.add("Ͼ");
        tecladoCombinacion5.add("¶");
        tecladoCombinacion5.add("Ѯ");
        tecladoCombinacion5.add("★");

        tecladoCombinacion6.add("Ϭ");
        tecladoCombinacion6.add("Ӭ");
        tecladoCombinacion6.add("҂");
        tecladoCombinacion6.add("æ");
        tecladoCombinacion6.add("ψ");
        tecladoCombinacion6.add("Ҋ");
        tecladoCombinacion6.add("Ω");
        
        matrizCodigoMorse = new String[][]{
            {"A", ".-"},
            {"B", "-..."},
            {"C", "-.-."},
            {"D", "-.."},
            {"E", "."},
            {"F", "..-."},
            {"G", "--."},
            {"H", "...."},
            {"I", ".."},
            {"J", ".---"},
            {"K", "-.-"},
            {"L", ".-.."},
            {"M", "--"},
            {"N", "-."},
            {"O", "---"},
            {"P", ".--."},
            {"Q", "--.-"},
            {"R", ".-."},
            {"S", "..."},
            {"T", "-"},
            {"U", "..-"},
            {"V", "...-"},
            {"W", ".--"},
            {"X", "-..-"},
            {"Y", "-.--"},
            {"Z", "--.."},
            {"Á", ".--.-"},
            {"É", "..-.."},
            {"Ñ", "--.--"},
            {"Ó", "---."}
        };
        
        matrizFrecuencias = new String[][]{
            {"freno", "3.505 MHz"},
            {"hongos", "3.515 MHz"},
            {"lentes", "3.522 MHz"},
            {"biela", "3.532 MHz"},
            {"resta", "3.535 MHz"},
            {"trato", "3.542 MHz"},
            {"volar", "3.545 MHz"},
            {"vuelta", "3.552 MHz"},
            {"llaves", "3.555 MHz"},
            {"tabla", "3.565 MHz"},
            {"tronco", "3.572 MHz"},
            {"bomba", "3.575 MHz"},
            {"santos", "3.582 MHz"},
            {"senso", "3.592 MHz"},
            {"ratas", "3.595 MHz"},
            {"trenes", "3.600 MHz"}
        };
        
        matrizPalabrasQuienVaPrimero = new String[][]{
            {"próxima", "Medio izquierda"},
            {"voy", "Arriba derecha"},
            {"primero", "Abajo derecha"},
            {"haya", "Arriba derecha"},
            {"vaya", "Abajo derecha"},
            {"va", "Medio izquierda"},
            {"espera", "Abajo izquierda"},
            {"rápido", "Medio derecha"},
            {"monitor", "Abajo derecha"},
            {"última", "Medio izquierda"},
            {"sí", "Abajo derecha"},
            {"dale", "Medio derecha"},
            {"hay", "Medio derecha"},
            {"otra", "Abajo izquierda"},
            {"bien", "Abajo izquierda"},
            {"palabra", "Abajo derecha"},
            {"nada", "Medio derecha"},
            {"baya", "Abajo derecha"},
            {"listo", "Medio derecha"},
            {"okay", "Medio derecha"},
            {"bueno", "Arriba izquierda"},
            {"no", "Abajo derecha"},
            {"allá", "Abajo izquierda"},
            {"explotó", "Medio derecha"},
            {"ahí", "Medio izquierda"},
            {"halla", "Abajo derecha"},
            {"valla", "Arriba derecha"},
            {"otro", "Abajo derecha"}
        };

        mapaPalabrasQuienVaPrimero = new HashMap<>();
        mapaPalabrasQuienVaPrimero.put("espera", "LISTO, VA, ¿ÉSTA?, VALE, NO ESTÁ, ¿ESA?, OKAY, OTRO, ESPERA, NO, ¿QUÉ?, ESTA, ¿CÓMO?, NO ES");
        mapaPalabrasQuienVaPrimero.put("¿qué?", "NO ESTÁ, VA, LISTO, VALE, NO, OKAY, ¿CÓMO?, ESTA, NO ES, ESPERA, OTRO, ¿ÉSTA?, ¿ESA?, ¿QUÉ?");
        mapaPalabrasQuienVaPrimero.put("no", "OTRO, ESTA, NO ES, ¿QUÉ?, ¿ÉSTA?, ESPERA, OKAY, LISTO, ¿CÓMO?, NO ESTÁ, ¿ESA?, VA, NO, VALE");
        mapaPalabrasQuienVaPrimero.put("otro", "NO ES, OKAY, VA, VALE, OTRO, ¿ESA?, ESPERA, ¿CÓMO?, NO, ¿ÉSTA?, NO ESTÁ, ESTA, LISTO, ¿QUÉ?");
        mapaPalabrasQuienVaPrimero.put("¿cómo?", "ESTA, OKAY, VA, VALE, LISTO, OTRO, NO, ¿ESA?, NO ESTÁ, ¿ÉSTA?, NO ES, ¿QUÉ?, ¿CÓMO?, ESPERA");
        mapaPalabrasQuienVaPrimero.put("listo", "VA, OKAY, ESTA, VALE, ¿QUÉ?, ¿ÉSTA?, ¿ESA?, ESPERA, ¿CÓMO?, LISTO, NO ESTÁ, OTRO, NO, NO ES");
        mapaPalabrasQuienVaPrimero.put("¿ésta?", "ESTA, ¿ÉSTA?, NO ESTÁ, ¿CÓMO?, ESPERA, OTRO, VALE, NO, VA, ¿QUÉ?, NO ES, LISTO, ¿ESA?, OKAY");
        mapaPalabrasQuienVaPrimero.put("esta", "ESPERA, ¿CÓMO?, NO ESTÁ, ¿ÉSTA?, VA, LISTO, OKAY, NO, ¿ESA?, OTRO, ESTA, VALE, NO ES, ¿QUÉ?");
        mapaPalabrasQuienVaPrimero.put("no está", "OKAY, NO ESTÁ, ¿QUÉ?, NO, VALE, LISTO, OTRO, ¿ÉSTA?, ESTA, NO ES, ¿ESA?, ESPERA, VA, ¿CÓMO?");
        mapaPalabrasQuienVaPrimero.put("okay", "LISTO, ¿CÓMO?, ESPERA, ¿ESA?, NO, NO ES, ¿ÉSTA?, OKAY, VALE, NO ESTÁ, ESTA, OTRO, VA, ¿QUÉ?");
        mapaPalabrasQuienVaPrimero.put("vale", "OTRO, ESPERA, VA, ¿ÉSTA?, ¿CÓMO?, ¿ESA?, NO, NO ES, NO ESTÁ, VALE, OKAY, ¿QUÉ?, ESTA, LISTO");
        mapaPalabrasQuienVaPrimero.put("va", "VALE, NO, ¿QUÉ?, LISTO, ESTA, ¿CÓMO?, NO ES, VA, NO ESTÁ, ESPERA, OTRO, ¿ESA?, ¿ÉSTA?, OKAY");
        mapaPalabrasQuienVaPrimero.put("no es", "ESTA, NO, OTRO, VA, LISTO, NO ESTÁ, ¿QUÉ?, ¿ESA?, ¿ÉSTA?, NO ES, ¿CÓMO?, ESPERA, OKAY, VALE");
        mapaPalabrasQuienVaPrimero.put("¿esa?", "OKAY, VALE, LISTO, ESPERA, ¿ESA?, VA, ¿CÓMO?, ESTA, OTRO, NO ESTÁ, ¿QUÉ?, ¿ÉSTA?, NO, NO ES");
        mapaPalabrasQuienVaPrimero.put("ok", "DALE, ¿DÓNDE?, BUENO, ÉSTA, BIEN, RÁPIDO, ESTÁ, YA ESTÁ, SÍ, OK, ¿CUÁL?, ¿SEGURO?, OTRA, NO SÉ");
        mapaPalabrasQuienVaPrimero.put("¿dónde?", "BUENO, BIEN, ¿SEGURO?, RÁPIDO, SÍ, OTRA, ¿CUÁL?, YA ESTÁ, OK, NO SÉ, ÉSTA, DALE, ESTÁ, ¿DÓNDE?");
        mapaPalabrasQuienVaPrimero.put("bueno", "¿CUÁL?, ¿DÓNDE?, RÁPIDO, BUENO, BIEN, ESTÁ, DALE, NO SÉ, ÉSTA, OK, SÍ, YA ESTÁ, ¿SEGURO?, OTRA");
        mapaPalabrasQuienVaPrimero.put("ésta", "OK, ÉSTA, ESTÁ, BIEN, ¿CUÁL?, ¿DÓNDE?, NO SÉ, BUENO, SÍ, RÁPIDO, DALE, OTRA, ¿SEGURO?, YA ESTÁ");
        mapaPalabrasQuienVaPrimero.put("está", "OTRA, NO SÉ, ESTÁ, RÁPIDO, SÍ, DALE, BUENO, YA ESTÁ, ÉSTA, ¿SEGURO?, BIEN, ¿CUÁL?, ¿DÓNDE?, OK");
        mapaPalabrasQuienVaPrimero.put("no sé", "RÁPIDO, DALE, BIEN, SÍ, ÉSTA, ESTÁ, ¿CUÁL?, OTRA, NO SÉ, OK, ¿SEGURO?, YA ESTÁ, ¿DÓNDE?, BUENO");
        mapaPalabrasQuienVaPrimero.put("rápido", "RÁPIDO, BUENO, ¿DÓNDE?, OK, OTRA, YA ESTÁ, ¿CUÁL?, BIEN, DALE, ¿SEGURO?, ÉSTA, ESTÁ, NO SÉ, SÍ");
        mapaPalabrasQuienVaPrimero.put("¿cuál?", "ESTÁ, NO SÉ, ¿DÓNDE?, ÉSTA, BIEN, ¿CUÁL?, OTRA, OK, RÁPIDO, ¿SEGURO?, BUENO, DALE, YA ESTÁ, SÍ");
        mapaPalabrasQuienVaPrimero.put("sí", "OK, YA ESTÁ, ÉSTA, BUENO, NO SÉ, OTRA, ¿CUÁL?, ¿SEGURO?, ¿DÓNDE?, RÁPIDO, ESTÁ, BIEN, SÍ, DALE");
        mapaPalabrasQuienVaPrimero.put("otra", "DALE, RÁPIDO, BIEN, SÍ, BUENO, ESTÁ, ÉSTA, YA ESTÁ, ¿SEGURO?, OK, NO SÉ, ¿DÓNDE?, ¿CUÁL?, OTRA");
        mapaPalabrasQuienVaPrimero.put("bien", "SÍ, RÁPIDO, ¿CUÁL?, BUENO, YA ESTÁ, DALE, BIEN, ¿SEGURO?, OTRA, ¿DÓNDE?, ESTÁ, ÉSTA, NO SÉ, OK");
        mapaPalabrasQuienVaPrimero.put("ya está", "¿DÓNDE?, NO SÉ, OTRA, ¿CUÁL?, OK, ESTÁ, DALE, SÍ, ÉSTA, BIEN, YA ESTÁ, RÁPIDO, BUENO, ¿SEGURO?");
        mapaPalabrasQuienVaPrimero.put("dale", "¿DÓNDE?, OTRA, ¿SEGURO?, ÉSTA, OK, YA ESTÁ, RÁPIDO, ESTÁ, DALE, NO SÉ, SÍ, BIEN, BUENO, ¿CUÁL?");
        mapaPalabrasQuienVaPrimero.put("¿seguro?", "ÉSTA, BIEN, NO SÉ, ESTÁ, YA ESTÁ, OTRA, ¿CUÁL?, SÍ, RÁPIDO, OK, ¿SEGURO?, DALE, ¿DÓNDE?, BUENO");
   
        etapa = 1;
        etiqueta = new String[5];
        posicion = new String[5];
        
        resultadoSimonDice = "";
    }
    
    //Función que realizan los botones. 
    public void actionPerformed (ActionEvent e) {
        
        //showMessageDialog(null, "Hola");
        
        if (e.getSource() == viewPrincipal.btnCables) { viewCables.setVisible(true); }  
        if (e.getSource() == viewPrincipal.btnContraseña) { viewContraseña.setVisible(true); }  
        if (e.getSource() == viewPrincipal.btnButton) { viewButton.setVisible(true); }  
        if (e.getSource() == viewPrincipal.btnCablesComplicados) { viewCablesComplicados.setVisible(true); }  
        if (e.getSource() == viewPrincipal.btnCodigoMorse) { viewCodigoMorse.setVisible(true); }  
        if (e.getSource() == viewPrincipal.btnLaberinto) { viewLaberinto.setVisible(true); }  
        if (e.getSource() == viewPrincipal.btnMemoria) { viewMemoria.setVisible(true); }  
        if (e.getSource() == viewPrincipal.btnPerilla) { viewPerilla.setVisible(true); }  
        if (e.getSource() == viewPrincipal.btnQuienVaPrimero) { viewQuienVaPrimero.setVisible(true); }  
        if (e.getSource() == viewPrincipal.btnSecuenciaDeCables) { viewSecuenciaDeCables.setVisible(true); }  
        if (e.getSource() == viewPrincipal.btnSimonDice) { viewSimonDice.setVisible(true); }  
        if (e.getSource() == viewPrincipal.btnTeclado) { viewTeclado.setVisible(true); }  
        
        if (e.getSource() == viewContraseña.jButton1) {
                    
            String c1;
            String c2;
            String c3;
            String c4;
            String c5;
            String contraseñaTemp = "";
            
            boolean bandera = false;
            
            try {
                
                c1 = viewContraseña.textField1.getText();
                c2 = viewContraseña.textField2.getText();
                c3 = viewContraseña.textField3.getText();
                c4 = viewContraseña.textField4.getText();
                c5 = viewContraseña.textField5.getText();
                
                for (int i = 0; i <= 4; i++) {
                    contraseñaTemp += c1.charAt(i);
                    for (int j = 0; j <= 4; j++) {
                        contraseñaTemp += c2.charAt(j);
                        for (int a = 0; a <= 4; a++) {
                            contraseñaTemp += c3.charAt(a);
                            for (int s = 0; s <= 4; s++) {
                                contraseñaTemp += c4.charAt(s);
                                for (int d = 0; d <= 4; d++) {
                                    contraseñaTemp += c5.charAt(d);
                                    
                                    for (int q = 0; q < contraseñas.size(); q++) {
                                        if (contraseñaTemp.equals(contraseñas.get(q))) {
                                            viewContraseña.jLabel8.setText("RESULTADO: " + contraseñaTemp);
                                            bandera = true;
                                            break;
                                        }
                                    }
                                    
                                    contraseñaTemp = contraseñaTemp.substring(0, contraseñaTemp.length()-1);
                                }
                                contraseñaTemp = contraseñaTemp.substring(0, contraseñaTemp.length()-1);
                            }
                            contraseñaTemp = contraseñaTemp.substring(0, contraseñaTemp.length()-1);
                        }
                        contraseñaTemp = contraseñaTemp.substring(0, contraseñaTemp.length()-1);
                    }
                    contraseñaTemp = contraseñaTemp.substring(0, contraseñaTemp.length()-1);
                }
                
                if (bandera == false) {
                    viewContraseña.jLabel8.setText("RESULTADO: Algo anda mal :(");
                }
                
            } catch (Exception x) {
                showMessageDialog(null, "Error: " + x.getMessage());
            }
            
        }
        
        if (e.getSource() == viewTeclado.btnOrdenar) {

            int bandera = 0;
            String tecladoCombinacionCorrecta = "";
            tecladoCombinacionTemp = new ArrayList<String>();
            
            if (viewTeclado.cbæ.isSelected()) { tecladoCombinacionTemp.add("æ"); }
            if (viewTeclado.cbCopy.isSelected()) { tecladoCombinacionTemp.add("©"); }
            if (viewTeclado.cbӬ.isSelected()) { tecladoCombinacionTemp.add("Ӭ"); }
            if (viewTeclado.cbҨ.isSelected()) { tecladoCombinacionTemp.add("Ҩ"); }
            if (viewTeclado.cbҊ.isSelected()) { tecladoCombinacionTemp.add("Ҋ"); }
            if (viewTeclado.cbϗ.isSelected()) { tecladoCombinacionTemp.add("ϗ"); }
            if (viewTeclado.cbϰ.isSelected()) { tecladoCombinacionTemp.add("ϰ"); }
            if (viewTeclado.cbԆ.isSelected()) { tecladoCombinacionTemp.add("Ԇ"); }
            if (viewTeclado.cbϘ.isSelected()) { tecladoCombinacionTemp.add("Ϙ"); }
            if (viewTeclado.cbѮ.isSelected()) { tecladoCombinacionTemp.add("Ѯ"); }
            if (viewTeclado.cbƛ.isSelected()) { tecladoCombinacionTemp.add("ƛ"); }
            if (viewTeclado.cbΩ.isSelected()) { tecladoCombinacionTemp.add("Ω"); }
            if (viewTeclado.cbPilc.isSelected()) { tecladoCombinacionTemp.add("¶"); }
            if (viewTeclado.cbψ.isSelected()) { tecladoCombinacionTemp.add("ψ"); }
            if (viewTeclado.cbQuer.isSelected()) { tecladoCombinacionTemp.add("¿"); }
            if (viewTeclado.cbϬ.isSelected()) { tecladoCombinacionTemp.add("Ϭ"); }
            if (viewTeclado.cbϾ.isSelected()) { tecladoCombinacionTemp.add("Ͼ"); }
            if (viewTeclado.cbϿ.isSelected()) { tecladoCombinacionTemp.add("Ͽ"); }
            if (viewTeclado.cbDStar.isSelected()) { tecladoCombinacionTemp.add("★"); }
            if (viewTeclado.cbWStar.isSelected()) { tecladoCombinacionTemp.add("☆"); }
            if (viewTeclado.cbټ.isSelected()) { tecladoCombinacionTemp.add("ټ"); }
            if (viewTeclado.cbThous.isSelected()) { tecladoCombinacionTemp.add("҂"); }
            if (viewTeclado.cbѢ.isSelected()) { tecladoCombinacionTemp.add("Ѣ"); }
            if (viewTeclado.cbѬ.isSelected()) { tecladoCombinacionTemp.add("Ѭ"); }
            if (viewTeclado.cbѦ.isSelected()) { tecladoCombinacionTemp.add("Ѧ"); }
            if (viewTeclado.cbҖ.isSelected()) { tecladoCombinacionTemp.add("Җ"); }
            if (viewTeclado.cbѼ.isSelected()) { tecladoCombinacionTemp.add("Ѽ"); }
            
            try {

                for (int j = 0; j < 7; j++) {
                    for (int s = 0; s < 4; s++) {
                        if (tecladoCombinacionTemp.get(s).equals(tecladoCombinacion1.get(j))) {
                            bandera++;
                            break;
                        }
                    }
                }

                if (bandera == 4) {
                    for (int j = 0; j < 7; j++) {
                        for (int s = 0; s < 4; s++) {
                            if (tecladoCombinacion1.get(j).equals(tecladoCombinacionTemp.get(s))) {
                                if (bandera < 2) {
                                    tecladoCombinacionCorrecta += tecladoCombinacion1.get(j);
                                } else {
                                    tecladoCombinacionCorrecta += tecladoCombinacion1.get(j) + " -> ";
                                    bandera--;
                                }

                                break;
                            }
                        }
                    }

                    viewTeclado.lbOrden.setText("Orden: " + tecladoCombinacionCorrecta);
                } else {
                    bandera = 0;

                    for (int j = 0; j < 7; j++) {
                        for (int s = 0; s < 4; s++) {
                            if (tecladoCombinacionTemp.get(s).equals(tecladoCombinacion2.get(j))) {
                                bandera++;
                                break;
                            }
                        }
                    }

                    if (bandera == 4) {
                        for (int j = 0; j < 7; j++) {
                            for (int s = 0; s < 4; s++) {
                                if (tecladoCombinacion2.get(j).equals(tecladoCombinacionTemp.get(s))) {
                                    if (bandera < 2) {
                                        tecladoCombinacionCorrecta += tecladoCombinacion2.get(j);
                                    } else {
                                        tecladoCombinacionCorrecta += tecladoCombinacion2.get(j) + " -> ";
                                        bandera--;
                                    }

                                    break;
                                }
                            }
                        }

                        viewTeclado.lbOrden.setText("Orden: " + tecladoCombinacionCorrecta);
                    } else {
                        bandera = 0;

                        for (int j = 0; j < 7; j++) {
                            for (int s = 0; s < 4; s++) {
                                if (tecladoCombinacionTemp.get(s).equals(tecladoCombinacion3.get(j))) {
                                    bandera++;
                                    break;
                                }
                            }
                        }

                        if (bandera == 4) {
                            for (int j = 0; j < 7; j++) {
                                for (int s = 0; s < 4; s++) {
                                    if (tecladoCombinacion3.get(j).equals(tecladoCombinacionTemp.get(s))) {
                                        if (bandera < 2) {
                                            tecladoCombinacionCorrecta += tecladoCombinacion3.get(j);
                                        } else {
                                            tecladoCombinacionCorrecta += tecladoCombinacion3.get(j) + " -> ";
                                            bandera--;
                                        }

                                        break;
                                    }
                                }
                            }

                            viewTeclado.lbOrden.setText("Orden: " + tecladoCombinacionCorrecta);
                        } else {
                            bandera = 0;

                            for (int j = 0; j < 7; j++) {
                                for (int s = 0; s < 4; s++) {
                                    if (tecladoCombinacionTemp.get(s).equals(tecladoCombinacion4.get(j))) {
                                        bandera++;
                                        break;
                                    }
                                }
                            }

                            if (bandera == 4) {
                                for (int j = 0; j < 7; j++) {
                                    for (int s = 0; s < 4; s++) {
                                        if (tecladoCombinacion4.get(j).equals(tecladoCombinacionTemp.get(s))) {
                                            if (bandera < 2) {
                                                tecladoCombinacionCorrecta += tecladoCombinacion4.get(j);
                                            } else {
                                                tecladoCombinacionCorrecta += tecladoCombinacion4.get(j) + " -> ";
                                                bandera--;
                                            }

                                            break;
                                        }
                                    }
                                }

                                viewTeclado.lbOrden.setText("Orden: " + tecladoCombinacionCorrecta);
                            } else {
                                bandera = 0;

                                for (int j = 0; j < 7; j++) {
                                    for (int s = 0; s < 4; s++) {
                                        if (tecladoCombinacionTemp.get(s).equals(tecladoCombinacion5.get(j))) {
                                            bandera++;
                                            break;
                                        }
                                    }
                                }

                                if (bandera == 4) {
                                    for (int j = 0; j < 7; j++) {
                                        for (int s = 0; s < 4; s++) {
                                            if (tecladoCombinacion5.get(j).equals(tecladoCombinacionTemp.get(s))) {
                                                if (bandera < 2) {
                                                    tecladoCombinacionCorrecta += tecladoCombinacion5.get(j);
                                                } else {
                                                    tecladoCombinacionCorrecta += tecladoCombinacion5.get(j) + " -> ";
                                                    bandera--;
                                                }

                                                break;
                                            }
                                        }
                                    }

                                    viewTeclado.lbOrden.setText("Orden: " + tecladoCombinacionCorrecta);
                                } else {
                                    bandera = 0;

                                    for (int j = 0; j < 7; j++) {
                                        for (int s = 0; s < 4; s++) {
                                            if (tecladoCombinacionTemp.get(s).equals(tecladoCombinacion6.get(j))) {
                                                bandera++;
                                                break;
                                            }
                                        }
                                    }

                                    if (bandera == 4) {
                                        for (int j = 0; j < 7; j++) {
                                            for (int s = 0; s < 4; s++) {
                                                if (tecladoCombinacion6.get(j).equals(tecladoCombinacionTemp.get(s))) {
                                                    if (bandera < 2) {
                                                        tecladoCombinacionCorrecta += tecladoCombinacion6.get(j);
                                                    } else {
                                                        tecladoCombinacionCorrecta += tecladoCombinacion6.get(j) + " -> ";
                                                        bandera--;
                                                    }

                                                    break;
                                                }
                                            }
                                        }

                                        viewTeclado.lbOrden.setText("Orden: " + tecladoCombinacionCorrecta);
                                    } else {
                                        viewTeclado.lbOrden.setText("Orden: Algo anda mal :(");
                                    }
                                }
                            }
                        }
                    }
                }

            } catch (Exception x) {
                showMessageDialog(null, "Error: " + x.getMessage());
            }
            
        }
        
        if (e.getSource() == viewCodigoMorse.btnConvertir ) {
            
            String codigoMorse = "";
            String frecuencia = "";
            boolean encontrado = false;
            
            try {
                codigoMorse = viewCodigoMorse.jtfMorse.getText();

                if (codigoMorse.matches("[\\-\\.\\s]+")) {
                    String[] partes = codigoMorse.split("[\\s]+");

                    ArrayList<String> resultados = new ArrayList<>();

                    for (String parte : partes) {
                        if (parte.matches("[\\-\\.]+")) {
                            resultados.add(parte);
                        }
                    }

                    String[] resultadoFinal = resultados.toArray(new String[0]);

                    String[] palabrasMorse = resultadoFinal; // Separa el resultadoFinal en un array de palabras Morse
                    StringBuilder palabra = new StringBuilder(); // Inicializa un StringBuilder para construir la palabra a partir de las palabras Morse

                    // Itera por cada palabra Morse y busca su correspondencia en la matriz de código Morse
                    for (String palabraMorse : palabrasMorse) {
                        for (String[] fila : matrizCodigoMorse) {
                            if (palabraMorse.equals(fila[1])) { // Si la palabra Morse coincide con la fila de la matriz de código Morse, agrega la letra correspondiente al StringBuilder
                                palabra.append(fila[0]);
                                break; // Sal del bucle interno para pasar a la siguiente palabra Morse
                            }
                        }
                    }

                    String palabraEnMinusculas = palabra.toString().toLowerCase();
                    for (String[] fila : matrizFrecuencias) {
                        String palabraFrecuencia = fila[0].toLowerCase();
                        String primerasDosLetras = palabraEnMinusculas.substring(0, 2);
                        String primerasTresLetras;

                        
                        if (palabraFrecuencia.startsWith(primerasDosLetras)) {
                            frecuencia = fila[1];
                            break;
                        } else 
                            primerasTresLetras = palabraEnMinusculas.substring(0, 3);
                            if (palabraFrecuencia.startsWith(primerasTresLetras)) {
                            frecuencia = fila[1];
                            break;
                        }
                    }

                    viewCodigoMorse.jlbPalabra.setText("La palabra es: " + palabra);
                    viewCodigoMorse.jlbFrecuencia.setText("Frecuencia: " + frecuencia);

                } else {
                    showMessageDialog(null, "El String contiene otros caracteres además de '-' o '.' o ' '");
                }

            } catch (Exception x) {
                showMessageDialog(null, "Error: " + x.getMessage());
            }
        }
        
        if (e.getSource() == viewMemoria.btnOkey) {
            
            try {
                if (etapa == 4) {
                    if (viewMemoria.tfEtiqueta.getText().matches("[1-4]+")) {
                        etiqueta[3] = viewMemoria.tfEtiqueta.getText();
                        if (viewMemoria.tfPosicion.getText().matches("[1-4]+")) {
                            posicion[3] = viewMemoria.tfPosicion.getText();
                            etapa = 5;
                            viewMemoria.lbEtapa.setText("ETAPA 5");
                        } else {
                            showMessageDialog(null, "La Posicion no contiene solo números del 1 al 4");
                        }
                    } else {
                        showMessageDialog(null, "La Etiqueta no contiene solo números del 1 al 4");
                    }
                } 
                
                if (etapa == 3) {
                    if (viewMemoria.tfEtiqueta.getText().matches("[1-4]+")) {
                        etiqueta[2] = viewMemoria.tfEtiqueta.getText();
                        if (viewMemoria.tfPosicion.getText().matches("[1-4]+")) {
                            posicion[2] = viewMemoria.tfPosicion.getText();
                            etapa = 4;
                            viewMemoria.lbEtapa.setText("ETAPA 4");
                        } else {
                            showMessageDialog(null, "La Posicion no contiene solo números del 1 al 4");
                        }
                    } else {
                        showMessageDialog(null, "La Etiqueta no contiene solo números del 1 al 4");
                    }
                }
                
                if (etapa == 2) {
                    if (viewMemoria.tfEtiqueta.getText().matches("[1-4]+")) {
                        etiqueta[1] = viewMemoria.tfEtiqueta.getText();
                        if (viewMemoria.tfPosicion.getText().matches("[1-4]+")) {
                            posicion[1] = viewMemoria.tfPosicion.getText();
                            etapa = 3;
                            viewMemoria.lbEtapa.setText("ETAPA 3");
                        } else {
                            showMessageDialog(null, "La Posicion no contiene solo números del 1 al 4");
                        }
                    } else {
                        showMessageDialog(null, "La Etiqueta no contiene solo números del 1 al 4");
                    }
                }
                
                if (etapa == 1) {
                    if (viewMemoria.tfEtiqueta.getText().matches("[1-4]+")) {
                        etiqueta[0] = viewMemoria.tfEtiqueta.getText();
                        if (viewMemoria.tfPosicion.getText().matches("[1-4]+")) {
                            posicion[0] = viewMemoria.tfPosicion.getText();
                            etapa = 2;
                            viewMemoria.lbEtapa.setText("ETAPA 2");
                        } else {
                            showMessageDialog(null, "La Posicion no contiene solo números del 1 al 4");
                        }
                    } else {
                        showMessageDialog(null, "La Etiqueta no contiene solo números del 1 al 4");
                    }
                }              
            } catch (Exception x) {
                showMessageDialog(null, "Error: " + x.getMessage());
            }
        }
        
        if (e.getSource() == viewMemoria.btnReset) {
            this.etapa = 1;
            viewMemoria.lbEtapa.setText("ETAPA 1");
        }
        
        if (e.getSource() == viewMemoria.btnMonitor1) {
            if (etapa == 1) { viewMemoria.lbResultado.setText("RESULTADO: POSICION 2"); }
            if (etapa == 2) { viewMemoria.lbResultado.setText("RESULTADO: ETIQUETA 4"); }
            if (etapa == 3) { viewMemoria.lbResultado.setText("RESULTADO: ETIQUETA " + etiqueta[1]); }
            if (etapa == 4) { viewMemoria.lbResultado.setText("RESULTADO: POSICION " + posicion[0]); }
            if (etapa == 5) { viewMemoria.lbResultado.setText("RESULTADO: ETIQUETA " + etiqueta[0]); }    
        }
        
        if (e.getSource() == viewMemoria.btnMonitor2) {
            if (etapa == 1) { viewMemoria.lbResultado.setText("RESULTADO: POSICION 2"); }
            if (etapa == 2) { viewMemoria.lbResultado.setText("RESULTADO: POSICION " + posicion[0]); }
            if (etapa == 3) { viewMemoria.lbResultado.setText("RESULTADO: ETIQUETA " + etiqueta[0]); }
            if (etapa == 4) { viewMemoria.lbResultado.setText("RESULTADO: POSICION 1"); }
            if (etapa == 5) { viewMemoria.lbResultado.setText("RESULTADO: ETIQUETA " + etiqueta[1]); }    
        }
        
        if (e.getSource() == viewMemoria.btnMonitor3) {
            if (etapa == 1) { viewMemoria.lbResultado.setText("RESULTADO: POSICION 3"); }
            if (etapa == 2) { viewMemoria.lbResultado.setText("RESULTADO: POSICION 1"); }
            if (etapa == 3) { viewMemoria.lbResultado.setText("RESULTADO: POSICION 3"); }
            if (etapa == 4) { viewMemoria.lbResultado.setText("RESULTADO: POSICION " + posicion[1]); }
            if (etapa == 5) { viewMemoria.lbResultado.setText("RESULTADO: ETIQUETA " + etiqueta[3]); }    
        }
        
        if (e.getSource() == viewMemoria.btnMonitor4) {
            if (etapa == 1) { viewMemoria.lbResultado.setText("RESULTADO: POSICION 4"); }
            if (etapa == 2) { viewMemoria.lbResultado.setText("RESULTADO: POSICION " + posicion[0]); }
            if (etapa == 3) { viewMemoria.lbResultado.setText("RESULTADO: ETIQUETA 4"); }
            if (etapa == 4) { viewMemoria.lbResultado.setText("RESULTADO: POSICION " + posicion[1]); }
            if (etapa == 5) { viewMemoria.lbResultado.setText("RESULTADO: ETIQUETA " + etiqueta[2]); }    
        }
        
        if (e.getSource() == viewQuienVaPrimero.btnBuscarPrimerPalabra) {
            
            String primerPalabra = "";
            String resultado = "";
            
            try {
                primerPalabra = viewQuienVaPrimero.tfPrimerPalabra.getText();
                
                for (int i = 0; i < matrizPalabrasQuienVaPrimero.length; i++) {
                    if (matrizPalabrasQuienVaPrimero[i][0].equals(primerPalabra)) {
                        resultado = matrizPalabrasQuienVaPrimero[i][1];
                        break; // Si encontramos la palabra, salimos del bucle
                    }
                }
                
                if (!resultado.equals("")) {
                    viewQuienVaPrimero.lbResultadoPrimerPalabra.setText("RESULTADO: " + resultado);
                } else {
                    viewQuienVaPrimero.lbResultadoPrimerPalabra.setText("RESULTADO: NO SE ENCONTRO LA PALABRA");
                }
            } catch (Exception x) {
                showMessageDialog(null, "Error: " + x.getMessage());
            }
            
        }
        
        if (e.getSource() == viewQuienVaPrimero.btnBuscarSegundaPalabra) {
            
            String segundaPalabra = "";
            
            try {
                segundaPalabra = viewQuienVaPrimero.tfSegundaPalabra.getText();
                viewQuienVaPrimero.taResultadoSegundaPalabra.setText(mapaPalabrasQuienVaPrimero.get(segundaPalabra));
                if (mapaPalabrasQuienVaPrimero.get(segundaPalabra).equals(null)) { }
            } catch (Exception x) {
                viewQuienVaPrimero.taResultadoSegundaPalabra.setText("NO SE ENCONTRO LA PALABRA");
            }
        }
        
        if (e.getSource() == viewSimonDice.btnRojo) {
            
            if (viewSimonDice.cbConVocal.isSelected()) {
                if (viewSimonDice.rbSinFallos.isSelected()) {
                    resultadoSimonDice += "Azul ";
                } else {
                    if (viewSimonDice.rb1Fallo.isSelected()) {
                        resultadoSimonDice += "Amarillo ";
                    } else {
                        resultadoSimonDice += "Verde ";
                    }
                }
            } else {
                if (viewSimonDice.rbSinFallos.isSelected()) {
                    resultadoSimonDice += "Azul ";
                } else {
                    if (viewSimonDice.rb1Fallo.isSelected()) {
                        resultadoSimonDice += "Rojo ";
                    } else {
                        resultadoSimonDice += "Amarillo ";
                    }
                }
            }
            
            viewSimonDice.taResultado.setText(resultadoSimonDice);
        }
        
        if (e.getSource() == viewSimonDice.btnAzul) {
            if (viewSimonDice.cbConVocal.isSelected()) {
                if (viewSimonDice.rbSinFallos.isSelected()) {
                    resultadoSimonDice += "Rojo ";
                } else {
                    if (viewSimonDice.rb1Fallo.isSelected()) {
                        resultadoSimonDice += "Verde ";
                    } else {
                        resultadoSimonDice += "Rojo ";
                    }
                }
            } else {
                if (viewSimonDice.rbSinFallos.isSelected()) {
                    resultadoSimonDice += "Amarillo ";
                } else {
                    if (viewSimonDice.rb1Fallo.isSelected()) {
                        resultadoSimonDice += "Azul ";
                    } else {
                        resultadoSimonDice += "Verde ";
                    }
                }
            }
            
            viewSimonDice.taResultado.setText(resultadoSimonDice);
        }
        
        if (e.getSource() == viewSimonDice.btnAmarillo) {
            if (viewSimonDice.cbConVocal.isSelected()) {
                if (viewSimonDice.rbSinFallos.isSelected()) {
                    resultadoSimonDice += "Verde ";
                } else {
                    if (viewSimonDice.rb1Fallo.isSelected()) {
                        resultadoSimonDice += "Rojo ";
                    } else {
                        resultadoSimonDice += "Azul ";
                    }
                }
            } else {
                if (viewSimonDice.rbSinFallos.isSelected()) {
                    resultadoSimonDice += "Rojo ";
                } else {
                    if (viewSimonDice.rb1Fallo.isSelected()) {
                        resultadoSimonDice += "Verde ";
                    } else {
                        resultadoSimonDice += "Rojo ";
                    }
                }
            }
            
            viewSimonDice.taResultado.setText(resultadoSimonDice);
        }
        
        if (e.getSource() == viewSimonDice.btnVerde) {
            if (viewSimonDice.cbConVocal.isSelected()) {
                if (viewSimonDice.rbSinFallos.isSelected()) {
                    resultadoSimonDice += "Amarillo ";
                } else {
                    if (viewSimonDice.rb1Fallo.isSelected()) {
                        resultadoSimonDice += "Azul ";
                    } else {
                        resultadoSimonDice += "Amarillo ";
                    }
                }
            } else {
                if (viewSimonDice.rbSinFallos.isSelected()) {
                    resultadoSimonDice += "Verde ";
                } else {
                    if (viewSimonDice.rb1Fallo.isSelected()) {
                        resultadoSimonDice += "Amarillo ";
                    } else {
                        resultadoSimonDice += "Azul ";
                    }
                }
            }
            
            viewSimonDice.taResultado.setText(resultadoSimonDice);
        }
        
        if (e.getSource() == viewSimonDice.btnReset) {
            resultadoSimonDice = "";
            viewSimonDice.taResultado.setText("");
        }
        
        if (e.getSource() == viewCablesComplicados.btnBuscar) {
            if (viewCablesComplicados.cbRojo.isSelected()) {
                if (viewCablesComplicados.cbAzul.isSelected()) {
                    if (viewCablesComplicados.cbEstrella.isSelected()) {
                        if (viewCablesComplicados.cbLed.isSelected()) {
                            viewCablesComplicados.taRespuesta.setText("No cortes el cable");
                        } else {
                            viewCablesComplicados.taRespuesta.setText("Hay un puerto paralelo");
                        }
                    } else {
                        if (viewCablesComplicados.cbLed.isSelected()) {
                            viewCablesComplicados.taRespuesta.setText("Ultimo digito del serial es par");
                        } else {
                            viewCablesComplicados.taRespuesta.setText("Ultimo digito del serial es par");
                        }
                    }
                } else {
                    if (viewCablesComplicados.cbEstrella.isSelected()) {
                        if (viewCablesComplicados.cbLed.isSelected()) {
                            viewCablesComplicados.taRespuesta.setText("Dos o más baterias");
                        } else {
                            viewCablesComplicados.taRespuesta.setText("Corta el cable");
                        }
                    } else {
                        if (viewCablesComplicados.cbLed.isSelected()) {
                            viewCablesComplicados.taRespuesta.setText("Dos o más baterias");
                        } else {
                            viewCablesComplicados.taRespuesta.setText("Ultimo digito del serial es par");
                        }
                    }
                }
            } else {
                if (viewCablesComplicados.cbAzul.isSelected()) {
                    if (viewCablesComplicados.cbEstrella.isSelected()) {
                        if (viewCablesComplicados.cbLed.isSelected()) {
                            viewCablesComplicados.taRespuesta.setText("Hay un puerto paralelo");
                        } else {
                            viewCablesComplicados.taRespuesta.setText("No cortes el cable");
                        }
                    } else {
                        if (viewCablesComplicados.cbLed.isSelected()) {
                            viewCablesComplicados.taRespuesta.setText("Hay un puerto paralelo");
                        } else {
                            viewCablesComplicados.taRespuesta.setText("Ultimo digito del serial es par");
                        }
                    }
                } else {
                    if (viewCablesComplicados.cbEstrella.isSelected()) {
                        if (viewCablesComplicados.cbLed.isSelected()) {
                            viewCablesComplicados.taRespuesta.setText("Dos o más baterias");
                        } else {
                            viewCablesComplicados.taRespuesta.setText("Corta el cable");
                        }
                    } else {
                        if (viewCablesComplicados.cbLed.isSelected()) {
                            viewCablesComplicados.taRespuesta.setText("No cortes el cable");
                        } else {
                            viewCablesComplicados.taRespuesta.setText("Corta el cable");
                        }
                    }
                }
            }
        }
        
        if (e.getSource() == viewLaberinto.btnBuscar) {
            
            try {
                if (viewLaberinto.tfX1.getText().matches("[1-6]+")) {
                    if (viewLaberinto.tfY1.getText().matches("[1-6]+")) {
                        if (viewLaberinto.tfX2.getText().matches("[1-6]+")) {
                            if (viewLaberinto.tfY2.getText().matches("[1-6]+")) {
                                int x1 = Integer.parseInt(viewLaberinto.tfX1.getText());
                                int y1 = Integer.parseInt(viewLaberinto.tfY1.getText());
                                int x2 = Integer.parseInt(viewLaberinto.tfX2.getText());
                                int y2 = Integer.parseInt(viewLaberinto.tfY2.getText());

                                for (int i = 0; i < mapas.length; i++) {
                                    if (mapas[i].contienePuntos(x1, y1, x2, y2)) {
                                        File archivoImagen = new File("src\\main\\java\\img\\" + mapas[i].getImg() + ".png");
                                        try {
                                            viewLaberinto.lbImg.setIcon(new javax.swing.ImageIcon(ImageIO.read(archivoImagen)));
                                        } catch (Exception x) {
                                            showMessageDialog(null, "Error: " + x.getMessage());
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                
                
            } catch (Exception x) {
                showMessageDialog(null, "Error: " + x.getMessage());
            }
        }
    }    
}
