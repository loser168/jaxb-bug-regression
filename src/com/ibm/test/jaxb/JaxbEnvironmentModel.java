package com.ibm.test.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ibm.test.jaxb.JaxbContainer;
import com.ibm.test.jaxb.JaxbDistribution;

/**
 */
@XmlRootElement(name = "environmentModel")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "environmentModelType", propOrder = {
        "container",
        "distribution"
})
public class JaxbEnvironmentModel {

    @XmlElement
    private JaxbContainer container;

    @XmlElement
    private JaxbDistribution distribution;

    public JaxbContainer getContainer() {
        return this.container;
    }

    public void setContainer(final JaxbContainer container) {
        this.container = container;
    }

    public JaxbDistribution getDistribution() {
        return this.distribution;
    }

    public void setDistribution(final JaxbDistribution distribution) {
        this.distribution = distribution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JaxbEnvironmentModel that = (JaxbEnvironmentModel) o;

        if (container != null ? !container.equals(that.container) : that.container != null) return false;
        return !(distribution != null ? !distribution.equals(that.distribution) : that.distribution != null);

    }

    @Override
    public int hashCode() {
        int result =  (container != null ? container.hashCode() : 0);
        result = 31 * result + (distribution != null ? distribution.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JaxbEnvironmentModel{" +
                "container=" + container +
                ", distribution=" + distribution +
                '}';
    }
}
