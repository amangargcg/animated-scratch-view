package com.amangarg.animatedscratchview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class CardViewActivity extends AppCompatActivity {
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        cardView = findViewById(R.id.card);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardViewActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });
    }
}