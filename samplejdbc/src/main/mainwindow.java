package main;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.mob;
import service.MobileService;
import service.MobileServiceImpl;

public class mainwindow {
	public static void main(String[] args) {
		boolean doflag = false;
		boolean vflag = false;
		DateTimeFormatter formatter = null;
		LocalDate date = null;
		LocalDate joindate = null;
		int Mobid = 0;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("WELCOME TO  mobile world");
			System.out.println("1. buymobile");
			System.out.println("2. exit");
			System.out.println("Choose ");
			int choices;
			try {
				choices = scanner.nextInt();
				scanner.nextLine();
				if (choices > 0 && choices < 3) {
					doflag = true;
					switch (choices) {
					case 1:
						System.out.println("nihal mobile store");
						MobileService service = new MobileServiceImpl();
						try {
							List<mob> list = service.getAllEmployee();
							if (list.size() > 0) {
								System.err.println(
										"productID" + "		" + "product NAME" + "		" + "quantity" + "		");
								for (mob m : list) {
									System.out.println(
											m.getMobid() + "		" + m.getProcname() + "		" + m.getQuantity());
								}
								String name;
								do {
									System.out.println("Enter Your First Name");
									name = scanner.nextLine();
									boolean valflag = service.getvaldate(name);
									if (valflag == true)
										vflag = valflag;
									else
										System.err.println("Name should be Alphabet");

								} while (!vflag);
								int model;
								String prodname = null;

								do {
									vflag = false;
									scanner = new Scanner(System.in);
									System.out.println("Select Your product");
									System.out.println("1.Sony");
									System.out.println("2.oneplus");
									System.out.println("3.redmi");
									System.out.println("4.nokia");
									System.out.println();
									System.out.println("Select Your Choice");
									try {
										model = scanner.nextInt();
										if (model >= 1 && model <= 4) {
											vflag = true;
											scanner.nextLine();
											switch (model) {
											case 1:
												prodname = "sony";
												Mobid = 1;
												break;
											case 2:
												prodname = "oneplus";
												Mobid = 2;
												break;
											case 3:
												prodname = "redmi";
												Mobid = 3;
												break;
											case 4:
												prodname = "nokia";
												Mobid = 4;
											default:
												System.err.println("Invalid Selection");
												break;
											}

										}
									} catch (InputMismatchException e) {
										System.err.println("INPUT SHOULD BE INTEGER");
									}

								} while (!vflag);
								int quan = 0;
								vflag = false;
								do {
									System.out.println("Enter Quantity");
									quan = scanner.nextInt();
									int value = service.getQuantity(Mobid);
									if (quan < value) {
										vflag = true;
									} else {
										System.out.println("enter quantity above that we have");
									}

								} while (!vflag);
								String dob;
								do {
									scanner.nextLine();
									System.out.println("date of birth (dd-MM-yyyy)");
									dob = scanner.nextLine();

									formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

									try {
										date = LocalDate.parse(dob, formatter);
									} catch (DateTimeParseException e) {
										vflag = false;
										System.err.println(
												"date is not in the given format, give the date in dd-MM-yyyy format ");
									}
								} while (!vflag);

								mob m = new mob();
								m.setMobid(Mobid);
								m.setCustname(name);
								m.setProdname(prodname);
								m.setQuantity(quan);
								m.setBuydate(date);
								try {
									int insert = service.insertcust(m);
									System.out.println("insert" + insert);
								} catch (Exception e) {
									System.err.println("insert service is not established" + e);
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 2:
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Selection Try Again");
						System.out.println();
						doflag = false;
						break;
					}
				} else {
					System.err.println("PLEASE ENTER VALID OPTION RANGE(1-3)");
					doflag = false;
				}
			} catch (InputMismatchException e) {
				System.err.println("INPUT MUST BE INTEGER");
			}
		} while (!doflag);
	}
}
