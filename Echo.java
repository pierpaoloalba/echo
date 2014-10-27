package org.apache.cordova.plugin;


//https://gitlab.com/palba/echo.git

import java.util.List;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import android.os.Handler;
import android.os.Looper;

/**
 * This class echoes a string called from JavaScript.
 */
public class Echo extends CordovaPlugin {  
    
     public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
            try
            {
       
        if (action.equals("echo")) {
            String message = args.getString(0); 
            this.echo(message, callbackContext);
            return true;
        }
        return false;
            }
            catch(JSONException  ex)
            {
            }            
            return false;
            
       
    }


    private void echo(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) { 
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
