
package apps.arusoft.com.rxjavaexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageView = (TextView)findViewById(R.id.tv_result);
        findViewById(R.id.btn_sample_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sample1();
            }
        });

        findViewById(R.id.btn_sample_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sample2();
            }
        });

        findViewById(R.id.btn_sample_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sample3();
            }
        });
    }

    private void sample1() {
        clearMessage();
        Observable<String> myObservable = Observable.just("Hello");

        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                // Called when the observable has no more data to emit
            }

            @Override
            public void onError(Throwable e) {
                // Called when the observable encounters an error
            }

            @Override
            public void onNext(String s) {
                // Called each time the observable emits data
                Log.d(TAG, "MY OBSERVER :" + s);
                addMessage(s);
            }
        };

        Subscription mySubscription = myObservable.subscribe(myObserver);
    }


    private void sample2() {
        clearMessage();
        //Using Action 1
        Observable<String> myObservable = Observable.just("Hello World Bitches");
        Action1<String> myAction1 = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "Action1 s::" + s);
                addMessage(s);
            }
        };

        Subscription subscription = myObservable.subscribe(myAction1);
    }

    private void sample3() {
        clearMessage();
        Observable.from(new Integer[]{1, 2, 3, 4, 5, 6})
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer % 2 == 0;
                    }
                })
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "Sample 3 is Completed");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "Sample 3 integer:" + integer);
                        addMessage(String.valueOf(integer));
                    }
                });

    }

    private void addMessage(String text) {
        String message = messageView.getText().toString();
        message += " " + text;
        messageView.setText(message);
    }

    private void clearMessage() {
        messageView.setText("");
    }
}
