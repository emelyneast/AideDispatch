import java.util.ArrayList;
import java.util.List;

public class Agent {
    String nomAgent;
    String grade ;

    List<Agent> agents = new ArrayList<>();


    public Agent(String nomAgent, String grade) {
        this.nomAgent = nomAgent;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public String getNomAgent() {
        return nomAgent;
    }

    public void setNomAgent(String nomAgent) {
        this.nomAgent = nomAgent;
    }

    public String[] tabGrade(){
        String tab[] = {"Sheriff","Sheriff-Adjoint","Sergent |||","Sergent ||","Sergent |","Officier sup |||","Officier sup ||","Officier sup |","Officier","Ranger"};
        return tab;
    }

    public void addAgent(Agent agent){
        agents.add(agent);
    }

    public void listAgent(){
       agents.add(new Agent("Lewis Clark",tabGrade()[0]));
       agents.add(new Agent("Davis Harrison", tabGrade()[1]));
       agents.add(new Agent("Landers Smith", tabGrade()[3]));
       agents.add(new Agent("Bob Lebuis", tabGrade()[4]));
       agents.add(new Agent("A.Bond", tabGrade()[5]));
       agents.add(new Agent("Mickael Johnson", tabGrade()[7]));
       agents.add(new Agent("Boris Turner", tabGrade()[7]));
       agents.add(new Agent("William Spencer", tabGrade()[7]));
       agents.add(new Agent("Thomas Menfin", tabGrade()[7]));
       agents.add(new Agent("Alice Mayer", tabGrade()[8]));
       agents.add(new Agent("Mehdi Forda", tabGrade()[8]));
       agents.add(new Agent("William Crawford", tabGrade()[8]));
       agents.add(new Agent("Lorenzo Lifiusa", tabGrade()[8]));
       agents.add(new Agent("Steve Wade", tabGrade()[8]));
       agents.add(new Agent("Ayden Lopez", tabGrade()[9]));

    }

    public String[] listeVeh(){
        String veh[] = {"granger serigraphier 2021","granger","SUV","Buffalo","crowwn Voctoria"};
        return veh;
    }

    public static void main(String[] args) {
        Agent a = new Agent("","");
        a.listAgent();
    }
}
