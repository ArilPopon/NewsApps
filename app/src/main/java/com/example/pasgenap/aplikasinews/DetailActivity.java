package com.example.pasgenap.aplikasinews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    String img, judul, deskripsi, tgl, penulis, sumber;
    ImageView tvImg;
    TextView tvJudul, tvDeskripsi, tvTgl, tvPenulis, tvSumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));

        img = getIntent().getStringExtra("imgNews");
        judul = getIntent().getStringExtra("titleNews");
        deskripsi = getIntent().getStringExtra("contentNews");
        tgl = getIntent().getStringExtra("dateNews");
        penulis = getIntent().getStringExtra("authorNews");
        sumber = getIntent().getStringExtra("sourceNews");

        bindView();

        Glide.with(getApplicationContext())
                .load(img).apply(new RequestOptions().placeholder(R.drawable.noimg))
                .into(tvImg);
        tvJudul.setText(judul);
        tvDeskripsi.setText(deskripsi);
        tvTgl.setText(tgl);
        tvSumber.setText("Lihat Lebih Lengkap");
        tvPenulis.setText(penulis);

        if(getSupportActionBar() != null)getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void sumber (View view) {
        Intent intent = new Intent(getApplicationContext(),webview.class);
        intent.putExtra("sumber",sumber);
        startActivity(intent);
    }

    public void bindView(){
        tvImg = findViewById(R.id.img);
        tvJudul = findViewById(R.id.judul);
        tvDeskripsi = findViewById(R.id.deskripsi);
        tvPenulis = findViewById(R.id.penulis);
        tvTgl = findViewById(R.id.tgl);
        tvSumber = findViewById(R.id.sumber);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);

        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);

    }

}
