package com.ibm.test.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "concreteContainerType")
public class JaxbConcreteContainer  extends JaxbContainer {

    public static final String ELEMENT_NAME = "concreteContainer";

    @Override
    public String toString() {
        return "JaxbConcreteContainer{" +
                "deployments=" + getDeployments() +
                '}';
    }

}

