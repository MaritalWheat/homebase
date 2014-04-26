package app.android.homeBase;

import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;

import com.parse.*;

public abstract class HomeBaseActivity extends ActionBarActivity{

    protected float x1, x2, y1, y2;
    protected Intent myIntent;
    protected String myClassName;
    private ApplicationManager mApplication;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {


        // Normal event dispatch to this container's children, ignore the return value
        super.dispatchTouchEvent(ev);

        // Always consume the event so it is not dispatched further up the chain
        onTouchEvent(ev);
        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent touchevent){

        switch (touchevent.getAction())
        {

            // when user first touches the screen we get x and y coordinate
            case MotionEvent.ACTION_DOWN:
            {
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                x2 = touchevent.getX();
                y2 = touchevent.getY();


                // if right to left sweep event on screen
                if ((x1 + 150) < x2 && ((y2 - y1) < 10 || (y1 - y2) < 10 ))
                {
                    //Toast.makeText(this, "Right to Left Swap Performed", Toast.LENGTH_LONG).show();
                    onBackPressed();
                }
                
                //if left to right sweep event on screen
                if (x1 > (x2 + 150) && ((y2 - y1) < 10 || (y1 - y2) < 10 ))
                {
                    //Toast.makeText(this, "Right to Left Swap Performed", Toast.LENGTH_LONG).show();
                    onForwardSwipe();
                }

                break;
            }
        }
        return false;
    }

    public void onBackPressedEndpoint()
    {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_in_back, R.anim.anim_out_back);
    }

    @Override
    public void onBackPressed()
    {
        addIntentToForwardQueue();
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_in_back, R.anim.anim_out_back);
    }

    public void onForwardSwipe() 
    {
        if (mApplication.forwardIntentQueue.isEmpty()) return;
        if (!mApplication.traversingForwardIntentQueue) {
            mApplication.traversingForwardIntentQueue = true;
        }

        Intent popped = mApplication.forwardIntentQueue.pop();

        String caller = popped.getStringExtra("caller");
        if (caller == null) return;
        if (!caller.equals(myClassName)) {
            mApplication.forwardIntentQueue.clear();
            mApplication.traversingForwardIntentQueue = false ;
            return;
        }

        startActivity(popped);
    }
    
    public void addIntentToForwardQueue()
    {

        if (myIntent == null) return;

        if (mApplication.traversingForwardIntentQueue) {
            mApplication.forwardIntentQueue.clear();
            mApplication.traversingForwardIntentQueue = false;
        }

        mApplication.forwardIntentQueue.push(myIntent);
    }

    public void clearIntentForwardQueue()
    {
        mApplication.forwardIntentQueue.clear();
    }

    public void onLoginSuccess()
    {

    }

    public void onLoginError(String e)
    {

    }

    public void onSignupSuccess(ParseUser user)
    {

    }

    public void onSignupError(ParseException e)
    {

    }

    public void onCheckUserSuccess()
    {

    }

    public void onCheckUserFailure()
    {

    }

    public void onCheckUserError(ParseException e)
    {

    }

    public void onGetHomeUsersSuccess(String user, Boolean home)
    {


    }
    public void onGetHomeUsersFailure()
    {

    }

    public void onReturnUsersSuccess()
    {

    }
    public void onReturnUsersFailure() {

    }

    public void onParseSuccess(ParseObject parseObject)
    {

    }

    public void onParseSuccess(ParseObject parseObject, ParseException e)
    {

    }

    public void onSaveSuccess(Object saved)
    {

    }

    public void onSaveSuccess()
    {

    }

    public void onSaveError(String error)
    {
        Toast.makeText(this, "Parse error: "+error, Toast.LENGTH_LONG).show();
    }



    public void onGetAlertSuccess(HomeBaseAlert alert)
    {

    }
    public void onGetAlertFailure(String e)
    {

    }
    public void onCreateAlertSuccess(HomeBaseAlert alert)
    {

    }
    public void onCreateAlertFailure(String e)
    {

    }
    public void onUpdateAlertSuccess(HomeBaseAlert alert)
    {

    }
    public void onUpdateAlertFailure(String e)
    {

    }

    public void onDeleteAlertSuccess()
    {

    }
    public void onDeleteAlertFailure(String e)
    {

    }

    public void onGetHouseSuccess(HomeBaseHouse house)
    {

    }
    public void onGetHouseFailure(String e)
    {

    }
    public void onCreateHouseSuccess(HomeBaseHouse house)
    {

    }
    public void onCreateHouseFailure(String e)
    {

    }
    public void onUpdateHouseSuccess(HomeBaseHouse house)
    {

    }
    public void onUpdateHouseFailure(String e)
    {

    }

    public void onDeleteHouseSuccess()
    {

    }
    public void onDeleteHouseFailure(String e)
    {

    }

    public void onGetAlertListSuccess(ArrayList<HomeBaseAlert> alerts)
    {

    }

    public void onGetAlertListFailure(String e)
    {

    }

    public void onUpdateAlertListSuccess(ArrayList<HomeBaseAlert> alerts)
    {

    }

    public void onUpdateAlertListFailure(String e)
    {

    }

    public void onGetAlertListByTypeSuccess(ArrayList<HomeBaseAlert> alerts)
    {

    }

    public void onGetAlertListByTypeFailure(String e)
    {

    }

    public void onUpdateAlertListByTypeSuccess(ArrayList<HomeBaseAlert> alerts)
    {

    }

    public void onUpdateAlertListByTypeFailure(String e)
    {

    }

    public void onGetAlertResponsibleUsersSuccess(List<String> responsibleUsers) {

    }

    public void onGetAlertResponsibleUsersFailure(String e)
    {

    }

    public void onGetAlertCompletedUsersSuccess(List<String> responsibleUsers) {

    }

    public void onGetAlertCompletedUsersFailure(String e)
    {

    }

    public void onGetBillsFailure(String e)
    {

    }

    public void onCreateBillSuccess(HomeBaseBill bill)
    {

    }

    public void onCreateBillFailure(String e)
    {

    }

    public void onUpdateBillSuccess(HomeBaseBill bill)
    {

    }

    public void onUpdateBillFailure(String e)
    {

    }

    // Deprecated
    public void onDeleteBillSuccess()
    {

    }

    // Deprecated
    public void onDeleteBillFailure(String e)
    {

    }
}
