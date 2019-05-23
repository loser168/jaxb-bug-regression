package com.ibm.test.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream; 

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.validation.Schema;
import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;

public class MainTest {

	public static void main(String[] args) throws JAXBException,Exception {
		// TODO Auto-generated method stub
		DataModelValidationEventHandler eventHandler = new DataModelValidationEventHandler();
		
		JAXBContext cont = JAXBContext.newInstance(JaxbEnvironmentModel.class);
		JaxbEnvironmentModel envModel = new JaxbEnvironmentModel();
		JaxbDistribution dist = new JaxbDistribution();
		JaxbConcreteDeployment dep = new JaxbConcreteDeployment();
		dep.setContextRoot("Context-Root");
		dist.addDeployment(dep);
		envModel.setDistribution(dist);
		JaxbContainer container = new JaxbConcreteContainer();
		container.addDeployment(dep);
		envModel.setContainer(container);
		
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
        Schema schema = sf.newSchema(new File("NewXMLSchema1.xsd"));
		
		Marshaller marshal = cont.createMarshaller();
		marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshal.setSchema(schema);
		marshal.setEventHandler(eventHandler);
		marshal.marshal(envModel, new FileOutputStream("Model.xml"));
		

	}
	
	public static final class DataModelValidationEventHandler extends ValidationEventCollector {

        public String reportProblems() {
            final StringBuilder result = new StringBuilder();

            for (ValidationEvent event: this.getEvents()) {
                result.append(event.getMessage());
                result.append(Character.LINE_SEPARATOR);
            }
            return result.toString();
        }
    }

}
