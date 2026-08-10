/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class AbrirFormulario {

    public static void abrir(JDesktopPane escritorio, JInternalFrame formulario) {

        for (JInternalFrame ventana : escritorio.getAllFrames()) {

            if (ventana.getClass().equals(formulario.getClass())) {

                try {

                    ventana.setIcon(false);
                    ventana.setSelected(true);
                    ventana.toFront();

                } catch (Exception e) {

                }

                return;

            }

        }

        escritorio.add(formulario);

        formulario.setVisible(true);

    }

}