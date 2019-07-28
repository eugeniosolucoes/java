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
@Table( name = "organizacao_militar" )
@XmlRootElement
@NamedQueries( { 
    @NamedQuery( name = "OrganizacaoMilitar.findAll", query = "SELECT o FROM OrganizacaoMilitar o" )
    , @NamedQuery( name = "OrganizacaoMilitar.findById", query = "SELECT o FROM OrganizacaoMilitar o WHERE o.id = :id" )
    , @NamedQuery( name = "OrganizacaoMilitar.findByCodigo", query = "SELECT o FROM OrganizacaoMilitar o WHERE o.codigo = :codigo" )
    , @NamedQuery( name = "OrganizacaoMilitar.findByIndicativoNaval", query = "SELECT o FROM OrganizacaoMilitar o WHERE o.indicativoNaval = :indicativoNaval" )
    , @NamedQuery( name = "OrganizacaoMilitar.findByNome", query = "SELECT o FROM OrganizacaoMilitar o WHERE o.nome = :nome" )
    , @NamedQuery( name = "OrganizacaoMilitar.findByPostoTitular", query = "SELECT o FROM OrganizacaoMilitar o WHERE o.postoTitular = :postoTitular" )
    , @NamedQuery( name = "OrganizacaoMilitar.findBySequencia", query = "SELECT o FROM OrganizacaoMilitar o WHERE o.sequencia = :sequencia" )
    , @NamedQuery( name = "OrganizacaoMilitar.findBySigla", query = "SELECT o FROM OrganizacaoMilitar o WHERE o.sigla = :sigla" ) } )
public class OrganizacaoMilitar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic( optional = false )
    @Column( name = "id" )
    private Integer id;

    @Column( name = "codigo" )
    private String codigo;

    @Basic( optional = false )
    @Column( name = "indicativo_naval" )
    private String indicativoNaval;

    @Column( name = "nome" )
    private String nome;

    @Column( name = "posto_titular" )
    private Integer postoTitular;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column( name = "sequencia" )
    private Double sequencia;

    @Column( name = "sigla" )
    private String sigla;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "omId" )
    private List<Materia> materiaList;

    public OrganizacaoMilitar() {
    }

    public OrganizacaoMilitar( Integer id ) {
        this.id = id;
    }

    public OrganizacaoMilitar( Integer id, String indicativoNaval ) {
        this.id = id;
        this.indicativoNaval = indicativoNaval;
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo( String codigo ) {
        this.codigo = codigo;
    }

    public String getIndicativoNaval() {
        return indicativoNaval;
    }

    public void setIndicativoNaval( String indicativoNaval ) {
        this.indicativoNaval = indicativoNaval;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public Integer getPostoTitular() {
        return postoTitular;
    }

    public void setPostoTitular( Integer postoTitular ) {
        this.postoTitular = postoTitular;
    }

    public Double getSequencia() {
        return sequencia;
    }

    public void setSequencia( Double sequencia ) {
        this.sequencia = sequencia;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla( String sigla ) {
        this.sigla = sigla;
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
        if ( !( object instanceof OrganizacaoMilitar ) ) {
            return false;
        }
        OrganizacaoMilitar other = (OrganizacaoMilitar) object;
        if ( ( this.id == null && other.id != null ) || ( this.id != null && !this.id.equals( other.id ) ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mb.siscpo.bono.OrganizacaoMilitar[ id=" + id + " ]";
    }
    
}
