package com.uptc.fwr.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="COMPRAS")

public class Bill {

    @Id
    @Column(name = "ID_COMPRA")
    private Long id;
    @Column(name = "ID_PERSONA", insertable = false, updatable = false)
    private Long personId;
    @Column(name = "FECHA")
    private Date fecha;
    @ManyToOne
    @JoinColumn(name ="ID_PERSONA")
    private Person person;

    public Bill() {
    }


    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", personId=" + personId +
                ", fecha=" + fecha +
                '}';
    }
}
