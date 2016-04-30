package ua.artcode.testio.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IdAutoGeneratedEntity {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public IdAutoGeneratedEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdAutoGeneratedEntity that = (IdAutoGeneratedEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}