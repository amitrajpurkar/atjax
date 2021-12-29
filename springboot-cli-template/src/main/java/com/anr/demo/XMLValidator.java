package com.anr.demo;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

@Service
public class XMLValidator {

    static final Logger logger = LoggerFactory.getLogger(XMLValidator.class);

    public boolean validate(Source xmlSource, Source xsdSource) {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            if (logger.isDebugEnabled()) {
                logger.debug("starting schema validation");
            }

            Schema schema = factory.newSchema(xsdSource);
            if (logger.isDebugEnabled()) {
                logger.debug("got handle to schema file");
            }

            Validator validator = schema.newValidator();
            if (logger.isDebugEnabled()) {
                logger.debug("initialized validator for given schema");
            }

            validator.validate(xmlSource);
            if (logger.isDebugEnabled()) {
                logger.debug("parsed xml against xsd");
            }

            return true;
        } catch (SAXException | IOException e) {
            if (logger.isDebugEnabled()) {
                logger.debug("got exception");
            }
            logger.info(e.getMessage());
        }
        return false;
    }
}
