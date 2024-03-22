package sv.edu.udb.repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sv.edu.udb.repository.domain.NotasEntity;

import java.util.List;

@Transactional
@ApplicationScoped
public class NotasRepository {
    @PersistenceContext
    private EntityManager em;

    public List<NotasEntity> findAll() {
        return em.createNamedQuery("NotasEntity.findAll", NotasEntity.class).getResultList();
    }

    public NotasEntity findById(final int id) {
        return em.find(NotasEntity.class, id);
    }

    public List<NotasEntity> findByAlumno(final int idAlumno) {
        return em.createNamedQuery("NotasEntity.findByAlumno", NotasEntity.class)
                .setParameter("idAlumno", idAlumno)
                .getResultList();
    }

    public List<NotasEntity> findByProfesorMateria(final int idProfesorMateria) {
        return em.createNamedQuery("NotasEntity.findByProfesorMateria", NotasEntity.class)
                .setParameter("idProfesorMateria", idProfesorMateria)
                .getResultList();
    }

    public NotasEntity findNotaByAlumnoAndProfesorMateria(final int idAlumno, final int idProfesorMateria) {
        try {
            return em.createNamedQuery("NotasEntity.findNotaByAlumnoAndProfesorMateria", NotasEntity.class)
                    .setParameter("idAlumno", idAlumno)
                    .setParameter("idProfesorMateria", idProfesorMateria)
                    .getSingleResult();
        } catch (Exception e) {
            return null; // No result found
        }
    }

    public boolean isExist(final int id) {
        Long count = (Long) em.createNamedQuery("NotasEntity.isExist")
                .setParameter("idNotas", id)
                .getSingleResult();
        return count > 0;
    }

    public void save(final NotasEntity notas) {
        if (!isExist(notas.getIdNotas())) {
            em.persist(notas);
        } else {
            em.merge(notas);
        }
    }

    public void delete(final int id) {
        NotasEntity notas = findById(id);
        if (notas != null) {
            em.remove(notas);
        }
    }
}
