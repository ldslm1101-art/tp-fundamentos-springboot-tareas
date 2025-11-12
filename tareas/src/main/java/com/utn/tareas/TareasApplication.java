package com.utn.tareas;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareasApplication implements CommandLineRunner {

    private final TareaService tareaService;
    private final MensajeService mensajeService;

    public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
        this.tareaService = tareaService;
        this.mensajeService = mensajeService;
    }

	public static void main(String[] args) {

        SpringApplication.run(TareasApplication.class, args);
	}
    @Override
    public void run(String... args) throws Exception {
        mensajeService.mostrarBienvenida();
        tareaService.mostrarConfiguracion();
        System.out.println("\n--- Tareas Iniciales ---");
        tareaService.listarTodasLasTareas().forEach(System.out::println);
        System.out.println("\n--- Agregando nueva tarea ---");
        tareaService.agregarNuevaTarea("Estudiar Interfaz CommandLineRunner", Prioridad.MEDIA);
        System.out.println("\n--- Tareas Pendientes ---");
        tareaService.listarTareasPendientes().forEach(System.out::println);
        System.out.println("\n--- Marcando tarea 1 como completada ---");
        boolean completada = tareaService.marcarTareaComoCompletada(1L);

        if (completada){
            System.out.println("Tarea 1 marcada como completada");
        }
        else{
            System.out.println("No se encontró o no se encuentra disponible la Tarea 1");
        }
        System.out.println("\n--- Estadísticas ---");
        System.out.println(tareaService.obtenerEstadisticas());
        System.out.println("\n--- Tareas Completadas ---");
        tareaService.listarTareasCompletadas().forEach(System.out::println);
        mensajeService.mostrarDespedida();
    }

}
