package namtran.lifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainFragment.LifeCycleFragment{

    private TextView txtLifeCycle;
    private int count = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtLifeCycle = (TextView) findViewById(R.id.txtLifeCycle);
        setSupportActionBar(toolbar);

        if (savedInstanceState != null){
            Log.d("LifeCyCle","onCreate  " + getClass().getSimpleName());
            count = savedInstanceState.getInt("Count");
            txtLifeCycle.append(savedInstanceState.getString("LifeCycle"));
            txtLifeCycle.append("onCreate Activity "  + count + "\n\n");
        }else {
            Log.d("LifeCyCle","onCreate  " + getClass().getSimpleName());
            txtLifeCycle.append("onCreate Activity "  + count + "\n\n");

        }

        initFragment(new MainFragment(this),MainFragment.TAG);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("LifeCyCle","onRestoreInstanceState(Bundle savedInstanceState)  " + getClass().getSimpleName());
        txtLifeCycle.append("onRestoreInstanceState(Bundle savedInstanceState) Activity "  + count + "\n\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCyCle","onStart  " + getClass().getSimpleName());
        txtLifeCycle.append("onStart Activity "  + count + "\n\n");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d("LifeCyCle","onPostCreate(@Nullable Bundle savedInstanceState)  " + getClass().getSimpleName());
        txtLifeCycle.append("onPostCreate(@Nullable Bundle savedInstanceState) Activity "  + count + "\n\n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCyCle","onResume  " + getClass().getSimpleName());
        txtLifeCycle.append("onResume Activity "  + count + "\n\n");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("LifeCyCle","onPostResume  " + getClass().getSimpleName());
        txtLifeCycle.append("onPostResume Activity "  + count + "\n\n");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCyCle","onPause  " + getClass().getSimpleName());
        txtLifeCycle.append("onPause Activity "  + count + "\n\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCyCle","onStop  " + getClass().getSimpleName());
        txtLifeCycle.append("onStop Activity "  + count + "\n\n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCyCle","onRestart  " + getClass().getSimpleName());
        txtLifeCycle.append("onRestart Activity "  + count + "\n\n");
    }

    //https://inthecheesefactory.com/blog/fragment-state-saving-best-practices/en
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        count ++;
        Log.d("LifeCyCle","onSaveInstanceState(Bundle outState)  " + getClass().getSimpleName());
        txtLifeCycle.append("onSaveInstanceState(Bundle outState) Activity "  + count + "\n\n");
        outState.putString("LifeCycle",txtLifeCycle.getText().toString());
        outState.putInt("Count",count);
    }
    
    private void initFragment(Fragment fragment,String TAG){
        FragmentManager fm = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment) fm.findFragmentByTag(MainFragment.TAG);
        if (mainFragment != null){
            Toast.makeText(MainActivity.this,"Ok",Toast.LENGTH_SHORT).show();
            mainFragment.setLifeCycleFragment(this);
        }else {
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.add(R.id.container,fragment,TAG);
            fragmentTransaction.addToBackStack(TAG);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1){
            finish();
        }
        else {
            super.onBackPressed();
        }
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

    /* ---------------------------------------------- Life Cycle Fragment -----------------------------------------------*/

    @Override
    public void onAttachFragmentCycle() {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onAttachFragment Fragment " + "\n\n");
    }

    @Override
    public void onAttachCycle() {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onAttach Fragment " + count + "\n\n");
    }

    @Override
    public void onCreateCycle() {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onCreate Fragment " + "\n\n");
    }

    @Override
    public void onCreateViewCycle() {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onCreateView Fragment " + "\n\n");
    }

    @Override
    public void onViewCreatedCycle() {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onViewCreated Fragment " + "\n\n");
    }

    @Override
    public void onActivityCreatedCycle(int count) {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onActivityCreated Fragment " + count + "\n\n");
    }

    @Override
    public void onStartCycle(int count) {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onStart Fragment " + count + "\n\n");
    }

    @Override
    public void onResumeCycle(int count) {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onResume Fragment " + count + "\n\n");
    }

    @Override
    public void onSaveInstanceStateCycle(int count) {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onSaveInstanceState Fragment " + count + "\n\n");
    }

    @Override
    public void onViewStateRestoredCycle(int count) {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onViewStateRestored Fragment " + count + "\n\n");
    }

    @Override
    public void onPauseCycle(int count) {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onRestoreInstanceState(Bundle savedInstanceState) Fragment " + count + "\n\n");
    }

    @Override
    public void onStopCycle(int count) {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onStop Fragment " + count + "\n\n");
    }

    @Override
    public void onDestroyViewCycle(int count) {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onDestroyView Fragment " + count + "\n\n");
    }

    @Override
    public void onDestroyCycle(int count) {
        if (txtLifeCycle != null)
            txtLifeCycle.append("onDestroy Fragment " + count + "\n\n");
    }

    @Override
    public void onDetachCycle(int count) {
        Log.d("LifeCyCle","onDetach  " + getClass().getSimpleName());
        if (txtLifeCycle != null)
            txtLifeCycle.append("onDetach Fragment " + count + "\n\n");
    }
}
