package com.amangarg.animatedscratchview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.goibibo.libs.views.ScratchRelativeLayoutView;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class MainActivity extends AppCompatActivity {
    KonfettiView viewKonfetti;
    ScratchRelativeLayoutView scratchRelativeLayoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scratchRelativeLayoutView = findViewById(R.id.scratch_card);
        scratchRelativeLayoutView.setStrokeWidth(20);
        viewKonfetti = findViewById(R.id.viewKonfetti);

        /**
         Using Inflated View
         */
    /*final View scratchView = inflater.inflate(R.layout.lyt_scratch, scratchRelativeLayoutView, true);
    scratchRelativeLayoutView.setScratchView(scratchView, scratchRelativeLayoutView);*/

        /**
         * Opening in already revealed state
         */
        //scratchRelativeLayoutView.setScratchView(ScratchRelativeLayoutView.ScratchedState.REVEALED);

        /**
         * Using Raw View
         */
        scratchRelativeLayoutView.setScratchView(R.layout.lyt_scratch);


        scratchRelativeLayoutView.setRevealListener(new ScratchRelativeLayoutView.IRevealListener() {
            @Override
            public void onRevealed(ScratchRelativeLayoutView tv) {
                // on reveal
            }

            @Override
            public void onRevealPercentChangedListener(ScratchRelativeLayoutView siv, float percent) {
                if (percent > 0.5) {
                    scratchRelativeLayoutView.clear();
                    showConfetti();
                }
            }
        });
    }

    void showConfetti() {
        viewKonfetti.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12, 5))
                .setPosition(-50f, viewKonfetti.getWidth() + 50f, -50f, -50f)
                .streamFor(100, 5000L);
    }
}