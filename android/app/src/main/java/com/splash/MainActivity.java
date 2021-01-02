package com.splash;

import android.os.Bundle; // Este Aqui
import com.facebook.react.ReactActivity;//Este já esta no arquivo
import org.devio.rn.splashscreen.SplashScreen; // Este Aqui

public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      SplashScreen.show(this, R.style.SplashScreenTheme);
      super.onCreate(savedInstanceState);
  }

  @Override
  protected String getMainComponentName() {
    return "splash";
  }
  
}
