package es.reto.diheda.clases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolService {
    
    private RolRepository rolRepository;
    @Autowired
    public void setRolRepository(RolRepository rollRepository){
        this.rolRepository = rollRepository;
    }

    /**
     * Metodo que obtiene todos los roles de la bbdd
     * @return roles
     */
    public List<Rol> getAllRoles(){
        return rolRepository.findAll();
    }

    /**
     * Metodo que obtiene un rol segun su id
     * @param rolId
     * @return rol
     */
    public Rol getRolById(int rolId){
        return rolRepository.findById(rolId).orElse(null);
    }

    /**
     * Metodo que crea un usuario en la bbdd
     * @param rol
     * @return rol creado
     */
    public Rol createRol(Rol rol){
        if (rol == null){
            throw new RuntimeException("no existeel rol a crear");
        }
        return rolRepository.save(rol);
    }

    /**
     * Metodo que actualiza un usuario de la bbdd
     * @param rolId
     * @param rolDetails
     * @return
     */
    public Rol updateRol(int rolId, Rol rolDetails){
        Rol roles = rolRepository.findById(rolId).orElse(null);
        if(roles != null){
            roles.setId(rolDetails.getId());
            return rolRepository.save(roles);
        }
        throw new RuntimeException("no existe el rol a actualiza");
    }

    /**
     * Metodo qe elimina un usuario de la bbdd
     * @param rolId
     */
    public void deleteRol (int rolId){
        if(rolRepository.existsById(rolId)){
            rolRepository.deleteById(rolId);
        }else{
            throw new RuntimeException("no existe el rol a eliminar");
        }
    }
}
