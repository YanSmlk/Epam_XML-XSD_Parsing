package yan.epam.task3.builder.impl.jaxb.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private final static QName _Booklet_QNAME = new QName("Papers", "booklet");
    private final static QName _Newspaper_QNAME = new QName("Papers", "newspaper");
    private final static QName _AbstrPaper_QNAME = new QName("Papers", "abstrPaper");
    private final static QName _Journal_QNAME = new QName("Papers", "journal");


    public ObjectFactory() {
    }


    public Newspaper createNewspaper() {
        return new Newspaper();
    }

    public AbstrPaper createAbstrPaper() {
        return new AbstrPaper();
    }


    public Journal createJournal() {
        return new Journal();
    }


    public Booklet createBooklet() {
        return new Booklet();
    }


    public Papers createPapers() {
        return new Papers();
    }


    @XmlElementDecl(namespace = "Papers", name = "booklet", substitutionHeadNamespace = "Papers", substitutionHeadName = "abstrPaper")
    public JAXBElement<Booklet> createBooklet(Booklet value) {
        return new JAXBElement<Booklet>(_Booklet_QNAME, Booklet.class, null, value);
    }


    @XmlElementDecl(namespace = "Papers", name = "newspaper", substitutionHeadNamespace = "Papers", substitutionHeadName = "abstrPaper")
    public JAXBElement<Newspaper> createNewspaper(Newspaper value) {
        return new JAXBElement<Newspaper>(_Newspaper_QNAME, Newspaper.class, null, value);
    }


    @XmlElementDecl(namespace = "Papers", name = "abstrPaper")
    public JAXBElement<AbstrPaper> createAbstrPaper(AbstrPaper value) {
        return new JAXBElement<AbstrPaper>(_AbstrPaper_QNAME, AbstrPaper.class, null, value);
    }


    @XmlElementDecl(namespace = "Papers", name = "journal", substitutionHeadNamespace = "Papers", substitutionHeadName = "abstrPaper")
    public JAXBElement<Journal> createJournal(Journal value) {
        return new JAXBElement<Journal>(_Journal_QNAME, Journal.class, null, value);
    }

}
