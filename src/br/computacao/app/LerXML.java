package br.computacao.app;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class LerXML {

	public static void main(String[] args) {
		SAXBuilder builder=new SAXBuilder();
		File arquivoXML=new File("Jogo.xml");
		try {
			Document doc=(Document)builder.build(arquivoXML);
			Element root=doc.getRootElement();
			List<Element> lista=root.getChildren("pokemon");
			for(int i=0;i<lista.size();i++) {
				Element pok=lista.get(i);
				System.out.println("Nome: "+pok.getChildText("nome"));
				System.out.println("Resultado: "+pok.getChildText("resultado"));
			}
		}catch(JDOMException e) {
			System.out.println(e.getMessage());
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
