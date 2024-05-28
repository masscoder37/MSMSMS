import java.text.DecimalFormat;
import java.util.ArrayList;


//this class is a subclass of Ion
    //fragment ions of peptides are an object of this class
public class FragmentIon extends Ion {
    private String precursorSequence;
    private char ionSeries;
    private int ionNumber;
    private boolean isModified;
    //implement new variables for modifications
    private ArrayList<AminoAcid> aminoAcidsList;

    private static DecimalFormat fiveDec = new DecimalFormat("0.00000");


    public FragmentIon(SumFormula sumFormulaIn, int chargeIn, Peptide peptideIn, char ionSeriesIn, int ionNumberIn, boolean modificationStatus, ArrayList<AminoAcid> aaCompositionIn){
        super(sumFormulaIn, chargeIn);
        this.precursorSequence = peptideIn.getSequence();
        this.ionSeries = ionSeriesIn;
        this.ionNumber = ionNumberIn;
        this.isModified = modificationStatus;
        this.aminoAcidsList = aaCompositionIn;
    }


    //getter
    public String getPrecursorSequence(){return this.precursorSequence;}
    public char getIonSeries(){return this.ionSeries;}
    public int getIonNumber(){return this.ionNumber;}
    public String getCompleteIon(){return ""+this.ionSeries+this.ionNumber;}
    public boolean getModificationStatus(){return this.isModified;}
    public ArrayList<AminoAcid> getAminoAcidsList(){return this.aminoAcidsList;}

    //getter for fragment ion label properties
    //does the fragment ion has a label at all?
    public boolean getLabelStatus(){
        boolean hasLabel = false;
        for (AminoAcid aa : this.aminoAcidsList){
            if(aa.getModification()!=null) {
                if (aa.getModification().getLabelStatus())
                    hasLabel = true;
            }
        }
        return hasLabel;
    }

    public boolean getCleavedLabelStatus(){
        boolean hasCleavedLabel = false;
        for (AminoAcid aa : this.aminoAcidsList){
            if(aa.getModification()!=null) {
                if (aa.getModification().getLabelStatus()){
                    if (aa.getModification().getCleavedStatus())
                        hasCleavedLabel = true;
                }
            }
        }
        return hasCleavedLabel;
    }
    //how many labels are there in the fragment ion
    public int getLabelQuantity(){
        int labelQuantity = 0;
        for (AminoAcid aa : this.aminoAcidsList) {
            if (aa.getModification() != null) {
                if (aa.getModification().getLabelStatus())
                    labelQuantity++;
            }
        }
        return labelQuantity;
    }

    //is the modification mixed, e.g. contains cleaved and intact tmt?
    //true: mixed
    public boolean getLabelMixingStatus(){
        boolean isMixed = false;
        ArrayList<String> mixList = new ArrayList<>();
        for (AminoAcid aa : this.aminoAcidsList) {
            if (aa.getModification() != null) {
                if (aa.getModification().getLabelStatus()){
                    if(aa.getModification().getCleavedStatus())
                        mixList.add("cleaved");
                    else
                        mixList.add("intact");
                }
            }
        }
        if (mixList.contains("cleaved")&&mixList.contains("intact"))
            isMixed = true;
        return isMixed;
    }
    public int getNumberOfCleavedLabels() {
        int cleavedLabels = 0;
        for (AminoAcid aa : this.aminoAcidsList) {
            if (aa.getModification() != null) {
                if (aa.getModification().getLabelStatus()) {
                    if (aa.getModification().getCleavedStatus())
                        cleavedLabels++;
                }
            }
        }
        return cleavedLabels;
    }





    //returns the labeled amino acids
     public ArrayList<AminoAcid> getLabelAAs(){
        ArrayList<AminoAcid> labeledAAs = new ArrayList<>();
         for (AminoAcid aa : this.aminoAcidsList) {
             if (aa.getModification() != null) {
                 if (aa.getModification().getLabelStatus())
                     labeledAAs.add(aa);

             }
         }
         return labeledAAs;
     }

     //returns amino acid sequence
    public String getAASequence(){

        String sequence = "";
        for (AminoAcid acid : this.aminoAcidsList){
            sequence += acid.get1Let();
        }
        if (this.getIonSeries() == 'y')
            sequence = new StringBuilder(sequence).reverse().toString();

        return sequence;
    }







    public static void fragmentIonPrinter(FragmentIon queriedIon){

        System.out.print(""+queriedIon.ionSeries+queriedIon.ionNumber+" "
                +queriedIon.getCharge()+"+"
                +":    "+fiveDec.format(queriedIon.getMToZ())+" m/z"
        +"   is modified: "+queriedIon.getModificationStatus());
        System.out.println("    Sequence: "+queriedIon.getAASequence());

    }
    public static void fragmentIonFormulaPrinter(FragmentIon queriedIon){

        System.out.println(""+queriedIon.ionSeries+queriedIon.ionNumber+" "+queriedIon.getCharge()+"+"+":    "+queriedIon.getFormula().getSumFormula());
    }




}
