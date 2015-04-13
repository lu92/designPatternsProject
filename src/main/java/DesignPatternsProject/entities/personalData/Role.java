package DesignPatternsProject.entities.personalData;

import DesignPatternsProject.entities.actors.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucjan on 10.03.15.
 */
@Entity
public class Role {

    @Id @GeneratedValue
    private Long role_id;
    private String roleName;


    @OrderBy(value = "role_id")
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Privilege> privileges = new ArrayList<>();


    @OneToOne
    @PrimaryKeyJoinColumn
    private Person person;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(Long role_id, String roleName, List<Privilege> privileges) {
        this.role_id = role_id;
        this.roleName = roleName;
        this.privileges = privileges;
    }

    public Role(String roleName, List<Privilege> privileges) {
        this.roleName = roleName;
        this.privileges = privileges;
    }


    //              METHODS

    public void addPrivilege(Privilege privilege) {
        privileges.add(privilege);
    }

    public void addPrivileges(String ... args) {
        for (String privilege : args)
            privileges.add(new Privilege(privilege));
    }

    public Privilege getPrivilege(int index) {
        return privileges.get(index);
    }

    //          END OF METHODS

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (privileges != null ? !privileges.equals(role.privileges) : role.privileges != null) return false;
        if (!roleName.equals(role.roleName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleName.hashCode();
        result = 31 * result + (privileges != null ? privileges.hashCode() : 0);
        return result;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", roleName='" + roleName + '\'' +
                ", privileges=" + privileges +
                '}';
    }
}
