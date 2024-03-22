package sv.edu.udb.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.udb.common.JsfUtil;
import sv.edu.udb.repository.AlumnoRepository;
import sv.edu.udb.repository.domain.AlumnoEntity;

import java.util.ArrayList;
import java.util.List;
@Named
@ViewScoped
public class AlumnoView {
    @Inject
    private AlumnoRepository estudiantesRepository;
    private AlumnoEntity estudiante;
    private List<AlumnoEntity> listaEstudiantes;
    @PostConstruct
    public void init() {
        estudiante = new AlumnoEntity();
        listaEstudiantes = new ArrayList<>();
    }
    public AlumnoEntity getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(AlumnoEntity estudiante) {
        this.estudiante = estudiante;
    }
    public List<AlumnoEntity> getListaEstudiantes() {
        return estudiantesRepository.findAll();
    }
    public void guardarEstudiante() {
        if (estudiantesRepository.saveEstudiante(estudiante) != 1) {
            JsfUtil.setErrorMessage(null, "Ya se registró un alumno con este carnet");
        } else {

            JsfUtil.setFlashMessage("exito", "Alumno registrado exitosamente");
        }
    }
}
