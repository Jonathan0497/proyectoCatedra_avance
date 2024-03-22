package sv.edu.udb.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.udb.common.JsfUtil;
import sv.edu.udb.repository.GruposRepository;

import java.util.List;

@Named
@ViewScoped
public class GruposView {
    @Inject
    private GruposRepository gruposRepository;
    private GruposEntity grupoSeleccionado;
    private List<GruposEntity> listaGrupos;

    @PostConstruct
    public void init() {
        grupoSeleccionado = new GruposEntity();
        listaGrupos = gruposRepository.findAll();
    }

    public GruposEntity getGrupoSeleccionado() {
        return grupoSeleccionado;
    }

    public void setGrupoSeleccionado(GruposEntity grupoSeleccionado) {
        this.grupoSeleccionado = grupoSeleccionado;
    }

    public List<GruposEntity> getListaGrupos() {
        return listaGrupos;
    }

    public void guardarGrupo() {
        if (grupoSeleccionado.getIdGrupo() == 0) { // Si es un nuevo grupo
            gruposRepository.save(grupoSeleccionado);
            JsfUtil.setFlashMessage("exito","Grupo creado exitosamente.");
        } else { // Si es una actualización
            gruposRepository.save(grupoSeleccionado);
            JsfUtil.setFlashMessage("exito","Grupo actualizado exitosamente.");
        }
        cargarGrupos();
    }

    public void eliminarGrupo(int idGrupo) {
        gruposRepository.delete(idGrupo);
        JsfUtil.setFlashMessage("exito","Grupo eliminado exitosamente.");
        cargarGrupos();
    }

    public void cargarGrupos() {
        listaGrupos = gruposRepository.findAll();
    }

    public void nuevoGrupo() {
        grupoSeleccionado = new GruposEntity();
    }

}

