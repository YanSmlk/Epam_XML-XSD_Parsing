package yan.epam.task3.builder.impl.jaxb.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Newspaper", propOrder = {
    "glossy"
})

public class Newspaper extends AbstrPaper
{

    @XmlElement(required = true)
    protected String glossy;
    @XmlAttribute(name = "index")
    protected String index;


    public String getGlossy() {
        return glossy;
    }


    public void setGlossy(String value) {
        this.glossy = value;
    }


    public String getIndex() {
        if (index == null) {
            return "00000";
        } else {
            return index;
        }
    }


    public void setIndex(String value) {
        this.index = value;
    }

}
