package Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
	//atributo
	
	private Map<LocalDate, Evento> eventosMap;
	
	public AgendaEventos() {
		this.eventosMap = new HashMap<>();
	}
	
	public void adicionarEventos(LocalDate data, String nome, String atracao) {
		//Evento evento = new Evento(nome, atracao;
		eventosMap.put(data, new Evento(nome, atracao));
	}
	
	public void exibirAgenda() {
		Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
		System.out.println(eventosTreeMap);
	}
	
	public void obterProximoEvento() {
		/*Set<LocalDate> dateSet = eventosMap.keySet();
		Collection<Evento> valus = eventosMap.values();	
		*/
		//eventosMap.get();
		
		LocalDate dataAtual = LocalDate.now();
		LocalDate proximaData = null;
		Evento proximoEvento = null;
		Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
		for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
			if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
				proximaData = entry.getKey();
				proximoEvento = entry.getValue();
				System.out.println("O próxivo evento: " + entry.getValue() + " acontecerá na data " + entry.getKey());
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		AgendaEventos agendaEventos = new AgendaEventos();
		agendaEventos.adicionarEventos(LocalDate.of(2022, Month.JULY, 15), "Evento 1", "Atração 1");
		agendaEventos.adicionarEventos(LocalDate.of(2022, 7, 9), "Evento 2", "Atração 2");
		agendaEventos.adicionarEventos(LocalDate.of(2000, Month.JANUARY, 10), "Evento 3", "Atração 3");
		agendaEventos.adicionarEventos(LocalDate.of(2023, Month.OCTOBER, 15), "Evento 4", "Atração 4");
		agendaEventos.adicionarEventos(LocalDate.of(2024, Month.JULY, 16), "Evento 5", "Atração 5");
		
		agendaEventos.exibirAgenda();
		
		agendaEventos.obterProximoEvento();
	}
}
