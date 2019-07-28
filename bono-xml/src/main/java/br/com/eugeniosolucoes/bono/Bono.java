/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.bono;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author eugenio
 */
@Entity
@Table( name = "bono" )
@XmlRootElement
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( propOrder = {
    "id",
    "ano",
    "numero",
    "dataPublicacao",
    "categoria",
    "subcategoria",
    "criadorId",
    "publicado",
    "conteudo",
    "arquivoPdf" } )
@NamedQueries( {
    @NamedQuery( name = "Bono.findAll", query = "SELECT b FROM Bono b" )
    , @NamedQuery( name = "Bono.findById", query = "SELECT b FROM Bono b WHERE b.id = :id" )
    , @NamedQuery( name = "Bono.findByDataPublicacao", query = "SELECT b FROM Bono b WHERE b.dataPublicacao = :dataPublicacao" )
    , @NamedQuery( name = "Bono.findByNumero", query = "SELECT b FROM Bono b WHERE b.numero = :numero" )
    , @NamedQuery( name = "Bono.findByPublicado", query = "SELECT b FROM Bono b WHERE b.publicado = :publicado" )
    , @NamedQuery( name = "Bono.findByCategoria", query = "SELECT b FROM Bono b WHERE b.categoria = :categoria" )
    , @NamedQuery( name = "Bono.findBySubcategoria", query = "SELECT b FROM Bono b WHERE b.subcategoria = :subcategoria" )
    , @NamedQuery( name = "Bono.findByAno", query = "SELECT b FROM Bono b WHERE b.ano = :ano" ) } )
public class Bono implements Serializable {

    private static final long serialVersionUID = 1L;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic( optional = false )
    @Column( name = "id" )
    private BigDecimal id;

    @Lob
    @Column( name = "arquivo_pdf" )
    @XmlSchemaType( name = "base64Binary" )
    @XmlElement( name = "arquivo_pdf" )
    private byte[] arquivoPdf;

    @Basic( optional = false )
    @Column( name = "conteudo" )
    private String conteudo;

    @Basic( optional = false )
    @Column( name = "data_publicacao" )
    @Temporal( TemporalType.TIMESTAMP )
    @XmlElement( name = "data_publicacao" )
    private Date dataPublicacao;

    @Basic( optional = false )
    @Column( name = "numero" )
    private int numero;

    @Basic( optional = false )
    @Column( name = "publicado" )
    private boolean publicado;

    @Basic( optional = false )
    @Column( name = "categoria" )
    @Enumerated( EnumType.ORDINAL )
    private Categoria categoria;

    @Basic( optional = false )
    @Column( name = "subcategoria" )
    @Enumerated( EnumType.ORDINAL )
    @XmlElement( name = "sub_categoria" )
    private TipoBono subcategoria;

    @Basic( optional = false )
    @Column( name = "ano" )
    private int ano;

    @JoinColumn( name = "criador_id", referencedColumnName = "id" )
    @ManyToOne( optional = false )
    @XmlElement( name = "criador" )
    private Criador criadorId;

    @OneToMany( mappedBy = "bonoId" )
    @XmlTransient
    private List<Materia> materiaList;

    public Bono() {
    }

    public Bono( BigDecimal id ) {
        this.id = id;
    }

    public Bono( BigDecimal id, String conteudo, Date dataPublicacao, int numero, boolean publicado, Categoria categoria, TipoBono subcategoria, int ano ) {
        this.id = id;
        this.conteudo = conteudo;
        this.dataPublicacao = dataPublicacao;
        this.numero = numero;
        this.publicado = publicado;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.ano = ano;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId( BigDecimal id ) {
        this.id = id;
    }

    public Serializable getArquivoPdf() {
        return arquivoPdf;
    }

    public void setArquivoPdf( byte[] arquivoPdf ) {
        this.arquivoPdf = arquivoPdf;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo( String conteudo ) {
        this.conteudo = conteudo;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao( Date dataPublicacao ) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero( int numero ) {
        this.numero = numero;
    }

    public boolean getPublicado() {
        return publicado;
    }

    public void setPublicado( boolean publicado ) {
        this.publicado = publicado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria( Categoria categoria ) {
        this.categoria = categoria;
    }

    public TipoBono getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria( TipoBono subcategoria ) {
        this.subcategoria = subcategoria;
    }

    public int getAno() {
        return ano;
    }

    public void setAno( int ano ) {
        this.ano = ano;
    }

    public Criador getCriadorId() {
        return criadorId;
    }

    public void setCriadorId( Criador criadorId ) {
        this.criadorId = criadorId;
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
        if ( !( object instanceof Bono ) ) {
            return false;
        }
        Bono other = (Bono) object;
        return !( ( this.id == null && other.id != null ) || ( this.id != null && !this.id.equals( other.id ) ) );
    }

    @Override
    public String toString() {
        return "mb.siscpo.bono.Bono[ id=" + id + " ]";
    }

}
