package it.hueic.kenhoang.materialdesign_gridlayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FindViewById & Events
        getWidGetFunction();
    }

    private void getWidGetFunction() {
        mainGrid = findViewById(R.id.gridLayout);

        //Set Events
        //setSingleEvents();
        setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child Item
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            // You can see, all child is CardView, so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background Color
                        cardView.setCardBackgroundColor(Color.parseColor("#rr6r00"));
                        //Here you can replace Toast with start new Activity code
                        Toast.makeText(MainActivity.this, "State: true", Toast.LENGTH_SHORT).show();
                    } else {
                        //Change background Color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(MainActivity.this, "State: false", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvents() {
        //Loop all child Item
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            // You can see, all child is CardView, so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Here you can replace Toast with start new Activity code
                    Toast.makeText(MainActivity.this, "Clicked at index " + finalI, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
