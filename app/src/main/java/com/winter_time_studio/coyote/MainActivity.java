package com.winter_time_studio.coyote;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setCustomActionBar();

        ProfileList pl = new ProfileList();
        String[] profileData = pl.getProfileData();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, profileData);

        listView.setAdapter(adapter);

    }

    @OnItemClick(R.id.listView)
    public void onListItemClick(int position) {
        Toast.makeText(this, "selected pos=" + position, Toast.LENGTH_SHORT).show();
    }

    private View getActionBarView(String title, String imageURL) {

        // 表示するlayoutファイルの取得
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.custom_action_bar, null);

        // CustomViewにクリックイベントを登録する
        final MainActivity self = this;
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //self.finish();
                //TODO: Profile詳細を実装
                Toast.makeText(self, "profile", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void setCustomActionBar(){
        // customActionBarの取得
        View customActionBarView = this.getActionBarView("Hoge", "表示する画像のURL");
        // ActionBarの取得
        ActionBar actionBar = this.getSupportActionBar();
        // タイトルを表示するか
        actionBar.setDisplayShowTitleEnabled(true);
        // iconを表示するか
        actionBar.setDisplayShowHomeEnabled(false);

        actionBar.setCustomView(customActionBarView);
        actionBar.setDisplayShowCustomEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
