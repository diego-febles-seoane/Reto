package es.reto.diheda.clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class RolController {

    private RolService rolService;

    @Autowired
    public void setRolRepository(RolService rolesService) {
        this.rolService = rolesService;
    }

    @GetMapping("/roles/")
    public List<Rol> getAllRoles() {
        return rolService.getAllRoles();
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable(value = "id") int rolesId) {
        Rol roles = rolService.getRolById(rolesId);
        return ResponseEntity.ok().body(roles);
    }

    @PostMapping("/add/roles/")
    public Rol createRol(@Valid @RequestBody Rol roles) {
        if (roles == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El rol no puede ser nulo");
        }
        if (roles.getId() < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El id del rol no puede ser nulo");
        }
        return rolService.createRol(roles);
    }

    @PutMapping("/update/roles/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable(value = "id") int rolesId,
            @Valid @RequestBody Rol rolDetailsRol) {
        final Rol updateRol = rolService.updateRol(rolesId, rolDetailsRol);
        return ResponseEntity.ok(updateRol);
    }

    @DeleteMapping("/delete/roles/{id}")
    public Map<String, Boolean> deleteRol(@PathVariable(value = "id") int rolesId) {
        rolService.deleteRol(rolesId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
