package Cruise_Ship_Management_Task_one;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *COPYRIGHT(C) Dumindu Induawara Gamage. email-gamagedumindui@gamail.com
 *Task I  Management System for a Cruise ship in java.
 *@author Dumindu Induwara Gamage.
 *@version 1 2023.08.15
 */

public class Main
{
    private final String[] cabin_info=new String[12];  //Declare an array of Cabin objects named cabinsArray with a size of 12 We use "final" for the cabinsInfo array,
                                                       // but even though it's marked as final, it doesn't prevent modification or deletion of its elements. This is because
                                                      // arrays are references to memory locations rather than containers of values. When objects or arrays are marked final,
                                                     // their reference variables cannot be reassigned to point to a different object or array. In the case of arrays, we
                                                     // cannot assign a new array to cabinsArray since it's marked as final.



    private static final Main cruise_ship_class=new Main(); // Define a final static instance of the Main class named cruiseShipClass.
                                                             //This variable is static, allowing all methods,
                                                             // including main(), to access it.

    private final String fileName = "Cabin_info.txt";      // Declare a final string variable named fileName to hold a file name.

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        for (int i = 0; i <cruise_ship_class.cabin_info.length ; i++)
        {
            cruise_ship_class.cabin_info[i]="Empty";
        }
        cruise_ship_class.show_menu();
        while(true)
        {
            System.out.println("Enter your option: ");
            String user_Input=String.valueOf(sc.next().charAt(0)).toUpperCase();
            cruise_ship_class.call_Actions(user_Input);

        }

    }
    /**
     *This method will print the menu to the console.
     * So,I used formatted println for print the menu.
     * */
    public void show_menu()
    {
        System.out.println("""
                M:Show Menu
                V:View all cabins
                E:Display Empty cabins                      
                A:Add a customer to a cabin
                D:Delete customer from cabin
                F:Find cabin from customer name
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
                System.out.println("Cabin "+ i+" is "+cabin_info[i]);
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

    /**
     * This method will Add_a_Customer to a cabin
     *it will ask a cabin number which you hope to add a customer to cabin
     *if the give cabin is empty it will add customer to a cabin or otherwise print
     */


    public void Add_a_Customer_to_a_Cabin()
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter a cabin Number(0-11) to add a Customer(Enter 12 to go back):  ");  // Prompt the user to enter a cabin number.
            int cabin_number= sc.nextInt();

            if (cabin_number==12)        // Prompt the user to enter a cabin number.
            {

            }
            else if (cabin_info[cabin_number].equals("empty"))                             // The selected cabin is empty,
            {
                System.out.println("Enter Customer Name for Cabin "+cabin_number+" :");  // prompt for customer name and assign the cabin.
                String Cabin_Customer_Name= sc.next();
                cabin_info[cabin_number]=Cabin_Customer_Name.toUpperCase();
                System.out.println("Customer " + Cabin_Customer_Name.toUpperCase() + " Added to Cabin " + cabin_number + " Successfully");

            }
            else
            {
                System.out.println("This Cabin is Already occupied by " + cabin_info[cabin_number]);
                Add_a_Customer_to_a_Cabin();
            }


        }
        catch (Exception e)
        {
            System.out.println("The Entered Value can't be proceed. Please Enter a valid Cabin Number. Error :" + e);
            Add_a_Customer_to_a_Cabin();
            // if any exception occurred when adding a customer, then allow user to add a customer again.
        }
    }

    /**
     *deleteCustomer method will delete customer from cabin
     *if the given cabin is empty then show a message that cabin is already empty, otherwise it will delete customer record.
     */

    public void deleteCustomer()
    {
        try
        {
            Scanner sc=new Scanner(System.in); // Create a new Scanner object to read input from the console.
            System.out.println("Enter a cabin Number(0-11) to delete (Enter 12 to go back): "); //prompt user to enter the cabin number user want to delete
            int cabin_number= sc.nextInt();  //read the user entered input using newly created ' sc' object and store it variable called cabin number as an integer.

            if (cabin_number==12)
            {
                /**
                 * if cabin_number 12 do nothing and allow method to end without doing anything.
                 * This option allows the user to go back without deleting a customer.
                 */

            }
            else if (cabin_number<cabin_info.length)
            {
                if (cabin_info[cabin_number].equals("Empty")) // Check if the selected cabin is already empty
                {
                    System.out.println("Cannot fulfill deletion request "+cabin_number+" is already empty");  //then show a message to the console

                }
                else
                {
                    cabin_info[cabin_number]="Empty";        //make cabin empty.this deletion point in this method.it will set the specified cabin number into empty cabin.
                    System.out.println("Customer deleted successfully."); //this will tell user deletion process is successful.

                }
            }
            else
            {
                System.out.println("The Entered Cabin Number Does Not Exist"); //if the user entered cabin number does not exist then
                deleteCustomer(); //allow user to do the deletion process again using concept recursion.
                                  // Recursively call deleteCustomer() to handle the incorrect input
            }

        }
        catch (Exception e)
        {
            System.out.println("The Entered cabin number is Invalid.Hint:You cannot enter a alphabetical character. Error :" + e);
            deleteCustomer(); // Recursively call deleteCustomer() to handle the exception
        }
    }

    /**
     * find_Customer_From_Name method will find any customer with his name
     *
     */

    public void find_Customer_From_Name()
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the name you want to find:  ");
            String Name_to_find=sc.next();
            boolean found_customer=false;
            for (int i = 0; i <cabin_info.length ; i++)
            {
                if(Name_to_find.toUpperCase().equalsIgnoreCase(cabin_info[i]))
                {
                    System.out.println("Customer name found in the array"+ Name_to_find.toUpperCase()+"Located in Cabin "+i);
                    found_customer=true;


                }
            }
            if (!found_customer)
            {
                System.out.println("You entered customer cannot found.Please check the name again.Enter the name correctly");
                find_Customer_From_Name();

            }

        }
        catch(Exception e)
        {
            System.out.println("Entered Named is not valid.Error: "+e);
            find_Customer_From_Name();

        }
    }

    public void Save_to_file()
    {
        try
        {
            StringBuilder Text_to_write=new StringBuilder(); //In here i created a String Builder to efficiently construct and manipulate strings
                                                             //when you need to perform multiple concatenation or modification operations,
            FileWriter my_writer=new FileWriter( fileName);

            for (int i = 0; i < cabin_info.length ; i++)
            {
                if (cabin_info[i].equals("Empty"))
                {
                    Text_to_write.append("Cabin").append(i).append("is").append(cabin_info[i]).append("\n");

                }
                else
                {
                    Text_to_write.append("Cabin").append(i).append("is Occupied by").append(cabin_info[i]).append("\n");
                }
                my_writer.write(Text_to_write.toString());
                my_writer.close();
                System.out.println("Relevant information successfully wrote to the "+fileName+" file");

            }


        }
        catch(IOException e)
        {
            System.out.println("An error occurred while writing to the file "+e);

        }

    }

    /**
     * Load_from_file method will load data from the Cabin_info.txt and it will print the data to the console.
     */

    public void Load_from_file()
    {
        File inputFile=new File(fileName);
        try
        {
            Scanner reader=new Scanner(inputFile);
            while (reader.hasNext())
            {
                System.out.println(reader.nextLine());
            }
            reader.close();

        }
        catch (IOException e)
        {
            System.out.println("An Error Occurred While Reading The File. Error :" + e);

        }


    }

    /**
     *OrderAlphabetically method will sort the Customer Names Alphabetically and Print Name
     *In here i used Bubble sort as the basic sorting algorithms for this program.
     */

    public void OrderAlphabetically()
    {
        String[] cabinNamesOrdered=cabin_info.clone(); // Create a clone of the cabinsInfo array and initialize it as cabinNamesOrdered.
        for (int i = 0; i < cabinNamesOrdered.length; i++)  // Outer loop iterating through the cabinNamesOrdered array.
        {
            for (int j = 0; j <cabinNamesOrdered.length-(i+1) ; j++) // Inner loop iterating through unsorted portion of cabinNamesOrdered.
            {
                // Compare adjacent elements using the compareNames method.
                // If the result is 1, swap the elements to arrange in alphabetical order.
                if (CompareNames(cabinNamesOrdered[j],cabinNamesOrdered[j+1])==1)
                {
                    String temp=cabinNamesOrdered[j];
                    cabinNamesOrdered[j]=cabinNamesOrdered[j+1];
                    cabinNamesOrdered[j]=temp;
                }
                boolean check=false;
                for(String s:cabinNamesOrdered)
                {
                    if (!s.equals("Empty"))
                    {
                        System.out.println(s);
                        check = true;

                    }
                }

                if (!check)
                {
                    System.out.println("All Cabins are Empty. Nothing to Sort.");

                }
            }
        }
    }

    public int CompareNames(String first,String second)
    {
        int len;

        if (first.length()>=second.length())
        len=second.length();
        else
        len=first.length();

        for (int i=0;i<len;i++)
        {
            if (first.charAt(i)>second.charAt(i))
                return 1;
            else if(first.charAt(i)<second.charAt(i))
                return -1;
        }
        return 0;
    }

    /**
     * exit method will terminate the program using exit code 0
     */

    public void exit()
    {
        System.exit(0);
    }

    public void call_Actions(String user_Input)
    {
        //enhanced switch case
        switch (user_Input)
        {
            case "M"->show_menu();
            case "A"->Add_a_Customer_to_a_Cabin();
            case "V"->View_Cabin_Status();
            case "E"->View_Empty_Cabins();
            case "D"->deleteCustomer();
            case "F"->find_Customer_From_Name();
            case "S"->Save_to_file();
            case "L"->Load_from_file();
            case "O"->OrderAlphabetically();
            case "X"->exit();
            default -> System.out.println("Invalid Input.Please enter a valid input.");



        }

    }










}
