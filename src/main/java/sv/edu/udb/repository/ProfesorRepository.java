package sv.edu.udb.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sv.edu.udb.repository.domain.ProfesorEntity;

import java.util.List;

@Transactional
@ApplicationScoped
public class ProfesorRepository {
    @PersistenceContext
    private EntityManager em;

    public List<ProfesorEntity> findAll() {
        return em.createNamedQuery("ProfesorEntity.findAll").getResultList();
    }

    public ProfesorEntity getProfesorPorCarnet(final String carnet) {
        if (existeProfesor(carnet) > 0) {
            return (ProfesorEntity) em.createNamedQuery("ProfesorEntity.findByCarnetProfesor")
                    .setParameter("carnetProfesor", carnet)
                    .getSingleResult();
        } else {
            return null;
        }
    }

    public int saveProfesor(final ProfesorEntity profesor) {
        if (existeProfesor(profesor.getCarnetProfesor()) > 0) {
            return 0;
        } else {
            em.persist(profesor);
            return 1;
        }
    }

    public int updateProfesor(final ProfesorEntity profesor) {
        if (existeProfesor(profesor.getCarnetProfesor()) > 0) {
            em.merge(profesor);
            return 1;
        } else {
            return 0;
        }
    }

    public int eliminarProfesor(final String carnet) {
        int filasBorradas = 0;

        ProfesorEntity prof = getProfesorPorCarnet(carnet);
        if (prof != null) {
            em.remove(prof);
            filasBorradas = 1;
        }
        return filasBorradas;
    }

    private Long existeProfesor(final String carnet) {
        return (Long) em.createNamedQuery("ProfesorEntity.isExist")
                .setParameter("carnetProfesor", carnet)
                .getSingleResult();
    }
}
