package com.anr.demo;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class XsltService {

    static final Logger logger = LoggerFactory.getLogger(XsltService.class);

    public String applyXslt(String inputXmlString, String xsltString)
            throws TransformerConfigurationException, TransformerException, IOException {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream = new StreamSource(new StringReader(xsltString));
        Transformer transformer = factory.newTransformer(xslStream);

        StreamSource in = new StreamSource(new StringReader(inputXmlString));

        StringWriter stringWriter = new StringWriter();
        StreamResult out = new StreamResult(stringWriter);

        transformer.transform(in, out);

        if (logger.isDebugEnabled()) {
            logger.debug("the output file is generated");
        }
        return stringWriter.toString();
    }

    public void convertXmlUsingXslt(String xmlFilePath, String xsltFilePath, String outputFilePath)
            throws TransformerConfigurationException, TransformerException, IOException {
        String xml = null;
        String xslt = null;

        if (xmlFilePath == null) {
            Path xmlFile = ResourceUtils.getFile("classpath:Sample.xml").toPath();
            xml = new String(Files.readAllBytes(xmlFile));
        } else {
            xml = new String(Files.readAllBytes(Paths.get(xmlFilePath)));
        }

        if (xsltFilePath == null) {
            Path xsltFile = ResourceUtils.getFile("classpath:Sample.xsl").toPath();
            xslt = new String(Files.readAllBytes(xsltFile));
        } else {
            xslt = new String(Files.readAllBytes(Paths.get(xsltFilePath)));
        }

        String outContent = applyXslt(xml, xslt);

        if (Paths.get(outputFilePath).toFile().exists()) {
            Files.write(Paths.get(outputFilePath), outContent.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        } else {
            Files.write(Paths.get(outputFilePath), outContent.getBytes(), StandardOpenOption.CREATE_NEW);
        }
    }

}
