package DesignPatternsProject.entities.personalData;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by lucjan on 10.03.15.
 */

@Entity
public class Privilege {

    @Id @GeneratedValue
    Long privilege_id;

    String privilege;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Privilege() {
    }

    public Privilege(Long privilege_id, String privilege) {
        this.privilege_id = privilege_id;
        this.privilege = privilege;
    }

    public Privilege(String privilege) {
        this.privilege = privilege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Privilege privilege1 = (Privilege) o;

        if (!privilege.equals(privilege1.privilege)) return false;
        if (privilege_id != null ? !privilege_id.equals(privilege1.privilege_id) : privilege1.privilege_id != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = privilege_id != null ? privilege_id.hashCode() : 0;
        result = 31 * result + privilege.hashCode();
        return result;
    }

    public Long getPrivilege_id() {
        return privilege_id;
    }

    public void setPrivilege_id(Long privilege_id) {
        this.privilege_id = privilege_id;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "privilege_id=" + privilege_id +
                ", privilege='" + privilege + '\'' +
                '}';
    }
}
