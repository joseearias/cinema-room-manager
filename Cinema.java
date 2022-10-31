import java.util.Scanner;

public class Cinema {
    public static void statistics(int totalTickets, int ticketsSold, int income, int totalIncome) {
        float percentage = 100 / (float) totalTickets * (float) ticketsSold;
        
        System.out.printf("Number of purchased tickets: %d\n", ticketsSold);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.printf("Current income: $%d\n", income);
        System.out.printf("Total income: $%d\n", totalIncome);
    }
    
    public static void showSeats(String[][] cinemaSeats, int rows, int seats) {
        System.out.println("Cinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                System.out.print(cinemaSeats[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int buyTicket(String[][] cinemaSeats, int totalSeats, int rows, int seats) {
        int rowNumber, seatNumber;
        
        boolean flag = true;
        do {
            System.out.println("Enter a row number:");
            rowNumber = scanner.nextInt();
        
            System.out.println("Enter a seat number in that row:");
            seatNumber = scanner.nextInt(); 

            if (rowNumber > rows || seatNumber > seats) {
                System.out.println("Wrong Input!");
            } else if (cinemaSeats[rowNumber][seatNumber] == "B") {
                System.out.println("The ticket has already been purchased!");
            } else {
                flag = false;
            }
        } while (flag);
        
        int ticketCost;
        
        if (totalSeats <= 60) {
            ticketCost = 10;
        } else {
            if (rowNumber <= rows / 2) {
                ticketCost = 10;
            } else {
                ticketCost = 8;
            }
        }

        System.out.print("Ticket price: ");
        System.out.println("$" + ticketCost);
        
        cinemaSeats[rowNumber][seatNumber] = "B";

        return ticketCost;
    }
    
    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        
        String[][] cinemaSeats = new String[rows + 1][seats + 1];

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (i == 0) {
                    cinemaSeats[i][j] = j == 0 ? " " : Integer.toString(j);
                } else {
                    cinemaSeats[i][j] = j == 0 ? Integer.toString(i) : "S";
                }
            }
        }
        
        showSeats(cinemaSeats, rows, seats);

        int totalSeats = rows * seats;
        int frontSeats = (rows / 2) * seats;
        int backSeats = totalSeats - frontSeats;
        
        int choice = 1;
        int income = 0;
        int ticketsSold = 0;
        int totalIncome;

        if (totalSeats <= 60) {
            totalIncome = totalSeats * 10;
        } else {
            totalIncome = frontSeats * 10 + backSeats * 8;
        }
        
        while (choice != 0) {
            System.out.println("1. Show the Seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    showSeats(cinemaSeats, rows, seats);
                    break;
                case 2:
                    income += buyTicket(cinemaSeats, totalSeats, rows, seats);
                    ticketsSold += 1;
                    break;
                case 3:
                    statistics(totalSeats, ticketsSold, income, totalIncome);
                    break;
                case 0:
                    break;
                    
            }
        }
    }
    static Scanner scanner = new Scanner(System.in);
}
