package sg.edu.nus.travellion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Rach on 9/11/2017.
 */

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList<DataModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        arrayList.add(new DataModel("Cheeka - The Bot", R.drawable.battle, "#09A9FF"));
        arrayList.add(new DataModel("Meal With Me", R.drawable.beer, "#3E51B1"));
        arrayList.add(new DataModel("Smart Headset", R.drawable.ferrari, "#673BB7"));
        arrayList.add(new DataModel("Fitness Tracker", R.drawable.jetpack_joyride, "#4BAA50"));
        arrayList.add(new DataModel("AR", R.drawable.three_d, "#F94336"));
        arrayList.add(new DataModel("Innum Peru Vaikala", R.drawable.terraria, "#0A9B88"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onItemClick(DataModel item) {

        //Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();
        if (item.text == "Cheeka - The Bot") {
            Intent chatIntent = new Intent(this, ChatActivity.class);
            this.startActivity(chatIntent);
        }
        if (item.text == "AR") {
            Intent arIntent = new Intent(this, ARActivity.class);
            this.startActivity(arIntent);
        }
        if (item.text == "Meal With Me") {
            Intent mealIntent = new Intent(this, MWMActivity.class);
            this.startActivity(mealIntent);
        }
        if (item.text == "Smart Headset") {
            Intent mealIntent = new Intent(this, HeadsetActivity.class);
            this.startActivity(mealIntent);
        }
        if (item.text == "Fitness Tracker") {
            Intent mealIntent = new Intent(this, SmartWatchActivity.class);
            this.startActivity(mealIntent);
        }

    }
}
