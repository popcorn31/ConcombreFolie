/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Banque;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author 21509311
 */
@Entity
public class ClientBanque implements Serializable {

    //Propriétés Privées
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    @OneToMany
    private ArrayList<Compte> lesComptes;
    
    //Attributs publics
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public ArrayList<Compte> getLesComptes() {
        return lesComptes;
    }
    public void setLesComptes(Compte unCompte) {
        this.lesComptes.add(unCompte);
    }

    //Constructeur(s)
    public ClientBanque(){}
    public ClientBanque(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.lesComptes = new ArrayList<Compte>();
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
        if (!(object instanceof ClientBanque)) {
            return false;
        }
        ClientBanque other = (ClientBanque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Banque.Client_B[ id=" + id + " ]";
    }
    
}
