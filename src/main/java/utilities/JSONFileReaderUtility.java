package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileReaderUtility {

    public Object createJsonFileObject(String filePath) throws IOException, ParseException{

        JSONParser jsonParser = new JSONParser();
        FileReader reader;
        try {
             reader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("JSON file not found at path - "+ filePath);
        }

        Object obj = jsonParser.parse(reader);
        reader.close();
    
        return obj;
    }
}
