package adder;

public class Main {

    public static void main(String[] args) {
        try {
            int result = addArguments(args);
            System.out.println(result);
        }
		catch (NumberFormatException e) {
			// Argument syntax is given in Extended Backus-Naur Form, as per Unix standards
			System.err.println("Please use the supported syntax:\n\t
				[-] integer integer {integer}");
        }
		catch (IllegalArgumentException e) {
			System.err.println("Please provide at least two integer arguments.");
		}
    }

    private static int addArguments(String[] args) {
		if (args.length < 2 || (args.length < 3 && args[0] == "-")) {
		throw new IllegalArgumentException();
		}
		int sum = 0;
		if (args[0] == "-") {
			for (int i = 1; i < args.length; i++) {
				sum -= Integer.parseInt(args[i]);
			}	
		}
		else {
			for (int i = 0; i < args.length; i++) {
			sum += Integer.parseInt(args[i]);
			}
		}
        return sum;
    }
}
