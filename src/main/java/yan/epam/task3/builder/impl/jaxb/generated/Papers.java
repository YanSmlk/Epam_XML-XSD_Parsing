package yan.epam.task3.builder.impl.jaxb.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "abstrPaper"
})
@XmlRootElement(name = "papers")
public class Papers
 {

    @XmlElementRef(name = "abstrPaper", namespace = "Papers", type = JAXBElement.class)
    protected List<JAXBElement<? extends AbstrPaper>> abstrPaper;


    public List<JAXBElement<? extends AbstrPaper>> getAbstrPaper()
    {
        if (abstrPaper == null)
        {
            abstrPaper = new ArrayList<JAXBElement<? extends AbstrPaper>>();
        }
        return this.abstrPaper;
    }

}
