package sv.edu.udb.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.udb.common.JsfUtil;
import sv.edu.udb.repository.SalonesRepository;
import sv.edu.udb.repository.domain.SalonesEntity;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class SalonesView implements Serializable {
    @Inject
    private SalonesRepository salonesRepository;
    private SalonesEntity salonSeleccionado;
    private List<SalonesEntity> listaSalones;

    @PostConstruct
    public void init() {
        salonSeleccionado = new SalonesEntity();
        listaSalones = salonesRepository.findAll();
    }

    public SalonesEntity getSalonSeleccionado() {
        return salonSeleccionado;
    }

    public void setSalonSeleccionado(SalonesEntity salonSeleccionado) {
        this.salonSeleccionado = salonSeleccionado;
    }

    public List<SalonesEntity> getListaSalones() {
        return listaSalones;
    }

    public void guardarSalon() {
        if (salonSeleccionado.getIdSalon() == 0) {
            // El ID es 0, se trata de un nuevo salón
            salonesRepository.save(salonSeleccionado);
            JsfUtil.setFlashMessage("exito", "Salón agregado exitosamente");
        } else {
            // Actualizar el salón existente
            salonesRepository.update(salonSeleccionado);
            JsfUtil.setFlashMessage("exito", "Salón actualizado exitosamente");
        }
        cargarSalones(); // Recargar lista de salones
    }

    public void eliminarSalon(int id) {
        salonesRepository.delete(id);
        JsfUtil.setFlashMessage("exito", "Salón eliminado exitosamente");
        cargarSalones(); // Recargar lista de salones
    }

    public void cargarSalones() {
        listaSalones = salonesRepository.findAll();
    }

    public void nuevoSalon() {
        salonSeleccionado = new SalonesEntity();
    }
}
