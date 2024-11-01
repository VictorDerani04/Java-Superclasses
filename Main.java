class Pie{
    public String description;
    public double cost;
    public static double price = 0;

    public Pie(){}

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("%-10s", "Cost: ") + this.cost + "\n" +
                String.format("%-10s", "Description") + this.description;
    }
}

class Pizza extends Pie{
    private String toppings;
    private int size;
    private double tempCost;

    public Pizza(String toppings, int size){
        super();
        this.toppings = toppings;
        this.size = size;
        setToppings(this.toppings);
        setDescription(this.toppings,this.size);
        setSize(size);
        price += tempCost;
        setCost();
    }

    public String getToppings() {
        return toppings;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        if(size == 14){
            tempCost += 12;
        }
        else{
            tempCost += 16;
        }
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
        if(toppings.contains(",") && size==14){
            int counter = 0;
            for(int i = 0; i<toppings.length()-1; i++){
                if(toppings.substring(i,i+1).equals(",")){
                    counter += 1;
                }
            }
            counter += 1;
            tempCost += counter;
        }

        else if(toppings.contains(",") && size==18){
            int counter = 0;
            for(int i = 0; i<toppings.length()-1; i++){
                if(toppings.substring(i,i+1).equals(",")){
                    counter += 2;
                }
            }
            counter += 2;
            tempCost += counter;
        }

        else if(size==14){
            tempCost += 1;
        }

        else{
            tempCost += 2;
        }
    }

    public void setDescription(String toppings, int size) {
        super.setDescription(size + toppings);
    }

    public void setCost() {
        super.setCost(tempCost);
    }

    @Override
    public String toString() {
        return String.format("%-10s", "Cost: ") + this.cost + "\n" +
                String.format("%-10s", "Description: ") + this.description;
    }
}

class Dessert extends Pie{
    public Dessert(String description, double cost){
        super();
        this.description = description;
        this.cost = cost;
        price += cost;
    }

    @Override
    public String toString() {
        return String.format("%-10s", "Cost: ") + this.cost + "\n" +
                String.format("%-10s", "Description: ") + this.description;
    }
}

class Main{
    public static void main (String[] args){
        Pizza order1 = new Pizza("' with anchovies, olives", 18);
        Pizza order2 = new Pizza("' with peperoni", 14);
        Dessert order3 = new Dessert("Small Peaches & Cream", 5);
        Dessert order4 = new Dessert("Large Pumpkin cheesecake", 7);
        Pie price = new Pie();

        System.out.println("--------- Your Pi-R-Squared Order ---------");
        System.out.println("PIZZA\n" + order1);
        System.out.println("PIZZA\n" + order2);
        System.out.println("DESSERT\n" + order3);
        System.out.println("DESSERT\n" + order4);
        System.out.println("Your bill: " + price.getPrice());
    }
}