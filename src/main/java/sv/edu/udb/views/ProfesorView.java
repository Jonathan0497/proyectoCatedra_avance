package sv.edu.udb.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.udb.common.JsfUtil;
import sv.edu.udb.repository.ProfesorRepository;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProfesorView implements Serializable {
    @Inject
    private ProfesorRepository profesorRepository;
    private ProfesorEntity profesorSeleccionado;
    private List<ProfesorEntity> listaProfesores;

    @PostConstruct
    public void init() {
        profesorSeleccionado = new ProfesorEntity();
        listaProfesores = profesorRepository.findAll();
    }

    public ProfesorEntity getProfesorSeleccionado() {
        return profesorSeleccionado;
    }

    public void setProfesorSeleccionado(ProfesorEntity profesorSeleccionado) {
        this.profesorSeleccionado = profesorSeleccionado;
    }

    public List<ProfesorEntity> getListaProfesores() {
        return listaProfesores;
    }

    public void guardarProfesor() {
        if (profesorSeleccionado.getIdProfesor() == 0) {
            if (profesorRepository.saveProfesor(profesorSeleccionado) == 1) {
                JsfUtil.setFlashMessage("exito", "Profesor agregado exitosamente");
            } else {
                JsfUtil.setErrorMessage(null, "Un profesor con ese carnet ya existe.");
            }
        } else {
            if (profesorRepository.updateProfesor(profesorSeleccionado) == 1) {
                JsfUtil.setFlashMessage("exito", "Profesor actualizado exitosamente");
            } else {
                JsfUtil.setErrorMessage(null, "Error al actualizar el profesor.");
            }
        }
        cargarProfesores();
    }

    public void eliminarProfesor(String carnet) {
        if (profesorRepository.eliminarProfesor(carnet) == 1) {
            JsfUtil.setFlashMessage("exito", "Profesor eliminado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "Error al eliminar el profesor.");
        }
        cargarProfesores();
    }

    public void cargarProfesores() {
        listaProfesores = profesorRepository.findAll();
    }

    public void seleccionarProfesor(ProfesorEntity profesor) {
        this.profesorSeleccionado = profesor;
    }

    public void nuevoProfesor() {
        this.profesorSeleccionado = new ProfesorEntity();
    }
}
