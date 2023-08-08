package Cruise_Ship_Management_Task_one;

import java.util.Scanner;

public class Main
{
    private final String[] cabin_info=new String[12];

    private static final Main cruise_ship_class=new Main();


    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        for (int i = 0; i <cruise_ship_class.cabin_info.length ; i++)
        {
            cruise_ship_class.cabin_info[i]="Empty";








        }




    }
    public void show_menu()
    {
        System.out.println("""
                M:Show Menu
                A:Add a customer to a cabin
                V:View all cabins
                E: Display Empty cabins
                D: Delete customer from cabin
                F: Find cabin from customer name
                S: Store program data into file
                L: Load program data from file
                O: View passengers Ordered alphabetically by name
                X: Exit
                               
                               
                             
                 """);
    }
}
