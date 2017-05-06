/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Banque;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author 21509311
 */
@Entity
public class Compte implements Serializable {

    //Propriétés privées
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float solde;
    private boolean cloture;
    @OneToMany
    private ArrayList<Operation> lesOperations;
    @ManyToOne
    private ClientBanque leClient;
            
    //Attributs publics
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public float getSolde() {
        return solde;
    }
    public void setSolde(float solde) {
        this.solde = solde;
    }
    public boolean getCloture() {
        return cloture;
    }
    public void setCloture(boolean cloture) {
        this.cloture = cloture;
    }
    public ArrayList<Operation> getLesOperations() {
        return lesOperations;
    }
    public void setLesOperations(Operation uneOperation) {
        this.lesOperations.add(uneOperation);
    }
    public ClientBanque getLeClient() {
        return leClient;
    }
    public void setLeClient(ClientBanque idClient) {
        this.leClient = idClient;
    }
    
    //Constructeur(s)
    public Compte(){};
    public Compte(ClientBanque p_leClient){
        id = p_leClient.getId();
        solde = 0;
        cloture = false;
        this.lesOperations = new ArrayList<Operation>();
    }
    public Compte(ClientBanque p_leClient, float p_solde){
        id = p_leClient.getId();
        solde = p_solde;
        cloture = false;
        this.lesOperations = new ArrayList<Operation>();
    }
    
    //Fonctions et méthodes
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Banque.Compte[ id=" + id + " ]";
    }
    
}
