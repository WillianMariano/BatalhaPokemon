package br.computacao.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import br.computação.model.pokemon;

public class AppBatalha {

	public static void main(String[] args) {
		String resultado, parcial;
		String x;
		int y;
		int vidapok1=100;
		int vidapok2=100;
		Scanner input=new Scanner(System.in);
		List<pokemon> lista=new ArrayList<pokemon>();
		for(int i=0;i<2;i++)
		{
			System.out.println("Informe o nome do pokemon: ");
			String nome=input.next();
			System.out.println("Informe o hp do pokemon: ");
			int hp=input.nextInt();
			System.out.println("Informe o at do pokemon: ");
			int at=input.nextInt();
			pokemon pok=new pokemon(nome,hp,at);
			lista.add(pok);
		}
		
		
		
		pokemon pok1=lista.get(0);
		pokemon pok2=lista.get(1);
		System.out.println("Começa a batalha!!");
		System.out.println("Os dois pokemons começam com 100 pontos de vida");
		System.out.println();
		//regra:o primeiro pokemon da lista sempre começa atacando
		//regra:a batalha acaba quando um oponente zerar a vida ou atingir nivel maximo de vida (200)
		do{
			if(pok1.getat()==pok2.gethp() && pok2.getat()==pok1.gethp()) {
				System.out.println("Ataque e defesa dos oponentes são identicos");
				break;
			}
			
			vidapok2=vidapok2-(pok1.getat()-pok2.gethp());
			if(vidapok2<0) {
				vidapok2=0;
			}
			if(vidapok2>200) {
				vidapok2=200;
			}
			parcial="Vida pokemon 2: "+vidapok2;
			System.out.println(parcial);
			
			vidapok1=vidapok1-(pok2.getat()-pok1.gethp());
			if(vidapok1<0) {
				vidapok1=0;
			}
			if(vidapok1>200) {
				vidapok1=200;
			}
			parcial="Vida pokemon 1: "+vidapok1;
			System.out.println(parcial);
		}while(vidapok1>0 && vidapok2>0 && vidapok1<200 && vidapok2<200);		

		
		
		if(vidapok1>vidapok2)
		{
			resultado="Pokemon "+pok1.getNome()+" ganhou a batalha";
			System.out.println(resultado);
		}
		else if(vidapok2>vidapok1)
		{
			resultado="Pokemon "+pok2.getNome()+" ganhou a batalha";
			System.out.println(resultado);
		}
		else {
			resultado="A batalha empatou";
			System.out.println(resultado);
			System.out.println("Vida do "+pok1.getNome()+"="+vidapok1);
			System.out.println("Vida do "+pok2.getNome()+"="+vidapok2);
		}
		
		
		
		Element jogo = new Element("Jogo");
		Document doc = new Document(jogo);
		for (pokemon pok : lista){
			Element aux = new Element("pokemon");
			aux.addContent(new Element("nome").setText(pok.getNome()));
			aux.addContent(new Element("resultado").setText(resultado));
			doc.getRootElement().addContent(aux);
		}	
		XMLOutputter xmlOutput=new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		try {
			xmlOutput.output(doc, new FileWriter("Jogo.xml"));
			System.out.println("Arquivo gerado com sucesso");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
