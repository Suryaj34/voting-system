import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VotingSystem vs = new VotingSystem();

        // Sample data
        vs.registerCandidate("C1", "Elson");
        vs.registerCandidate("C2", "Sudeep");
        vs.registerVoter("V1", "John");
        vs.registerVoter("V2", "Emma");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Cast Vote\n2. Show Results\n3. Exit");
            System.out.print("Choose option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Voter ID: ");
                    String voterId = scanner.nextLine();
                    vs.listCandidates();
                    System.out.print("Enter Candidate ID to vote: ");
                    String candidateId = scanner.nextLine();
                    if (vs.castVote(voterId, candidateId)) {
                        System.out.println("Vote cast successfully.");
                    } else {
                        System.out.println("Vote failed. Check ID or you may have already voted.");
                    }
                    break;
                case 2:
                    vs.displayResults();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
