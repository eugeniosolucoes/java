/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.bono;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eugenio
 */
@Entity
@Table( name = "criador" )
@XmlRootElement
@NamedQueries( { 
    @NamedQuery( name = "Criador.findAll", query = "SELECT c FROM Criador c" )
    , @NamedQuery( name = "Criador.findById", query = "SELECT c FROM Criador c WHERE c.id = :id" )
    , @NamedQuery( name = "Criador.findByNome", query = "SELECT c FROM Criador c WHERE c.nome = :nome" ) } )
public class Criador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic( optional = false )
    @Column( name = "id" )
    private String id;

    @Column( name = "nome" )
    private String nome;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "criadorId" )
    private List<Bono> bonoList;

    public Criador() {
    }

    public Criador( String id ) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Bono> getBonoList() {
        return bonoList;
    }

    public void setBonoList( List<Bono> bonoList ) {
        this.bonoList = bonoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += ( id != null ? id.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object ) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if ( !( object instanceof Criador ) ) {
            return false;
        }
        Criador other = (Criador) object;
        if ( ( this.id == null && other.id != null ) || ( this.id != null && !this.id.equals( other.id ) ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mb.siscpo.bono.Criador[ id=" + id + " ]";
    }
    
}
