package sv.edu.udb.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sv.edu.udb.repository.domain.ProfesoresMateriaEntity;

import java.util.List;

@Transactional
@ApplicationScoped
public class ProfesoresMateriaRepository {
    @PersistenceContext
    private EntityManager em;

    public List<ProfesoresMateriaEntity> findAll() {
        return em.createNamedQuery("ProfesorMateriaEntity.findAll", ProfesoresMateriaEntity.class).getResultList();
    }

    public ProfesoresMateriaEntity findById(final int id) {
        return em.find(ProfesoresMateriaEntity.class, id);
    }

    public List<ProfesoresMateriaEntity> findByProfesor(final int idProfesor) {
        return em.createNamedQuery("ProfesorMateriaEntity.findByProfesor", ProfesoresMateriaEntity.class)
                .setParameter("idProfesor", idProfesor)
                .getResultList();
    }

    public List<ProfesoresMateriaEntity> findByMateria(final int idMateria) {
        return em.createNamedQuery("ProfesorMateriaEntity.findByMateria", ProfesoresMateriaEntity.class)
                .setParameter("idMateria", idMateria)
                .getResultList();
    }

    public boolean isExist(final int id) {
        Long count = (Long) em.createNamedQuery("ProfesorMateriaEntity.isExist")
                .setParameter("idProfesorMateria", id)
                .getSingleResult();
        return count > 0;
    }

    public void save(final ProfesoresMateriaEntity profesorMateria) {
        if (!isExist(profesorMateria.getIdProfesorMateria())) {
            em.persist(profesorMateria);
        }
    }

    public void update(final ProfesoresMateriaEntity profesorMateria) {
        if (isExist(profesorMateria.getIdProfesorMateria())) {
            em.merge(profesorMateria);
        }
    }

    public void delete(final int id) {
        ProfesoresMateriaEntity profesorMateria = findById(id);
        if (profesorMateria != null) {
            em.remove(profesorMateria);
        }
    }
}
