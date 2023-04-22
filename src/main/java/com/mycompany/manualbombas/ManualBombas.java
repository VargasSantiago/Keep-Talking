

package com.mycompany.manualbombas;

import vista.VentanaCables;
import vista.VentanaPrincipal;
import vista.VentanaContraseña;

import controller.Controlador;
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

public class ManualBombas {

    public static void main(String[] args) {

        VentanaPrincipal viewPrincipal = new VentanaPrincipal();
        VentanaCables viewCables = new VentanaCables();
        VentanaContraseña viewContraseña = new VentanaContraseña();
        VentanaButton viewButton = new VentanaButton();
        VentanaCablesComplicados viewCablesComplicados = new VentanaCablesComplicados();
        VentanaCodigoMorse viewCodigoMorse = new VentanaCodigoMorse();
        VentanaLaberinto viewLaberinto = new VentanaLaberinto();
        VentanaMemoria viewMemoria = new VentanaMemoria();
        VentanaPerilla viewPerilla = new VentanaPerilla();
        VentanaQuienVaPrimero viewQuienVaPrimero = new VentanaQuienVaPrimero();
        VentanaSecuenciaDeCables viewSecuenciaDeCables = new VentanaSecuenciaDeCables();
        VentanaSimonDice viewSimonDice = new VentanaSimonDice();
        VentanaTeclado viewTeclado = new VentanaTeclado();
        
        Controlador ctrl = new Controlador(viewPrincipal, viewCables, viewContraseña, viewButton, viewCablesComplicados, viewCodigoMorse, viewLaberinto, viewMemoria, viewPerilla, viewQuienVaPrimero, viewSecuenciaDeCables, viewSimonDice, viewTeclado);
        
        ctrl.iniciar();
        viewPrincipal.setVisible(true);
        
    }
}
