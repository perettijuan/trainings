package com.example.jpp.constraintlayoutexamples;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;

public class BasicExamplesActivity extends Activity {

    private static final int NO_LAYOUT_ID = -99;

    private int mLayoutId = NO_LAYOUT_ID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_examples_activity);
    }


    public void onCenterInParent(View view) {
        setContentView(R.layout.center_in_parent);
    }

    public void onDimensionRatio(View view) {
        setContentView(R.layout.dimension_ratio);
    }

    public void onGuidelines(View view) {
        setContentView(R.layout.guidelines);
    }

    public void onLinearLayout(View view) {
        setContentView(R.layout.linear_layout_with_constraint_layout);
    }

    public void onMatchParent(View view) {
        setContentView(R.layout.match_parent);
    }

    public void onRelativeLayour(View view) {
        setContentView(R.layout.relative_layout_to_constraint_layout_1);
    }

    public void onBias(View view) {
        setContentView(R.layout.vertical_and_horizontal_vias);
    }

    public void onPackedChain(View view) {
        setContentView(R.layout.packed_chain);
    }

    public void onSpreadChain(View view) {
        setContentView(R.layout.spread_chain);
    }

    public void onSpreadChainInside(View view) {
        setContentView(R.layout.spread_inside_chain);
    }

    public void onWeightedChain(View view) {
        setContentView(R.layout.weighted_chain);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if(layoutResID == R.layout.basic_examples_activity) {
            mLayoutId = NO_LAYOUT_ID;
        } else {
            mLayoutId = layoutResID;
        }
        super.setContentView(layoutResID);
    }


    @Override
    public void onBackPressed() {
        if(mLayoutId == NO_LAYOUT_ID) {
            super.onBackPressed();
        } else {
            setContentView(R.layout.basic_examples_activity);
        }
    }
}
