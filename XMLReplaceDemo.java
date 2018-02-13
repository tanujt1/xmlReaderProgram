import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class XMLReplaceDemo {

    public static void main(String[] args) throws Exception {

        String xml = "<data>\n" +
                " <employee>\n" +
                "    <name>John</name>\n" +
                "    <title>Manager</title>\n" +
                " </employee>\n" +
                " <employee>\n" +
                "    <name>Sara</name>\n" +
                "    <title>Clerk</title>\n" +
                "    </employee>\n" +
                "</data>";

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(xml));

        Document doc = builder.parse(src);
        doc.getElementsByTagName("name").item(1).setTextContent("Tanuj");

        String name = doc.getElementsByTagName("name").item(1).getTextContent();

        System.out.println(name);
    }
}