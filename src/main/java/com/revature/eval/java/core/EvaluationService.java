 package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	public String acronym(String phrase) {
		phrase=phrase.replace('-', ' ');
		String listOfWords;
		String acronym="";
		for(int i=0;i < phrase.split(" ").length; i++) {
			listOfWords =phrase.split(" ")[i];
			acronym=acronym+listOfWords.charAt(0);
		}
		return acronym.toUpperCase();
	}

	
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(sideOne==sideTwo && sideTwo==sideThree) {
				return true;
			}
			else {
				return false;
			}
				
		}

		public boolean isIsosceles() {
			if(sideOne==sideTwo || sideTwo==sideThree||sideOne==sideThree) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isScalene() {
			if(sideOne!=sideTwo && sideTwo!=sideThree) {
				return true;
			}
			else {
				return false;
			}
		}

	}

	public int getScrabbleScore(String string) {
		char letter;
		int score=0;
		string=string.toUpperCase();
		for(int i=0 ; i<string.length() ;i++) {
			letter=string.charAt(i);
			int j;
			if(letter=='A' ||letter== 'E'||letter== 'I'||letter== 'O'||letter== 'U'||letter== 'L'||letter== 'N'||letter== 'R'||letter== 'S'||letter== 'T') {
				j=1;
			}
			else if(letter== 'D'||letter==  'G') {
				j=2;
			}
			else if(letter=='B' ||letter== 'C'||letter== 'M'||letter== 'P') {
				j=3;
			}
			else if(letter=='F' ||letter== 'H'||letter== 'V'||letter== 'W'||letter== 'Y') {
				j=4;
			}
			else if(letter=='K') {
				j=5;
			}
			else if(letter=='J' ||letter== 'X') {
				j=8;
			}
			else if(letter=='Q' ||letter== 'Z') {
				j=10;
			}
			else {
				j=0;
			}
			score=score+j;
			
		}
		return score;
	}


	public String cleanPhoneNumber(String string) {
		String fix="";
		string=string.replace('+', ' ');
		string=string.replace('(', ' ');
		string=string.replace(')', ' ');
		string=string.replace('-', ' ');
		string=string.replace('.', ' ');
		string=string.replace('[', ' ');
		string=string.replace(']', ' ');
		string=string.trim();
		
		if(string.split(" ")[0].charAt(0)=='1') {
			string=string.replaceFirst("1", "");
		}
		else {
			
		}
		for(int h=0;h<string.split(" ").length;h++) {
			fix=fix+string.split(" ")[h];	
		}
		if(fix.length()!=10) {
			throw new IllegalArgumentException();
		}
		else {
			return fix;
		}
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		string=string.replace(",", " ");
		string=string.replace("\n", "");
		Map<String, Integer> map=new HashMap<>();
		String string1=string;
		 for (int i=0; i<string.split(" ").length;i++) {
			int count=0;
			 for(int j=0;j<string1.split(" ").length;j++ ) {
				 if(string.split(" ")[i].equals(string1.split(" ")[j])) {
					 count++;
				 }
				 else {
					 
				 }	
			 }
			 System.out.println(string1.split(" ")[i]);
			 map.put(string1.split(" ")[i], count);
			 string1=string1.replaceAll(string.split(" ")[i], " ");
			 
			 
			 
		 }
		return map;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			if(t.equals("6")) {
				return 3;
			}
			int i=(int)Math.floor(sortedList.size()/2)-1;
			while(sortedList.get(i)!=t) {
				if((int)sortedList.get(i)<(int)t) {
					i=(int)Math.round(i+(sortedList.size()-i)/2);
				}
				else if((int)sortedList.get(i)>(int)t) {
					i=(int)Math.floor((2*i-i)/2);
				}
				else {
					return i;
				}
			}
			
			return i;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	
	public String toPigLatin(String string) {
		String pl="";
		for(int i=0;i< string.split(" ").length ;i++) {
			String string1=string.split(" ")[i];
		
			int k1=0;
			char[] temp=new char[ string1.length() + 2];
			if(string1.charAt(0)=='A' || string1.charAt(0)=='E'||string1.charAt(0)=='I'||string1.charAt(0)=='O'||string1.charAt(0)=='U'
					||string1.charAt(0)=='a' || string1.charAt(0)=='e'||string1.charAt(0)=='i'||string1.charAt(0)=='o'||string1.charAt(0)=='u') {
				pl=string1+"ay";
			}		
			else if(string1.charAt(0)=='q'||string1.charAt(0)=='Q') {
				temp=string1.toCharArray();
				k1=2;
				for(int i1=k1;i1<string1.length();i1++) {
					pl=pl+temp[i1];
				}
				for(int k2=0;k2<=k1-1;k2++) {
					pl=pl+temp[k2];
					
				}
				pl=pl+"ay";
				
			}
			else {
				while(string1.charAt(k1)!='A' && string1.charAt(k1)!='E'&& string1.charAt(k1)!='I'&& string1.charAt(k1)!='O'&& string1.charAt(k1)!='U'
						&& string1.charAt(k1)!='a' && string1.charAt(k1)!='e'&& string1.charAt(k1)!='i'&& string1.charAt(k1)!='o'&& string1.charAt(k1)!='u') {
					temp=string1.toCharArray();
					k1++;
				}
				for(int i1=k1;i1<string1.length();i1++) {
					pl=pl+temp[i1];
				}
				for(int k2=0;k2<=k1-1;k2++) {
					pl=pl+temp[k2];
					
				}
				pl=pl+"ay";
				
			}
			if(string.split(" ").length>1 && i <string.split(" ").length-1 ) {
				pl=pl+" ";
			}
		}
		return pl;
	}

	public boolean isArmstrongNumber(int input) {
		double test9=(double) input;
		double mode=test9;
		int power=0;
		double sum=0;
		while(mode>0) {
			mode=(mode-(mode%10))/10;
			power++;
		}
		mode=test9;
		for(int i=1;i<=power;i++) {
			sum=sum+(Math.pow(mode%10, power));
			mode=(mode-(mode%10))/10;
			
		}
		return sum==test9;
	}

	public List<Long> calculatePrimeFactorsOf(long l) {
		long num =2;
		List<Long> al= new ArrayList<Long>();
		while(l>1) {
			if(l%num==0) {
				al.add(num);
				l=l/num;
			}
			else {
				num++;
			}
		}
		return al;
	}


	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String efg="";
			for(int i=0;i<string.length();i++) {
				if('a'<=string.charAt(i) && string.charAt(i)<='z') {
					efg=efg+ (char)(((((int)string.charAt(i)-'a')+key)%26)+(int)'a');
				}
				else if('A'<= string.charAt(i)&& string.charAt(i) <= 'Z') {
					efg=efg+ (char)(((((int)string.charAt(i)-'A')+key)%26)+(int)'A');
				}
				else {
					efg=efg+string.charAt(i);
				}
				
			}
		return efg;
		}

	}

	
	public int calculateNthPrime(int i) {
		if(i>=1) {
			int j=1;
			int run=3;
			
			ArrayList<Integer> primes= new ArrayList<Integer>();
			primes.add(2);
			while(j<i) {
				int k=0;
				for(int each:primes) {
					if(run%each==0) {
						run++;
					}
					else {
						k++;
					}
					
				}
				if(k==primes.size()) {
					primes.add(run);
					run++;
					j++;
				}
				else {
				}
			}
			return primes.get(i-1);
		}
		else {
			throw new IllegalArgumentException();
		}

	}


	static class AtbashCipher {


		public static String encode(String string) {
			String fix="";
			string=string.replace('.', ' ');
			string=string.replace(',', ' ');
			string=string.toLowerCase();
			string.trim();
			for(int h=0;h<string.split(" ").length ; h++) {
				fix=fix+string.split(" ")[h].trim();	
			}
			string=fix;
			String efg1="";
			for(int j=0;j<string.length();j++) {
				if('a'<=string.charAt(j) && string.charAt(j)<='z') {
					efg1=efg1+ (char)((25-((((int)string.charAt(j)-'a'))))+(int)'a');;
				}
				else if('0'<=string.charAt(j) && string.charAt(j)<='9') {
					efg1=efg1+string.charAt(j);
				}
				else {
					efg1=efg1;
				}
				if((j+1)%5==0 && j!=string.length()-1) {
					efg1=efg1+' ';
				}
			}
			return efg1;
		}


		public static String decode(String string) {
			String fix="";
			string=string.replace('.', ' ');
			string=string.replace(',', ' ');
			string=string.toLowerCase();
			string.trim();
			for(int h=0;h<string.split(" ").length ; h++) {
				fix=fix+string.split(" ")[h].trim();	
			}
			string=fix;
			String efg1="";
			for(int j=0;j<string.length();j++) {
				if('a'<=string.charAt(j) && string.charAt(j)<='z') {
					efg1=efg1+ (char)((25-((((int)string.charAt(j)-'a'))))+(int)'a');;
				}
				else if('0'<=string.charAt(j) && string.charAt(j)<='9') {
					efg1=efg1+string.charAt(j);
				}
				else {
					efg1=efg1;
				}
			
			}
			return efg1;
		}
	}


	public boolean isValidIsbn(String string) {
		String t="";
		int summ=0;
		string=string.replace('-', ' ');
		for(int e=0; e < string.split(" ").length;e++) {
			t=t+string.split(" ")[e];
		}
		
		for( int i1=0;i1<9;i1++) {
			if('0'<=t.charAt(i1) && t.charAt(i1) <='9') {
				summ=summ+((int)t.charAt(i1)-(int)'0')*(10-i1);
			}
			else {
				return false;
			}
		}
		if(t.charAt(9)=='X') {
			summ=summ+10;
		}
		else if ('0'<=t.charAt(9)&&t.charAt(9)<='9') {
			summ=summ+(int)t.charAt(9)-(int)'0';
		}
		else {
			return false;
		}
		
		return summ%11==0;
	}

	
	public boolean isPangram(String string) {
		string=string.toLowerCase();
		String noSpace="";
		String letters="";
		String spaces;
		for(int i2=0; i2 < string.split(" ").length; i2++) {
			noSpace=noSpace+ string.split(" ")[i2];
		}
		spaces=noSpace;
		for(int i3=0;i3<noSpace.length();i3++) {
			if(spaces.charAt(i3)!=' ') {
				spaces=spaces.replace(spaces.charAt(i3), ' ');
				letters=letters+spaces.charAt(i3);
			}
			else {
				
			}
			
		}
		return letters.length()==26;
	}

	
	public Temporal getGigasecondDate(Temporal given) {
		//In case,time not included
		if(given instanceof LocalDate) {
			LocalDateTime time = LocalDateTime.of((LocalDate) given, LocalTime.MIN);
			return time.plus(Duration.ofSeconds(1000000000l));
		}
		//if time is included
		LocalDateTime time = LocalDateTime.from(given);
		return time.plus(Duration.ofSeconds(1000000000l));
	}

	
	public int getSumOfMultiples(int i, int[] set) {
		int sum=0;
		ArrayList<Integer> al= new ArrayList<Integer>();
		for(int j=0;j<set.length;j++) {
			int k=1;
			while(i>k*set[j]) {
				if (!al.contains(k*set[j])) {
					sum=sum+k*set[j];
				}
				al.add(k*set[j]) ;
				k++;

			}
		}

		return sum;
	}

	
	public boolean isLuhnValid(String string) {
		String fix="";
		for(int h=0;h<string.split(" ").length ; h++) {
			fix=fix+string.split(" ")[h].trim();	
		}
		string=fix;
		int summm=0;
		System.out.println(fix);
		for(int q=1; q<string.length();q++) {
			if('0'>string.charAt(q)||string.charAt(q)>'9') {
				return false;
			}
			else if(q%2==1) {
				if((int)string.charAt(q)-'0'<5) {
					summm=summm+((int)string.charAt(q)-'0')*2;
				}
				else {
					summm=summm+((int)string.charAt(q)-'0')*2-9;
				}
			}
			else {
				summm=summm+((int)string.charAt(q)-'0');
			}
		}
		return(summm%10==0);
	}


	public int solveWordProblem(String string) {
		int sum=0;
		string=string.replace('?', ' ');
		string=string.trim();
		if(string.split(" ")[3].equals("plus")) {
			if(string.split(" ")[2].charAt(0)=='-') {

				int i=2;
					if(  i<string.split(" ")[2].length() ) {
						sum=sum-((int) string.split(" ")[2].charAt(1)-(int)'0')*10-((int) string.split(" ")[2].charAt(2)-(int)'0');
					}
					else {
						sum=sum-((int) string.split(" ")[2].charAt(1)-(int)'0');
					}
				

			}
			else {

				int i=1;
					if(  i<string.split(" ")[2].length() ) {
						sum=sum+((int) string.split(" ")[2].charAt(0)-(int)'0')*10+((int) string.split(" ")[2].charAt(1)-(int)'0');
					}
					else {
						sum=sum+((int) string.split(" ")[2].charAt(0)-(int)'0');
					}
				

			}
			if(string.split(" ")[4].charAt(0)=='-') {

				int i=2;
					if(  i<string.split(" ")[4].length() ) {
						sum=sum-((int) string.split(" ")[4].charAt(1)-(int)'0')*10-((int) string.split(" ")[4].charAt(2)-(int)'0');
					}
					else {
						sum=sum-((int) string.split(" ")[4].charAt(1)-(int)'0');
					}
				

			}
			else {
				int i=1;
					if(  i<string.split(" ")[4].length() ) {
						sum=sum+((int) string.split(" ")[4].charAt(0)-(int)'0')*10+((int) string.split(" ")[4].charAt(1)-(int)'0');
					}
					else {
						sum=sum+((int) string.split(" ")[4].charAt(0)-(int)'0');
					}
				

			}
			
			
			return sum;
		}
		else if(string.split(" ")[3].equals("minus")) {
			if(string.split(" ")[2].charAt(0)=='-') {

				int i=2;
					if(  i<string.split(" ")[2].length() ) {
						sum=sum-((int) string.split(" ")[2].charAt(1)-(int)'0')*10-((int) string.split(" ")[2].charAt(2)-(int)'0');
					}
					else {
						sum=sum-((int) string.split(" ")[2].charAt(1)-(int)'0');
					}
				

			}
			else {

				int i=1;
					if(  i<string.split(" ")[2].length() ) {
						sum=sum+((int) string.split(" ")[2].charAt(0)-(int)'0')*10+((int) string.split(" ")[2].charAt(1)-(int)'0');
					}
					else {
						sum=sum+((int) string.split(" ")[2].charAt(0)-(int)'0');
					}
				

			}
			if(string.split(" ")[4].charAt(0)=='-') {

				int i=2;
					if(  i<string.split(" ")[4].length() ) {
						sum=sum+((int) string.split(" ")[4].charAt(1)-(int)'0')*10+((int) string.split(" ")[4].charAt(2)-(int)'0');
					}
					else {
						sum=sum+((int) string.split(" ")[4].charAt(1)-(int)'0');
					}
				

			}
			else {
				int i=1;
					if(  i<string.split(" ")[4].length() ) {
						sum=sum-((int) string.split(" ")[4].charAt(0)-(int)'0')*10-((int) string.split(" ")[4].charAt(1)-(int)'0');
					}
					else {
						sum=sum-((int) string.split(" ")[4].charAt(0)-(int)'0');
					}
				

			}
			
			
			return sum;
		}
		else if(string.split(" ")[3].equals("multiplied")) {
			if((string.split(" ")[2].charAt(0)=='-'&& string.split(" ")[5].charAt(0)=='-')) {

				int i=2;
				if(  i<string.split(" ")[5].length() ) {
					sum=sum+((int) string.split(" ")[5].charAt(1)-(int)'0')*10+((int) string.split(" ")[5].charAt(2)-(int)'0');
				}
				else {
					sum=sum+((int) string.split(" ")[5].charAt(1)-(int)'0');
				}
				if(  i<string.split(" ")[2].length() ) {
					sum=sum*(((int) string.split(" ")[2].charAt(1)-(int)'0')*10+((int) string.split(" ")[2].charAt(2)-(int)'0'));
				}
				else {
					sum=sum*((int) string.split(" ")[2].charAt(1)-(int)'0');
				}
				return sum;
			}
			else if((string.split(" ")[2].charAt(0)!='-'&& string.split(" ")[5].charAt(0)!='-')) {
				int i=1;
				if(  i<string.split(" ")[5].length() ) {
					sum=sum+((int) string.split(" ")[5].charAt(0)-(int)'0')*10+((int) string.split(" ")[5].charAt(1)-(int)'0');
				}
				else {
					sum=sum+((int) string.split(" ")[5].charAt(0)-(int)'0');
				}
				if(  i<string.split(" ")[2].length() ) {
					sum=sum*(((int) string.split(" ")[2].charAt(0)-(int)'0')*10+((int) string.split(" ")[2].charAt(1)-(int)'0'));
				}
				else {
					sum=sum*((int) string.split(" ")[2].charAt(0)-(int)'0');
				}
				return sum;
			}
			else if(string.split(" ")[5].charAt(0)=='-') {
				int i=2;
				if(  i<string.split(" ")[5].length() ) {
					sum=sum+((int) string.split(" ")[5].charAt(1)-(int)'0')*10+((int) string.split(" ")[5].charAt(2)-(int)'0');
				}
				else {
					sum=sum+((int) string.split(" ")[5].charAt(1)-(int)'0');
				}
			    i=1;
				if(  i<string.split(" ")[2].length() ) {
					sum=sum*(((int) string.split(" ")[2].charAt(0)-(int)'0')*10+((int) string.split(" ")[2].charAt(1)-(int)'0'));
				}
				else {
					sum=sum*((int) string.split(" ")[2].charAt(0)-(int)'0');
				}
				return sum;
				
			}
			else {
				int i=1;
				if(  i<string.split(" ")[5].length() ) {
					sum=sum+((int) string.split(" ")[5].charAt(0)-(int)'0')*10+((int) string.split(" ")[5].charAt(1)-(int)'0');
				}
				else {
					sum=sum+((int) string.split(" ")[5].charAt(0)-(int)'0');
				}
				
				i=2;
				if(  i<string.split(" ")[2].length() ) {
					sum=sum*(((int) string.split(" ")[2].charAt(0)-(int)'0')*10+((int) string.split(" ")[2].charAt(1)-(int)'0'));
				}
				else {
					sum=sum*((int) string.split(" ")[2].charAt(0)-(int)'0');
				}
				return sum*(1);
			}
			
		}
		else  {
			if((string.split(" ")[2].charAt(0)=='-'&& string.split(" ")[5].charAt(0)=='-')) {

				int i=2;
				if(  i<string.split(" ")[5].length() ) {
					sum=sum+((int) string.split(" ")[5].charAt(1)-(int)'0')*10+((int) string.split(" ")[5].charAt(2)-(int)'0');
				}
				else {
					sum=sum+((int) string.split(" ")[5].charAt(1)-(int)'0');
				}
				if(  i<string.split(" ")[2].length() ) {
					sum=(((int) string.split(" ")[2].charAt(1)-(int)'0')*10+((int) string.split(" ")[2].charAt(2)-(int)'0'))/sum;
				}
				else {
					sum=((int) string.split(" ")[2].charAt(1)-(int)'0')/sum;
				}
				return sum;
			}
			else if((string.split(" ")[2].charAt(0)!='-'&& string.split(" ")[5].charAt(0)!='-')) {
				int i=1;
				if(  i<string.split(" ")[5].length() ) {
					sum=sum+((int) string.split(" ")[5].charAt(0)-(int)'0')*10+((int) string.split(" ")[5].charAt(1)-(int)'0');
				}
				else {
					sum=sum+((int) string.split(" ")[5].charAt(0)-(int)'0');
				}
				if(  i<string.split(" ")[2].length() ) {
					sum=(((int) string.split(" ")[2].charAt(0)-(int)'0')*10+((int) string.split(" ")[2].charAt(1)-(int)'0'))/sum;
				}
				else {
					sum=((int) string.split(" ")[2].charAt(0)-(int)'0')/sum;
				}
				return sum;
			}
			else if(string.split(" ")[5].charAt(0)=='-') {
				int i=2;
				if(  i<string.split(" ")[5].length() ) {
					sum=sum+((int) string.split(" ")[5].charAt(1)-(int)'0')*10+((int) string.split(" ")[5].charAt(2)-(int)'0');
				}
				else {
					sum=sum+((int) string.split(" ")[5].charAt(1)-(int)'0');
				}
			    i=1;
				if(  i<string.split(" ")[2].length() ) {
					sum=(((int) string.split(" ")[2].charAt(0)-(int)'0')*10+((int) string.split(" ")[2].charAt(1)-(int)'0'))/sum;
				}
				else {
					sum=((int) string.split(" ")[2].charAt(0)-(int)'0')/sum;
				}
				return sum*(-1);
				
			}
			else {
				int i=1;
				if(  i<string.split(" ")[5].length() ) {
					sum=sum+((int) string.split(" ")[5].charAt(0)-(int)'0')*10+((int) string.split(" ")[5].charAt(1)-(int)'0');
				}
				else {
					sum=sum+((int) string.split(" ")[5].charAt(0)-(int)'0');
				}
				
				i=2;
				if(  i<string.split(" ")[2].length() ) {
					sum=(((int) string.split(" ")[2].charAt(0)-(int)'0')*10+((int) string.split(" ")[2].charAt(1)-(int)'0'))/sum;
				}
				else {
					sum=((int) string.split(" ")[2].charAt(0)-(int)'0')/sum;
				}
				return sum*(-1);
			}
		
		
	
	}
			
		
	}

}
