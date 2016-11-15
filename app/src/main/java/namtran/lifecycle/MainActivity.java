package namtran.lifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtLifeCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtLifeCycle = (TextView) findViewById(R.id.txtLifeCycle);
        setSupportActionBar(toolbar);

        if (savedInstanceState != null){
            Log.d("LifeCyCle","onCreate  " + getClass().getSimpleName());
            txtLifeCycle.append(savedInstanceState.getString("LifeCycle"));
            txtLifeCycle.append("onCreate Activity" + "\n\n");
        }else {
            Log.d("LifeCyCle","onCreate  " + getClass().getSimpleName());
            txtLifeCycle.append("onCreate Activity" + "\n\n");
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCyCle","onStart  " + getClass().getSimpleName());
        txtLifeCycle.append("onStart Activity" + "\n\n");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d("LifeCyCle","onPostCreate(@Nullable Bundle savedInstanceState)  " + getClass().getSimpleName());
        txtLifeCycle.append("onPostCreate(@Nullable Bundle savedInstanceState) Activity" + "\n\n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCyCle","onResume  " + getClass().getSimpleName());
        txtLifeCycle.append("onResume Activity" + "\n\n");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("LifeCyCle","onPostResume  " + getClass().getSimpleName());
        txtLifeCycle.append("onPostResume Activity" + "\n\n");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCyCle","onPause  " + getClass().getSimpleName());
        txtLifeCycle.append("onPause Activity" + "\n\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCyCle","onStop  " + getClass().getSimpleName());
        txtLifeCycle.append("onStop Activity" + "\n\n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCyCle","onRestart  " + getClass().getSimpleName());
        txtLifeCycle.append("onRestart Activity" + "\n\n");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("LifeCyCle","onSaveInstanceState(Bundle outState)  " + getClass().getSimpleName());
        txtLifeCycle.append("onSaveInstanceState(Bundle outState) Activity" + "\n\n");
        outState.putString("LifeCycle",txtLifeCycle.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("LifeCyCle","onRestoreInstanceState(Bundle savedInstanceState)  " + getClass().getSimpleName());
        txtLifeCycle.append("onRestoreInstanceState(Bundle savedInstanceState) Activity" + "\n\n");
    }
    
    private void initFragment(Fragment fragment){
         
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
