package assignment8.acadgild.com.assignment81;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
//    button that sorts the data to ascending
    Button toSortAscent;
//    button that sorts the data to descending
    Button toSortDescend;
//    Listview variable that holds the reference to the list on the main xml
    ListView list;

//    Array list that hold the data for the months that show up on the app
    ArrayList<String> months = new ArrayList<String>(Arrays.asList("January" ,
            "Febuary" ,
            "March" ,
            "April" ,
            "May" ,
            "June" ,
            "July" ,
            "August" ,
            "September" ,
            "October" ,
            "November" ,
            "December"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      link the reference to the xml main activity with the Listview from this class and the xml
        list = findViewById(R.id.listView);

//        Create a new array adapter that is the final link to show the data on the screen
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.customlayout, months);

//        Sets the adapter on the listview.
        list.setAdapter(adapter);

//        set references to the buttons ascending and descending
        toSortAscent = findViewById(R.id.sortAscend);
        toSortDescend = findViewById(R.id.sortDescend);

//        set the onclick listener for the ascending button
        toSortAscent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                get the adapter to sort the list
                adapter.sort(new Comparator<String>() {
                    @Override
                    public int compare(String word1, String word2) {
//                        Comparator that sorts the list and returns a list sorted in ascending
                        return word1.compareTo(word2);
                    }
                });
            }
        });
//        set the onclick listener for the sort descending button
        toSortDescend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                get the adapter to sort the list
                adapter.sort(new Comparator<String>() {
                    @Override
                    public int compare(String word1, String word2) {
//                        Comparator that sorts the list and returns a list sorted descending
                        return word2.compareTo(word1);
                    }
                });
            }
        });
    }
}