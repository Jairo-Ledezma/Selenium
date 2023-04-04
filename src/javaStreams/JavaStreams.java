package javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class JavaStreams {
	
	//@Test
	public void noStream() { // without stream 
		
		ArrayList <String> names = new ArrayList<String>();
		names.add("Amanda");
		names.add("Carlos");
		names.add("Atina");
		names.add("Angel");
		names.add("Abinesh");
		int aCount = 0;
		
		for(int i=0; i<names.size(); i++) {
			if(names.get(i).startsWith("A")) {
				aCount++;
			}
		}
		System.out.println(aCount);
	}
	
	//@Test
	public void streamFilter() { //with java stream
		ArrayList <String> names = new ArrayList<String>();
		names.add("Amanda");
		names.add("Carlos");
		names.add("Ata");
		names.add("Angel");
		names.add("Abinesh");
		
		
		Long c =  names.stream().filter(a->a.startsWith("A")).count();
		
		System.out.println(c);
		
		Long d = Stream.of("Amanda" , "Carlos" , "Atina" , "Angel" , "Abinesh").filter( s ->
		{
			if(s.startsWith("A")) {
				return true;
			}
			return false;
			
		}).count();
		
		System.out.println(d);
		
		names.stream().filter(s-> s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s-> s.length()>4).limit(1).forEach(s->System.out.println(s));
	}

	//@Test
	public void streamMap() {
		
		// print names with last letter as "a" in uppercase
		Stream.of("Anita" , "Anota" , "Donito" , "Atinoton" , "Pepito").filter(s->s.endsWith("a")).map(s-> s.toUpperCase()).forEach(s-> System.out.println(s));
		//print names wich have first letter as a with uppercase and sorted 
		Stream.of("Amanda" , "Ana" , "Don" , "Atino" , "Pepe").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
		
		
	}
	
	//@Test
	public void mergeListStream() {
		List <String> names = Arrays.asList("Antonio" , "Pulgarcito" , "Antonella" , "Kamikase");
		ArrayList <String> names1 = new ArrayList<>();
		names1.add("Jairo");
		names1.add("steve");
		names1.add("Bill");
		names1.add("Elon");
		names1.add("John");
		
		Stream <String> newStreamList = Stream.concat(names.stream(), names1.stream());
		newStreamList.sorted().forEach(s-> System.out.println(s));
	}

	
	//@Test
	public void streamMAtch() {
		List <String> names = Arrays.asList("Antonio" , "Pulgarcito" , "Antonella" , "Kamikase");
		ArrayList <String> names1 = new ArrayList<>();
		names1.add("Jairo");
		names1.add("steve");
		names1.add("Kamikase");
		names1.add("Elon");
		names1.add("John");
		
		boolean match = Stream.concat(names.stream(), names1.stream()).anyMatch(s-> s.equalsIgnoreCase("Kamikase"));
		System.out.println(match);
		
		
		
	}

	//@Test
	public void streamCollect() {
		
		List <String> names = Arrays.asList("Antonio" , "Pulgarcito" , "Antonella" , "Kamikase");
		ArrayList <String> names1 = new ArrayList<>();
		names1.add("Jairo");
		names1.add("steve");
		names1.add("Kamikase");
		names1.add("Elon");
		names1.add("John");
		
		List <String> newList = Stream.concat(names.stream(), names1.stream()).collect(Collectors.toList()); //collect returns a normal list instead of a stream List
		
		for(String i:newList) {
			System.out.println(i);
		}
		
		
		
	}
	
	@Test
	public void challenge() {
		
		List<Integer> numbers = Arrays.asList(3,2,2,7,5,1,9,7);
		
		//numbers.stream().distinct().sorted().forEach(n-> System.out.println(n));
		List <Integer> sList = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sList.get(3));
	}


}

	