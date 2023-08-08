package Cruise_Ship_Management_Task_one;

import java.util.Scanner;

/**
 *COPYRIGHT(C) Dumindu Induawara Garage. email-gamagedumindui@gamail.com
 * Task I  Management System for a Cruise ship in java.
 * @author Dumindu Induwara Gamage.
 */

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

    /**
     *This method will print the menu to the console.
     * So,I used formatted println for print the menu.
     * */


    }
    public void show_menu()
    {
        System.out.println("""
                M:Show Menu
                V:View all cabins
                E:Display Empty cabins                      
                A:Add a customer to a cabin
                D: Delete customer from cabin
                F: Find cabin from customer name
                S: Store program data into file
                L: Load program data from file
                O: View passengers Ordered alphabetically by name
                X: Exit
                                              
                 """);

    }

    /**
     *This method will show cabin status,whether they are occupied or not occupied by someone.
     *
     * */

    public void View_Cabin_Status()
    {
        for (int i = 0; i < cabin_info.length; i++)
        {
            if (!cabin_info[i].equals("Empty"))
            {
                System.out.println("Cabin "+i+"is occupied by: "+cabin_info[i]);
            }
            else
            {
                System.out.println("Cabin "+ i+" is"+cabin_info[i]);
            }

        }
    }

    /**
     *This method will display Empty cabins.
     *
     **/

    public  void View_Empty_Cabins()
    {
        for (int i = 0; i < cabin_info.length; i++)
        {
            if (cabin_info[i].equals("Empty"))
            {
                System.out.println("Cabin "+i +" is Empty");

            }

        }
    }


    public void Add_a_Customer_to_a_Cabin()
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter a cabin Number(0-11) to add a Customer(Enter 12 to go back):  ");
            int cabin_number= sc.nextInt();

            if (cabin_number==12)
            {

            }
            else if (cabin_info[cabin_number].equals("empty"))
            {

            }



        }
    }




}
