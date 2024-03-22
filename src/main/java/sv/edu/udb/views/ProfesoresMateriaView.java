package sv.edu.udb.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.udb.common.JsfUtil;
import sv.edu.udb.repository.ProfesoresMateriaRepository;
import sv.edu.udb.repository.domain.ProfesoresMateriaEntity;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProfesoresMateriaView implements Serializable {
    @Inject
    private ProfesoresMateriaRepository profesorMateriaRepository;
    private ProfesoresMateriaEntity profesorMateriaSeleccionada;
    private List<ProfesoresMateriaEntity> listaProfesoresMateria;

    @PostConstruct
    public void init() {
        profesorMateriaSeleccionada = new ProfesoresMateriaEntity();
        listaProfesoresMateria = profesorMateriaRepository.findAll();
    }

    public ProfesoresMateriaEntity getProfesorMateriaSeleccionada() {
        return profesorMateriaSeleccionada;
    }

    public void setProfesorMateriaSeleccionada(ProfesoresMateriaEntity profesorMateriaSeleccionada) {
        this.profesorMateriaSeleccionada = profesorMateriaSeleccionada;
    }

    public List<ProfesoresMateriaEntity> getListaProfesoresMateria() {
        return listaProfesoresMateria;
    }

    public void guardarRelacion() {
        if (!profesorMateriaRepository.isExist(profesorMateriaSeleccionada.getIdProfesorMateria())) {
            profesorMateriaRepository.save(profesorMateriaSeleccionada);
            JsfUtil.setFlashMessage("exito", "Relación profesor-materia agregada exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "Esta relación ya está registrada");
        }
        cargarRelaciones();
    }

    public void actualizarRelacion() {
        if (profesorMateriaRepository.isExist(profesorMateriaSeleccionada.getIdProfesorMateria())) {
            profesorMateriaRepository.update(profesorMateriaSeleccionada);
            JsfUtil.setFlashMessage("exito", "Relación profesor-materia actualizada exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "Esta relación no se puede actualizar porque no existe");
        }
        cargarRelaciones();
    }

    public void eliminarRelacion(int id) {
        profesorMateriaRepository.delete(id);
        JsfUtil.setFlashMessage("exito", "Relación profesor-materia eliminada exitosamente");
        cargarRelaciones();
    }

    public void cargarRelaciones() {
        listaProfesoresMateria = profesorMateriaRepository.findAll();
    }

    public void nuevaRelacion() {
        this.profesorMateriaSeleccionada = new ProfesoresMateriaEntity();
    }
}
