import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SearchMethods {
    public static void main(String[] args) {
        ArrayList<Currency> currencies = new ArrayList<Currency>();
        ArrayList<Currency> currencies2 = new ArrayList<Currency>();
        ArrayList<Currency> currencies3 = new ArrayList<Currency>();
        ArrayList<Currency> currencies4 = new ArrayList<Currency>();
        
        String fileName = "CurrencyData.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String cname1 = values[0];
                String cname2 = values[1];
                String data = values[2];
                Double value = Double.parseDouble(values[3]);
                Integer number = Integer.parseInt(values[4]);
                Currency currency = new Currency(cname1, cname2, data, value, number);
                currencies.add(currency);
            }  
        } catch (IOException e) {
            e.printStackTrace();
        }

       
    currencies2.addAll(currencies);
    currencies3.addAll(currencies); 
    currencies4.addAll(currencies); 
        


        System.out.println("Unsorted table");

        for (Currency currency : currencies) {
            System.out.println(currency.cname1 + ", " + currency.cname2 + ", " + currency.data + ", " + currency.value + ", " + currency.number);
        }
       
        System.out.println("");

////////////////////// Bubble ///////////////////////////        
long startTime = System.currentTimeMillis();   
bubble(currencies2);

System.out.println("Bubble sort");
System.out.println("Theoretical complexity assessment O(n^2) = O(50^2) = 2500 ");
System.out.println("The number of comparisons (n^2)/2 = (50^2)/2 = 1250 ");
System.out.println("The number of permutations  n(n-1)/2 = 50(50-1)/2 = 1225 ");
long endTime = System.currentTimeMillis();
long timeTaken = endTime - startTime;
System.out.println("Time taken: " + timeTaken + " milliseconds");
System.out.println("");

    for (Currency currency : currencies2) {
        System.out.println(currency.cname1 + ", " + currency.cname2 + ", " + currency.data + ", " + currency.value + ", " + currency.number);

    }
       
System.out.println("");
////////////////////// End Bubble ///////////////////////////

////////////////////// Selection ///////////////////////////        
long startTime2 = System.currentTimeMillis();
selection(currencies3);

System.out.println("");       
System.out.println("Selection sort");
System.out.println("Theoretical complexity assessment O(n^2) = O(50^2) = 2500 ");
System.out.println("The number of comparisons n(n-1)/2 = 50(50-1)/2 = 1225 ");
System.out.println("The number of permutations   n-1 = 49 ");
long endTime2 = System.currentTimeMillis();
long timeTaken2 = endTime2 - startTime2;
System.out.println("Time taken: " + timeTaken2 + " milliseconds");
System.out.println("");

for (Currency currency : currencies3) {
    System.out.println(currency.cname1 + ", " + currency.cname2 + ", " + currency.data + ", " + currency.value + ", " + currency.number);

}

System.out.println("");
////////////////////// End Selection ///////////////////////////

////////////////////// Insertion ///////////////////////////        
long startTime3 = System.currentTimeMillis();
insertion(currencies4);

System.out.println("");       
System.out.println("Insertion sort");
System.out.println("Theoretical complexity assessment O(n log n) = O(50 log 50) = 85 ");
System.out.println("The number of comparisons n(n-1)/2 = 50(50-1)/2 = 1225 ");
System.out.println("The number of permutations n(n-1)/2 = 50(50-1)/2 = 1225 ");
long endTime3 = System.currentTimeMillis();
long timeTaken3 = endTime3 - startTime3;
System.out.println("Time taken: " + timeTaken3 + " milliseconds");
System.out.println("");

for (Currency currency : currencies4) {
    System.out.println(currency.cname1 + ", " + currency.cname2 + ", " + currency.data + ", " + currency.value + ", " + currency.number);

}

System.out.println("");

////////////////////// End Insertion ///////////////////////////
}

    public static void bubble(ArrayList<Currency> currencies2){
    int n = currencies2.size();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n -1 -i; j++){
                if (currencies2.get(j).number > currencies2.get(j + 1).number){
                    Currency temp = currencies2.get(j);
                    currencies2.set(j , currencies2.get(j + 1));
                    currencies2.set(j +1 , temp);
                }
            
            }
        }
    }

    public static void selection(ArrayList<Currency> currencies3){
    int n = currencies3.size();
        for(int i = 0; i < n - 1; i++){
        int min = i;
            for(int j = i + 1; j < n; j++){
            if (currencies3.get(min).number > currencies3.get(j).number ){
                min = j;
            }
        }
        Currency temp = currencies3.get(i);
        currencies3.set(i , currencies3.get(min));
        currencies3.set(min , temp );
        }
    }

    public static void insertion(ArrayList<Currency> currencies4) {
        int n = currencies4.size();
        for (int i = 1; i < n; ++i) {
            Currency key = currencies4.get(i);
            int j = i - 1;

            while (j >= 0 && currencies4.get(j).number > key.number) {
                currencies4.set(j + 1, currencies4.get(j));
                j = j - 1;
            }
            currencies4.set(j + 1, key);
        }
    }
        
}

