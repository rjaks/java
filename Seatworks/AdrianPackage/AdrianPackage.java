class AdrianPackage{
    public static void main(String[] args){
        Package adri = new Package();
        adri.displayWeight();
        adri.addWeight(85.0);
        adri.displayWeight();
        Package chi = new Package(52.0);
        chi.displayWeight();
    }
}

class Package{
    private double weight;

    public Package(){
        weight = 0.0;
    }
    public Package(double weight_param){
        weight = weight_param;
    }
    public void addWeight(double weight_param){ weight = weight_param; }
    public void displayWeight(){ System.out.println(weight); }
}