
package com.project_logic;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Alpha {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("***********************");
		System.out.println("Welcome to Lockers Pvt. Ltd :)");
		System.out.println("LockedMe.com");
		System.out.println("Developed by Prajwal N");
		System.out.println("***********************");
		File fdir = new File("C:\\PROJECT_DIR");
		fdir.mkdir();
		String Dpath = fdir.getAbsolutePath();
		while(true) {
			System.out.println("Enter 1 to list file:");
			System.out.println("Enter 2 to perform file operation:");
			System.out.println("Enter 3 to exit:");
			int ip = sc.nextInt();
			if(ip == 1) {
				if(fdir.isDirectory()) {
					File[] farray = fdir.listFiles();
					if(farray.length != 0) {
						Arrays.sort(farray);
						for(File i : farray) {
							System.out.println(i.getName());
						}
					}
					else {
						System.out.println("No files present");
					}
				}
				else {
					System.out.println("Directory not found");
				}
				System.out.println("----------------------");
			}
			else if(ip == 2) {
				while(true) {
					System.out.println("Enter a to create file:");
					System.out.println("Enter b to delete file:");
					System.out.println("Enter c to search for a file:");
					System.out.println("Enter * to go back:");
					String ip1 = sc.next();
					if (ip1.equalsIgnoreCase("a")) {
						System.out.println("Enter the Name of the file : ");
						String name = sc.next();
						String filename = Dpath+"\\"+name; 
						File f1 = new File(filename);
						if(f1.createNewFile())
							System.out.println("File "+f1.getName()+" created successfully.");
						else
							System.out.println("File already exists!");
						System.out.println("Enter the data : ");
						FileWriter fw = new FileWriter(filename);
						String filedata = sc.nextLine();
						filedata += sc.nextLine();
						fw.write(filedata);
						fw.close();
						System.out.println("Data written successfully.");
						System.out.println("----------------------");
					}
					else if(ip1.equalsIgnoreCase("b")) {
						System.out.println("Enter the file name to be deleted :");
						String delName = sc.next();
						String dname = Dpath+"\\"+delName;
						File fdel = new File(dname);
						if(fdel.exists()) {
							if(fdel.delete()) {
								System.out.println("File "+fdel.getName()+" deleted successfully.");
							}
							else {
								System.out.println("File could not be deleted");
							}
						}
						else {
							System.out.println("The file does not exists.");
						}
						System.out.println("----------------------");
					}
					else if(ip1.equalsIgnoreCase("c")) {
						System.out.println("Enter the Name of the file : ");
						String sname = sc.next();
						String searchName = Dpath+"\\"+sname;
						File fsearchName = new File(searchName);
						if(fsearchName.exists()) {
							System.out.println("File "+fsearchName.getName()+" exists in location: "+fsearchName.getAbsolutePath());
						}
						else {
							System.out.println("File not found.");
						}
						System.out.println("----------------------");
					}
					else if(ip1.equalsIgnoreCase("*")) {
						System.out.println("----------------------");
						break;
					}
					else {
						System.out.println("Enter valid option");
						System.out.println("----------------------");
					}
				}
			}
			else if(ip == 3){
				System.out.println("Thank you. Have a nice day!");
				System.out.println("----------------------");
				break;
			}
			else {
				System.out.println("Enter valid option");
				System.out.println("----------------------");
			}
		}
		sc.close();
	}

}
