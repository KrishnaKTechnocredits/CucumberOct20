
public class RWAutomation {

	static double monthBasicSalary = 31200;

	public static void main(String[] args) {
		double baseSalary = (section1() * 12);
		double finalValue = baseSalary + section3(baseSalary) + section4(monthBasicSalary);
		System.out.println("----------------> " + finalValue);
	}

	private static double section1() {
		System.out.println("----------------------- Section 1 -----------------------");

		double mHRA = (monthBasicSalary * 0.5);
		double mConAll = (monthBasicSalary * 0.2);
		double balance = 123595;
		double mBalanceFig = balance / 12;
		double mEdu = 200;
		double mgratia = 3600;
		double mMedi = 1250;

		double mLeave = (monthBasicSalary / 12);

		System.out.println("HRA : " + mHRA);
		System.out.println("Col : " + mConAll);
		System.out.println("Bala : " + mBalanceFig);
		System.out.println("Edu : " + mEdu);
		System.out.println("Gratia : " + mgratia);
		System.out.println("Medi : " + mMedi);
		System.out.println("Mothly : " + monthBasicSalary);

		System.out.println("Leave : " + mLeave);

		double totalMonthlySalary = monthBasicSalary + mHRA + mConAll + mBalanceFig + mEdu + mgratia + mMedi + mLeave;

		double aHRA = (monthBasicSalary * 0.5) * 12;
		double aConAll = (monthBasicSalary * 0.2) * 12;
		double aBalance = 123595;
		double aEdu = 2400;
		double agratia = 43200;
		double aMedi = 15000;
		double aLeave = monthBasicSalary;

		double totalYearSalarry = (monthBasicSalary * 12) + aHRA + aConAll + aBalance + aEdu + agratia + aMedi + aLeave;
		System.out.println("Total Year Salary : " + totalYearSalarry);
		System.out.println();
		System.out.println("Total Month Salary : " + totalMonthlySalary);
		System.out.println();

		return totalMonthlySalary;
	}

	private static double section3(double baseSalary) {
		System.out.println();
		System.out.println("----------------------- Section 3 -----------------------");
		double a = baseSalary * 10;
		a = a / 100;
		System.out.println();
		System.out.println();
		System.out.println("Variable Pay : " + a);
		return a;
	}

	private static double section4(double basicSalary) {
		System.out.println("----------------------- Section 4 -----------------------");
		double pf = ((basicSalary * 0.12) * 12);
		System.out.println("PF : -------> " + pf);
		double gratuity = ((basicSalary * 0.0481) * 12);
		System.out.println("gratuity : -------> " + gratuity);

		System.out.println("total benifit : " + (pf + gratuity));
		System.out.println();
		System.out.println();
		return (pf + gratuity);
	}

}
