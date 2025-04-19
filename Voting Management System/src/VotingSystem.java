/* VotingSystem.java */
import java.util.*;

public class VotingSystem {
    private Map<String, Voter> voters = new HashMap<>();
    private Map<String, Candidate> candidates = new HashMap<>();

    public void registerVoter(String voterId, String name) {
        voters.put(voterId, new Voter(voterId, name));
    }

    public void registerCandidate(String candidateId, String name) {
        candidates.put(candidateId, new Candidate(candidateId, name));
    }

    public boolean castVote(String voterId, String candidateId) {
        Voter voter = voters.get(voterId);
        Candidate candidate = candidates.get(candidateId);
        if (voter == null || candidate == null) return false;
        if (voter.hasVoted()) return false;

        voter.setVoted(true);
        candidate.incrementVote();
        return true;
    }

    public void displayResults() {
        System.out.println("\n--- Voting Results ---");
        for (Candidate candidate : candidates.values()) {
            System.out.println(candidate.getName() + ": " + candidate.getVotes() + " votes");
        }
    }

    public void listCandidates() {
        System.out.println("\n--- Candidates ---");
        for (Candidate candidate : candidates.values()) {
            System.out.println(candidate.getCandidateId() + ": " + candidate.getName());
        }
    }
}