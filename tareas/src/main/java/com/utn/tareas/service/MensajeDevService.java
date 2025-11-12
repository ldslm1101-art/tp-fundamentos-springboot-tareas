package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")

public class MensajeDevService implements MensajeService {
    @Override
    public void mostrarBienvenida() {
        System.out.println("=================================");
        System.out.println("BIENVENIDO");
        System.out.println("A PROBAR LA LÓGISTICA DE TAREAS");
        System.out.println("=================================");
    }
    @Override
    public void mostrarDespedida() {
        System.out.println("=================================");
        System.out.println("FIN DE LA EJECUCIÓN EN DEV");
        System.out.println("=================================");
    }
}
