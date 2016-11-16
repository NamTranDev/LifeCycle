package namtran.lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

    public static final String TAG = "MainFragment";

    public interface LifeCycleFragment {
        void onAttachFragmentCycle();

        void onAttachCycle();

        void onCreateCycle();

        void onCreateViewCycle();

        void onViewCreatedCycle();

        void onActivityCreatedCycle(int count);

        void onStartCycle(int count);

        void onResumeCycle(int count);

        void onSaveInstanceStateCycle(int count);

        void onViewStateRestoredCycle(int count);

        void onPauseCycle(int count);

        void onStopCycle(int count);

        void onDestroyViewCycle(int count);

        void onDestroyCycle(int count);

        void onDetachCycle(int count);
    }

    public MainFragment() {
    }

    public MainFragment(LifeCycleFragment lifeCycleFragment) {
        this.lifeCycleFragment = lifeCycleFragment;
    }

    private LifeCycleFragment lifeCycleFragment;

    private int count = 0;

    public void setLifeCycleFragment(LifeCycleFragment lifeCycleFragment){
        this.lifeCycleFragment = lifeCycleFragment;
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.d("LifeCyCle", "onAttachFragment  " + getClass().getSimpleName());
        lifeCycleFragment.onAttachFragmentCycle();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("LifeCyCle", "onAttach  " + getClass().getSimpleName());
        if (lifeCycleFragment != null)
            lifeCycleFragment.onAttachCycle();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LifeCyCle", "onCreate  " + getClass().getSimpleName());
        if (lifeCycleFragment != null)
            lifeCycleFragment.onCreateCycle();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("LifeCyCle", "onCreateView  " + getClass().getSimpleName());
        if (lifeCycleFragment != null)
            lifeCycleFragment.onCreateViewCycle();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("LifeCyCle", "onViewCreated  " + getClass().getSimpleName());
        if (lifeCycleFragment != null)
            lifeCycleFragment.onViewCreatedCycle();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("LifeCyCle", "onActivityCreated  " + getClass().getSimpleName());

        if (savedInstanceState != null)
            count = savedInstanceState.getInt("Count");

        if (lifeCycleFragment != null)
            lifeCycleFragment.onActivityCreatedCycle(count);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("LifeCyCle", "onStart  " + getClass().getSimpleName());
        if (lifeCycleFragment != null)
            lifeCycleFragment.onStartCycle(count);

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("LifeCyCle", "onResume  " + getClass().getSimpleName());
        if (lifeCycleFragment != null)
            lifeCycleFragment.onResumeCycle(count);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        count++;
        Log.d("LifeCyCle", "onSaveInstanceState  " + getClass().getSimpleName());
        outState.putInt("Count", count);
        if (lifeCycleFragment != null)
            lifeCycleFragment.onSaveInstanceStateCycle(count);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("LifeCyCle", "onViewStateRestored  " + getClass().getSimpleName());
        if (lifeCycleFragment != null)
            lifeCycleFragment.onViewStateRestoredCycle(count);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("LifeCyCle", "onPause  " + getClass().getSimpleName());
        if (lifeCycleFragment != null)
            lifeCycleFragment.onPauseCycle(count);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("LifeCyCle", "onStop  " + getClass().getSimpleName());
        if (lifeCycleFragment != null)
            lifeCycleFragment.onStopCycle(count);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("LifeCyCle", "onAttachFragment  " + getClass().getSimpleName());
        if (lifeCycleFragment != null)
            lifeCycleFragment.onDestroyViewCycle(count);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("LifeCyCle", "onDestroy  " + getClass().getSimpleName());
        if (lifeCycleFragment != null)
            lifeCycleFragment.onDestroyCycle(count);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("LifeCyCle", "onDetach  " + getClass().getSimpleName());
        if (lifeCycleFragment != null)
            lifeCycleFragment.onDetachCycle(count);
    }
}
