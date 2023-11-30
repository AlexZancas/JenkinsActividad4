import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Trabajador> employeeList = new ArrayList<Trabajador>();
		ArrayList<Trabajador> listaFaltas = new ArrayList<Trabajador>();
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<5; i++) {
			System.out.println("Introduce el nombre del trabajador "+(i+1));
			String nombre = sc.nextLine();
			
			System.out.println("Introduce la posición del trabajador "+(i+1));
			String posicion = sc.nextLine();
			
			System.out.println("Introduce la hora de entrada del trabajador siguiendo el siguiente formato: hh.mm, siendo mm la fracción de minutos");
			double horaEntrada = sc.nextDouble();
			sc.nextLine();
		
			Trabajador trabajador = new Trabajador(nombre, posicion, horaEntrada);
			employeeList.add(trabajador);
		}
		sc.close();
		
		for(int i=0; i<employeeList.size(); i++) {
			String posicion = employeeList.get(i).getPosicion();
			switch (posicion) {
			case "CEO": {
				if(employeeList.get(i).getHoraIngreso() > 7) {
					listaFaltas.add(employeeList.get(i));
				}
				break;
			}
			case "Jefe": {
				if(employeeList.get(i).getHoraIngreso() > 8) {
					listaFaltas.add(employeeList.get(i));
				}	
				break;
				}
			case "Ingeniero": {
				if(employeeList.get(i).getHoraIngreso() > 9) {
					listaFaltas.add(employeeList.get(i));
				}
				break;
			}
			case "Analista": {
				if(employeeList.get(i).getHoraIngreso() > 9) {
					listaFaltas.add(employeeList.get(i));
				}
				break;
			}
			case "Scrum Master": {
				if(employeeList.get(i).getHoraIngreso() > 9) {
					listaFaltas.add(employeeList.get(i));
				}
				break;
			}
			case "RRHH": {
				if(employeeList.get(i).getHoraIngreso() > 9) {
					listaFaltas.add(employeeList.get(i));
				}
				break;
			}
			default:
				System.out.println(employeeList.get(i).getNombre() +" tiene una posición no contemplada");
			}
		}
		String strList = "";
		for(int i =0; i<listaFaltas.size(); i++) {
			strList += listaFaltas.get(i).getNombre()+" - "+listaFaltas.get(i).getPosicion()+"\n";
		}
		String listToText = "La lista de personas con infracciones son \n"+strList;
		String jenkinsText = "pipeline\n{\nagent any\nstages\n{\nstage (\"Hola Mundo!\")\n{\nsteps\n{\nprintln ";
		jenkinsText += listToText+" }\n}\n}\n}";
		File file = new File("./Jenkinsfile");
		

		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			bw.write(jenkinsText);
			bw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
