package sv.edu.udb.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sv.edu.udb.repository.domain.GruposEntity;

import java.util.List;

@Transactional
@ApplicationScoped
public class GruposRepository {
    @PersistenceContext
    private EntityManager em;

    public List<GruposEntity> findAll() {
        return em.createNamedQuery("GrupoEntity.findAll", GruposEntity.class).getResultList();
    }

    public GruposEntity findById(final int id) {
        return em.find(GruposEntity.class, id);
    }

    public List<GruposEntity> findByAlumno(final int idAlumno) {
        return em.createNamedQuery("GrupoEntity.findByAlumno", GruposEntity.class)
                .setParameter("idAlumno", idAlumno)
                .getResultList();
    }

    public List<GruposEntity> findByProfesor(final int idProfesor) {
        return em.createNamedQuery("GrupoEntity.findByProfesor", GruposEntity.class)
                .setParameter("idProfesor", idProfesor)
                .getResultList();
    }

    public List<GruposEntity> findBySalon(final int idSalon) {
        return em.createNamedQuery("GrupoEntity.findBySalon", GruposEntity.class)
                .setParameter("idSalon", idSalon)
                .getResultList();
    }

    public boolean isExist(final int id) {
        Long count = (Long) em.createNamedQuery("GrupoEntity.isExist")
                .setParameter("idGrupo", id)
                .getSingleResult();
        return count > 0;
    }

    public void save(final GruposEntity grupo) {
        if (!isExist(grupo.getIdGrupo())) {
            em.persist(grupo);
        } else {
            em.merge(grupo);
        }
    }

    public void delete(final int id) {
        GruposEntity grupo = findById(id);
        if (grupo != null) {
            em.remove(grupo);
        }
    }

}

