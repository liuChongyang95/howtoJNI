package fina.com.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("hello-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI_HelloWorld());
        @SuppressLint("SdCardPath") String filepath="/data/data/fina.com.myapplication/init.txt";
        Writefile(filepath);

        int[] data={1,2,3,4,5};
        for (int i=0;i<data.length;i++){
            Log.d("MainActivity", String.valueOf(data[i]));
        }
        operationArray(data);

        for (int i=0;i<data.length;i++){
            Log.d("MainActivity", String.valueOf(data[i]));
        }
//对数组的调用，返回void，最终改变了数组的值
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI_HelloWorld();
    public native void Writefile(String Filename);
    public native void operationArray(int[] args);
}
