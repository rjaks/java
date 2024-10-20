package Seatworks.LW9;

class InstantNoodles {
    private String brand, flavor, type, currentStatus;
    private String[] status = {"Raw", "Cooked", "Overcooked"};
    private int calories;
    private boolean isOpened;

    InstantNoodles(String inpBrand, String inpFlavor, String inpType, int inpCalories){        
        brand = inpBrand;
        flavor = inpFlavor;
        type = inpType;
        calories = inpCalories;
        currentStatus = status[0];
        isOpened = false;
    }

    String getBrand(){ return brand; }
    String getFlavor(){ return flavor; }
    String getType(){ return type; }
    String getStatus(){ return currentStatus; }
    int getCalories(){ return calories; }
    String getOpenedString(){ if(isOpened) return "Opened"; else return "Closed"; }

    void display(){
        System.out.printf("Brand: %s \nFlavor: %s\nType: %s\nCalories: %d\nStatus: %s\nOpened: %s\n", getBrand(), getFlavor(), getType(), getCalories(), getStatus(), getOpenedString());
    }

    void open(){
        if(this.getOpenedString() == "Closed") { isOpened = true; System.out.println("Noodle opened."); }
        else if (this.getOpenedString() == "Open") System.out.println("Noodle is already opened."); 
    }

    void cook(){
        if (this.getStatus() == "Raw") { currentStatus = status[1]; System.out.println("Successfully cooked the noodle!"); }
        else if (this.getStatus() == "Cooked") { currentStatus = status[2]; System.out.println("Successfully cooked the noodle!"); }
        else if (this.getStatus() == "Overcooked") System.out.println("Can't cook the Noodle anymore!");
    }
}

class LW9{
    public static void main(String[] args){
        InstantNoodles q = new InstantNoodles("Lucky Me", "Calamansi", "Canton", 235);
        q.display();
    }
}