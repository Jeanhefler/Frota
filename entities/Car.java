package entities;


public class Car extends Vehicle {
    private int doors;

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
@Override
public String toString() {
    return "Tipo: Carro"+ " - " + this.getBrand() + " " + this.getModel() + " " + this.getYear() + " - " + "Placa: " +  this.getPlate() + " - " + "N. Portas: " + this.getDoors();
}
}
