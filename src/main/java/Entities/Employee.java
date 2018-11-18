package Entities;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    public Employee(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID")
    private long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Column(name = "DESIGNATION")
    private String designation;

    @ManyToOne
    @JoinColumn(name = "DPT_ID")
    private Department department;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
