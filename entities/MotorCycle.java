package entities;

public class MotorCycle extends Vehicle {
    private boolean eletricStarter;

    public boolean isEletricStarter() {
        return eletricStarter;
    }

    public void setEletricStarter(boolean eletricStarter) {
        this.eletricStarter = eletricStarter;
    }
    @Override
    public String toString() {
        String EletricStarter;
        if (eletricStarter == true) {
            EletricStarter = "Sim";
        }
        else{
            EletricStarter = "Não";
        }
        return "Tipo: Moto" + " - " + this.getBrand() + " " + this.getModel() + " " + this.getYear() + " - " + "Placa: " + this.getPlate() + " - " + "Part. Elétrica: " + (EletricStarter);
    }
}
