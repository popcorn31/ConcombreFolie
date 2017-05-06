/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Banque;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author 21509311
 */
@Entity
public class Operation implements Serializable {

    //Propriétés privées
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float somme;
    private Date date;
    private String type;
    @ManyToOne
    private Compte leCompte;
    
    //Attributs publics
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getSomme() {
        return  somme;
    }
    public void setSomme(float somme) {
        this. somme =  somme;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Compte getLeCompte() {
        return leCompte;
    }
    public void setLeCompte(Compte leCompte) {
        this.leCompte = leCompte;
    }
    
    //Constructeur
    public Operation(){}
    public Operation(String type, Date d,float somme, Compte cpt){
        this.type = type;
        this.date = d;
        this. somme =  somme;
        this.leCompte = cpt;
    }
    public Operation(String type, Date d,Compte cpt){
        this.type = type;
        this.date = d;
        this. somme = 0;
        this.leCompte = cpt;
    }
    
    //Méthodes & fonctions
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Banque.Operation[ id=" + id + " ]";
    }
    
}
