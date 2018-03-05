package sample.pham.sang.memoryleaksample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import sample.pham.sang.memoryleaksample.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity {

    private static final String TAG = SubActivity.class.getSimpleName();
    List<BigModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(list.isEmpty()){
            for (int i = 0; i < 300; i++) {
                list.add(new BigModel());
            }
        }

        ActivitySubBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sub);

//        Glide.with(this).load(Constant.RANDOME_IMAGE+ System.currentTimeMillis()).into(binding.content.imgLeak);
//        Glide.with(this).load(Constant.RANDOME_IMAGE+ System.currentTimeMillis()).into(binding.content.imgLeak1);
//        Glide.with(this).load(Constant.RANDOME_IMAGE+ System.currentTimeMillis()).into(binding.content.imgLeak2);
//        Glide.with(this).load(Constant.RANDOME_IMAGE+ System.currentTimeMillis()).into(binding.content.imgLeak3);
//        Glide.with(this).load(Constant.RANDOME_IMAGE+ System.currentTimeMillis()).into(binding.content.imgLeak4);
        binding.content.imgLeak.setImageResource(R.drawable.sunset);
        binding.content.imgLeak1.setImageResource(R.drawable.sunset);
        binding.content.imgLeak2.setImageResource(R.drawable.sunset);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i = new Intent(SubActivity.this, MainActivity.class);
                startActivity(i);

            }
        });

        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Runtime rt = Runtime.getRuntime();
                System.out.println( "free memory: " + rt.freeMemory() );
                return true;
            }
        });
    }

    @Override
    public void onTrimMemory(int level) {
        Log.i(TAG, "onTrimMemory: ");
        list.clear();
//        Glide.with(this).clear(binding.content.imgLeak);
//        Glide.with(this).clear(binding.content.imgLeak1);
//        Glide.with(this).clear(binding.content.imgLeak2);
//        Glide.with(this).clear(binding.content.imgLeak3);
//        Glide.with(this).clear(binding.content.imgLeak4);
        super.onTrimMemory(level);
    }


}
