package java9.easy.easyapp2;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesPerson implements Comparable<SalesPerson>{
	private Integer id;
	private String name;
	private Integer saleAmount;
	private String grade;
	
	
	
	@Override
	public String toString() {
	 String output=String.format("%-5s %-20s %-10s %-10s",id,name,saleAmount,grade);
	 return output;
	}
    
	
	public int compareTo(SalesPerson salesPerson)
	{
		return this.saleAmount.compareTo(salesPerson.saleAmount);
	}


	@Override
	public boolean equals(Object obj) {
		SalesPerson other = (SalesPerson) obj;
		if(this.hashCode()==other.hashCode())
		return true;
		else
		return false;
	}

	@Override
	public int hashCode() {
		return id;
	}


	public SalesPerson(Integer id, String name, Integer saleAmount) {
		super();
		this.id = id;
		this.name = name;
		this.saleAmount = saleAmount;
	}
	

}
