package com.daviskevin.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView create, start, resume, pause, stop, restart, destroy,
            acreate, astart, aresume, apause, astop, arestart, adestroy;
    Stats stats = new Stats();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create = findViewById(R.id.create);
        start = findViewById(R.id.start);
        resume = findViewById(R.id.resume);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        restart = findViewById(R.id.restart);
        destroy = findViewById(R.id.destroy);
        acreate = findViewById(R.id.create2);
        astart = findViewById(R.id.start2);
        aresume = findViewById(R.id.resume2);
        apause = findViewById(R.id.pause2);
        astop = findViewById(R.id.stop2);
        arestart = findViewById(R.id.restart2);
        adestroy = findViewById(R.id.destroy2);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();
        editor.putInt("cr", sharedPreferences.getInt("cr", 0)+1);
        editor.apply();
        stats.setCr(stats.getCr()+1);
        updateText();
    }
    protected void onStart(){
        super.onStart();
        editor = sharedPreferences.edit();
        editor.putInt("st", sharedPreferences.getInt("st", 0)+1);
        editor.apply();
        stats.setSt(stats.getSt()+1);
        updateText();
    }
    protected void onResume(){
        super.onResume();
        editor = sharedPreferences.edit();
        editor.putInt("rs", sharedPreferences.getInt("rs", 0)+1);
        editor.apply();
        stats.setRs(stats.getRs()+1);
        updateText();
    }
    protected void onPause(){
        super.onPause();
        editor = sharedPreferences.edit();
        editor.putInt("pa", sharedPreferences.getInt("pa", 0)+1);
        editor.apply();
        stats.setPa(stats.getPa()+1);
        updateText();
    }
    protected void onStop(){
        super.onStop();
        editor = sharedPreferences.edit();
        editor.putInt("sp", sharedPreferences.getInt("sp", 0)+1);
        editor.apply();
        stats.setSp(stats.getSp()+1);
        updateText();
    }
    protected void onRestart(){
        super.onRestart();
        editor = sharedPreferences.edit();
        editor.putInt("re", sharedPreferences.getInt("re", 0)+1);
        editor.apply();
        stats.setRe(stats.getRe()+1);
        updateText();
    }
    protected void onDestroy(){
        super.onDestroy();
        editor = sharedPreferences.edit();
        editor.putInt("de", sharedPreferences.getInt("de", 0)+1);
        editor.apply();
        stats.setDe(stats.getDe()+1);
        updateText();
    }
    private void updateText(){
        create.setText(""+stats.getCr());
        start.setText(""+stats.getSt());
        resume.setText(""+stats.getRs());
        pause.setText(""+stats.getPa());
        stop.setText(""+stats.getSp());
        restart.setText(""+stats.getRe());
        destroy.setText(""+stats.getDe());
        acreate.setText(""+sharedPreferences.getInt("cr", 0));
        astart.setText(""+sharedPreferences.getInt("st", 0));
        aresume.setText(""+sharedPreferences.getInt("rs", 0));
        apause.setText(""+sharedPreferences.getInt("pa", 0));
        astop.setText(""+sharedPreferences.getInt("sp", 0));
        arestart.setText(""+sharedPreferences.getInt("re", 0));
        adestroy.setText(""+sharedPreferences.getInt("de", 0));
    }
}

class Stats {
    private int cr=0, st=0, rs=0, pa=0, sp=0, re=0, de=0;

    public int getCr() {
        return cr;
    }

    public void setCr(int cr) {
        this.cr = cr;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getRs() {
        return rs;
    }

    public void setRs(int rs) {
        this.rs = rs;
    }

    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getRe() {
        return re;
    }

    public void setRe(int re) {
        this.re = re;
    }

    public int getDe() {
        return de;
    }

    public void setDe(int de) {
        this.de = de;
    }
}