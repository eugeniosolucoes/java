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
@Table( name = "autor" )
@XmlRootElement
@NamedQueries( { 
    @NamedQuery( name = "Autor.findAll", query = "SELECT a FROM Autor a" )
    , @NamedQuery( name = "Autor.findById", query = "SELECT a FROM Autor a WHERE a.id = :id" )
    , @NamedQuery( name = "Autor.findByNome", query = "SELECT a FROM Autor a WHERE a.nome = :nome" ) } )
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic( optional = false )
    @Column( name = "id" )
    private String id;

    @Basic( optional = false )
    @Column( name = "nome" )
    private String nome;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "autorId" )
    private List<Materia> materiaList;

    public Autor() {
    }

    public Autor( String id ) {
        this.id = id;
    }

    public Autor( String id, String nome ) {
        this.id = id;
        this.nome = nome;
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
    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList( List<Materia> materiaList ) {
        this.materiaList = materiaList;
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
        if ( !( object instanceof Autor ) ) {
            return false;
        }
        Autor other = (Autor) object;
        if ( ( this.id == null && other.id != null ) || ( this.id != null && !this.id.equals( other.id ) ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mb.siscpo.bono.Autor[ id=" + id + " ]";
    }
    
}
