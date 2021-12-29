package com.anr.demo;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Json2Xml {

    static final Logger logger = LoggerFactory.getLogger(Json2Xml.class);

    public String xmlToJson(String xmlAsString) {
        String convertedJson = null;
        int PRETTY_PRINT_INDENT_FACTOR = 2;
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(xmlAsString);
            convertedJson = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
        } catch (JSONException e) {
            logger.info(e.getMessage());
        }
        return convertedJson;
    }

    public String jsonToXml(String jsonString) {
        String convertedXml = null;
        try {
            JSONObject jsonObj = new JSONObject(jsonString);
            convertedXml = XML.toString(jsonObj);
        } catch (JSONException e) {
            logger.info(e.getMessage());
        }
        return convertedXml;
    }
}
