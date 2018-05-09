package yan.epam.task3.builder.impl.jaxb.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Booklet", propOrder = {
    "glossy"
})
public class Booklet extends AbstrPaper
{
    @XmlElement(required = true)
    protected String glossy;


    public String getGlossy() {
        return glossy;
    }


    public void setGlossy(String value) {
        this.glossy = value;
    }

}
