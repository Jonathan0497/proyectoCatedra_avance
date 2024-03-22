package sv.edu.udb.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.udb.common.JsfUtil;
import sv.edu.udb.repository.NotasRepository;
import sv.edu.udb.repository.domain.NotasEntity;

import java.util.List;

@Named
@ViewScoped
public class NotasView {
    @Inject
    private NotasRepository notasRepository;
    private NotasEntity notaSeleccionada;
    private List<NotasEntity> listaNotas;

    @PostConstruct
    public void init() {
        notaSeleccionada = new NotasEntity();
        listaNotas = notasRepository.findAll();
    }

    public NotasEntity getNotaSeleccionada() {
        return notaSeleccionada;
    }

    public void setNotaSeleccionada(NotasEntity notaSeleccionada) {
        this.notaSeleccionada = notaSeleccionada;
    }

    public List<NotasEntity> getListaNotas() {
        return listaNotas;
    }

    public void guardarNota() {
        if (notaSeleccionada.getIdNotas() == 0) {
            notasRepository.save(notaSeleccionada);
            JsfUtil.setFlashMessage("exito","Nota creada exitosamente.");
        } else {
            notasRepository.save(notaSeleccionada);
            JsfUtil.setFlashMessage("exito","Nota actualizada exitosamente.");
        }
        cargarNotas();
    }

    public void eliminarNota(int idNota) {
        notasRepository.delete(idNota);
        JsfUtil.setFlashMessage("exito", "Nota eliminada exitosamente.");
        cargarNotas();
    }

    public void cargarNotas() {
        listaNotas = notasRepository.findAll();
    }
}
