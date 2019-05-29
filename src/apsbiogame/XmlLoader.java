package apsbiogame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlLoader {
    
     public static List<Questionario> XmlToList()
    {
        try 
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("QuestFile.xml");
            NodeList LiQuest = doc.getElementsByTagName("Questao");
            int LiLength = LiQuest.getLength();
            
            List<Questionario> ListadeQuestoes = new ArrayList<>();
            
            
            for (int i = 0; i < LiLength; i++) {
                
                Node noPessoa = LiQuest.item(i);

                if(noPessoa.getNodeType() == Node.ELEMENT_NODE){
                    Element ElementQuest = (Element) noPessoa;   
                    NodeList ChildTagsInto = ElementQuest.getChildNodes();
                    int LenghtChildTags = ChildTagsInto.getLength();
                            

                    String Pergunta = null;
                    String Resposta = null;
                    String OP1 = null;
                    String OP2 = null;
                    String OP3 = null;
                    String OP4 = null;                        
                    
                    for (int j = 0; j < LenghtChildTags; j++) {
                        
                        Node ChildNode = ChildTagsInto.item(j);
                            
                        if(ChildNode.getNodeType() == Node.ELEMENT_NODE){

                            Element ChildElement = (Element) ChildNode;
                                 
                            switch(ChildElement.getTagName()){
                                case "Questao":
                                    Pergunta = (ChildElement.getTextContent());
                                    break;
                                    
                                case "Resposta_Correta":
                                    Resposta = (ChildElement.getTextContent());
                                    break;
                                    
                                case "Alternativa_1":
                                    OP1 = (ChildElement.getTextContent());
                                    break;
                                    
                                case "Alternativa_2":
                                    OP2 = (ChildElement.getTextContent());
                                    break;
                                    
                                case "Alternativa_3":
                                    OP3 = (ChildElement.getTextContent());
                                    break;
                                    
                                case "Alternativa_4":
                                    OP4 = (ChildElement.getTextContent());
                                    break;
                            }    
                        }
                    }
                    
                    if(Pergunta != null){
                    Questionario Quest = new Questionario( Pergunta, Resposta, OP1 , OP2, OP3, OP4);
                    ListadeQuestoes.add(Quest);
                    }
                }
            }
            return ListadeQuestoes;
        }  
        catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XmlLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

