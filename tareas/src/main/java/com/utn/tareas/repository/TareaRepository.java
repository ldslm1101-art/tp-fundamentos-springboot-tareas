package com.utn.tareas.repository;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Repository

public class TareaRepository {

    private final List<Tarea> tareasEnMemoria = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong();

    public TareaRepository() {
        guardar(new Tarea("Estudiar Spring Boot", Prioridad.ALTA));
        guardar(new Tarea("Hacer el TP", Prioridad.ALTA));
        guardar(new Tarea("Comprar pan", Prioridad.MEDIA));
        guardar(new Tarea("Limpiar la casa", Prioridad.BAJA));
    }

    public Tarea guardar(Tarea tarea){
        if (tarea.getId()==null){
            tarea.setId(contador.incrementAndGet());
        }
        tareasEnMemoria.removeIf(t->t.getId().equals(tarea.getId()));
        tareasEnMemoria.add(tarea);
        return tarea;
    }

    public List<Tarea> obtenerTodas() {
        return new ArrayList<>(tareasEnMemoria);
    }

    public Optional<Tarea> buscarPorId(Long id){
        return tareasEnMemoria.stream().filter(t->t.getId().equals(id))
                .findFirst();
    }

    public void eliminarPorId(Long id){
        tareasEnMemoria.removeIf(t->t.getId().equals(id));
    }
}
