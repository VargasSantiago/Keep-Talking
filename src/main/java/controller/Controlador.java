
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    }    
}
