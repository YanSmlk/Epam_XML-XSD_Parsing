package yan.epam.task3.builder.impl.jaxb.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstrPaper", propOrder = {
    "title",
    "mounthly",
    "colored",
    "pages"
})
@XmlSeeAlso({
    Newspaper.class,
    Journal.class,
    Booklet.class
})
public class AbstrPaper
{

    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String mounthly;
    @XmlElement(required = true)
    protected String colored;
    protected int pages;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;


    public String getTitle() {
        return title;
    }


    public void setTitle(String value) {
        this.title = value;
    }


    public String getMounthly() {
        return mounthly;
    }


    public void setMounthly(String value) {
        this.mounthly = value;
    }


    public String getColored() {
        return colored;
    }


    public void setColored(String value) {
        this.colored = value;
    }


    public int getPages() {
        return pages;
    }


    public void setPages(int value) {
        this.pages = value;
    }


    public String getId() {
        return id;
    }


    public void setId(String value) {
        this.id = value;
    }

}
