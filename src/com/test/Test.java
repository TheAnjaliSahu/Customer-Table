package com.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.CustomerDAO;
import com.dto.CustomerDTO;

public class Test {

	private static final boolean Accno = false;

	public static void main(String[] args) throws Exception {
		CustomerDTO cm = new CustomerDTO();
		Scanner sc = new Scanner(System.in);
		int choice;
		int accno;
		CustomerDTO e;
		while (true) {
			System.out.println("1. Insert Customer");
			System.out.println("2. Delete Customer");
			System.out.println("3. Update Customer");
			System.out.println("4. Select Customer");
			System.out.println("5. SelectAll Customer");
			System.out.println("Enter your Choice");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				e = new CustomerDTO();
				System.out.println("Enter Account no.");
				e.setAccno(sc.nextInt());
				sc.nextLine();
				System.out.println("Enter Cusomer Name");
				e.setCname(sc.nextLine());
				System.out.println("Enter Balance");
				e.setBalance(sc.nextDouble());
				sc.nextLine();
				System.out.println("Enter Phone");
				e.setPhone(sc.nextLine());

				if (CustomerDAO.insertCustomer(e))
					System.out.println("Customer insert Successfully");
				else
					System.out.println("Failed insertion");
				break;

			case 2:
				System.out.println("Enter Account ");
				accno = sc.nextInt();
				if (CustomerDAO.deleteCustomer(accno))
					System.out.println("Employee Delete SuccessFully");
				else
					System.out.println("Failed Delete");
				break;

			case 3:
				e = new CustomerDTO();
				System.out.println("Enter Account no");
				e.setAccno(sc.nextInt());
				System.out.println("Enter Customer name");
				sc.nextLine();
				e.setCname(sc.nextLine());
				System.out.println("Enter Balance");
				e.setBalance(sc.nextDouble());
				sc.nextLine();
				System.out.println("Enter Phone");
				e.setPhone(sc.nextLine());

				if (CustomerDAO.updateCustomer(e))
					System.out.println("Employee Update SuccessFully");
				else
					System.out.println("Failed Update");
				break;

			case 4:
				System.out.println("Enter Account");
				accno = sc.nextInt();
				System.out.println(CustomerDAO.selectCustomer(accno));
				break;

			case 5:
				ArrayList<CustomerDTO> al = CustomerDAO.selectAllCustomer();
				if (al.isEmpty())
					System.out.println("No any employee found");

				for (CustomerDTO item : al) {
					System.out.println(item);
				}

			}

		}
	}
}
