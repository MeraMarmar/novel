package com.example.allinone.elaniadnovel;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list);
        String[] item = getResources().getStringArray(R.array.index);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.raw_items, R.id.txt, item);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,webhtml.class);
                intent.putExtra("page",i);
                startActivity(intent);
            }
        });
    }

    public void share(View view) {
        String txtShare="تطبيق روايه العنيد";
        String sharelink="https://play.google.com/store/apps/details?id=com.example.allinone.elaniadnovel";
        Intent share=new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,txtShare+"\n"+sharelink);
        startActivity(share);
    }
    public void home(View view){
        Intent home=new Intent(Intent.ACTION_VIEW);
        home.setData(Uri.parse("http://play.google.com/store/apps/developer?id=Qays300"));
        startActivity(home);
    }
    public void email(View view){
        try {
            String txt = "السلام عليكم ورحمه الله وبركاته" + "\n" + "اقتراحى هو:";
            Intent sendemail = new Intent(Intent.ACTION_SEND);
            sendemail.setData(Uri.parse("mailto:"));
            sendemail.setType("message/rfc822");
            sendemail.putExtra(Intent.EXTRA_EMAIL, "prencessmarmar@gmail.com");
            sendemail.putExtra(Intent.EXTRA_SUBJECT, "تطبيق روايه العنيد");
            sendemail.putExtra(Intent.EXTRA_TEXT, txt);
            startActivity(sendemail);
        }
        catch (Exception e){
            Toast.makeText(this,"للاسف لا يوجد تطبيق بريد على هاتفك",Toast.LENGTH_LONG).show();
        }
    }
public void close(View view){
        finish();
}

}



