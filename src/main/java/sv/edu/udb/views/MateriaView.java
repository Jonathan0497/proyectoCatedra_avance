package sv.edu.udb.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.udb.common.JsfUtil;
import sv.edu.udb.repository.MateriaRepository;
import sv.edu.udb.repository.domain.MateriaEntity;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class MateriaView implements Serializable {
    @Inject
    private MateriaRepository materiaRepository;
    private MateriaEntity materiaSeleccionada;
    private List<MateriaEntity> listaMaterias;

    @PostConstruct
    public void init() {
        materiaSeleccionada = new MateriaEntity();
        listaMaterias = materiaRepository.findAll();
    }

    public MateriaEntity getMateriaSeleccionada() {
        return materiaSeleccionada;
    }

    public void setMateriaSeleccionada(MateriaEntity materiaSeleccionada) {
        this.materiaSeleccionada = materiaSeleccionada;
    }

    public List<MateriaEntity> getListaMaterias() {
        return listaMaterias;
    }

    public void guardarMateria() {
        if (materiaSeleccionada.getIdMateria() == 0) {
            materiaRepository.saveMateria(materiaSeleccionada);
            JsfUtil.setFlashMessage("exito", "Materia agregada exitosamente");
        } else {
            materiaRepository.updateMateria(materiaSeleccionada);
            JsfUtil.setFlashMessage("exito", "Materia actualizada exitosamente");
        }
        cargarMaterias();
    }

    public void eliminarMateria(int id) {
        materiaRepository.deleteMateria(id);
        JsfUtil.setFlashMessage("exito", "Materia eliminada exitosamente");
        cargarMaterias();
    }

    public void cargarMaterias() {
        listaMaterias = materiaRepository.findAll();
    }

    public void seleccionarMateria(MateriaEntity materia) {
        this.materiaSeleccionada = materia;
    }

    public void nuevaMateria() {
        this.materiaSeleccionada = new MateriaEntity();
    }
}
