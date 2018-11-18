package Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    public Department(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "DPT_ID")
    private long id;

    @Column(name = "NAME",nullable = false,unique = true)
    private String Name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department",
            fetch = FetchType.EAGER)
    private List<Employee> employees = new ArrayList<Employee>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setName(String name) {
        Name = name;
    }
}
