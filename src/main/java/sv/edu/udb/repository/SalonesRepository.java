package sv.edu.udb.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sv.edu.udb.repository.domain.SalonesEntity;

import java.util.List;

@Transactional
@ApplicationScoped
public class SalonesRepository {
    @PersistenceContext
    private EntityManager em;

    public List<SalonesEntity> findAll() {
        return em.createNamedQuery("SalonesEntity.findAll", SalonesEntity.class).getResultList();
    }

    public SalonesEntity findById(final int id) {
        return em.find(SalonesEntity.class, id);
    }

    public boolean isExist(final int id) {
        Long count = (Long) em.createNamedQuery("SalonesEntity.isExist")
                .setParameter("idSalon", id)
                .getSingleResult();
        return count != null && count > 0;
    }

    public void save(final SalonesEntity salon) {
        if (!isExist(salon.getIdSalon())) {
            em.persist(salon);
        }
    }

    public void update(final SalonesEntity salon) {
        if (isExist(salon.getIdSalon())) {
            em.merge(salon);
        }
    }

    public void delete(final int id) {
        SalonesEntity salon = findById(id);
        if (salon != null) {
            em.remove(salon);
        }
    }
}

