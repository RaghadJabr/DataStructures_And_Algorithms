package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import event_registration.participant;
import event_registration.queueEvent;
import locker_allocation.*;
import lost_found_record.list;
import lost_found_record.*;
import room_booking.*;
import student_help.graphUni;
import undo_redo.stack;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		list featureOne = new list();
		queueRoom featureTwo = new queueRoom();
		graphUni featureThree = null;
		stack featureFour = new stack();
		queueEvent featureFive = new queueEvent();
		location featureSix = new location();
		try {
			while (true) {
				System.out.println("\n===== Campus Management System =====");
				System.out.println("1. Are You Looking For Your Lost Items?");
				System.out.println("2. Do You Want to Book a Study Room?");
				System.out.println("3. Navigate In HTU!");
				System.out.println("4. Undo/Redo Room Bookings");
				System.out.println("5. So Many Great Events!! Register Here.");
				System.out.println("6. Do You Want to Reserve a Locaker?");
				System.out.println("0. Exit");
				System.out.print("Select an option: ");
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1 -> LostFoundMenu(featureOne, scanner);
				case 2 -> bookingMenu(featureTwo, scanner);
				case 3 -> {
					if (featureThree == null) {
						graphMenu(featureThree, scanner);
					}
					graphMenu(featureThree, scanner);
				}
				case 4 -> undoRedoMenu(featureFour, scanner);
				case 5 -> registrationMenu(featureFive, scanner);
				case 6 -> lockMenu(featureSix, scanner);
				case 0 -> {
					System.out.println("Goodbye!");
					scanner.close();
					return;
				}
				default -> System.out.println("Invalid option. Please try again.");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input type. Please enter a number.");
		}
	}

	private static void LostFoundMenu(list featureOne, Scanner scanner) {
		while (true) {
			System.out.println("\n--- Lost and Found Menu ---");
			System.out.println("1. Insert Item");
			System.out.println("2. Remove Last Item");
			System.out.println("3. Search by Description");
			System.out.println("4. Print All Items");
			System.out.println("5. How many Items are there?");
			System.out.println("0. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1 -> {
				System.out.print("Enter item description: ");
				String desc = scanner.nextLine();
				System.out.print("Enter location: ");
				String location = scanner.nextLine();
				System.out.print("Enter date of lost: ");
				String date = scanner.nextLine();
				list.addFirst(new records(desc, date, location));
			}
			case 2 -> {
				records removed = featureOne.removeFirst();
				if (removed != null) {
					System.out.println("Removed: " + removed);
				}
			}
			case 3 -> {
				System.out.print("Enter description to search: ");
				String desc = scanner.nextLine();

				boolean foundRecord = featureOne.searchByDescription(desc);
				if (foundRecord == true) {
					System.out.println("Item found");
				} else {
					System.out.println("Item not found");
				}
			}
			case 4 -> featureOne.printList();
			case 5 -> System.out.println(featureOne.size());

			case 0 -> {
				return;
			}
			default -> System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private static void bookingMenu(queueRoom featureTwo, Scanner scanner) {
		while (true) {
			System.out.println(
					"\n--- Room Booking Menu --- \nPlease Note that Booking is Processed Based On Your University Year");
			System.out.println("1. Add Booking");
			System.out.println("2. View All Bookings. Sorted By Priority");
			System.out.println("3. Remove Last Booking");
			System.out.println("4. Search Room By its Number to Check its Availability");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1 -> {
				System.out.print("Enter student ID: ");
				int id = scanner.nextInt();
				System.out.print("Enter Room number: ");
				int room = scanner.nextInt();
				System.out.print("Enter student year (1-7): ");
				int year = scanner.nextInt();
				queueRoom.insert(new booking(id, room, year));
				System.out.println("Booking added.");
			}
			case 2 -> {
				System.out.println("\nCurrent Bookings (Sorted By Priority):");
				queueRoom.printList();
			}
			case 3 -> {
				booking removed = queueRoom.remove();
				if (removed != null) {
					System.out.println("Removed Student ID: " + removed.getStudentId() + ", Room: "
							+ removed.getRoomNumber() + ", Year: " + removed.getYear());
				} else {
					System.out.println("No bookings");
				}
			}
			case 4 -> {
				System.out.print("Enter Room Number to Search: ");
				int num = scanner.nextInt();
				queueRoom.searchRoom(num);
			}
			case 0 -> {
				System.out.println("Exiting...");
				scanner.close();
				return;
			}
			default -> System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private static void graphMenu(graphUni featureThree, Scanner scanner) {
		while (true) {
			int numBuildings;
			graphUni uniGraph = new graphUni(numBuildings =5 );

			uniGraph.addBuilding(0, "Old Building");
			uniGraph.addBuilding(1, "New Building");
			uniGraph.addBuilding(2, "Eman Building");
			uniGraph.addBuilding(3, "Auditorium");
			uniGraph.addBuilding(4, "Workshops");

			uniGraph.addEdge(0, 1, 10);
			uniGraph.addEdge(0, 2, 5);
			uniGraph.addEdge(1, 2, 2);
			uniGraph.addEdge(1, 3, 1);
			uniGraph.addEdge(2, 1, 3);
			uniGraph.addEdge(2, 3, 9);
			uniGraph.addEdge(2, 4, 2);
			uniGraph.addEdge(3, 4, 4);
			uniGraph.addEdge(4, 2, 7);

			while (true) {
				System.out.println("\n=== University Navigation Menu ===");
				System.out.println("1. Print Campus Map");
				System.out.println("2. Find Shortest Path");
				System.out.println("3. Exit");
				System.out.print("Enter your choice: ");

				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					System.out.println("\nCampus Map (Graph):");
					uniGraph.printGraph();
					break;

				case 2:
					System.out.println("\nEnter your current building ID (0 to " + (numBuildings - 1) + "):");
					int source = scanner.nextInt();

					if (source < 0 || source >= numBuildings) {
						System.out.println("Invalid building ID(s). Please try again.");
						break;
					}
					uniGraph.dijkstra(source);

					System.out.println("Note: Distances above are shortest distances from source to all buildings.");
					break;

				case 3:
					System.out.println("Exiting program. Goodbye!");
					scanner.close();
					System.exit(0);
					break;

				default:
					System.out.println("Invalid option. Please choose 1, 2, or 3.");
				}
			}
		}
	}

	private static void undoRedoMenu(stack featureFour, Scanner scanner) {
		while (true) {
			System.out.println("\n--- Undo/Redo Menu ---");
			System.out.println("1. Add Action (e.g., Book/Cancel Room)");
			System.out.println("2. Perform Undo");
			System.out.println("3. Perform Redo");
			System.out.println("4. Print Undo/Redo Status");
			System.out.println("0. Back to Main Menu");
			System.out.print("Select an option: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
			case 1 -> {
				System.out.print("Enter action description (e.g., 'Book Room 101'): ");
				String action = scanner.nextLine();
				featureFour.doAction(action);
			}
			case 2 -> featureFour.undo();
			case 3 -> featureFour.redo();
			case 4 -> featureFour.printUndoRedoStatus();
			case 0 -> {
				return; // Exit to main menu
			}
			default -> System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private static void registrationMenu(queueEvent featureFive, Scanner scanner) {
		while (true) {
			System.out.println("\n--- Student Registration Menu ---");
			System.out.println("1. Register Student");
			System.out.println("2. Remove Next Registration");
			System.out.println("3. Peek Next Registration");
			System.out.println("4. Print All Registrations");
			System.out.println("0. Back to Main Menu");
			System.out.print("Select an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1 -> {
				System.out.print("Enter student ID to register: ");
				int studentId = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter student ID to register: ");
				String studentname = scanner.toString();
				scanner.nextLine();
				queueEvent.enqueue(new participant(studentname, studentId));
			}
			case 2 -> featureFive.dequeue();
			case 3 -> {
				participant next = featureFive.peek();
				System.out.println(next != null ? "Next student ID: " + next : "No registrations available.");
			}
			case 4 -> featureFive.printQueue();
			case 0 -> {
				return;
			}
			default -> System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private static void lockMenu(location featureSix, Scanner scanner) {
		while (true) {
			System.out.println("\n--- Locker Assignment Menu ---");
			System.out.println("1. Assign Locker");
			System.out.println("2. Search Locker by Student ID");
			System.out.println("3. Remove Locker Assignment");
			System.out.println("4. Print All Lockers");
			System.out.println("0. Back to Main Menu");
			System.out.print("Select an option: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1 -> {
				System.out.print("Enter student ID: ");
				int studentId = scanner.nextInt();
				System.out.print("Enter locker number: ");
				int lockerNumber = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				featureSix.insert(new looking(studentId, lockerNumber));
			}

			case 2 -> {
				System.out.print("Enter student ID to search: ");
				int searchId = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				looking result = featureSix.search(searchId);
				if (result != null) {
					System.out.println(
							"Student ID: " + result.getStudentID() + ", Locker Number: " + result.getLockerID());
				} else {
					System.out.println("Locker assignment not found for Student ID: " + searchId);
				}
			}

			case 3 -> {
				System.out.print("Enter student ID to remove locker: ");
				int removeId = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				featureSix.remove(removeId);
				System.out.println("Locker assignment removed (if it existed).");
			}

			case 4 -> {
				System.out.println("All Locker Assignments (In-Order):");
				featureSix.printAll();
			}

			case 0 -> {
				System.out.println("Returning to main menu...");
				return;
			}

			default -> System.out.println("Invalid choice. Try again.");
			}
		}
	}
}
