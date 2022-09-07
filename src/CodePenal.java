import java.util.ArrayList;
import java.util.List;

public class CodePenal {
    String def;
    Integer amande;
    Boolean gav;
    Integer minEmprisonnement;
    Integer maxEmprisonnement;

    String autre;
    List<CodePenal> codePenal = new ArrayList<>();


    public CodePenal(String def, Integer amande, Boolean gav, Integer minEmprisonnement, Integer maxEmprisonnement, String autre) {
        this.def = def;
        this.amande = amande;
        this.gav = gav;
        this.minEmprisonnement = minEmprisonnement;
        this.maxEmprisonnement = maxEmprisonnement;
        this.autre = autre;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public Integer getAmande() {
        return amande;
    }

    public void setAmande(Integer amande) {
        this.amande = amande;
    }

    public Boolean getGav() {
        return gav;
    }

    public void setGav(Boolean gav) {
        this.gav = gav;
    }

    public Integer getMinEmprisonnement() {
        return minEmprisonnement;
    }

    public void setMinEmprisonnement(Integer minEmprisonnement) {
        this.minEmprisonnement = minEmprisonnement;
    }

    public Integer getMaxEmprisonnement() {
        return maxEmprisonnement;
    }

    public void setMaxEmprisonnement(Integer maxEmprisonnement) {
        this.maxEmprisonnement = maxEmprisonnement;
    }

    public String getAutre() {
        return autre;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }

    public void listCode(){
        codePenal.add(new CodePenal("Agression au premier degré: armes blanches et pistolets PPA",50000,false,5, 10,""));
        codePenal.add(new CodePenal("Agression au second degré: armes automatique",100000,false,5, 10,""));
        codePenal.add(new CodePenal("Agression sexuelle",0,false,0, 0,"Prison a vie"));
        codePenal.add(new CodePenal("Atteinte à la défense national, entrave envers le fonctionnement normal des institution",250000,false,15, 15,""));
        codePenal.add(new CodePenal("Atteinte à la défense nationale, intrusion sur un secteur dépositaire de la défense",300000,false,8, 8,""));
        codePenal.add(new CodePenal("Blanchiment de bien ou d’argent",100000,false,5, 5,""));
        codePenal.add(new CodePenal("Blanchiment de bien ou d’argent en réunion",150000,false,10, 10,""));
        codePenal.add(new CodePenal("Brandit une arme à feu",10000,false,1, 1,""));
        codePenal.add(new CodePenal("Complicité (évasion / meurtre …)",30000,false,2, 2,""));
        codePenal.add(new CodePenal("Complot en étant fonctionnaire des force de l’ordre",40000,false,20, 20,""));
        codePenal.add(new CodePenal("Corruption",30000,false,5, 5,""));
        codePenal.add(new CodePenal("Création d’hostilité",30000,false,30, 30,""));
        codePenal.add(new CodePenal("Délit de fuite",30000,false,3, 3,""));
        codePenal.add(new CodePenal("Détournement de fond ou de bien",30000,false,8, 8,""));
        codePenal.add(new CodePenal("Distribution d’une arme de guerre",100000,false,14, 14,""));
        codePenal.add(new CodePenal("Distribution d’une arme illégale",75000,false,7, 7,""));
        codePenal.add(new CodePenal("Distribution non autorisé d’une arme légale",50000,false,5, 5,""));
        codePenal.add(new CodePenal("Dommage à un bien",10000,false,1, 3,""));
        codePenal.add(new CodePenal("Entrave à la justice",50000,false,5, 5,""));
        codePenal.add(new CodePenal("Entrave à la justice en étant dépositaire de l’autorité publique",60000,false,15, 15,""));
        codePenal.add(new CodePenal("Escroquerie",30000,false,8, 8,""));
        codePenal.add(new CodePenal("Escroquerie d’un membre dépositaire de l'autorité publique",45000,false,10, 10,""));
        codePenal.add(new CodePenal("Exhibition sexuelle",60000,false,3, 3,""));
        codePenal.add(new CodePenal("Extorsion",20000,false,5, 5,""));
        codePenal.add(new CodePenal("Extorsion avec visage dissimulé",25000,false,10, 10,""));
        codePenal.add(new CodePenal("Extorsion sur un membres dépositaire de l’autorité publique",35000,false,15, 15,""));
        codePenal.add(new CodePenal("Fabrication de stupéfiants",45000,false,10, 10,""));
        codePenal.add(new CodePenal("Fausse information",10000,false,2, 2,""));
        codePenal.add(new CodePenal("Faux et usage de Faux",15000,false,3, 3,""));
        codePenal.add(new CodePenal("Homicide involontaire",50000,false,3, 5,""));
        codePenal.add(new CodePenal("Incitation au suicide",10000,false,3, 3,""));
        codePenal.add(new CodePenal("Incitation d’un crime contre l’Etat",200000,false,20, 20,""));
        codePenal.add(new CodePenal("Livraison d’information ou de matériels à un ennemie de l’Etat relevant d’un secret de la défense nationale",0,false,0, 0,"Pein de mort"));
        codePenal.add(new CodePenal("Livraison d’information ou de matériels à un ennemie de l’Etat relevant d’un secret national",0,false,0, 0,"Pein de mort"));
        codePenal.add(new CodePenal("Manifestation illégale",20000,true,24, 24,""));
        codePenal.add(new CodePenal("Menace Criminelle",25000,false,10, 10,""));
        codePenal.add(new CodePenal("Meurtre / assasinat",150000,false,15, 30,""));
        codePenal.add(new CodePenal("Mise en danger de la vie d'autrui",25000,false,5, 10,""));
        codePenal.add(new CodePenal("Non assistance à personne en danger",10000,false,1, 1,""));
        codePenal.add(new CodePenal("Non paiement d'un service",25000,true,3, 3,""));
        codePenal.add(new CodePenal("Outrage en fait d’arrestation",25000,false,2, 2,""));
        codePenal.add(new CodePenal("Outrage en réunion",20000,false,5, 5,""));
        codePenal.add(new CodePenal("Outrage envers un organisme public",15000,true,24, 24,""));
        codePenal.add(new CodePenal("Outrage envers un agent assermenté: LSPD, Municipaux...",25000,true,24, 24,""));
        codePenal.add(new CodePenal("Prise d’otage",150000,false,10, 10,""));
        codePenal.add(new CodePenal("Prise de pouvoir sur un personne",150000,false,20, 20,""));
        codePenal.add(new CodePenal("Possession de stupéfiants",10000,false,0, 0,""));
        codePenal.add(new CodePenal("Possession d’un équipement ou d’une arme de guerre en continuité à l’Article 12 de la Mairie (par armes)",30000,false,10, 10,""));
        codePenal.add(new CodePenal("Possession d’une arme à feu illégale (par armes)",50000,false,8, 8,""));
        codePenal.add(new CodePenal("Possession d’une arme à feu légale sans licence",25000,false,2, 2,""));
        codePenal.add(new CodePenal("Possession d’une lame",1000,false,0, 0,""));
        codePenal.add(new CodePenal("Racket",25000,false,3, 3,""));
        codePenal.add(new CodePenal("Racket aggravé ",35000,false,5, 5,""));
        codePenal.add(new CodePenal("Recel",50000,false,5, 5,""));
        codePenal.add(new CodePenal("Refus d’obtempérer",20000,false,1, 1,""));
        codePenal.add(new CodePenal("Sabotage",25000,false,8, 8,""));
        codePenal.add(new CodePenal("Survol d’une zone interdite ou militaire",150000,false,0, 0,"Destruction du véhicule"));
        codePenal.add(new CodePenal("Tentative de corruption",20000,false,2, 2,""));
        codePenal.add(new CodePenal("Terrorisme",0,false,0, 0,"PEINE DE MORT"));
        codePenal.add(new CodePenal("Torture",0,false,0, 0,"PEINE DE MORT"));
        codePenal.add(new CodePenal("Trafic de stupéfiants",30000,false,5, 5,""));
        codePenal.add(new CodePenal("Trouble à l’ordre publique causant la mort",0,false,0, 0,"PEINE DE MORT"));
        codePenal.add(new CodePenal("Trouble à l'ordre publique dans le cadre d’un rassemblement",5000,true,24, 24,""));
        codePenal.add(new CodePenal("Trouble à l’ordre publique dans le cadre d’un rassemblement avec le visage dissimulé",5500,true,48, 48,""));
        codePenal.add(new CodePenal("Trouble à l’ordre publique en ayant le visage dissimulé",2000,true,24, 24,""));
        codePenal.add(new CodePenal("Trouble à l’ordre publique en état d’ivresse sur la voie publique",3000,true,24, 24,""));
        codePenal.add(new CodePenal("Trouble à l’ordre publique provoquant des blessures corporelle",50000,false,1, 3,""));
        codePenal.add(new CodePenal("Usurpation d’identité",25000,false,1, 1,""));
        codePenal.add(new CodePenal("Usurpation de fonction",45000,false,5, 5,""));
        codePenal.add(new CodePenal("Utilisation d'une arme depuis un véhicule terrestre, marin ou aérien",30000,false,5, 5,""));
        codePenal.add(new CodePenal("Vente de stupéfiants",20000,false,1, 1,""));
        codePenal.add(new CodePenal("Viol",0,false,0, 0,"PEINE DE MORT"));
        codePenal.add(new CodePenal("Viol en réunion",0,false,0, 0,"PEINE DE MORT"));
        codePenal.add(new CodePenal("Vol alias braquage ou cambriolage d’une maison ou d’une entreprise",30000,false,12, 12,""));
        codePenal.add(new CodePenal("Vol avec visage dissimulé",15000,false,10, 10,""));
        codePenal.add(new CodePenal("Vol effectué avec une arme",35000,false,15, 15,""));
        codePenal.add(new CodePenal("Vol d’un bien",15000,false,3, 3,""));
        codePenal.add(new CodePenal("Vol d’une propriété appartenant à l'état",50000,false,20, 20,""));
        codePenal.add(new CodePenal("Vol en réunion",20000,false,5, 5,""));

    }

    public void listCodeDelaroute(){
        codePenal.add(new CodePenal("Absence de céder le passage à un véhicule prioritaire",15000,true,4, 4,""));
        codePenal.add(new CodePenal("Accident Involontaire",2000,false,0, 0,""));
        codePenal.add(new CodePenal("Accident volontaire ou en tord",15000,false,0, 0,""));
        codePenal.add(new CodePenal("Accident Involontaire Provoquant la mort",30000,false,3, 3,""));
        codePenal.add(new CodePenal("Accident volontaire ou en tord provoquant la mort",50000,false,20, 20,""));
        codePenal.add(new CodePenal("Arrêt ou stationnement en sens inverse de la circulation",3000,false,0, 0,""));
        codePenal.add(new CodePenal("Chevauchement d'une ligne continue",500,false,0, 0,""));
        codePenal.add(new CodePenal("Conduite à contre-sens",10000,false,0, 0,""));
        codePenal.add(new CodePenal("Conduite d’un  véhicule endommagé",500,false,0, 0,""));
        codePenal.add(new CodePenal("Conduite hors de la chaussée",10000,false,0, 0,""));
        codePenal.add(new CodePenal("Conduite sans permis de conduire",40000,true,5, 5,""));
        codePenal.add(new CodePenal("Conduite sous état d’ivresse, sous l’emprise de stupéfiant ou de médicament",30000,true,48, 48,""));
        codePenal.add(new CodePenal("Course de rue",10000,false,0, 0,""));
        codePenal.add(new CodePenal("Défaut de feux",500,false,0, 0,""));
        codePenal.add(new CodePenal("Dépassement d’un véhicule prioritaire",5000,false,0, 0,""));
        codePenal.add(new CodePenal("Excès de vitesse",1000,false,0, 0,""));
        codePenal.add(new CodePenal("Klaxon en agglomération sans danger immédiat",2000,false,0, 0,""));
        codePenal.add(new CodePenal("Non respect d’un feu tricolore",1500,false,0, 0,""));
        codePenal.add(new CodePenal("Nuisance sonore du véhicule",750,false,0, 0,""));
        codePenal.add(new CodePenal("Ouverture dangereuse de portière",50,false,0, 0,""));
        codePenal.add(new CodePenal("Possession illégale d’un système hydraulique",2000,false,0, 0,"Immobilisation du véhicule"));
        codePenal.add(new CodePenal("Possession illégale de N.O.S.",10000,false,0, 0,"Immobilisation du véhicule"));
        codePenal.add(new CodePenal("Refus de se soumettre à un dispositif, sonore ou visuel, de contrôle routier",5000,false,2, 2,""));
        codePenal.add(new CodePenal("Stationnement interdit: Véhicule terrestre",1000,false,0, 0,""));
        codePenal.add(new CodePenal("Stationnement interdit: Véhicule aérien",20000,false,0, 0,""));
        codePenal.add(new CodePenal("Stationnement interdit pouvant entraver les autorités publique: Véhicule terrestre",3000,false,0, 0,""));
        codePenal.add(new CodePenal("Téléphone au volant",500,false,0, 0,""));
        codePenal.add(new CodePenal("Traverser en dehors du passage piéton",500,false,0, 0,""));
        codePenal.add(new CodePenal("Utilisation du moteur à des régime excessifs",1350,false,0, 0,""));
    }
}
