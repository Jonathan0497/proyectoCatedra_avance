package sv.edu.udb.repository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sv.edu.udb.repository.domain.AlumnoEntity;

import java.util.List;

@Transactional
@ApplicationScoped
public class AlumnoRepository {
    @PersistenceContext
    private EntityManager em;
    public List<AlumnoEntity> findAll() {
        return em.createNamedQuery("AlumnoEntity.findAll").getResultList();
    }
    public AlumnoEntity getEstudiantePorCarnet(final String carnet) {
        if (existeEstudiante(carnet) > 0) {
            return em.find(AlumnoEntity.class, carnet);
        } else {
            return null;
        }
    }
    public int saveEstudiante(final AlumnoEntity estudiante) {

        if (existeEstudiante(estudiante.getCarnet()) > 0) {
            return 0; //Estudiante ya existe;
        } else {
            em.persist(estudiante);
            return 1;
        }
    }
    public int updateEstudiante(final AlumnoEntity estudiante) {
        if (existeEstudiante(estudiante.getCarnet()) > 0) {
            em.merge(estudiante);
            return 1;
        } else {
            return 0;
        }
    }
    public int eliminarEstudiante(final String carnet) {
        int filasBorradas = 0;

        final AlumnoEntity est = em.find(AlumnoEntity.class, carnet);
        if (est != null) {
            em.remove(est);
            filasBorradas = 1;
        }
        return filasBorradas;
    }
    private Long existeEstudiante(final String carnet) {
        return (Long) em.createNamedQuery("AlumnoEntity.isExist")
                .setParameter("carnet", carnet).getSingleResult();
    }
}
