package App;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Stateless
@Entity
public class Calculation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number1;
    private int number2;
    private String operation;
    
    
	
	public Calculation(){	
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
	public int getNumber1() {
		return number1;
	}
	
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	
	public int getNumber2() {
		return number2;
	}
	
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public double calculate(Calculation c) {
		
		switch (c.getOperation()){
			
			case "+":
				return c.getNumber1()+c.getNumber2();
			
			case "-":
				return c.getNumber1()-c.getNumber2();
			
			case "*":
				return c.getNumber1()*c.getNumber2();
			
			case "/":
				if (number2 != 0) {
                     return ((double) c.getNumber1()/c.getNumber2());
                } else {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
			default:
                throw new IllegalArgumentException("Invalid operation: " + c.getOperation());	
		
		}
				
	}
	
	
	
}
