package com.anr.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Stopwatch;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertManyResult;

public class CollectionUpload {

    @Autowired
    private MongoClient mdbClient;

    private static final String FOLDER_LOCATION = "";
    private static final String FILE_EXTN = ".txt";

    private String collectionNeeded = "";

    public String uploadToCollection() throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        MongoDatabase mdb = null;// TBD
        String returnMessage = null;
        String filename = null;
        Long oneGB = Long.parseLong("1073741824");
        int numOfDocuments = 0;

        filename = FOLDER_LOCATION + collectionNeeded + FILE_EXTN;
        if (oneGB.compareTo(Long.valueOf(Files.size(Paths.get(filename)))) < 0) {
            numOfDocuments = uploadLargeFileToCollection(mdb, collectionNeeded);
        } else {
            numOfDocuments = uploadDocsToCollection(mdb, collectionNeeded);
        }

        long timeTakenInMS = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        returnMessage = "uploaded " + numOfDocuments + " documents in " + timeTakenInMS + " ms";

        return returnMessage;
    }

    private int uploadDocsToCollection(MongoDatabase mdb, String collectionName) {
        MongoCollection<Document> collection = mdb.getCollection(collectionName);
        collection.drop();
        int counter = 0;

        List<Document> listOfDocuments = readDocumentsFromFile(FOLDER_LOCATION + collectionName + FILE_EXTN);

        InsertManyResult result = null;
        if (listOfDocuments.size() > 0) {
            result = collection.insertMany(listOfDocuments);
        }
        result.wasAcknowledged();
        counter = listOfDocuments.size();

        return counter;
    }

    private List<Document> readDocumentsFromFile(String filepath) {
        List<Document> listOfDocs = new ArrayList<Document>();
        List<String> linesOfJson = null;
        try {
            linesOfJson = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
            for (String eachLine : linesOfJson) {
                listOfDocs.add(Document.parse(eachLine));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return listOfDocs;
    }

    private int uploadLargeFileToCollection(MongoDatabase mdb, String collectionName) {
        MongoCollection<Document> collection = mdb.getCollection(collectionName);
        collection.drop();
        int counter = 0;

        BufferedReader reader = null;
        String eachLine = null;
        try {
            reader = Files.newBufferedReader(Paths.get(FOLDER_LOCATION + collectionName + FILE_EXTN),
                    StandardCharsets.UTF_8);
            while ((eachLine = reader.readLine()) != null) {
                collection.insertOne(Document.parse(eachLine));
                counter++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return counter;
    }
}
