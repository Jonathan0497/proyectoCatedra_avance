package sv.edu.udb.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sv.edu.udb.repository.domain.MateriaEntity;

import java.util.List;

@Transactional
@ApplicationScoped
public class MateriaRepository {
    @PersistenceContext
    private EntityManager em;

    public List<MateriaEntity> findAll() {
        return em.createNamedQuery("MateriaEntity.findAll", MateriaEntity.class).getResultList();
    }

    public MateriaEntity findById(final int id) {
        return em.find(MateriaEntity.class, id);
    }

    public boolean isExist(final int id) {
        Long count = (Long) em.createNamedQuery("MateriaEntity.isExist")
                .setParameter("idMateria", id)
                .getSingleResult();
        return count > 0;
    }

    public void saveMateria(final MateriaEntity materia) {
        if (!isExist(materia.getIdMateria())) {
            em.persist(materia);
        }
    }

    public void updateMateria(final MateriaEntity materia) {
        if (isExist(materia.getIdMateria())) {
            em.merge(materia);
        }
    }

    public void deleteMateria(final int id) {
        MateriaEntity materia = findById(id);
        if (materia != null) {
            em.remove(materia);
        }
    }
}

