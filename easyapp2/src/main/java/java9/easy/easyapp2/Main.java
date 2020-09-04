package java9.easy.easyapp2;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main 
{
    public static void main( String[] args )
    {
    	Scanner scanner=new Scanner(System.in);
		System.out.println("Enter number of Sales Persons:");
		int no=Integer.parseInt(scanner.nextLine());
		Set<SalesPerson> salesPersonSet=new LinkedHashSet<SalesPerson>();
		System.out.println("Enter Sales Person's details one line at a time");
		for(int i=0;i<no;i++)
		{
			String str=scanner.nextLine();
			String arr[]=str.split(",");
			SalesPerson salesPerson=new SalesPerson(Integer.parseInt(arr[0]),arr[1],Integer.parseInt(arr[2]));
			salesPersonSet.add(salesPerson);
		}
		Stream<SalesPerson> salesStarStream=salesPersonSet.stream().filter(salesPerson->salesPerson.getSaleAmount()>=100000).limit(5);
		List<SalesPerson> salesStarList=salesStarStream.collect(Collectors.toList());
		Collections.sort(salesStarList);
		int x=0;
		for(SalesPerson salesPerson:salesStarList)
		{
			x++;
			salesPerson.setGrade(""+x+"Star");
		}
		Collections.reverse(salesStarList);
		System.out.println("\nThe Star Performers List");
		System.out.println(String.format("%-5s %-20s %-10s %-10s","ID","NAME","SALE AMOUNT","GRADE"));
	    salesStarList.forEach(System.out::println);
		    
    }
}
