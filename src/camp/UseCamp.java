package camp;

import java.util.Scanner;

public class UseCamp {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		Camp ourCamp = new Camp("TouroSummerCamp",10);
		int choice;
		String firstname, lastname, hiredate, birthdate,allergy,bunkname;
		Double salary;
		
		do{
			choice = menu();
			switch (choice){
			case 1: // add a counselor
				System.out.println("Enter counselor's firstname lastname hire date(yyyy-MM-dd) salary ");
				firstname = userInput.next();
				lastname = userInput.next();
				hiredate = userInput.next();
				salary = userInput.nextDouble();
				try{
				   ourCamp.addCounselor(firstname, lastname, hiredate, salary);
				}
				catch (DuplicateDataException ex){
					System.out.println("This counselor is already working at the camp");
				}
				break;
			case 2:  //add a Bunk
				System.out.println("Enter bunkName");
				bunkname = userInput.next();
				System.out.println("Enter counselor firstname and lastname");
				firstname = userInput.next();
				lastname = userInput.next();
				try{
				    ourCamp.addBunk(bunkname, firstname, lastname);
				}
				catch(MaxBunksException ex){
					System.out.println("Camp can't support any more bunks ");
				}
				catch(CounselorNotFoundException ex){
					System.out.println("bunk not inserted, counselor not in the system");
				}
				break;
			case 3: //add a Camper
				System.out.println("Enter camper's firstname lastname dateofbirth (yyyy-MM-dd");
				firstname = userInput.next();
				lastname = userInput.next();
				birthdate = userInput.next();
				try{
				    ourCamp.addCamper(firstname, lastname, birthdate);
				}
				catch(DuplicateDataException ex){
					System.out.println("Camper is already in the system");
				}
				
				break;
			case 4: //modify counselor salary
				System.out.println("Enter counselor's firstname, lastname revised salary amount");
				firstname = userInput.next();
				lastname = userInput.next();
				salary = userInput.nextDouble();
				try{
				    ourCamp.modifySalary(firstname, lastname, salary);
				}
				catch(CounselorNotFoundException ex){
					System.out.println("Counselor not in the system");
				}
				break;
			case 5: //add an allergy
				System.out.println("Enter camper's firstname lastname allergy name");
				firstname = userInput.next();
				lastname = userInput.next();
				allergy = userInput.next();
				try{
				     ourCamp.addAllergy(firstname, lastname, allergy);
				}
				catch(CamperNotFoundException ex){
					System.out.println("camper not in the system");
				}
				break;
			case 6:  //assign a camper to a bunk
				System.out.println("Enter camper's firstname lastname and bunk name");
				firstname = userInput.next();
				lastname = userInput.next();
				bunkname = userInput.next();
				try{
				    ourCamp.placeCamper(firstname, lastname, bunkname);
				}
				catch(CamperNotFoundException ex){
					System.out.println("camper not found on list");
				}
				catch(BunkNotFoundException ex){
					System.out.println("bunk not found ,camper cant be assigned");
				}
				
			case 7:
				System.out.println(ourCamp);
				break;
			case 0:
				System.out.println("Ending Application....");
			}
			
		}while (choice != 0);
		
		System.exit(0);

	}
	
	public static int menu(){
		int choice;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("1.Add A Counselor"+
		"\n2. Add a Bunk" +
				"\n3. Add a Camper" +
		"\n4. Modify Counselor Salary" +
				"\n5. Add an Allergy"+
		"\n6. Assign a Camper to a Bunk"+
				"\n7. Display Camp data"+
		"\n0. Exit Application"
				);
		choice = keyboard.nextInt();
		return choice;
	}

}
