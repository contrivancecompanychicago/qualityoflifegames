import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

public class KrebsvilleGeneralLocusTrafficCUT extends KrebsvilleWorld {

    public static void main(String[] args) throws Exception {

        // Create a DocumentBuilderFactory object.
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        // Use the DocumentBuilderFactory object to create a DocumentBuilder object.
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        // Use the DocumentBuilder object to parse the XML file.
        Document document = documentBuilder.parse(new InputSource("KrebsvilleGeneralLocusTrafficCUT.xml"));

        // Get the ScheduledTrigger element from the Document object.
        org.w3c.dom.Element scheduledTriggerElement = document.getElementById("KrebsvilleGeneralLocusTrafficCUT");

        // Get the CommonInfo element from the ScheduledTrigger element.
        org.w3c.dom.Element commonInfoElement = (org.w3c.dom.Element) scheduledTriggerElement.getElementsByTagName("CommonInfo").item(0);

        // Get the TriggerActionName attribute from the CommonInfo element.
        String triggerActionName = commonInfoElement.getAttribute("TriggerActionName");

        // Get the Note attribute from the CommonInfo element.
        String note = commonInfoElement.getAttribute("Note");

        // Get the Disabled attribute from the CommonInfo element.
        String disabled = commonInfoElement.getAttribute("Disabled");

        // Get the Schedule element from the ScheduledTrigger element.
        org.w3c
