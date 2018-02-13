import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLReplaceDemo {

    public static void main(String[] args) throws Exception {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><data>\n" +
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

        DOMSource domSource = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(domSource, result);

        String convertedDocumentToString = writer.toString();
        System.out.println(convertedDocumentToString);

    }
}