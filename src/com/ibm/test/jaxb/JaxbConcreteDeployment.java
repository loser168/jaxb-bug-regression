package com.ibm.test.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "concreteDeploymentType")
public class JaxbConcreteDeployment extends JaxbDeployment {

    @Override
    public String toString() {
        return "JaxbConcreteDeployment{" +
                "contextRoot='" + getContextRoot() + '\'' +
                '}';
    }
}

