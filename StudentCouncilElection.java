import java.util.*;

public class StudentCouncilElection {

 static class Candidate {
 private String name;
 private String rollNumber;
 private String position;
 private int votes;


 public Candidate(String name, String rollNumber, String position, int votes) {
 this.name = name;
 this.rollNumber = rollNumber;
 this.position = position;
 this.votes = votes;
 }


 public Candidate(String name, String rollNumber, String position) {
 this(name, rollNumber, position, 0);
}

 public Candidate(String name, String rollNumber) {
 this(name, rollNumber, "Unassigned", 0);
 }

 public String getName() {
 return name;
 }

 public String getRollNumber() {
 return rollNumber;
 }

 public String getPosition() {
 return position;
 }

 public int getVotes() {
 return votes;
 }


 public void displayOfficialRecord() {
 System.out.println("Candidate Name     : " + name.toUpperCase());
 System.out.println("Roll Number        : " + rollNumber.toUpperCase());
 System.out.println("Position           : " + position.toUpperCase());
 System.out.println("Votes Received     : " + votes);
 }


 public boolean validate() {
 if (name == null || name.trim().isEmpty()) {
 return false;
 }
if (rollNumber == null || rollNumber.trim().isEmpty()) {
return false;
}
 if (position == null || position.trim().isEmpty()) {
 return false;
}
 if (votes < 0) {
 return false;
 }
return true;
 }
 }


 static class ElectionManager {
 private List<Candidate> candidates;

 public ElectionManager() {
 candidates = new ArrayList<>();
 }


 public void registerCandidate(Candidate candidate) {
 if (!candidate.validate()) {
 System.out.println("Invalid candidate information for: " + candidate.getName());
 return;
 }


 for (Candidate existing : candidates) {
 if (existing.getName().equalsIgnoreCase(candidate.getName())) {
 System.out.println("\nDuplicate Candidate Check:");
 System.out.println("Candidate Name     : " + existing.getName().toUpperCase());
 System.out.println("Status             : Duplicate Nomination");
 return;
 }
 }

 candidates.add(candidate);
 System.out.println("\nCandidate Registered Successfully");
 candidate.displayOfficialRecord();
 }


 public Candidate findWinner(String position) {
 String upperPosition = position.toUpperCase();
 Candidate winner = null;
 int maxVotes = -1;

 for (Candidate candidate : candidates) {
 if (candidate.getPosition().equalsIgnoreCase(upperPosition) && candidate.getVotes() > maxVotes) {
 winner = candidate;
  maxVotes = candidate.getVotes();
 }
  }

 return winner;
 }


 public void displayResults() {

 Set<String> positions = new LinkedHashSet<>();
 for (Candidate candidate : candidates) {
 positions.add(candidate.getPosition());
 }

 System.out.println("\n---------- ELECTION RESULTS ----------");

 for (String position : positions) {
 Candidate winner = findWinner(position);
 if (winner != null) {
 System.out.println("Position           : " + position.toUpperCase());
 System.out.println("Winning Candidate  : " + winner.getName().toUpperCase());
 System.out.println("Total Votes        : " + winner.getVotes());
 System.out.println();
}
 }
 }
 }

 public static void main(String[] args) {
 System.out.println("========== STUDENT COUNCIL ELECTION ==========");

 ElectionManager election = new ElectionManager();


 Candidate anya = new Candidate("Ananya", "101", "President", 125);
 election.registerCandidate(anya);


Candidate rahul = new Candidate("Rahul", "102", "President");
 rahul = new Candidate("Rahul", "102", "President", 98); // Re-register with votes
 election.registerCandidate(rahul);


 Candidate secretary1 = new Candidate("Priya", "103");
 secretary1 = new Candidate("Priya", "103", "Secretary", 200);
 election.registerCandidate(secretary1);


Candidate duplicate = new Candidate("Ananya", "104", "President", 50);
 election.registerCandidate(duplicate);


election.displayResults();
 }
}


