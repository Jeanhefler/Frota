package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Car;
import entities.MotorCycle;
import entities.Vehicle;

public class VehicleService {
    static Scanner input = new Scanner (System.in);
    private List <Vehicle> dataBase;

    public List<Vehicle> getDataBase() {
        return dataBase;
    }
    public VehicleService(){
        this.dataBase = new ArrayList<>();
    }
    public Car saveCar(Car car) throws Exception{
        for (int i = 0; i < dataBase.size(); i ++){
            if (dataBase.get(i).getPlate().equals(car.getPlate())) {
                throw new Exception("\nNÃO FOI POSSÍVEL CADASTRAR O VEÍCULO\njá existe um veículo com esta mesma placa\nPressione Enter para voltar ao Menu Inicial");
            }
        }
        if (car.getPlate().isEmpty()){
            throw new Exception("\nNÃO FOI POSSÍVEL CADASTRAR O VEÍCULO \nCampo Placa não pode ser em branco\nPressione Enter para voltar ao Menu Inicial");
        }
        if (car.getBrand().isEmpty()){
            throw new Exception("\nNÃO FOI POSSÍVEL CADASTRAR O VEÍCULO \nCampo Marca não pode ser em branco\nPressione Enter para voltar ao Menu Inicial");
        }
        if (car.getModel().isEmpty()){
            throw new Exception("\nNÃO FOI POSSÍVEL CADASTRAR O VEÍCULO \nCampo Modelo não pode ser em branco\nPressione Enter para voltar ao Menu Inicial");
        }
        if (car.getDoors() == 0){
            throw new Exception("\nNÃO FOI POSSÍVEL CADASTRAR O VEÍCULO \nO número de portas não pode ser 0\nPressione Enter para voltar ao Menu Inicial");
        }
        if (car.getYear() == 0){
            throw new Exception("\nNÃO FOI POSSÍVEL CADASTRAR O VEÍCULO \nO ano de lançamento não pode ser 0\nPressione Enter para voltar ao Menu Inicial");
        }
        dataBase.add(car);
        throw new Exception("Veículo cadastrado com sucesso!\nPressione Enter para voltar ao Menu Inicial");
    }
    
    public MotorCycle saveMotorCycle(MotorCycle motorCycle) throws Exception{
        for (int i = 0; i < dataBase.size(); i ++){
            if (dataBase.get(i).getPlate().equals(motorCycle.getPlate())) {
                throw new Exception("\nNÃO FOI POSSÍVEL CADASTRAR O VEÍCULO\njá existe um veículo com esta mesma placa\nPressione Enter para voltar ao Menu Inicial");
            }
        }
        if (motorCycle.getPlate().isEmpty()){
            throw new Exception("\nNÃO FOI POSSÍVEL CADASTRAR O VEÍCULO \nCampo Placa não pode ser em branco\nPressione Enter para voltar ao Menu Inicial");
        }
        if (motorCycle.getBrand().isEmpty()){
            throw new Exception("\nNÃO FOI POSSÍVEL CADASTRAR O VEÍCULO \nCampo Marca não pode ser em branco\nPressione Enter para voltar ao Menu Inicial");
        }
        if (motorCycle.getModel().isEmpty()){
            throw new Exception("\nNÃO FOI POSSÍVEL CADASTRAR O VEÍCULO \nCampo Modelo não pode ser em branco\nPressione Enter para voltar ao Menu Inicial");
        }
        if (motorCycle.getYear() == 0){
            throw new Exception("\nNÃO FOI POSSÍVEL CADASTRAR O VEÍCULO \nO ano de lançamento não pode ser 0\nPressione Enter para voltar ao Menu Inicial");
        }
        dataBase.add(motorCycle);
        throw new Exception("Veículo cadastrado com sucesso!\nPressione Enter para voltar ao Menu Inicial");
    }
    public void find() throws Exception{
        String plate = input.nextLine();
        boolean find = false;
        for (int i = 0; i < dataBase.size(); i ++){
            if (dataBase.get(i).getPlate().equals(plate)) {
                System.out.println("Veículo "+ dataBase.get(i));
                find = true;
                throw new Exception("Pressione Enter para voltar ao Menu Inicial");
            }
        }
        if (find == false) {
            throw new Exception("Veículo não encontrado com a placa informada\nPressione Enter para voltar ao Menu Inicial");
        }
    }
    public void remove() throws Exception{
        boolean remove = false;
        String plate = input.nextLine();
        for(int i = 0; i < dataBase.size(); i ++){
            if (dataBase.get(i).getPlate().equals(plate)) {
                dataBase.remove(i);
                remove = true;
                throw new Exception("Veículo removido com sucesso!\nPressione Enter para voltar ao Menu Inicial");
            }
        }
        if (remove == false) {
            throw new Exception("Veículo não encontrado com a placa informada\nPressione Enter para voltar ao Menu Inicial");
        }
    }
}
