package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TareaService {
    private final TareaRepository tareaRepository;

    @Value("${app.nombre}")
    private String nombreAplicacion;
    @Value("${app.max-tareas}")
    private int maximoDeTareas;
    @Value("${app.mostrar-estadisticas}")
    private boolean mostrarEstadisticas;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea agregarNuevaTarea(String descripcion, Prioridad prioridad){
        long totalTareas = tareaRepository.obtenerTodas().size();
        if (totalTareas>=maximoDeTareas){
            System.out.println("ERROR: Se ha alcanzado el límite de tareas (" + maximoDeTareas + ")");
            return null;
        }
        Tarea nuevaTarea = new Tarea(descripcion, prioridad);
        return tareaRepository.guardar(nuevaTarea);
    }

    public List<Tarea> listarTodasLasTareas(){
        return tareaRepository.obtenerTodas();
    }
    public List<Tarea> listarTareasPendientes(){
        return tareaRepository.obtenerTodas()
                .stream()
                .filter(tarea -> !tarea.isCompletada())
                .collect(Collectors.toList());
    }
    public List<Tarea> listarTareasCompletadas(){
        return tareaRepository.obtenerTodas()
                .stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }
    public boolean marcarTareaComoCompletada(Long id){
        Optional<Tarea> tareaOptional = tareaRepository.buscarPorId(id);
        if(tareaOptional.isPresent()){
            Tarea tarea = tareaOptional.get();
            tarea.setCompletada(true);
            tareaRepository.guardar(tarea);
            return true;
        }
        return false;
    }

    public String obtenerEstadisticas() {
        List<Tarea> todas = listarTodasLasTareas();
        long total = todas.size();
        long completadas = listarTareasCompletadas().size();
        long pendientes = total - completadas; //
        return String.format("Estadísticas: Total de tareas: %d. Completadas: %d. Pendientes: %d.",
                total, completadas, pendientes);
    }

    public void mostrarConfiguracion() {
        System.out.println("--- Configuración de la Aplicación ---");
        System.out.println("Nombre: " + nombreAplicacion);
        System.out.println("Máximo de tareas: " + maximoDeTareas);
        System.out.println("Mostrar Estadísticas: " + mostrarEstadisticas);
        System.out.println("-------------------------------------");
    }
}
