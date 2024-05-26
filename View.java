import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Car;
import entities.MotorCycle;
import entities.Vehicle;
import services.VehicleService;

public class View {
    public static VehicleService VehicleService;
    static Scanner input;
    static int option;
    public static void main(String[] args) throws Exception {
        VehicleService = new VehicleService();
        input = new Scanner(System.in);
        do {
            System.out.println("Sistema de Gerenciamento de Frotas");
            System.out.println("MENU DE OPÇÕES:");
            System.out.println("1 - Cadastrar Novo Veículo");
            System.out.println("2 - Listar todos os Veículos");
            System.out.println("3 - Pesquisar Veículo por Placa");
            System.out.println("4 - Remover Veículo");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            do {
                try {
                    option = input.nextInt();
                    input.nextLine();
                    if (option >=0 && option <= 4) {
                        break;
                    }
                    else{
                        System.out.print("Digite um número dentro das Opções acima: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Digite um número dentro das Opções acima: ");
                    input.nextLine();
                }
            } while (true);
            if (option == 0) {
                System.out.print("\033[H\033[2J");
                break;
            }
            else if (option == 1) {
                save();
            }
            else if (option == 2) {
                list();
            }
            else if (option == 3) {
                find();
            }
            else if (option == 4) {
                remove();
            }
        } while (true);
    }
    public static void save(){
        System.out.print("\033[H\033[2J");
        System.out.println("CADASTRO DE VEÍCULO");
        System.out.println("Qual o tipo de veículo");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.print("Digite a opção desejada: ");
        do {
            try {
                option = input.nextInt();
                input.nextLine();
                if (option >=1 && option <= 2) {
                    break;
                }
                else{
                    System.out.print("Digite um número dentro das Opções acima: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Digite um número dentro das Opções acima: ");
                input.nextLine();
            }
        } while (true);
        if (option == 1) {
            Car newCar = new Car();
            System.out.print("Digite a placa do carro: ");
            newCar.setPlate(input.nextLine());
            System.out.print("Digite a marca do carro: ");
            newCar.setBrand(input.nextLine());
            System.out.print("Digite o modelo do carro: ");
            newCar.setModel(input.nextLine());
            System.out.print("Digite o número de portas: ");
            do {
                try {
                    newCar.setDoors(input.nextInt());
                    input.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Digite um número de portas válido: ");
                    input.nextLine();
                }
            } while (true);
            System.out.print("Digite o ano do carro: ");
            do {
            try {
                newCar.setYear(input.nextInt());
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Digite um ano válido: ");
                input.nextLine();
            }
            } while (true);
            try {
            VehicleService.saveCar(newCar);
            } catch (Exception e) {
            System.out.println(e.getMessage());
            input.nextLine();
            }
            System.out.print("\033[H\033[2J");
        }
        else if (option == 2) {
            MotorCycle newMotorCycle = new MotorCycle();
            System.out.print("Digite a placa da moto: ");
            newMotorCycle.setPlate(input.nextLine());
            System.out.print("Digite a marca da moto: ");
            newMotorCycle.setBrand(input.nextLine());
            System.out.print("Digite o modelo da moto: ");
            newMotorCycle.setModel(input.nextLine());
            System.out.print("A moto possui partida elétrica: ");
            do {
                try {
                    System.out.print("1-Sim, 2-Não: ");
                    option = input.nextInt();
                    input.nextLine();
                    if (option == 1) {
                        newMotorCycle.setEletricStarter(true);
                    }
                    else{
                        newMotorCycle.setEletricStarter(false);
                    }
                    if (option >=1 && option <= 2) {
                        break;
                    }
                    else{
                        System.out.print("Digite um número dentro das Opções: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("O valor deve ser um número inteiro: ");
                    input.nextLine();
                }
            } while (true);
            System.out.print("Digite o ano da moto: ");
            do {
                try {
                newMotorCycle.setYear(input.nextInt());
                input.nextLine();
                break;
                } catch (InputMismatchException e) {
                System.out.print("Digite um ano válido: ");
                input.nextLine();
                }
            } while (true);
            try {
                VehicleService.saveMotorCycle(newMotorCycle);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
            System.out.print("\033[H\033[2J");
        }
    }
    public static void list(){
        List<Vehicle> Vehicles = VehicleService.getDataBase();
        int i = 1;
        System.out.print("\033[H\033[2J");
        System.out.println("LISTA DE VEÍCULOS CADASTRADOS");
        for ( Vehicle vehicle : Vehicles){
            System.out.println("Veículo "+i+" - "+ vehicle);
            i ++;
        }
        System.out.println("Pressione Enter para voltar ao Menu Inicial");
        input.nextLine();
        System.out.print("\033[H\033[2J");
    }
    public static void find() throws Exception{
        System.out.print("\033[H\033[2J");
        System.out.println("PESQUISA DE VEÍCULO POR PLACA");
        System.out.print("Informe a placa que deseja pesquisar: ");
        try {
            VehicleService.find();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            input.nextLine();
            System.out.print("\033[H\033[2J");
        }
    }
    public static void remove(){
        int i = 1;
        List<Vehicle> Vehicles = VehicleService.getDataBase();
        System.out.print("\033[H\033[2J");
        System.out.println("REMOÇÃO DE VEÍCULOS");
        System.out.println("LISTA DE VEÍCULOS CADASTRADOS");
        for ( Vehicle vehicle : Vehicles){
            System.out.println("Veículo "+i+" - "+ vehicle);
            i ++;
        }
        System.out.print("Informe a placa do veículo que deseja REMOVER: ");
        try {
            VehicleService.remove();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            input.nextLine();
            System.out.print("\033[H\033[2J");
        }
    }
}
