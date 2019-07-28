package br.com.eugeniosolucoes.bono;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "SubCategoria")
@XmlEnum
public enum TipoBono implements Tipo
{

    BLANK(0), GERAL(1), SEDE(2), ESPECIAL_GERAL(3), ESPECIAL_SEDE(4),
    ESPECIAL_TRANSFERENCIA(5);

    private final int tipo;

    TipoBono( int tipo )
    {

        this.tipo = tipo;

    }
    String[][] bonos =
    {
        {
            "GERAL", "Geral - Seção Geral"
        },
        {
            "GERAL SEDE", "Geral - Seção Sede"
        },
        {
            "ESPECIAL GERAL", "Especial - Geral"
        },
        {
            "ESPECIAL SEDE", "Especial - Sede"
        },
        {
            "ESPECIAL TRANSFERÊNCIA", "Especial - Transferência de Material"
        }
    };

    @Override
    public String getDescricao()
    {
        return bonos[this.ordinal()][1];
    }

    @Override
    public String getSigla()
    {
        return bonos[this.ordinal()][0];
    }

    @Override
    public int getTipo()
    {
        return tipo;
    }

    public static TipoBono getTipo( int tipo )
    {
        for (TipoBono t : TipoBono.values())
        {
            if (t.getTipo() == tipo)
            {
                return t;
            }
        }
        return null;
    }
}
